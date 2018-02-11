package com.zyz.learn.autolivesone;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author ZhangYuanzhuo
 * @since 2018/2/8
 */
public class Auto {
    public static void main(String[] args) {
        int urlNo = 0; // 网址计数器
        Random random = new Random();
        List<String> urlList = new ArrayList<>(); // 网址

        try {
            System.out.println("共生币智能挖矿程序已启动");
            // 读取配置文件的网址
            File file = new File("autolivesone/src/main/resources/urlList.txt");
            if(file.exists()){
                FileReader fileReader = new FileReader(file);
                BufferedReader br = new BufferedReader(fileReader);
                String lineContent;
                while((lineContent = br.readLine()) != null){
                    urlList.add(lineContent);
                }
                br.close();
                fileReader.close();
            } else {
                throw new FileNotFoundException();
            }

            System.out.println("正在为您打开网页...");
            String url;
            int nowOpen = 0;
            int randomClose = random.nextInt(5) + 6; // 关闭时随机网址数
            int randomBrowse = random.nextInt(26) + 28; // 随机浏览时间
            while (urlNo < urlList.size() && (url = urlList.get(urlNo)) != null) {
                // 打开网页
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
                System.out.println(url);
                urlNo++;
                nowOpen++;

                Thread.sleep(randomBrowse * 1000);
                randomBrowse = random.nextInt(26) + 28;

                if (nowOpen > randomClose) {
                    // 关闭遨游进程
                    System.out.println("关闭浏览器，本次共浏览" + nowOpen + "个网址。");
                    Runtime.getRuntime().exec("taskkill /F /IM maxthon.exe");
                    nowOpen = 0;
                    randomClose = random.nextInt(5) + 6;
                    System.out.println("请稍等，程序将会继续打开浏览器...");
                }
            }

            // 无论是网址全开了还是网址为空最终都关闭浏览器
            Runtime.getRuntime().exec("taskkill /F /IM maxthon.exe");

            // 如果是网址已用完，给出提示
            if (urlNo == urlList.size()) {
                System.out.println("网址已用完！请关闭命令行窗口，更改urlList文件并再次打开程序继续使用。");
            } else {
                System.out.println("程序运行结束，请关闭命令行窗口。");
            }
        } catch (FileNotFoundException e) {
            System.out.println("no this file");
            e.printStackTrace();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

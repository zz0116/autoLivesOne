## 共生币(LVT)挖矿辅助程序

- 实现模拟人浏览网页的功能：
打开网页，停留1分钟左右时间（每次停留时间不一样）。在网页达到一定数量（每次数量不一样）的时候关闭浏览器。然后自动重复以上步骤。
- 运行前应在urlList里面填入足够多的网址。最好是配合BrowsingHistoryView使用：把浏览记录用csv格式导出后，将网址复制到urlList.txt里面。

---
version: 1.2    date: 2018-2-11

1. 改变urlList.txt位置。
2. 增加.gitignore文件。

---
version: 1.1    date: 2018-2-9

1. 修复了在程序运行结束后命令行窗口闪退的问题。
2. 修改了命令行输出的语句。

---
version: 1.0    date: 2018-2-8

1. 实现自动浏览网页功能。
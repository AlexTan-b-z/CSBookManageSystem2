# CSBookManageSystem2
客户端+服务端（CS）版图书管理系统

**系统介绍:**

本图书管理系统采用CS（Cient+Server）结构，采用MVC编程模式，简单的实现了的图书管理系统的各个功能：1、用户登陆以及管理功能 2、图书管理功能 3、查询功能 4、排行榜功能 5、借阅归还功能 6、用户权限功能（读者+管理员+超级管理员）等。 大量采用Socket编程、数据库编程、以及简单的java Swing图形界面编程等。不算ui界面（即java Swing图形界面编程），代码量在1400行左右，总代码量在4000行左右。 特此声明：本系统设计得较简单，只适用于新手参考学习。

**更新日志：** 

这次是对CS版图书管理系统进行更新：
- 1. 实现了管理员、用户等权限功能
- 2. 实现了借阅归还功能
- 3. 实现了排行榜功能
- 4. 实现读者管理功能
- 5. 实现管理员管理功能

**数据库设计**

由于数据库比较简单，所以就不绘图了。

***User表：***

字段名 | 字段类型 | 其他
----|------|----
uid | int  | 自增主键
username | varchar  | not null
password	| varchar  |not null
borrowTime | int | default 0
status | int |default 0 (0代表读者，1代表管理员)

***Book表：***

字段名 | 字段类型 | 其他
----|------|----
bid | int | 自增主键
bookname | varchar | not null
author | varchar | not null
price | float | not null
category | varchar | not null
readtime | int |default 0
isout | int | 外键 (null代表未借出，否则为user表里的UID，代表借给了谁)

**csdn博客:**
http://blog.csdn.net/alextan_?viewmode=contents

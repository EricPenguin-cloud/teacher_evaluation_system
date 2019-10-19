# 教师综合评价系统

![](https://img.shields.io/badge/build-passing-green.svg)![](https://img.shields.io/badge/coverage-90%-yellowgreen.svg)  

![](https://img.shields.io/badge/java-1.8-red.svg)![](https://img.shields.io/badge/maven-3.6.0-yellow.svg)![](https://img.shields.io/badge/npm-6.11.3-orange.svg)![](https://img.shields.io/badge/mysql-8.0.15-lightgrey.svg)![](https://img.shields.io/badge/radis-3.2-blue.svg)![](https://img.shields.io/badge/springboot-2.1.9-lightgreen.svg)

# 语言

- [英语](.\README.md)
- [中文](.\README-CN.md)

# 背景

本项目为作者在校期间所开发的一个实训项目。作为一个教室综合评价系统，它拥有最基本的如管理员管理学生和教师信息，学生评价教师，教师互相评价等等，功能和业务流程极为简单，本不适合也不必要使用分布式架构，所以作者更多地是将其作为一个对于mvvm和分布式架构的一个练手型的项目来进行开发的，用以为未来的分布式架构设计和开发积累经验

# 特点

- 高并发：本项目部分固定数据和缓存业务使用Redis进行存储，同时根据平台和业务对项目的各个模块进行解耦，封装成多个微服务，使用Spring Cloud Eureka管理这些微服务并使用Spring Cloud Ribbon进行负载均衡，以达到缓解高流量访问导致服务器载荷过大的问题

- 高可用：每个业务模块和注册中心都存在一到两个功能相同的微服务模块，平时以默认轮询的方式轮流访问。在其中某个服务窘机或维护时，将会断开问题服务，保证项目正常运行

- 速度更快：采用ES6+React.js开发前端viewModel模块，其特有的虚拟dom操作相比其他方式更加快捷

- 可维护性高：本项目架构设计合理，逻辑清晰，可读性高

  

# 技术架构

![](.\md_img\tes-4.png)

![](.\md_img\tes-5.png)

# 视觉效果

![](.\md_img\tes-1.png''管理员端数据可视化'')

![](.\md_img\tes-2.png''评价列表示意'')

![](.\md_img\tes-3.png''查看评价结果'')



# 运行环境

- winows 10
- jdk 1.8
- maven 3.6.0
- mysql 8.0
- redis 3.2

# 安装

1. 命令行cmd运行

   ```
   git clone https://github.com/EricPenguin-cloud/teacher_evaluation_system.git
   ```

2. 下载完成后，进入tes文件夹，得到文件结构如下：

   > ├─.idea
   > ├─client
   > ├─eureka-server-1
   > ├─eureka-server-2
   > ├─eureka-server-3
   > ├─radis-server-1
   > ├─radis-server-2
   > ├─sql-server-1
   > ├─sql-server-2
   > └─src

   

3. 在项目文件夹tes下打开cmd,运行命令

   ```
   cd .\client\src\main\webapp
   npm install
   ```

4. 在仓库文件夹下你可以找到online_evaluation_system.sql文件，并在mysql中创建数据库运行

5. 打开Redis服务，并设置密码为123456

6. 按顺序进入eureka-server-1，eureka-server-2，eureka-server-3，radis-server-1，radis-server-2，sql-server-1，sql-server-2，client文件夹，分别运行mvn spring-boot:run，保持网络和端口畅通，项目即可运行成功

# 缺陷

1. 管理员端修改学生信息功能缺失
2. 用户修改密码功能缺失
3. 搜索功能缺失
4. 无法监测用户登录状态

# 支持

若有疑问或者批评，欢迎给我发送e-mail到我的邮箱，我会在闲暇时一一为你答复

我的邮箱地址是EricPenguin123@outlook.com

# 感谢

在此感谢帮助我开发此项目的同学和老师，为我提供技术和架构上的咨询
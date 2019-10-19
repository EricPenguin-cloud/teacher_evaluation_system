# Teacher Evaluatin System

![](https://img.shields.io/badge/build-passing-green.svg)![](https://img.shields.io/badge/coverage-90%-yellowgreen.svg)  

![](https://img.shields.io/badge/java-1.8-red.svg)![](https://img.shields.io/badge/maven-3.6.0-yellow.svg)![](https://img.shields.io/badge/npm-6.11.3-orange.svg)![](https://img.shields.io/badge/mysql-8.0.15-lightgrey.svg)![](https://img.shields.io/badge/radis-3.2-blue.svg)![](https://img.shields.io/badge/springboot-2.1.9-lightgreen.svg)

# Language

- [English](README.md)
- [Chinese](README-CN.md)

# Background

This project is a practical training project developed by myself in school.As the teacher evaluation system, it has the basic function such as administrators to manage students, and teachers' information, students' evaluation, teacher evaluation, etc., functions and business processes is very simple, this is not suitable for also unnecessary use of distributed architecture, so I am more as a a try for the MVVM and distributed architecture model of the project for development, to the distributed architecture design and development experience of the future

# Features

- High concurrency: the project 's part of the fixed business data and cache use Redis for storage, at the same time, according to the platform and business to decouple modules of the project, encapsulated into multiple services, using Spring Cloud Eureka had these micro management services and use the Spring Cloud Ribbon for load balancing, ease in order to achieve high flow too much access to load the server problem

- High availability: each business module and registry has one or two identical microservice modules that are accessed in rotation by default polling.During an outage or maintenance of one of these services, the problem service will be disconnected to ensure the normal operation of the project

- Faster: adopt ES6+React. Js to develop the front-end viewModel module, and its unique virtual dom operation is faster than other methods

- High maintainability: this project has reasonable structure design, clear logic and high readability

  

# Architecture

![](https://github.com/EricPenguin-cloud/teacher_evaluation_system/blob/master/md_img/tes-4.png)

![](https://github.com/EricPenguin-cloud/teacher_evaluation_system/blob/master/md_img/tes-5.png)

# Visuals

![](https://github.com/EricPenguin-cloud/teacher_evaluation_system/blob/master/md_img/tes-1.png''管理员端数据可视化'')

![](https://github.com/EricPenguin-cloud/teacher_evaluation_system/blob/master/md_img/tes-2.png'评价列表示意'')

![](https://github.com/EricPenguin-cloud/teacher_evaluation_system/blob/master/md_img/tes-3.png''查看评价结果'')



# Requirements

- winows 10
- jdk 1.8
- maven 3.6.0
- mysql 8.0
- redis 3.2

# Installation

1. The command line run CMD '

   ```
   git clone https://github.com/EricPenguin-cloud/teacher_evaluation_system.git
   ```

2. when it has downloaded, click enter tes folder, get the file structure is as follows:

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

   

3. Open CMD under project folder tes and run the command:

   ```
   cd .\client\src\main\webapp
   npm install
   ```

4. In the warehouse folder you can find the online_evaluation_system.sql and create a database run in mysql

5. Open the Redis server and set the password to 123456

6. Enter eureka-server-1, eureka-server-2, eureka-server-3, radis-server-1, radis-server-2, sql-server-1, sql-server-2, client folder in sequence, run MVN spring-boot:run , keep the network and port unblocked, and the project can run successfully

# Bug List

1. The administrator side modification student information function is missing
2. Missing user password modification function
3. Missing search function
4. Unable to monitor user login status

# Support

If you have any questions or criticism, please send me E-mail to my mailbox, I will reply for you one by one in my spare time

My E-mail address is ericpenguins123@outlook.com

# Authors and Acknowledgment

I would like to thank my classmates and teachers who helped me develop this project and provided me with technical and structural advice

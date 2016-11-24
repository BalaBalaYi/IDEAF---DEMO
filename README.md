# Integration of Distributed Enterprise Application Frame - DEMO
# 综合性分布式企业级应用框架整合DEMO

本项目意在结合国内目前各大公司开源产品，对当今企业级分布式架构体系应用提供一个简易的项目示例方案。仅供参考和学习使用。

注：本示例所采用的各类框架和应用都是本着低耦合性的目的去选用的。通过源码可以看到业务逻辑非常简单，就是实现最基本的CRUD。但是因为涉及相关技术框架和应用较多，整个DEMO还是很“重”。所以若要完整实现本示例的全部功能，请首先部署并应用以下产品，参考如下。

<br/>
## DEMO应用架构体系图：
![](https://github.com/BalaBalaYi/IDEAF---DEMO/raw/master/resources/DEMO-ARCH.gif)  

<br/>
## 主要集成开源应用的介绍：

####一. sharding-jdbc:
当当的基于jdbc协议的数据库分库分表解决方案，完美衔接spring+mybaits的ORM层实现。在本项目中用于实现CRUD的分库分表及读写分离。

#####github:https://github.com/dangdangdotcom/sharding-jdbc
使用依赖：`jar包` `项目配置文件`


####二. otter:
阿里的数据同步解决方案。在本项目中用于实现基于sharding-jdbc读写分离的主从库之间的数据同步。

#####github:https://github.com/alibaba/otter
使用依赖：`zookeeper` `mysql`or`oracle`


####三. disconf:
百度的分布式文件配置解决方案。在本项目中用于实现灵活，高效，并且完美热部署的文件配置及修改等功能。

#####github:https://github.com/knightliao/disconf<br/>
#####官网文档：http://disconf.readthedocs.io/zh_CN/latest/
使用依赖：`jar包` `项目配置文件` `zookeeper` `redis` `nginx`


####四. dubbo(dubbox):
原为阿里的分布式服务框架，当当在此基础上进行了增强（建议使用dubbox，dubbo已经长时间没有得到维护）。本项目中通过dubbo-provider.xml简单模拟了通过dubbo实现的远程调用。

#####dubbox:github:https://github.com/dangdangdotcom/dubbox<br/>
#####dubbo:github:https://github.com/alibaba/dubbo<br/>
#####dubbo原官方文档：http://dubbo.io/User+Guide-zh.htm#UserGuide-zh-%E5%BF%AB%E9%80%9F%E5%90%AF%E5%8A%A8
使用依赖：`jar包` `项目配置文件` `zookeeper`


####五. elastic-job:
当当的分布式弹性作业框架，与sharding-jdbc实现共同异步化操作。暂未实现。

#####github:https://github.com/dangdangdotcom/elastic-job
使用依赖：`jar包` `项目配置文件`


####六. DataX+Hbase:
阿里开源的异构数据源离线同步工具。在本项目中，计划用于结合elastic-job和Hbase，以实现离线的历史数据查询及大数据处理的基础构建。暂未实现。

#####github:https://github.com/dangdangdotcom/elastic-job
使用依赖：`jar包` `项目配置文件`

<br/>
## 其它基础开源应用及组件：

####一. zookeeper:用于分布式应用程序协调。
#####github:https://github.com/apache/zookeeper

####二. redis:key-value存储系统（缓存）。
#####github:https://github.com/antirez/redis

####三. mybatis-pageHelper:mybatis的分页组件，完美支持mybatis+sharding-jdbc。
#####github:https://github.com/pagehelper/Mybatis-PageHelper

####四. dataTables:JQuery下的前端分页插件。（本项目中暂时是使用此组件实现的分页，因为数据量小，pageHelper并没有起到实际作用。请注意disconf中关于定义pageHelper每页大小的配置）
#####github:https://github.com/DataTables/DataTables/

####五. bootstrap：前端框架。
#####github:https://github.com/twbs/bootstrap

<br/>
## 如何部署并运行：

####一. 完整部署并运行上述主要集成的开源应用，当然zoopkeeper必须要有。

####二. 执行demo.sql脚本，建立DEMO主体应用所需的库和表（要求：mysql数据库）。

####三. 在项目根目录执行`mvn clean install -Dmaven.test.skip=true`。

####四. 找到位于target下的war包并修改配置文件：
        1.`jdbc.properties`:数据源地址及对应用户名和密码 （单url地址也是允许的，只要数据库区分开即可)
        2.`disconf.properties`:disconf的服务地址以及对应项目的相关配置
        3.`dubbo-provider.xml`:注册中心地址 
        4.`logback.xml`:日志输出策略及日志存放地址

####五. 将war包放入tomcat或其它应用容器部署运行。

#####war包download:http://pan.baidu.com/s/1eRRiogi

<br/>
## 效果图展示：
![项目示例首页](https://github.com/BalaBalaYi/IDEAF---DEMO/raw/master/resources/index.gif)  
![DEMO首页（查询页）](https://github.com/BalaBalaYi/IDEAF---DEMO/raw/master/resources/main.gif)  
![DEMO子页（添加页）](https://github.com/BalaBalaYi/IDEAF---DEMO/raw/master/resources/add.gif)  

<br/>
## 项目计划：

###V1.0 基础实现
>#####v1.0.0 底层支持应用+基础框架+基础代码            ——已实现
>#####v1.1.0 引入Druid及其附属功能，引入分布式自生成主键的实现          ——进行中
>#####v1.2.0 整合elastic-job，实现简单的异步化操作           ——未实现
        
###v2.0 elastic-job+datax+hbase 的大数据存储以及高效查询的整体实现           ——未实现

###v3.0 应用分布式化+分布式事务实现          ——未实现（这个......能不能坚持到这个时候，就看缘分了......）

<br/>
##最后由衷希望，能与从事java web开发以及刚接触分布式的小伙伴们，多多交流，多多学习！







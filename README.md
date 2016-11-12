# Integration of Distributed Enterprise Application Frame - DEMO
# 综合性分布式企业级应用框架整合DEMO

本项目意在结合国内目前各大公司开源产品，对当今企业级分布式架构体系应用提供较为合理的解决方案的项目示例，仅供参考和学习使用。

注：本示例所采用的各类框架和应用都是本着低耦合性的目的去选用的。通过源码可以看到业务逻辑非常简单，就是实现最基本的CRUD。但是因为涉及相关技术框架和应用较多，整个DEMO还是很“重”。所以若要完整实现本示例的全部功能，请首先部署并应用以下产品，参考如下。



## DEMO应用架构体系图：
![](https://github.com/BalaBalaYi/IDEAF---DEMO/raw/master/DEMO-ARCH.gif)  




## 主要集成开源应用的介绍：

####一.sharding-jdbc:
当当的基于jdbc协议的数据库分库分表解决方案，完美衔接spring+mybaits的ORM层实现。在本项目中用于实现CRUD的分库分表及读写分离。

#####github:https://github.com/dangdangdotcom/sharding-jdbc
使用依赖：`jar包` `项目配置文件`


####二.otter:
阿里的数据同步解决方案。在本项目中用于实现基于sharding-jdbc读写分离的主从库之间的数据同步。

#####github:https://github.com/alibaba/otter
使用依赖：`zookeeper` `mysql`or`oracle`


####三.disconf:
百度的分布式文件配置解决方案。在本项目中用于实现灵活，高效，并且完美热部署的文件配置及修改等功能。

#####github:https://github.com/alibaba/otter<br/>
#####官网文档：http://disconf.readthedocs.io/zh_CN/latest/
使用依赖：`jar包` `项目配置文件` `zookeeper` `redis` `nginx`


####四.dubbo(dubbox):
原为阿里的分布式服务框架，当当在此基础上进行了增强（建议使用dubbox，dubbo已经长时间没有得到维护）。本项目中通过dubbo-provider.xml简单模拟了通过dubbo实现的远程调用。

#####dubbox:github:https://github.com/dangdangdotcom/dubbox<br/>
#####dubbo:github:https://github.com/alibaba/dubbo<br/>
#####dubbo原官方文档：http://dubbo.io/User+Guide-zh.htm#UserGuide-zh-%E5%BF%AB%E9%80%9F%E5%90%AF%E5%8A%A8
使用依赖：`jar包` `项目配置文件` `zookeeper`


####五.elastic-job:
当当的分布式弹性作业框架，与sharding-jdbc实现共同异步化操作。暂未实现。

#####github:https://github.com/dangdangdotcom/elastic-job
使用依赖：`jar包` `项目配置文件`




## 其它基础开源应用及组件：

####一.zookeeper:用于分布式应用程序协调。
#####github:https://github.com/apache/zookeeper

####二.redis:key-value存储系统（缓存）。
#####github:https://github.com/antirez/redis

####三.mybatis-pageHelper:mybatis的分页组件，完美支持mybatis+sharding-jdbc。
#####github:https://github.com/pagehelper/Mybatis-PageHelper

####四.dataTables:JQuery下的前端分页插件。（本项目中暂时是使用此组件实现的分页，因为数据量小，pageHelper并没有起到实际作用。请注意disconf中关于定义pageHelper每页大小的配置）
#####github:https://github.com/DataTables/DataTables/

####五.bootstrap：前端框架。
#####github:https://github.com/twbs/bootstrap







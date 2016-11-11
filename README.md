# Integration of Distributed Enterprise Application Frame - DEMO
# 综合性分布式企业级应用框架整合DEMO

本项目意在结合国内目前各大公司开源产品，对当今企业级分布式架构体系应用提供较为合理的解决方案的项目示例，仅供参考和学习使用。

注：本示例所采用的各类框架和应用都是本着低耦合性的目的去选用的。通过源码可以看到业务逻辑非常简单，就是实现最基本的CRUD。但是因为涉及相关技术框架和应用较多，整个DEMO还是很“重”。所以若要完整实现本示例的全部功能，请首先部署并应用以下产品，参考如何下。


## 主要开源应用介绍：

####一.sharding-jdbc:
当当的基于jdbc协议的数据库分库分表解决方案，完美衔接spring+mybaits的ORM层实现。在本项目中用于实现CRUD的分库分表及读写分离。

github:https://github.com/dangdangdotcom/sharding-jdbc


####二.otter:
阿里的数据同步解决方案。在本项目中用于实现基于sharding-jdbc读写分离的主从库之间的数据同步。

#####github:https://github.com/alibaba/otter


####三.disconf:
百度的分布式文件配置解决方案。在本项目中用于实现灵活，高效，并且完美热部署的文件配置及修改等功能。

#####github:https://github.com/alibaba/otter<br/>
#####官网文件：http://disconf.readthedocs.io/zh_CN/latest/


####四.dubbo(dubbox):
原为阿里的分布式服务框架，当当在此基础上进行了增强。本项目中通过dubbo-provider.xml简单模拟了通过dubbo实现的远程调用。

#####dubbox:github:https://github.com/dangdangdotcom/dubbox<br/>
#####dubbo:github:https://github.com/alibaba/dubbo<br/>
#####dubbo原官方文档：http://dubbo.io/User+Guide-zh.htm#UserGuide-zh-%E5%BF%AB%E9%80%9F%E5%90%AF%E5%8A%A8


####五.elastic-job:
当当的分布式弹性作业框架，与sharding-jdbc实现共同异步化操作。暂未实现。

#####github:https://github.com/dangdangdotcom/elastic-job


## 其它基础开源应用及组件：
####一.zookeeper:
#####github:https://github.com/apache/zookeeper

####二.redis:

####三.mybatis-pageHelper:

####四.dataTables:

####五.bootstrap




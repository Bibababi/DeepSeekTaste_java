# 用java接入deepseek尝试


## 介绍
这是一个用maven框架构建的java项目  
就是随便试一试，尝试用java来访问deepseek，实现一些基本的多回合对话。  


## 导入方法
### 一、必要工具
1.jdk17及以上
2.IDEA开发环境
3.Maven （一个管理java各个依赖包的工具，虽然IDEA会自带但还是推荐自己下一个，也就50M左右）
4.DeepSeekAPI Key（想要接入deepseek，就得先去官网上申请一个key）
（5.git版本管理工具，这个不是必要的，但可以试着玩玩）

### 二、导入方法
1.先在IDEA中建一个maven项目，（先建一个空项目再加载maven也行）
2.配置pow文件，就把这里的pow文件复制粘贴进去就行（pow文件里主要引入了两个依赖包okhttp和gson，前者是用来网络访问的，后者是生成json文件的）
3.把main里的两个类DeepSeekClient类和Main类放在相应的文件夹里
4.在根目录创建一个叫做keys的文件夹，并在keys中创建一个可以key01.txt文件,把deepseek key复制粘贴进去


## 为什么不用python?
练习练习java能力  
安卓是用java语言开发的，想为之后做安卓的东西做准备。  





## 相关网站
deepseek官网：https://www.deepseek.com/zh  
deepseek帮助：https://api-docs.deepseek.com/  
java下载：https://www.oracle.com/cn/java/technologies/downloads/#java21  
Idea下载：https://www.jetbrains.com/idea/  
Maven下载：https://maven.apache.org/  
Git下载：https://git-scm.com/downloads  







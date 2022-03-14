-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: finance
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '管理员账户  主键id',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '管理员用户名',
  `password` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登录密码',
  `status` int DEFAULT NULL COMMENT '登录状态（0：离线   1：在线）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin','202cb962ac59075b964b07152d234b70',0);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_permissions`
--

DROP TABLE IF EXISTS `admin_permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_permissions` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '管理员权限表 主键自增',
  `adminId` int DEFAULT NULL COMMENT '管理员id',
  `permissionId` int DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_permissions`
--

LOCK TABLES `admin_permissions` WRITE;
/*!40000 ALTER TABLE `admin_permissions` DISABLE KEYS */;
INSERT INTO `admin_permissions` VALUES (95,1,10),(96,1,11),(97,1,12),(98,1,13),(99,1,14),(100,1,15),(101,1,16),(102,1,17),(103,1,18),(104,1,19),(105,1,20),(106,1,21),(107,1,22),(108,1,23),(109,1,24),(110,1,25);
/*!40000 ALTER TABLE `admin_permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `balance`
--

DROP TABLE IF EXISTS `balance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `balance` (
  `userId` int NOT NULL,
  `balance` decimal(20,2) DEFAULT '0.00',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `balance`
--

LOCK TABLES `balance` WRITE;
/*!40000 ALTER TABLE `balance` DISABLE KEYS */;
INSERT INTO `balance` VALUES (1,0.00),(2,0.00),(3,0.00),(4,0.00),(5,0.00),(6,0.00),(7,10000.00),(8,0.00),(12,0.00),(13,0.00);
/*!40000 ALTER TABLE `balance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bank`
--

DROP TABLE IF EXISTS `bank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bank` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '银行 主键id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '银行名称',
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '银行类型',
  `assets` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '资产',
  `bankDesc` varchar(20000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '银行描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank`
--

LOCK TABLES `bank` WRITE;
/*!40000 ALTER TABLE `bank` DISABLE KEYS */;
INSERT INTO `bank` VALUES (1,'中国工商银行','商业银行','2,076.14亿元','<pre><code><span style=\"background-color: rgb(249, 250, 251);\">&nbsp;&nbsp;&nbsp;&nbsp;</span><span style=\"font-weight: bold;\">中国工商银行（INDUSTRIAL AND COMMERCIAL BANK OF CHINA，简称ICBC ，工行）成立于1984年1月1日。</span><br>    总行位于北京复兴门内大街55号，是中央管理的大型国有银行，国家副部级单位。中国工商银行的基本任务是依据国家的法律和法规，通过国内外开展融资活动筹集社会资金，加强信贷资金管理，支持企业生产和技术改造，为我国经济建设服务。</code></pre><p><br></p><div><p><br></p></div>'),(2,'中国建设银行','商业银行','2,941.12亿元','<pre><code><span style=\"background-color: rgb(249, 250, 251);\">&nbsp;&nbsp;&nbsp;&nbsp;</span><span style=\"font-weight: bold;\">中国建设银行（China Construction Bank）成立于1954年10月1日。总行位于北京金融大街25号，是中央管理的大型国有银行， 国家副部级单位。 </span><br>    中国建设银行主要经营领域包括公司银行业务、个人银行业务和资金业务，在29个国家和地区设有分支机构及子公司，拥有基金、租赁、信托、人寿、财险、投行、期货、养老金等多个行业的子公司。</code></pre><p><br></p><div><p><br></p></div>'),(3,'中国民生银行','商业银行','7,685.66亿元','<pre><code><span style=\"background-color: rgb(249, 250, 251);\">&nbsp;&nbsp;&nbsp;&nbsp;</span><span style=\"font-weight: bold;\">中国民生银行（英文名称：China Minsheng Banking Corp., Ltd.，简称CMBC，民生银行，上交所：600016 港交所：01988）是中国大陆第一家由民间资本设立的全国性商业银行，成立于1996年1月12日。 </span><br>    主要大股东包括刘永好的新希望集团，张宏伟的东方集团，卢志强的中国泛海控股集团，王玉贵代表的中国船东互保协会，中国人寿保险股份公司，史玉柱等。</code></pre><p><br></p><div><p><br></p></div>'),(4,'中国农业银行','商业银行','10255.00亿元','<pre><code>    <span style=\"font-weight: bold;\">中国农业银行股份有限公司是中华人民共和国国有股份制银行，简称农行，为传统四大国有商业银行之一，注册资本为2600亿元人民币，以资产计算是中国内地第三大的银行。</span> <br>    据该行自己介绍，2002年底中国农业银行的资产总额为29765.66亿元人民币，营业机构遍布全国城乡，此外在新加坡、纽约、东京和伦敦有分行或代表处。1995年，中国农业银行在香港设立。2008年11月6日，中央汇金投资有限责任公司向农行注资1300亿元人民币等值美元（约190亿美元），注资后农行资本金达到2600亿元人民币。汇金公司将持有农行50%股份，与财政部并列成为农行第一大股东。2009年1月16日，股份制改制后的中国农业银行股份有限公司正式挂牌，计划在2010年上市。中国农业银行股份有限公司被巴菲特杂志、世界企业竞争力实验室、世界经济学人周刊联合评为2010年（第七届）中国上市公司100强，排名第6位。</code></pre><p><br></p><div><p><br></p></div>'),(5,'招商银行','股份制商业银行','12617.57亿元','<pre><code>    <span style=\"font-weight: bold;\">招商银行（China Merchants Bank）1987年成立于深圳蛇口，是中国境内第一家完全由企业法人持股的股份制商业银行，也是国家从体制外推动银行业改革的第一家试点银行。</span><br>    自2012年首次入围《财富》世界500强以来，已连续7年入围，2018年《财富》世界500强居213位。2019年6月26日，招商银行等8家银行首批上线运行企业信息联网核查系统。2019年7月，发布2019《财富》世界500强位列188位。2019年11月，“一带一路”中国企业100强榜单排名第85位。2019年12月，招商银行入选2019中国品牌强国盛典榜样100品牌。2019年12月18日，人民日报“中国品牌发展指数”100榜单排名第31位。2020年1月13日，入选2020胡润至尚优品获奖名单。2020年3月，入选2020年全球品牌价值500强第74位。2021年5月，位列“2021福布斯全球企业2000强”第22位。</code></pre><p><br></p>'),(9,'浦发银行','股份制商业银行','2512.53亿元','<pre><code><span style=\"font-weight: bold;\">上海浦东发展银行（简称：浦发银行或上海浦发银行）是1992年8月28日经中国人民银行批准设立、1993年1月9日开业、1999年在上海证券交易所成功挂牌上市（股票交易代码：600000）的全国性股份制商业银行，总行设在上海。</span><br>2018年，浦发银行位列美国《福布斯》“全球企业2000强”第70位；英国《银行家》“全球银行1000强”第25位；美国《财富》“世界500强”第227位。浦发银行是国内为数不多同时获得三大国际评级机构投资级以上评级的股份制商业银行之一。2019年7月，发布2019《财富》世界500强：位列216位。2019年9月1日，2019中国服务业企业500强榜单发布，上海浦东发展银行股份有限公司排名第29位。2020年3月，入选2020年全球品牌价值500强第134位。</code></pre><p><br></p><p><br></p>');
/*!40000 ALTER TABLE `bank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bankcard`
--

DROP TABLE IF EXISTS `bankcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bankcard` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '银行卡编号 主键自增',
  `cardBank` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '银行卡所属银行',
  `type` int DEFAULT NULL COMMENT '银行卡类型（1：借记卡  2：信用卡）',
  `cardNum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '银行卡号',
  `userId` int DEFAULT NULL COMMENT '银行卡所属用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bankcard`
--

LOCK TABLES `bankcard` WRITE;
/*!40000 ALTER TABLE `bankcard` DISABLE KEYS */;
INSERT INTO `bankcard` VALUES (1,'中国建设银行',1,'12345678945213124',1),(6,'中国民生银行',1,'12345678998765432',1),(7,'中国邮政储蓄银行',2,'1234567891234567',6),(8,'中国农业银行',1,'12345678910111213',7);
/*!40000 ALTER TABLE `bankcard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `change_money`
--

DROP TABLE IF EXISTS `change_money`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `change_money` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '零钱理财产品 主键id',
  `name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '理财产品名称',
  `annualIncome` decimal(10,8) DEFAULT NULL COMMENT '七日年化收益率',
  `peiIncome` decimal(10,2) DEFAULT NULL COMMENT '每万元收益',
  `invesTerm` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '投资期限',
  `invesMoney` decimal(10,2) DEFAULT NULL COMMENT '起投金额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `change_money`
--

LOCK TABLES `change_money` WRITE;
/*!40000 ALTER TABLE `change_money` DISABLE KEYS */;
INSERT INTO `change_money` VALUES (1,'支付宝零钱理财',0.03435000,0.99,'30天',100.00),(2,'微信零钱理财',0.03236000,0.98,'30天',100.00),(3,'理财通零钱理财',0.03222000,0.97,'30天',300.00),(4,'云闪付理财',0.03233000,0.88,'三个月',200.00);
/*!40000 ALTER TABLE `change_money` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exceptionlog`
--

DROP TABLE IF EXISTS `exceptionlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exceptionlog` (
  `exc_id` varchar(64) NOT NULL COMMENT '主键ID',
  `exc_requparam` text COMMENT '请求参数',
  `exc_name` varchar(255) DEFAULT NULL COMMENT '异常名称',
  `exc_message` text COMMENT '异常信息',
  `oper_username` varchar(64) DEFAULT NULL COMMENT '操作员名称',
  `oper_method` varchar(255) DEFAULT NULL COMMENT '操作方法',
  `oper_url` varchar(255) DEFAULT NULL COMMENT '请求URL',
  `oper_ip` varchar(64) DEFAULT NULL COMMENT '请求IP',
  `oper_createtime` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`exc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exceptionlog`
--

LOCK TABLES `exceptionlog` WRITE;
/*!40000 ALTER TABLE `exceptionlog` DISABLE KEYS */;
INSERT INTO `exceptionlog` VALUES ('0a555fa4daf84b129eba1fd0e0a76bd3','{}','java.lang.NullPointerException','java.lang.NullPointerException:null\n	com.bitzh.finance.controller.MyFinanceController.toMyFinance(MyFinanceController.java:37)\ncom.bitzh.finance.controller.MyFinanceController$$FastClassBySpringCGLIB$$c705cd8c.invoke(<generated>)\norg.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:769)\norg.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\norg.springframework.aop.aspectj.AspectJAfterThrowingAdvice.invoke(AspectJAfterThrowingAdvice.java:62)\norg.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\norg.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:95)\norg.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\norg.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:689)\ncom.bitzh.finance.controller.MyFinanceController$$EnhancerBySpringCGLIB$$b0c8daa4.toMyFinance(<generated>)\nsun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\nsun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\nsun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\njava.lang.reflect.Method.invoke(Method.java:498)\norg.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)\norg.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)\norg.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)\norg.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:879)\norg.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)\norg.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)\norg.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)\norg.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)\norg.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)\norg.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)\njavax.servlet.http.HttpServlet.service(HttpServlet.java:634)\norg.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)\njavax.servlet.http.HttpServlet.service(HttpServlet.java:741)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)\norg.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)\norg.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)\norg.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)\norg.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)\norg.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)\norg.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)\norg.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)\norg.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)\norg.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:387)\norg.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)\norg.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\ncom.bitzh.finance.common.EncodingFilter.doFilter(EncodingFilter.java:40)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\ncom.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:123)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)\norg.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)\norg.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\norg.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202)\norg.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:96)\norg.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:541)\norg.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:139)\norg.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)\norg.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)\norg.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343)\norg.apache.coyote.http11.Http11Processor.service(Http11Processor.java:367)\norg.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65)\norg.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:868)\norg.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1639)\norg.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)\njava.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)\njava.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)\norg.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)\njava.lang.Thread.run(Thread.java:748)','admin','com.bitzh.finance.controller.MyFinanceController.toMyFinance','/user/personal/toMyFinance.html','0:0:0:0:0:0:0:1','2022-03-12 12:11:12'),('18720c87ceb8450f9fd528393e340bd2','{}','java.lang.NullPointerException','java.lang.NullPointerException:null\n	com.bitzh.finance.controller.MyFinanceController.toMyFinance(MyFinanceController.java:37)\ncom.bitzh.finance.controller.MyFinanceController$$FastClassBySpringCGLIB$$c705cd8c.invoke(<generated>)\norg.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:769)\norg.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\norg.springframework.aop.aspectj.AspectJAfterThrowingAdvice.invoke(AspectJAfterThrowingAdvice.java:62)\norg.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\norg.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:95)\norg.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\norg.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:689)\ncom.bitzh.finance.controller.MyFinanceController$$EnhancerBySpringCGLIB$$b0c8daa4.toMyFinance(<generated>)\nsun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\nsun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\nsun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\njava.lang.reflect.Method.invoke(Method.java:498)\norg.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)\norg.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)\norg.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)\norg.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:879)\norg.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)\norg.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)\norg.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)\norg.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)\norg.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)\norg.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)\njavax.servlet.http.HttpServlet.service(HttpServlet.java:634)\norg.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)\njavax.servlet.http.HttpServlet.service(HttpServlet.java:741)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)\norg.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)\norg.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)\norg.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)\norg.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)\norg.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)\norg.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)\norg.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)\norg.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)\norg.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:387)\norg.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)\norg.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\ncom.bitzh.finance.common.EncodingFilter.doFilter(EncodingFilter.java:40)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\ncom.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:123)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)\norg.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)\norg.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\norg.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202)\norg.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:96)\norg.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:541)\norg.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:139)\norg.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)\norg.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)\norg.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343)\norg.apache.coyote.http11.Http11Processor.service(Http11Processor.java:367)\norg.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65)\norg.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:868)\norg.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1639)\norg.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)\njava.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)\njava.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)\norg.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)\njava.lang.Thread.run(Thread.java:748)','admin','com.bitzh.finance.controller.MyFinanceController.toMyFinance','/user/personal/toMyFinance.html','0:0:0:0:0:0:0:1','2022-03-12 12:11:06'),('84e3aff3846648c094c1d3f12e1098a7','{}','org.apache.ibatis.binding.BindingException','org.apache.ibatis.binding.BindingException:Invalid bound statement (not found): com.bitzh.finance.mapper.FundProductMapper.selectcount\n	org.apache.ibatis.binding.MapperMethod$SqlCommand.<init>(MapperMethod.java:235)\norg.apache.ibatis.binding.MapperMethod.<init>(MapperMethod.java:53)\norg.apache.ibatis.binding.MapperProxy.lambda$cachedMapperMethod$0(MapperProxy.java:98)\njava.util.concurrent.ConcurrentHashMap.computeIfAbsent(ConcurrentHashMap.java:1660)\norg.apache.ibatis.binding.MapperProxy.cachedMapperMethod(MapperProxy.java:97)\norg.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:92)\ncom.sun.proxy.$Proxy116.selectcount(Unknown Source)\nsun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\nsun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\nsun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\njava.lang.reflect.Method.invoke(Method.java:498)\norg.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:344)\norg.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:198)\norg.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)\ncom.alibaba.druid.support.spring.stat.DruidStatInterceptor.invoke(DruidStatInterceptor.java:72)\norg.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\norg.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:212)\ncom.sun.proxy.$Proxy117.selectcount(Unknown Source)\ncom.bitzh.finance.service.impl.FundProductServiceImpl.selectcount(FundProductServiceImpl.java:54)\ncom.bitzh.finance.service.impl.FundProductServiceImpl$$FastClassBySpringCGLIB$$fdadedec.invoke(<generated>)\norg.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:769)\norg.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\ncom.alibaba.druid.support.spring.stat.DruidStatInterceptor.invoke(DruidStatInterceptor.java:72)\norg.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\norg.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:689)\ncom.bitzh.finance.service.impl.FundProductServiceImpl$$EnhancerBySpringCGLIB$$282c97e0.selectcount(<generated>)\ncom.bitzh.finance.controller.StatController.toProductStat(StatController.java:35)\ncom.bitzh.finance.controller.StatController$$FastClassBySpringCGLIB$$12c0b50e.invoke(<generated>)\norg.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:769)\norg.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\norg.springframework.aop.aspectj.AspectJAfterThrowingAdvice.invoke(AspectJAfterThrowingAdvice.java:62)\norg.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\norg.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:95)\norg.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\norg.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:689)\ncom.bitzh.finance.controller.StatController$$EnhancerBySpringCGLIB$$408598da.toProductStat(<generated>)\nsun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\nsun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\nsun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\njava.lang.reflect.Method.invoke(Method.java:498)\norg.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)\norg.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)\norg.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)\norg.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:879)\norg.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)\norg.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)\norg.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)\norg.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)\norg.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)\norg.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)\njavax.servlet.http.HttpServlet.service(HttpServlet.java:634)\norg.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)\njavax.servlet.http.HttpServlet.service(HttpServlet.java:741)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)\norg.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)\norg.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)\norg.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)\norg.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)\norg.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)\norg.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)\norg.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)\norg.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)\norg.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:387)\norg.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)\norg.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\ncom.bitzh.finance.common.EncodingFilter.doFilter(EncodingFilter.java:40)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\ncom.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:123)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)\norg.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)\norg.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\norg.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202)\norg.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:96)\norg.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:541)\norg.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:139)\norg.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)\norg.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)\norg.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343)\norg.apache.coyote.http11.Http11Processor.service(Http11Processor.java:367)\norg.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65)\norg.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:868)\norg.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1639)\norg.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)\njava.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)\njava.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)\norg.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)\njava.lang.Thread.run(Thread.java:748)','admin','com.bitzh.finance.controller.StatController.toProductStat','/admin/finance/toProductStat.html','0:0:0:0:0:0:0:1','2022-03-12 17:00:52'),('8f873511a68d4a2f827de2f8ef8b72f0','{}','java.lang.NullPointerException','java.lang.NullPointerException:null\n	com.bitzh.finance.controller.MyFinanceController.toMyFinance(MyFinanceController.java:37)\ncom.bitzh.finance.controller.MyFinanceController$$FastClassBySpringCGLIB$$c705cd8c.invoke(<generated>)\norg.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:769)\norg.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\norg.springframework.aop.aspectj.AspectJAfterThrowingAdvice.invoke(AspectJAfterThrowingAdvice.java:62)\norg.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\norg.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:95)\norg.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\norg.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:689)\ncom.bitzh.finance.controller.MyFinanceController$$EnhancerBySpringCGLIB$$b0c8daa4.toMyFinance(<generated>)\nsun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\nsun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\nsun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\njava.lang.reflect.Method.invoke(Method.java:498)\norg.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)\norg.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)\norg.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)\norg.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:879)\norg.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)\norg.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)\norg.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)\norg.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)\norg.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)\norg.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)\njavax.servlet.http.HttpServlet.service(HttpServlet.java:634)\norg.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)\njavax.servlet.http.HttpServlet.service(HttpServlet.java:741)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)\norg.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)\norg.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)\norg.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)\norg.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)\norg.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)\norg.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)\norg.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)\norg.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)\norg.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:387)\norg.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)\norg.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\ncom.bitzh.finance.common.EncodingFilter.doFilter(EncodingFilter.java:40)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\ncom.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:123)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)\norg.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)\norg.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\norg.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202)\norg.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:96)\norg.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:541)\norg.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:139)\norg.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)\norg.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)\norg.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343)\norg.apache.coyote.http11.Http11Processor.service(Http11Processor.java:367)\norg.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65)\norg.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:868)\norg.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1639)\norg.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)\njava.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)\njava.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)\norg.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)\njava.lang.Thread.run(Thread.java:748)','admin','com.bitzh.finance.controller.MyFinanceController.toMyFinance','/user/personal/toMyFinance.html','0:0:0:0:0:0:0:1','2022-03-12 12:11:03'),('b82efcdb1b2243ceadeb54a7638b9920','{}','org.springframework.jdbc.BadSqlGrammarException','org.springframework.jdbc.BadSqlGrammarException:\r\n### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'*)\n        from user\n        where status = 1\' at line 2\r\n### The error may exist in file [E:\\project\\理财管理\\finance\\target\\classes\\com\\bitzh\\finance\\mapper\\UserMapper.xml]\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: select         count (*)         from user         where status = 1;\r\n### Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'*)\n        from user\n        where status = 1\' at line 2\n; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'*)\n        from user\n        where status = 1\' at line 2\n	org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator.doTranslate(SQLErrorCodeSQLExceptionTranslator.java:235)\norg.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:72)\norg.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:88)\norg.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:440)\ncom.sun.proxy.$Proxy77.selectOne(Unknown Source)\norg.mybatis.spring.SqlSessionTemplate.selectOne(SqlSessionTemplate.java:159)\norg.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:87)\norg.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:93)\ncom.sun.proxy.$Proxy78.selectOnlineUser(Unknown Source)\nsun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\nsun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\nsun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\njava.lang.reflect.Method.invoke(Method.java:498)\norg.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:344)\norg.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:198)\norg.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)\ncom.alibaba.druid.support.spring.stat.DruidStatInterceptor.invoke(DruidStatInterceptor.java:72)\norg.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\norg.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:212)\ncom.sun.proxy.$Proxy79.selectOnlineUser(Unknown Source)\ncom.bitzh.finance.service.impl.UserServiceImpl.selectOnlineUser(UserServiceImpl.java:83)\ncom.bitzh.finance.service.impl.UserServiceImpl$$FastClassBySpringCGLIB$$6199b489.invoke(<generated>)\norg.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:769)\norg.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\ncom.alibaba.druid.support.spring.stat.DruidStatInterceptor.invoke(DruidStatInterceptor.java:72)\norg.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\norg.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:689)\ncom.bitzh.finance.service.impl.UserServiceImpl$$EnhancerBySpringCGLIB$$270c13b7.selectOnlineUser(<generated>)\ncom.bitzh.finance.controller.MainController.toAdminIndex(MainController.java:82)\ncom.bitzh.finance.controller.MainController$$FastClassBySpringCGLIB$$d4057a33.invoke(<generated>)\norg.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:769)\norg.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\norg.springframework.aop.aspectj.AspectJAfterThrowingAdvice.invoke(AspectJAfterThrowingAdvice.java:62)\norg.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\norg.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:95)\norg.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\norg.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:689)\ncom.bitzh.finance.controller.MainController$$EnhancerBySpringCGLIB$$29a8b874.toAdminIndex(<generated>)\nsun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\nsun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\nsun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\njava.lang.reflect.Method.invoke(Method.java:498)\norg.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)\norg.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)\norg.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)\norg.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:879)\norg.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)\norg.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)\norg.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)\norg.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)\norg.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)\norg.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)\njavax.servlet.http.HttpServlet.service(HttpServlet.java:634)\norg.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)\njavax.servlet.http.HttpServlet.service(HttpServlet.java:741)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)\norg.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)\norg.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)\norg.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)\norg.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)\norg.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)\norg.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)\norg.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)\norg.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)\norg.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:387)\norg.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)\norg.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\ncom.bitzh.finance.common.EncodingFilter.doFilter(EncodingFilter.java:40)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\ncom.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:123)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)\norg.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)\norg.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\norg.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202)\norg.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:96)\norg.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:541)\norg.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:139)\norg.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)\norg.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)\norg.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343)\norg.apache.coyote.http11.Http11Processor.service(Http11Processor.java:367)\norg.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65)\norg.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:868)\norg.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1639)\norg.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)\njava.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)\njava.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)\norg.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)\njava.lang.Thread.run(Thread.java:748)','admin','com.bitzh.finance.controller.MainController.toAdminIndex','/admin/index.html','0:0:0:0:0:0:0:1','2022-03-08 16:32:22'),('cb9d8bcb35e44a4bb3b9192486dc8fb5','{}','org.springframework.jdbc.BadSqlGrammarException','org.springframework.jdbc.BadSqlGrammarException:\r\n### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'*)\n        from user\n        where status = 1\' at line 2\r\n### The error may exist in file [E:\\project\\理财管理\\finance\\target\\classes\\com\\bitzh\\finance\\mapper\\UserMapper.xml]\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: select         count (*)         from user         where status = 1;\r\n### Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'*)\n        from user\n        where status = 1\' at line 2\n; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'*)\n        from user\n        where status = 1\' at line 2\n	org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator.doTranslate(SQLErrorCodeSQLExceptionTranslator.java:235)\norg.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:72)\norg.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:88)\norg.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:440)\ncom.sun.proxy.$Proxy77.selectOne(Unknown Source)\norg.mybatis.spring.SqlSessionTemplate.selectOne(SqlSessionTemplate.java:159)\norg.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:87)\norg.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:93)\ncom.sun.proxy.$Proxy78.selectOnlineUser(Unknown Source)\nsun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\nsun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\nsun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\njava.lang.reflect.Method.invoke(Method.java:498)\norg.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:344)\norg.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:198)\norg.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)\ncom.alibaba.druid.support.spring.stat.DruidStatInterceptor.invoke(DruidStatInterceptor.java:72)\norg.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\norg.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:212)\ncom.sun.proxy.$Proxy79.selectOnlineUser(Unknown Source)\ncom.bitzh.finance.service.impl.UserServiceImpl.selectOnlineUser(UserServiceImpl.java:83)\ncom.bitzh.finance.service.impl.UserServiceImpl$$FastClassBySpringCGLIB$$6199b489.invoke(<generated>)\norg.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:769)\norg.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\ncom.alibaba.druid.support.spring.stat.DruidStatInterceptor.invoke(DruidStatInterceptor.java:72)\norg.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\norg.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:689)\ncom.bitzh.finance.service.impl.UserServiceImpl$$EnhancerBySpringCGLIB$$270c13b7.selectOnlineUser(<generated>)\ncom.bitzh.finance.controller.MainController.toAdminIndex(MainController.java:82)\ncom.bitzh.finance.controller.MainController$$FastClassBySpringCGLIB$$d4057a33.invoke(<generated>)\norg.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:769)\norg.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\norg.springframework.aop.aspectj.AspectJAfterThrowingAdvice.invoke(AspectJAfterThrowingAdvice.java:62)\norg.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\norg.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:95)\norg.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\norg.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\norg.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:689)\ncom.bitzh.finance.controller.MainController$$EnhancerBySpringCGLIB$$29a8b874.toAdminIndex(<generated>)\nsun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\nsun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\nsun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\njava.lang.reflect.Method.invoke(Method.java:498)\norg.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)\norg.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)\norg.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)\norg.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:879)\norg.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)\norg.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)\norg.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)\norg.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)\norg.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)\norg.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)\njavax.servlet.http.HttpServlet.service(HttpServlet.java:634)\norg.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)\njavax.servlet.http.HttpServlet.service(HttpServlet.java:741)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)\norg.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)\norg.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)\norg.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)\norg.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)\norg.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)\norg.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)\norg.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)\norg.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)\norg.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:387)\norg.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)\norg.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\ncom.bitzh.finance.common.EncodingFilter.doFilter(EncodingFilter.java:40)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\ncom.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:123)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)\norg.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)\norg.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\norg.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\norg.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\norg.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\norg.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202)\norg.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:96)\norg.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:541)\norg.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:139)\norg.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)\norg.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)\norg.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343)\norg.apache.coyote.http11.Http11Processor.service(Http11Processor.java:367)\norg.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65)\norg.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:868)\norg.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1639)\norg.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)\njava.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)\njava.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)\norg.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)\njava.lang.Thread.run(Thread.java:748)','admin','com.bitzh.finance.controller.MainController.toAdminIndex','/admin/index.html','0:0:0:0:0:0:0:1','2022-03-08 16:32:15');
/*!40000 ALTER TABLE `exceptionlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flow_of_funds`
--

DROP TABLE IF EXISTS `flow_of_funds`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flow_of_funds` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '资金记录表 id主键自增',
  `userId` int DEFAULT NULL COMMENT '所属用户',
  `flowMoney` decimal(20,2) DEFAULT NULL COMMENT '金额',
  `type` int DEFAULT NULL COMMENT '类型（1：支出  2：收入）',
  `source` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '来源',
  `createTime` date DEFAULT NULL COMMENT '创建时间',
  `fundDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flow_of_funds`
--

LOCK TABLES `flow_of_funds` WRITE;
/*!40000 ALTER TABLE `flow_of_funds` DISABLE KEYS */;
/*!40000 ALTER TABLE `flow_of_funds` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fund_product`
--

DROP TABLE IF EXISTS `fund_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fund_product` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '基金理财产品  主键id',
  `type` int DEFAULT NULL COMMENT '基金类型(1:股票型基金  2:债券型基金  3:货币型基金  4:混合型基金)',
  `code` int DEFAULT NULL COMMENT '基金代码',
  `fundDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '基金简称',
  `dailyGrowth` decimal(10,8) DEFAULT NULL COMMENT '日增长率',
  `monthlyGrowth` decimal(10,8) DEFAULT NULL COMMENT '月增长率',
  `annualGrowth` decimal(10,8) DEFAULT NULL COMMENT '年增长率',
  `leastMoney` decimal(10,2) DEFAULT NULL COMMENT '起投金额',
  `invesTerm` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '投资期限',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fund_product`
--

LOCK TABLES `fund_product` WRITE;
/*!40000 ALTER TABLE `fund_product` DISABLE KEYS */;
INSERT INTO `fund_product` VALUES (1,1,143745,'广发多元新兴股票',-0.02720000,0.06090000,0.80550000,100.00,'两个月'),(2,4,519933,'长信利发债券',-0.00100000,0.03030000,0.23820000,100.00,'一个月');
/*!40000 ALTER TABLE `fund_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `info`
--

DROP TABLE IF EXISTS `info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '消息编号 主键自增',
  `sendId` int DEFAULT NULL COMMENT '消息发送者id（admin）',
  `receiveId` int DEFAULT NULL COMMENT '消息接收者id（user）',
  `createTime` date DEFAULT NULL COMMENT '消息创建时间',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '消息标题',
  `infoDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '消息内容',
  `status` int DEFAULT NULL COMMENT '消息状态（0：未读  1：已读）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `info`
--

LOCK TABLES `info` WRITE;
/*!40000 ALTER TABLE `info` DISABLE KEYS */;
INSERT INTO `info` VALUES (3,1,1,'2020-03-13','World','测试内容',1),(4,1,1,'2020-03-15','还款通知','用户lisi申请的9999.00元网贷该还款了！该提醒发送人为：admin',1),(6,1,3,'2020-03-18','网贷审核通过','用户zhangsan的123.00元网贷申请审核通过！审核人为：admin',0),(8,1,6,'2021-12-07','还款通知','用户zhangsan申请的123.00元网贷该还款了！该提醒发送人为：admin',0),(9,1,6,'2021-12-07','还款通知','用户zhangsan申请的123.00元网贷该还款了！该提醒发送人为：admin',0),(10,1,7,'2022-01-02','借款审核通过','用户lhj的1.00元借款申请审核通过！审核人为：admin',1),(11,1,7,'2022-01-02','借款审核通过','用户lhj的1.00元借款申请审核通过！审核人为：admin',1);
/*!40000 ALTER TABLE `info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loan`
--

DROP TABLE IF EXISTS `loan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loan` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '网贷信息表id 主键自增',
  `loanId` int DEFAULT NULL COMMENT '借贷人id（用户）',
  `examineId` int DEFAULT NULL COMMENT '审核人id（管理员）',
  `loanTime` date DEFAULT NULL COMMENT '借贷时间',
  `amount` decimal(10,2) DEFAULT NULL COMMENT '借贷金额',
  `term` int DEFAULT NULL COMMENT '借贷期限（天）',
  `rate` decimal(10,8) DEFAULT NULL COMMENT '固定年借贷利率',
  `applyStatus` int DEFAULT NULL COMMENT '申请状态（0：未审核  1：审核未通过  2：审核通过）',
  `loanStatus` int DEFAULT NULL COMMENT '借贷状态（0：未逾期  1：逾期  2：已还请）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loan`
--

LOCK TABLES `loan` WRITE;
/*!40000 ALTER TABLE `loan` DISABLE KEYS */;
/*!40000 ALTER TABLE `loan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `news` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '新闻资讯id 主键自增',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '标题',
  `newsDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '内容',
  `createTime` date DEFAULT NULL COMMENT '新闻发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (1,'个人理财简介','个人理财，是在对个人收入、资产、负债等数据进行分析整理的基础上，根据个人对风险的偏好和承受能力，结合预定目标运用诸如储蓄、保险、证券、外汇、收藏、住房投资等多种手段管理资产和负债，合理安排资金，从而在个人风险可以接受范围内实现资产增值的最大化的过程。','2021-12-09'),(2,'工行广灵支行个人理财业务实现了快速增长','今年以来，工商银行大同分行广灵支行清醒地认识到抢抓个人理财产品的营销，是提升中间业务收入增长的有效途径。立足早抓快抓争抢市场和客户，以存款低消耗的总原则，不断加大营销力度，挖掘营销潜力，个人理财业务实现了快速增长。','2021-12-10'),(3,'银行理财产品收益率走低 个人理财如何打“钱锋”？','对老百姓来说，如何实现自身财产的保值增值呢？专家建议，可以进行多元化的资产配置，4321理财法则是比较常见的资产配置方式，即40%的资金用于投资、30%生活开销、20%储蓄备用、10%保险。根据自身可承受的风险，保守型和稳健型的客户，可以做一些大额存单以及结构性存款，这些产品都是保本的，纳入存款保险制度；追求高投资收益的客户，可以适当配置风险相对高，但是收益也会高一些的权益类投资。除了银行理财产品，目前适合普通大众投资的资产，还有国债、结构性存款、大额存单、基金定投、券商集合理财等。','2021-12-10'),(4,'为什么要理财？做好个人理财规划，实现属于你的财富自由！','理财是伴随我们一生的财务规划，因为在人的一生中，根据不同的年龄阶段，会有着不同的财务状况和需求，所以说在不同的年龄段，我们的生活支出是不断变化的，理财的长期目标就是要实现我们财务上的收支平衡甚至盈余。另一方面，我们的生活中一直暴露着很多的风险，比如我们的工资收入以及身体的健康等等，如果它们能一直稳定的持续下去那当然是好事，但我们也应该未雨绸缪，通过做好理财措施，实现财富的积累和搭建多渠道的收入来源，避免当某一天意外发生时，我们会因为无法工作而让自己处于没有钱能用的状态。','2021-12-11');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operationlog`
--

DROP TABLE IF EXISTS `operationlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `operationlog` (
  `oper_id` varchar(64) NOT NULL COMMENT '主键ID',
  `oper_modul` varchar(64) DEFAULT NULL COMMENT '功能模块',
  `oper_type` varchar(64) DEFAULT NULL COMMENT '操作类型',
  `oper_desc` varchar(500) DEFAULT NULL COMMENT '操作描述',
  `oper_requparam` text COMMENT '请求参数',
  `oper_respparam` text COMMENT '返回参数',
  `oper_username` varchar(64) DEFAULT NULL COMMENT '操作员名称',
  `oper_method` varchar(255) DEFAULT NULL COMMENT '操作方法',
  `oper_url` varchar(255) DEFAULT NULL COMMENT '请求URL',
  `oper_ip` varchar(64) DEFAULT NULL COMMENT '请求IP',
  `oper_createtime` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operationlog`
--

LOCK TABLES `operationlog` WRITE;
/*!40000 ALTER TABLE `operationlog` DISABLE KEYS */;
/*!40000 ALTER TABLE `operationlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pay_money`
--

DROP TABLE IF EXISTS `pay_money`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pay_money` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '工资理财 主键id',
  `name` varchar(25) DEFAULT NULL,
  `type` int DEFAULT NULL COMMENT '产品类型（1：国债  2：期货）',
  `monthMoney` decimal(10,2) DEFAULT NULL COMMENT '每月金额设定',
  `autoInto` int DEFAULT NULL COMMENT '1:每月自动转入   2：每月不自动转入',
  `invesTerm` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '投资期限',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pay_money`
--

LOCK TABLES `pay_money` WRITE;
/*!40000 ALTER TABLE `pay_money` DISABLE KEYS */;
INSERT INTO `pay_money` VALUES (1,'短期国债',1,1000.00,1,'半年'),(2,'期货',2,2000.00,2,'一年'),(3,'长期国债',1,3600.00,2,'两年'),(4,'中期国债',1,3000.00,1,'一年'),(5,'短期期货',2,1000.00,1,'半年');
/*!40000 ALTER TABLE `pay_money` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissions`
--

DROP TABLE IF EXISTS `permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permissions` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '权限id 主键自增',
  `permission` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissions`
--

LOCK TABLES `permissions` WRITE;
/*!40000 ALTER TABLE `permissions` DISABLE KEYS */;
INSERT INTO `permissions` VALUES (1,'user:finance'),(2,'user:changeMoney'),(3,'user:payMoney'),(4,'user:termFinancial'),(5,'user:fundProduct'),(6,'user:bank'),(7,'user:tools'),(8,'user:loan'),(9,'user:record'),(10,'admin:userInfo'),(11,'admin:bankCard'),(12,'admin:reputation'),(13,'admin:userInfoElse'),(14,'admin:finance'),(15,'admin:changeMoney'),(16,'admin:payMoney'),(17,'admin:termFinancial'),(18,'admin:fundProduct'),(19,'admin:bank'),(20,'admin:permission'),(21,'admin:userPermissions'),(22,'admin:adminPermissions'),(23,'admin:loan'),(24,'admin:loanExam'),(25,'admin:loanInfo');
/*!40000 ALTER TABLE `permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `term_financial`
--

DROP TABLE IF EXISTS `term_financial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `term_financial` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '期限理财产品 主键id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '产品名称',
  `invesTerm` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '投资期限',
  `leastMoney` decimal(10,2) DEFAULT NULL COMMENT '起投金额',
  `profit` int DEFAULT NULL COMMENT '收益方式(1:收益型  2:净值型)',
  `annualIncome` decimal(10,8) DEFAULT NULL COMMENT '七日年化收益率',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `term_financial`
--

LOCK TABLES `term_financial` WRITE;
/*!40000 ALTER TABLE `term_financial` DISABLE KEYS */;
INSERT INTO `term_financial` VALUES (1,'支付宝期限理财','半年',5000.00,1,0.04489000),(2,'P2P期限理财','一年',8000.00,2,0.04371000);
/*!40000 ALTER TABLE `term_financial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户id 主键自增',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `realname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '真实姓名',
  `password` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登录密码',
  `IDcard` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '身份证号',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `paypwd` int DEFAULT NULL COMMENT '交易密码',
  `status` int DEFAULT NULL COMMENT '用户状态（0：离线   1：在线）',
  `reputation` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户信誉',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'lisi','李四','e10adc3949ba59abbe56e057f20f883e','110101199703142123','15188888888','123123@qq.com',123456,0,'良好'),(2,'inmaps','赵六','e10adc3949ba59abbe56e057f20f883e','110101199608142123','12345678912','2333@233.com',123456,0,'超级优秀'),(3,'zhangsan','张三','e10adc3949ba59abbe56e057f20f883e','110101199703142123','15188888888','567567@qq.com',123456,0,'良好'),(4,'wangwu','王五','e10adc3949ba59abbe56e057f20f883e',NULL,'13338106110','567567@qq.com',NULL,0,'差'),(6,'zhaoliu',NULL,'e10adc3949ba59abbe56e057f20f883e',NULL,NULL,NULL,NULL,0,'良好'),(7,'lhj','梁鸿基','202cb962ac59075b964b07152d234b70',NULL,NULL,NULL,NULL,1,'良好'),(8,'180021101056',NULL,'cc3c79c4d0e212c1fd5ddd11b5b519e6',NULL,NULL,NULL,NULL,0,'良好');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_change_money`
--

DROP TABLE IF EXISTS `user_change_money`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_change_money` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户-零钱理财 投资表id 主键自增',
  `userId` int DEFAULT NULL COMMENT '用户id',
  `changeId` int DEFAULT NULL COMMENT '零钱理财产品id',
  `startTime` date DEFAULT NULL COMMENT '起投时间',
  `averYield` decimal(10,8) DEFAULT NULL COMMENT '平均收益率',
  `profit` decimal(20,2) DEFAULT NULL COMMENT '收益',
  `status` int DEFAULT NULL COMMENT '投资状态（1：持有中  2：已失效  3：已撤销）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_change_money`
--

LOCK TABLES `user_change_money` WRITE;
/*!40000 ALTER TABLE `user_change_money` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_change_money` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_fund_product`
--

DROP TABLE IF EXISTS `user_fund_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_fund_product` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户-基金理财 投资表id 主键 自增',
  `userId` int DEFAULT NULL COMMENT '用户id',
  `fundId` int DEFAULT NULL COMMENT '基金产品id',
  `startTime` date DEFAULT NULL COMMENT '起投时间',
  `averYield` decimal(10,8) DEFAULT NULL COMMENT '平均投资率',
  `profit` decimal(10,2) DEFAULT NULL COMMENT '收益',
  `status` int DEFAULT NULL COMMENT '投资状态（1：持有中  2：已失效  3：已撤销）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_fund_product`
--

LOCK TABLES `user_fund_product` WRITE;
/*!40000 ALTER TABLE `user_fund_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_fund_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_pay_money`
--

DROP TABLE IF EXISTS `user_pay_money`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_pay_money` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户-工资理财 投资表id 主键自增',
  `userId` int DEFAULT NULL COMMENT '用户id',
  `payId` int DEFAULT NULL COMMENT '工资理财产品id',
  `startTime` date DEFAULT NULL COMMENT '起投时间',
  `averYield` decimal(10,8) DEFAULT NULL COMMENT '平均收益率',
  `profit` decimal(20,2) DEFAULT NULL COMMENT '收益',
  `status` int DEFAULT NULL COMMENT '投资状态（1：持有中  2：已失效  3：已撤销）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_pay_money`
--

LOCK TABLES `user_pay_money` WRITE;
/*!40000 ALTER TABLE `user_pay_money` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_pay_money` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_permissions`
--

DROP TABLE IF EXISTS `user_permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_permissions` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户权限中间表id 主键自增',
  `userId` int DEFAULT NULL COMMENT '用户id',
  `permissionId` int DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_permissions`
--

LOCK TABLES `user_permissions` WRITE;
/*!40000 ALTER TABLE `user_permissions` DISABLE KEYS */;
INSERT INTO `user_permissions` VALUES (121,1,1),(122,1,2),(123,1,3),(124,1,4),(125,1,5),(126,1,6),(127,1,7),(128,1,9),(129,1,8);
/*!40000 ALTER TABLE `user_permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_term_financial`
--

DROP TABLE IF EXISTS `user_term_financial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_term_financial` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户-期限理财 投资表id 主键自增',
  `userId` int DEFAULT NULL COMMENT '用户id',
  `termId` int DEFAULT NULL COMMENT '期限理财产品id',
  `startTime` date DEFAULT NULL COMMENT '起投时间',
  `averYield` decimal(10,8) DEFAULT NULL COMMENT '平均收益率',
  `profit` decimal(10,2) DEFAULT NULL COMMENT '收益',
  `status` int DEFAULT NULL COMMENT '投资状态（1：持有中  2：已失效  3：已撤销）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_term_financial`
--

LOCK TABLES `user_term_financial` WRITE;
/*!40000 ALTER TABLE `user_term_financial` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_term_financial` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-14 15:24:48

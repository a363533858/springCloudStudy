# springCloudStudy
springCloud学习库

端口占用
	configServer:	10040
	zuul:	10030
	consumerA:	10020
	providerA:	10010
	registry:	11000
	
依赖服务

	configServer:	web,config-server

	zuul:	eureka-client,netflix-zuul,web
		
	consumerA:	eureka-client,web,openfeign
   
	providerA:	eureka-client,config-client,web
   
	registry:	eureka-server
	
	
配置服务

	1.当读取的配置文件名字叫 config-client-dev.properties根据规则 /{application}-{profile}.properties该文件只能给应用名叫config-client的服务当配置文件,所以一个字符都不能改。可以用http://localhost:8888/config-client/dev 访问得到配置文件信息
	
	2.config-client从config-server默认用8888端口读取，如果想要修改，需要在bootstrap.properties上修改配置


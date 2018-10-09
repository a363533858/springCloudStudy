# springCloudStudy
springCloud学习库

端口占用
configServer:	10040
		zuul:	10030
   consumerA:	10020
   providerA:	10010
    registry:	11000
	
配置服务
	当读取的配置文件名字叫 config-client-dev.properties根据规则 /{application}-{profile}.properties该文件只能给应用名叫config-client的服务当配置文件,所以一个字符都不能改。可以用http://localhost:8888/config-client/dev 访问得到配置文件信息


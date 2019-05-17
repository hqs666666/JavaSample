FROM tomcat:8-alpine
ENV TZ=Asia/Shanghai
COPY target/JavaSample.war  /usr/local/tomcat/webapps

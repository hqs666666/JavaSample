FROM tomcat:8-alpine
COPY target/JavaSample.war  /usr/local/tomcat/webapps
I have use the following technologies for which I have attached the screenshot of all the artefacts that was required.

a) Spring Boot
b) Java 1.8
c) Postman for sending request in GET and POST-- Restful services.
d) Maven for automated building the project.
e) SOAP UI for testing the SOAP Webservices.
f) Active MQ for JMS.
g) Apacahe Derby Database: The capability provided by Spring Boot which automatically uses the Database. Other DB (MYSQL,Oracle etc) can be connected with the configuration in Application.properties (src/main/resources)


There are three projects created:
1) UnicEntry: This project is for creating the EAR file of UnicoRest and UnicoSOAP. 
			- Built on Maven
			- Have pom.xml which has depenency for UnicoRest and UnicoSOAP project. I have attached the logs of successfully generated EAR.
2) UnicoRest: This project is for creating Restul Webservices which does the following:
			- Implements the JMS Queue using ApacheMQ which send the request to the queue. Screenshot attached.
			- All request sent to JMS are in persistent (default) whih takes care of server tolerant as per the requirement. Screenshot attached in Word DOC.
			- Has two Services as to push and getAllItems in a List<>.
			- Implemented secure Login feature as provided by SPring boot in UnicoSecurity. 
			- UnicoSecurity java is used for maintaing the username and password / maximum session of 20 (capability provided by Spring boot) for all the urls deployed on servers.
			- Database connectivity is done by JPA capability provided by Spring boot as it is included in dependency of pom.xml (apache derby and JPA).
3) UnicoSOAP: This project is for creating SOAP Webservices which does the following:
			- Exposes three webservices for which screenshot and its relevant request/response xml can be seen.
			- SOAP implemetation includes the endpoint and WebserviceConfiguration to invoke all the three services.
			- It is validated through gcd.xsd as present in src/main/resources.
			- WSDL can be get through http://<hostname>:<port>/unico/ws/gcd?wsdl


Final EAR is auto-created /UnicEntry/target/UnicoEntry/UnicoEntry.ear which is ready to be deployed on any app server.


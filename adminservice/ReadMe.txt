
1. create spring boot starter project with Spring Web and Eureka Discovery Client
2. Annotate AdmineServiceApplication.java with @EnableEurekaClient
3. place application.yml file in src/main/resources
4. server port and application name also add in application.properties if they are not read correctly from .yml file
5. Run the application and check the URL http://localhost:7091 from postman
6. check the Eureka server URL : http://localhost:8761 - check if ADMIN-SERVICE registered




http://localhost:7091/admin



http://localhost:8761/admin
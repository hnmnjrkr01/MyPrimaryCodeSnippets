

1. create spring boot starter project with Spring Web and Eureka Discovery Client and Spring GateWay
2. Annotate GatewayServiceApplication.java with @EnableEurekaClient
3. place application.yml file in src/main/resources
4. server port and application name also add in application.properties if they are not read correctly from .yml file
5. Run the application and check the URL http://localhost:8989 from postman
6. check the Eureka server URL : http://localhost:8761 - check if GATEWAY-SERVICE registered


Check below URL for testing employee, admin, help services through gateway service from postman

1: for Employee 
	1. getAllEMp - http://localhost:8989/employee/getallemp
	2. getEmpById - http://localhost:8989/employee/getemp/101
	3. addEmp - http://localhost:8989/employee/addemp   with JSON object
	
2. For Admin - http://localhost:8989/admin

3. For Help -  http://localhost:8989/help

General Issues:

1. Spring application names should not contain '_' , instead can be used by '-'
   Ex: EMPLOYEE_SERVICE will not work when we use in gateway .yml file as lb://EMP_SERVICE

2. In .yml - routes - predicates - Path - P should be capital

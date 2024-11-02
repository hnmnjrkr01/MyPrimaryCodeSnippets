1. create packages model, resource , repository
2. add Empployee, EmployeeRepository, EmployeeController under respective packages
3. add below MongoDB properties to application.properties
	spring.data.mongodb.host=localhost
	spring.data.mongodb.port=27017
	spring.data.mongodb.database=EmpDB
	
4. Create EmpDB database and Employee Collection in MongoDB - no need to add any documents
	> show dbs
		EmpDB    0.000GB
		admin    0.000GB
		config   0.000GB
		empDBex  0.000GB
		local    0.000GB
		mydb     0.000GB
		test     0.000GB
	> db.createCollection('Employee')
	
5. start the spring boot application  - in this port is 8082
6. From postman try below Rest calls

  Add Employee - http://localhost:8092/addEmp
  				Request body json - 
  				{
				    "id": 101,
				    "name": "Sam",
				    "sal": 20000,
				    "age": 40,
				    "dept": 20
				}
				
 Get Employee List - http://localhost:8092/getallEmployees
 Get Employee by Id - http://localhost:8092/getEmpById/101
 Delete Employee - http://localhost:8092/deleteEmp/101
	

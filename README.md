Using MongoDB Docker Image in Spring Boot Application

### Start Docker on WSL2 distribution (ubuntu etc)

#### Pull MongoDB image from docker hub
```bash
docker pull mongodb/mongodb-community-server
```

#### Run container named `mongo` be sure to expose the default port using `-p 27017:27017`
```bash
docker run -p 27017:27017 --name mongo -d mongodb/mongodb-community-server:latest
```

#### Enter `mongosh` 
```bash
jdk@JDK:~$ docker exec -it mongos mongosh
test> db.employee.find()  ## get 'employee' collection data
test> db.employee.find({ 'salary': { $gte: 3000 } })  ## filter employee with salary > 3000
```

----
### *Spring YML configuration*
```yml
spring:
  data:
  mongodb:
    host: 172.30.245.70  # hostname -I | cut -f 1 -d ' '
    port: 27017
    database: test
```

#### `host` is important and run below command on WSL2 to get the IP address 
```bash
hostname -I | cut -f 1 -d ' '
```

### application.properties configuration
This is the default uri if you even not specified in properties file.
```bash
spring.data.mongodb.uri=mongodb://localhost:27017/test
```

#### Mongosh 
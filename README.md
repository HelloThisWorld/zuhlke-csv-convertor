## This is the assignment of zuhlke
## Description
### Framework
- This project built by spring boot
- Repository by spring data jpa
- Database MySql
- CSV resolver opencsv

### Functions
- Must start docker compose first
- During MySql in docker start up init.sql will be loaded and to create related database in MySql
- During the application start up, data in src/main/resources/data/sales.csv will be loaded and transfered to database module type.
- After the application started, you can use below API to check the data from MySql



## Usage
### Hot to run
- Step 0. install docker in local host [Install docker](https://docs.docker.com/get-docker/)
- Step 1. run `$ ./gradlew build` to build project
- Step 2. run `$ docker-compose up --build`

### Run by local
- Step 1. find docker-compose.yml in do root folder
- Step 2. comment or remove below

```
  converter:
        build: .
        depends_on:
        - mysql-db
        environment:
            - SPRING_DATASOURCE_URL=jdbc:mysql://mysql-db:3306/zuhlke?characterEncoding=utf8&useSSL=false
        ports:
            - 8090:8090
```

- Step 3. run `$ docker-compose up`
- Step 4. find application.properties file in folder src/main/resources change ip in `spring.datasource.url` to your LAN ip
- Step 5. run Mac `$ ./gradlew bootRun` Window cmd `$ gradlew bootRun`

### API usage
#### Check data in database
`GET http://localhost:8090/orders`

### Access MySql admin page
- Step 1. after docker compose started access this in browser `http://localhost:8888/?server=<You LAN IP(not localhost or 127.0.0.1)>`
- Step 2. input `username=root`	 `password=root` `database=zuhlke`

### Extension
- repository layer is using IoC mode, cloud be changed to different implementations
- Extend the CSVService layer to support other input data type

#### Unit test will not be fully covered

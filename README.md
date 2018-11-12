# My Java Homework

### Objective
---
The objective is to have a backend based in [Java Spring Boot](https://spring.io/projects/spring-boot) for registering and listing Companies and Employees with the use of **REST APIs**

### Context
---
- The Java version used is 8
- The Java project can be built with [maven](https://maven.apache.org/what-is-maven.html) or [gradle](https://gradle.org/)
- The APIs documentation can be found in the next [link](https://arcane-atoll-95791.herokuapp.com/swagger-ui.html)

### Local setup
---
1. Clone the Github [repository](https://github.com/josealbertohm/boom-homework)
```
git clone https://github.com/josealbertohm/boom-homework
cd boom-homework
```

2. With the `gradlew` command build the project:
```
gradlew build --info
```
3. To run the Spring Tests we use the same `gradlew` command
```
gradlew test --info
```


### Build tools
The Java project can be used with [maven](https://maven.apache.org/what-is-maven.html) and [gradle](https://gradle.org/)

### Project dependencies
The Java project use the next dependencies:


```
<!-- Spring Framework Boot for Web -->
spring-boot-starter-web

<!-- Spring Framework Boot Devtools -->
spring-boot-devtools

<!-- Spring Framework Boot for Data persistency -->
spring-boot-starter-data-jpa

<!-- H2 memory database -->
com.h2database

<!-- Spring Framework Boot for Testing -->
spring-boot-starter-test

<!-- Documentation APIs -->
springfox-swagger2
springfox-swagger-ui
```

---
The next operations are available for the Company through the API:

 - Create a `Company` ([see the API documentation](https://arcane-atoll-95791.herokuapp.com/swagger-ui.html#/company-resource/createCompanyUsingPOST))
 - Get a list with all Companies [/companies](https://arcane-atoll-95791.herokuapp.com/companies)
 - Search for Companies whose name **contains** a specified word [/companies/search?name=Company](https://arcane-atoll-95791.herokuapp.com/companies/search?name=Company)
 - Get a list of Companies in a specified `Industry` [/companies/search?industry=Technology](https://arcane-atoll-95791.herokuapp.com/companies/search?industry=Technology)
 - Get a single `Company` with a specified `id` [/companies/2](https://arcane-atoll-95791.herokuapp.com/companies/2)
 - Get a list of employees that work at a specified `Company` id [/companies/2/employees](https://arcane-atoll-95791.herokuapp.com/companies/2/employees)
---
The next operations are available for the Employee through the API:

 - Create an `Employee` ([see the API documentation](https://arcane-atoll-95791.herokuapp.com/swagger-ui.html#/employee-resource/createEmployeeUsingPOST))
 - Get a list of all Employees: [/employees](https://arcane-atoll-95791.herokuapp.com/employees)
 - Get a list of Employees whose `Job Title` **contains** a specified word [/employees/search?title=Advisor](https://arcane-atoll-95791.herokuapp.com/employees/search?title=Advisor)
 - Get a single `Employee` with a specified `id` [/employees/20](https://arcane-atoll-95791.herokuapp.com/employees/20)
 - Get a list with all supported Industries  [/employees/jobs](https://arcane-atoll-95791.herokuapp.com/employees/jobs)

The API documentation can be found in the Swagger html format in the next [link](https://arcane-atoll-95791.herokuapp.com/swagger-ui.html) format

The application can be used in: [Heroku demo application](https://arcane-atoll-95791.herokuapp.com/companies)

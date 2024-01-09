### Spring Boot Actuator
Following this lesson: https://www.youtube.com/watch?v=4OVe0MWgZ4k
C:\cwang\workspace-spring-boot\actuator-demo
give a bunch of out-of-box configurable end-points, such as "health", "beans" and "info", for diagnosis purpose in a production environment.
"mapping" --> controller mapping
beans --> all beans (including custom controller, etc)
configprops --> configuration

in `application.properties`
```
management.endpoints.web.exposure.include=*
management.endpoint.health.show-details=always
info.app.name=actuator-demo
info.app.description=cgtennis actuator demo application
info.app.version=1.0.0
info.app.author=Chenggang Wang
info.app.docs=http://cgtennis.org
management.info.env.enabled=true
management.info.build.enabled=true
management.info.java.enabled=true
management.info.os.enabled=true
server.port=8081
```

### Spring Data JDBC (Not JPA)
Check the example app in `content-calender` project.


### Load Initial Schema
check the ``content-calender` project
`spring.sql.init.mode=always`
need `schema.sql` in the `resources` folder


### Spring Boot Default @Autowire
Starting with Spring 4.3, if a class, which is configured as a Spring bean, has only one constructor, the @Autowired annotation can be omitted and Spring will use that constructor and inject all necessary dependencies.

### @ReponseBody vs @ReponseEntity
In summary, @ResponseBody is primarily used to indicate that the return value should be serialized directly into the response body, while @ResponseEntity provides more control over the entire HTTP response, allowing you to set headers, status code, and handle various response types
@RestController annotation include @Controller and @ResponseBody
ResponseEntity uses builder pattern.
```
# simple usage
return ResponseEntity.ok(List<Student>);
```
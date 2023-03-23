# myspace
Social media to share posts, allow add comments and users.

### Spring Boot Reference Documentation

```
# doc spring base
https://docs.spring.io/spring-boot/docs/current/reference/html/index.html

# doc aplication.properties
https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#application-properties.actuator.management.endpoints.web.base-path
```

### Up database

```
docker-compse up -d
```

### Stack
```
Springboot
JUnit
Mockiton
MongoDB
Docker
```

# Swagger

Access documentation API
```
http://localhost:8080/swagger-ui/index.html
http://localhost:8080/v3/api-docs
```

### Initializing a repo

```
git init
git config --global user.name "user"
git config --global user.email "user@mail.com"
git add .
git commit -m "Startup project"
git add remote ....
git push ....
```

# TODO:
```
[ ] Finish endpoints
[ ] Implement tests, container etc
[ ] Use faker to mock data
[ ] Add docker suport to build image
```

# Build image

base on https://www.docker.com/blog/9-tips-for-containerizing-your-spring-boot-code/

java -jar target/myspace-0-0.1-SNAOSHOT.jar
check on browser http://localhost:8080/swagger-ui/index.html

# Problems
- simple way to change base path configure on YAML, for example i want to set /api


# POC-Spring-Boot
#TODO traduzir pro ingles 

POC em Spring Boot, utilizando Java 18.
A aplicação estará hospedada no Heroku, 
e utilizará um banco de dados PostgreSQL, 
também provisionado pelo Heroku.
Será utilizado SDK Man (colocar link) 
para gerenciar as versões do java e Maven instaladas na máquina.
A aplicação foi desenvolvida parcialmente em 
ambiente Windows (Utilizando WSL2) e parcialmente no Ubuntu.

### Technologies:

- Spring Boot
- WSL2
- Docker
- PostgresSQL

### Architecture Diagram:
... Mermaid/PlantUML

### POC Checklist (Work In Progress):

- [x] POST route
- [x] GET route
- [ ] PATCH route
- [ ] DELETE route
- [ ] Pagination
- [ ] Flow using Web
- [ ] Flow using Reactive Web
- [ ] Performance comparison between Web and Reactive Web
- [ ] Implement JPA + Hibernate
- [ ] Implement OAuth
- [ ] Implement Unit Tests
- [ ] Feign Client
- [ ] Async call
- [x] Exception Handlers

### Useful commands

```
mvn clean install
sdk list java
sdk install java 18.0.1-zulu
sdk use java 18.0.1-zulu
sdk install maven
```

### Obtaining WSL2 address:
```wsl hostname -I```
 ip do postgres 172.18.0.1

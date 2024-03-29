# Architecture Logicielle :
- The code used in this example is provided by : [Open ClassRoom](https://openclassrooms.com/fr/courses/4668216-optimisez-votre-architecture-microservices/5176135-creez-les-microservices-e-commerce-et-leur-client)
- The main purpose of this repository is to use a more recent and up to date version of spring boot
- this lead to removing and replacing some deprecated and no longer maintained tools and dependencies
- **Tools Used :**
    - **API Gateway :**  Spring Cloud Gateway
    - **Service Discovery :** Eureka
    - **Circuit Breaker :** Resilience4j
    - **Load Balancer :** Ribbon
    - **Distributed Tracing :** Zipkin
    - **Distributed Configuration :** Spring Cloud Config
    - **Distributed Log :** Elk Stack
    - **Distributed Monitoring :** Prometheus and Grafana

- **Pre-requisite** :
  - **install Docker and Docker Compose** : [Docker](https://docs.docker.com/get-docker/)
  - **install Maven** : [Maven](https://maven.apache.org/install.html)
  - **Spring Boot Documentation** : [Spring Boot](https://spring.io/projects/spring-boot)
- **Setup** :
  - **Step 1** : Clone the repository
  - **Step 2** : Run the following Docker Images : 
    - **Zipkin** : 
      - `docker run -d -p 9411:9411 openzipkin/zipkin`
    - **ELK stack** :
      - `docker-compose up -d`

- **Resources**:
  - [Building a rest api with Spring-boot](https://spring.academy/courses/building-a-rest-api-with-spring-boot)
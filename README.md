# This is a Spring Boot based Micropservice Applications
In this app we have created three services
- Service Registery (eureka-server)
- Api Gateway (Zuul)
- messenger service (eureka-client)

## Prerequisites
- Install any Java version (Prefered Java-8)
- Install any Maven version

## Instalation
- First go r-server directory and in the source directory run the java class
- Then Run the remaining two services as well

## Testing
- To check weather all the services are up and running got to [click](http://localhost:9000/eureka).
- Now to check the routes which are registered in Zuul go to [click](http://localhost:9001/actuator/routes)
- Now we when we call the messenger service end point from Zuul it should return us the result [click](http://localhost:9001/messenger/api/v1/s1)
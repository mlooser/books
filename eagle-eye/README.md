# Eagle Eye
Project created while learning microservices with "Microservices in Action"

## Config Server
Config server serves configuration for Licensing Server and Organization Server. Uses:
 * spring-cloud-config-server
	
## Eureka Server
Used by Licensing Server to look for Organization Server. Uses:
 * spring-cloud-starter-netflix-eureka-server
	
## Authorization Service
Used to authorize users before they can access Licensing Service and Organization Service. Creates and verifies OAuth2 tokens. Uses:
 * spring-cloud-security
 * spring-security-oauth2
	
## Organization Service
Serves data about Organizations. Reads configuration from Config Server. After runs, registers in Eureka Server. Stores Organization data in H2DB. Access reuires beeing authorized by Authorization Service. Uses:
 * spring-boot-starter-data-jpa
 * spring-cloud-starter-config
 * spring-cloud-starter-netflix-eureka-client
 * spring-cloud-security

## Licensing Service
Serves data about Licences. Reads configuration from Config Server. Looks for Organization data in Organization Services with usage of Eureka Server and Fiegn Client.  Access reuires beeing authorized by Authorization Service. Uses:
 * spring-cloud-starter-config
 * spring-cloud-starter-netflix-eureka-client
 * spring-cloud-security
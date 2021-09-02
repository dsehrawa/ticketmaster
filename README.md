# ticketmaster
A sample application for booking online movie tickets

## Build Docker Image
Update MYSQL_HOST in Dockerfile with the IP Address of your MySql Server

```
$mvn clean package
$docker run -p 9090:9090 xyz/ticketmaster:0.0.1
```

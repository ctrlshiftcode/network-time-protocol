
# Network Time Security

Springboot project for using the NTP protocol. For academic study purposes

NTP is a protocol for synchronizing computer clocks based on the UDP protocol.
It is used to synchronize the clock of a set of computers and devices in data networks with
variable latency. NTP allows you to keep a computer's clock synchronized with the correct time at all times.
and with millisecond precision. 

## API Endpoint
The REST API to the example app is described below. 

## Swagger UI
```
http://localhost:8080/swagger-ui/index.html
```
![img.png](assets/img2.png)



### Request
```
curl -i -H 'Accept: application/json' http://localhost:8080/ntp/utcTime
```
### Response
```
HTTP/1.1 200
Content-Type: application/json
Content-Length: 13
Date: Sun, 14 May 2023 01:27:11 GMT
{
  "utcTime": "16:17:06.372Z"
}
```
![img.png](assets/img.png)


> References: <br>
> 1. [Wikipedia](https://pt.wikipedia.org/wiki/Network_Time_Protocol) - _Network Time Security_
> 2. [NTP.br](https://ntp.br/) _Brazil NTP Server_ 


## Author
- [@ctrlshiftcode](https://www.github.com/ctrlshiftcode) - Alberto Uehara


# IMEDIA24 BACKEND TEST

Built with SPRING BOOT / KOTLIN


## API
 
#### Get all products
```bash
GET http://localhost:8080/products/list  
Content-Type: application/json
 
```
#### Get products by skus
```bash
GET http://localhost:8080/products?skus=23,4567  
Content-Type: application/json
 
 
```
#### Get single product  by sku 
```bash
GET http://localhost:8080/products/23
Content-Type: application/json

 
 
```
#### Add new product
```bash
POST http://localhost:8080/product 
Content-Type: application/json

{
    "sku":"23",
    "name":"test product",
    "description": "test product description",
    "price": 22.99
}
```
###
## Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Official Kotlin documentation](https://kotlinlang.org/docs/home.html)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.3/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.3/gradle-plugin/reference/html/#build-image)
* [Flyway database migration tool](https://flywaydb.org/documentation/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)


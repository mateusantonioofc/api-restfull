<p align="center">
    <a href="https://github.com/mateusantonioofc/api-restfull/pulse"><img src="https://img.shields.io/github/last-commit/mateusantonioofc/api-restfull?style=for-the-badge&logo=github&color=7dc4e4&logoColor=D9E0EE&labelColor=302D41"></a>
    <a href="https://github.com/mateusantonioofc/api-restfull/releases/latest"><img src="https://img.shields.io/github/v/release/mateusantonioofc/api-restfull?style=for-the-badge&logo=gitbook&color=8bd5ca&logoColor=D9E0EE&labelColor=302D41"></a>
    <a href="https://github.com/mateusantonioofc/api-restfull/stargazers"><img src="https://img.shields.io/github/stars/mateusantonioofc/api-restfull?style=for-the-badge&logo=apachespark&color=eed49f&logoColor=D9E0EE&labelColor=302D41"></a>
    <br>
</p>

# Api RESTful in spring boot

# Java version

- 17

# Database

- PostgreSQL

## Packages

- Spring web
- JPA
- Validation
- PostgreSQL

## How to run

# Require
- git
- java

- In your cmd, type:
```shell
 git clone https://github.com/mateusantonioofc/api-restfull.git
```
- Enter a path
```shell
cd api-restfull
```
- Enter a path `bin`
```shell
cd bin
```
- Execute the jar file
```shell
java -jar apirest-1.0.0.jar
```

## Routes

- *GET* return all products
`http://localhost:8080/api/v1/products`

- *GET* get product by id
`http://localhost:8080/api/v1/products/{id}`

```json

{
	"idProduct": "id",
	"name": "name",
	"value": 0.0
}

```

- *POST* create product
`http://localhost:8080/api/v1/products`

```json

{
	"headers": {},
	"body": [
		{
			"idProduct": "id",
			"name": "name",
			"value": 0.0
		}
	],
	"statusCode": "OK",
	"statusCodeValue": 200
}
```

- *PUT* update product
`http://localhost:8080/api/v1/products/{id}`

-- Body
```json

{
	"idProduct": "new id",
	"name": "new name",
	"value": 0.0
}

```
-- Return

```json

{
	"idProduct": "id",
	"name": "name",
	"value": 0.0
}

```

- *DELETE* delete product by id
`http://localhost:8080/api/v1/products/{id}`

```json

{
	"headers": {},
	"body": [
		"idProduct": "others products",
		"name": "name",
		"value": 0.0,
	],
	"statusCode": "OK",
	"statusCodeValue": 200
}

```

## Possibles errors

```json
{
	"headers": {},
	"body": "List of products is empty",
	"statusCode": "NO_CONTENT",
	"statusCodeValue": 204
}
```

- 404 not found

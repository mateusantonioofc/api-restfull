# Api RESTful in spring boot

# Java version

- 17 LTS

# Database

- PostgreSQL

## Packages

- Spring web
- JPA
- Validation
- PostgreSQL

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



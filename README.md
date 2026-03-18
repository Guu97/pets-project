# Pets Project

REST API for pet management, developed with Spring Boot.

## Database

The application supports two databases via Spring `@Profile`:

| Profile | Database | Command |
|---------|----------|---------|
| `jpa` (default) | H2 (Oracle mode) | `mvn spring-boot:run` |
| `mongo` | MongoDB | `mvn spring-boot:run -Dspring-boot.run.profiles=mongo` |

## API Endpoints

### Pets

| Method | Endpoint | Description | Request Body | Response |
|--------|----------|-------------|--------------|----------|
| `GET` | `/api/pets` | List all pets | - | `200 OK` - List of pets |
| `GET` | `/api/pets/{id}` | Get a pet by ID | - | `200 OK` / `404 Not Found` |
| `POST` | `/api/pets` | Create a new pet | `PetRequest` | `201 Created` |
| `PUT` | `/api/pets/{id}` | Update an existing pet | `PetRequest` | `200 OK` / `404 Not Found` |
| `DELETE` | `/api/pets/{id}` | Delete a pet | - | `204 No Content` / `404 Not Found` |

### Request Body

```json
{
  "name": "Fido",
  "species": "Dog",
  "age": 3,
  "ownerName": "Mario Rossi"
}
```

| Field | Type | Required | Validation |
|-------|------|----------|------------|
| `name` | String | Yes | Not blank |
| `species` | String | Yes | Not blank |
| `age` | Integer | No | >= 0 |
| `ownerName` | String | No | - |

### Response Body

```json
{
  "id": 1,
  "name": "Fido",
  "species": "Dog",
  "age": 3,
  "ownerName": "Mario Rossi"
}
```

### Errors

```json
{
  "timestamp": "2026-03-18T15:30:00",
  "status": 404,
  "error": "Not Found",
  "message": "Pet not found with id: 1",
  "path": "/api/pets/1"
}
```

# Pets Project

REST API for pet management, developed with Spring Boot.

## API Endpoints

### Pets

| Metodo | Endpoint | Descrizione | Request Body | Response |
|--------|----------|-------------|--------------|----------|
| `GET` | `/api/pets` | Lista tutti i pet | - | `200 OK` - Lista di pet |
| `GET` | `/api/pets/{id}` | Recupera un pet per ID | - | `200 OK` / `404 Not Found` |
| `POST` | `/api/pets` | Crea un nuovo pet | `PetRequest` | `201 Created` |
| `PUT` | `/api/pets/{id}` | Aggiorna un pet esistente | `PetRequest` | `200 OK` / `404 Not Found` |
| `DELETE` | `/api/pets/{id}` | Elimina un pet | - | `204 No Content` / `404 Not Found` |

### Request Body

```json
{
  "name": "Fido",
  "species": "Dog",
  "age": 3,
  "ownerName": "Mario Rossi"
}
```

| Campo | Tipo | Obbligatorio | Validazione |
|-------|------|--------------|-------------|
| `name` | String | Sì | Non vuoto |
| `species` | String | Sì | Non vuoto |
| `age` | Integer | No | ≥ 0 |
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

### Errori

```json
{
  "timestamp": "2026-03-18T15:30:00",
  "status": 404,
  "error": "Not Found",
  "message": "Pet not found with id: 1",
  "path": "/api/pets/1"
}
```

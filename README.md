# CV API

REST API that powers my portfolio website. It serves CV content in three languages (EN / PL / UK) and handles messages from the contact form.

**Live:** [wh0tuest.github.io/cv-sap](https://wh0tuest.github.io/cv-sap/) · **API:** [cv-api-x38c.onrender.com/api/projects](https://cv-api-x38c.onrender.com/api/projects?lang=en)

> The API runs on a free Render instance and sleeps after 15 minutes of inactivity, so the first request may take up to a minute.

## Tech stack

- **Java 21**, **Spring Boot 4** (Web, Data JPA, Validation)
- **PostgreSQL** (Neon in production, Docker locally), **H2** for tests
- **JUnit 5**, **Mockito**, **MockMvc**
- **Docker**, **Docker Compose**, deployed on **Render**

## Architecture

```
GitHub Pages (HTML/CSS/JS)  →  Spring Boot REST API (Docker, Render)  →  PostgreSQL (Neon)
```

Layered structure: `controller` → `service` → `repository`, with DTOs between the API and JPA entities.

## API

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/health` | Health check |
| `GET` | `/api/projects?lang=en` | Projects in `en`, `pl` or `uk` (default `en`) |
| `POST` | `/api/contact` | Save a contact message |

Example request:

```bash
curl -X POST https://cv-api-x38c.onrender.com/api/contact \
  -H "Content-Type: application/json" \
  -d '{"name":"Anna","email":"anna@example.com","message":"Hi! Let us talk about a job."}'
```

Validation errors return `400` with details per field:

```json
{
  "error": "Validation failed",
  "fields": { "email": "Email must be valid" }
}
```

## Running locally

Requirements: Java 21, Docker.

```bash
# 1. Start PostgreSQL
docker compose up -d postgres

# 2. Run the app with the dev profile
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

Or run everything in Docker:

```bash
docker compose up -d --build
```

The API is available at `http://localhost:8080`.

## Tests

```bash
./mvnw test
```

Unit tests for the service layer (Mockito) and integration tests for the REST endpoints (MockMvc, H2).

## Configuration

| Profile | Database | Used for |
|---|---|---|
| default | H2 in memory | tests |
| `dev` | PostgreSQL in Docker | local development |
| `prod` | PostgreSQL via `DB_URL`, `DB_USERNAME`, `DB_PASSWORD` | deployment |

## Project structure

```
src/main/java/com/oleksandr/cv_api/
├── config/       # CORS, sample data
├── controller/   # REST endpoints
├── dto/          # request / response records
├── exception/    # custom exceptions, global error handler
├── model/        # JPA entities
├── repository/   # Spring Data repositories
└── service/      # business logic
```
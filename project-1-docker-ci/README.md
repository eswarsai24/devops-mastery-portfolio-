# Project 1 — Dockerized Spring Boot Microservice + CI

This repo is built to mimic a real team workflow:
- `main` is protected (no direct pushes)
- all work happens on `feature/*` branches via Pull Requests
- CI runs on PRs (build + tests + docker build)
- CI pushes images to Docker Hub **only** after merge to `main`

## Endpoints
- `GET /health` → returns `OK`
- `GET /users` → list users (in-memory)
- `POST /users` → create a user (in-memory)

Actuator:
- `GET /actuator/health`

## Local run

### Run with Maven
```bash
mvn clean package
mvn spring-boot:run
curl http://localhost:8080/health
```

### Run with Docker
```bash
docker build -t devops-app:local .
docker run --rm -p 8080:8080 devops-app:local
curl http://localhost:8080/health
```

## Example API usage
```bash
curl -X POST http://localhost:8080/users \
  -H 'Content-Type: application/json' \
  -d '{"name":"Eswar","email":"eswar@example.com"}'

curl http://localhost:8080/users
```

## CI (GitHub Actions)
Workflow file: `.github/workflows/ci.yml`

Secrets required (Repo → Settings → Secrets and variables → Actions):
- `DOCKERHUB_USERNAME`
- `DOCKERHUB_TOKEN` (Docker Hub access token)

## Branching standard
- `feature/*` new features
- `bugfix/*` bug fixes
- `hotfix/*` urgent prod fixes
- `chore/*` maintenance

Commit messages follow Conventional Commits:
- `feat: ...`, `fix: ...`, `chore: ...`, `docs: ...`

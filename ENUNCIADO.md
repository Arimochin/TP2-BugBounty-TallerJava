# Taller de Java — Bug Hunt

## Descripción del proyecto

**Collaborative ToDo** es una API REST que permite gestionar una lista de tareas compartidas entre múltiples usuarios. Está construida con Spring Boot y persiste los datos en una base de datos H2 en memoria.

La aplicación expone los siguientes servicios:

| Método | Ruta | Descripción |
|--------|------|-------------|
| `GET` | `/api/todo` | Lista todos los ToDos |
| `POST` | `/api/todo` | Crea un nuevo ToDo (`{"content":"..."}`) |
| `DELETE` | `/api/todo/{id}` | Elimina un ToDo por UUID |
| `GET` | `/api/user` | Lista todos los usuarios |
| `POST` | `/api/user` | Inicia sesión / crea usuario (`{"name":"..."}`) |
| `GET` | `/api/currentuser` | Retorna el usuario de la sesión actual |
| `GET` | `/api/log` | Lista todos los logs en memoria |

Una interfaz web simple está disponible en `http://localhost:8080` al ejecutar la aplicación.

---

## Objetivo

El código fuente contiene **bugs intencionales** distribuidos en los servicios de la aplicación. Estos bugs provocan que **todos los tests fallen**.

Tu tarea es:

1. Ejecutar los tests e identificar cuáles fallan.
2. Leer el test y el código fuente para entender **qué comportamiento se espera** y **por qué no se cumple**.
3. Corregir cada bug en el código de producción (no en los tests).
4. Verificar que el test correspondiente pasa tras la corrección.
5. Documentar los hallazgos completando la tabla del entregable.

> Los tests **no deben modificarse**. Solo se puede tocar el código en `src/main/java/`.

---

## Cómo ejecutar el proyecto

### Correr la aplicación

```bash
mvn spring-boot:run
```

La aplicación queda disponible en `http://localhost:8080`.

### Ejecutar los tests

```bash
# Todos los tests
mvn test

# Una clase de test específica
mvn test -Dtest=NombreDeLaClase

# Un método de test específico
mvn test -Dtest=NombreDeLaClase#nombreDelMetodo
```

**Ejemplos:**

```bash
mvn test -Dtest=LogServiceTest
mvn test -Dtest=LogServiceTest#addLogs
mvn test -Dtest=TodoServiceTest#testCreateTodo
```

---

## Estructura del código

```
src/
├── main/java/.../
│   ├── todo/
│   │   ├── ToDo.java              — Entidad JPA
│   │   ├── TodoController.java    — Endpoints REST
│   │   ├── TodoRepository.java    — Acceso a datos
│   │   └── TodoService.java       — Lógica de negocio
│   ├── users/
│   │   ├── User.java              — Entidad JPA
│   │   ├── UserController.java    — Endpoints REST
│   │   ├── UserRepository.java    — Acceso a datos
│   │   ├── UserService.java       — Lógica de negocio
│   │   └── CurrentUserService.java — Usuario de sesión actual (scope=session)
│   └── log/
│       ├── Log.java               — Modelo (no persistido en BD)
│       ├── LogController.java     — Endpoint REST
│       └── LogService.java        — Logs en memoria (HashMap)
└── test/java/.../
    ├── log/LogServiceTest.java
    ├── todo/TodoServiceTest.java
    └── users/
        ├── UserServiceTest.java
        └── CurrentUserTest.java
```

---

## Entregable

Completar la siguiente tabla con un análisis de cada test fallido. Para cada uno indicar la causa raíz del error y la corrección aplicada.

| Test (`Clase.método`) | Descripción del error | Descripción de la solución |
|---|---|---|
| `LogServiceTest.addLogs` | | |
| `LogServiceTest.hasAllLogsConcurrent` | | |
| `LogServiceTest.getLogsByUser` | | |
| `TodoServiceTest.testCreateTodo` | | |
| `TodoServiceTest.testTimerDelete` | | |
| `CurrentUserTest.testGetsDefaultUser` | | |
| `CurrentUserTest.testCurrentConcurrent` | | |
| `UserServiceTest.testSortedByName` | | |
| `UserServiceTest.testAddNullUser` | | |
| `UserServiceTest.testLoginUser` | | |
| `UserServiceTest.testAddUsersAndClear` | | |

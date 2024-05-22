# Simple CRUD
This repository contains a simple CRUD project built using Java Spring. 

This project was based on a live coding session by Fernanda Kipper.

## Table of Contents

- [Installation](#installation)
- [Configuration](#configuration)
- [API Endpoints](#api-endpoints)
- [Database](#database)

## Installation

1. Clone the repository:

```bash
$ git clone https://github.com/Pedrosant11/crud-java-spring.git
```

2. Install dependencies with Maven

## Usage

1. Start the application with Maven
2. The API will be accessible at http://localhost:8080


## API Endpoints
The API provides the following endpoints:

```markdown
GET /creditcard - Retrieve a list of all data.

POST /creditcard - Register a new data.

PUT /creditcard - Alter data.

DELETE /creditcard/{id} - Inactivate data.
```

## Database
The project uses PostgresSQL as the database. The necessary database migrations are managed using Flyway.

To install PostgresSQL locally you can [click here](https://www.postgresql.org/download/).

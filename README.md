# Practice Project

A Spring Boot application with MongoDB, Redis, and Kafka integration for practice purposes.

## Project Overview

This is a Spring Boot application that demonstrates integration with various technologies:
- Spring Boot 3.4.4
- MongoDB for data persistence
- Redis for caching
- Kafka for event streaming
- Spring Security for authentication
- Spring Actuator for monitoring

## Prerequisites

- Java 21
- Maven
- Docker or Podman
- Docker Compose or Podman Compose

## Building the Project

1. Clone the repository:
```bash
git clone <repository-url>
cd practice
```

2. Build the project using Maven:
```bash
./mvnw clean package
```

## Running with Docker Compose

### Option 1: Running All Services Together

1. Make sure Docker and Docker Compose are installed and running on your system.

2. Build and start all services:
```bash
docker-compose up --build
```

3. To run in detached mode:
```bash
docker-compose up -d --build
```

4. To stop the services:
```bash
docker-compose down
```

### Option 2: Running Kafka and Zookeeper Separately

1. Start Kafka and Zookeeper services:
```bash
docker-compose -f kafka-zookeeper-docker-compose.yml up -d
```

2. Start the main application services:
```bash
docker-compose up -d
```

3. To stop all services:
```bash
docker-compose -f kafka-zookeeper-docker-compose.yml down
docker-compose down
```

## Running with Podman Compose

### Option 1: Running All Services Together

1. Make sure Podman and Podman Compose are installed on your system.

2. Build and start all services:
```bash
podman-compose up --build
```

3. To run in detached mode:
```bash
podman-compose up -d --build
```

4. To stop the services:
```bash
podman-compose down
```

### Option 2: Running Kafka and Zookeeper Separately

1. Start Kafka and Zookeeper services:
```bash
podman-compose -f kafka-zookeeper-docker-compose.yml up -d
```

2. Start the main application services:
```bash
podman-compose up -d
```

3. To stop all services:
```bash
podman-compose -f kafka-zookeeper-docker-compose.yml down
podman-compose down
```

## Accessing Services

Once the services are running, you can access them at the following endpoints:

- Application: http://localhost:5050
- Redis Commander (Web UI): http://localhost:8081
- RedisInsight: http://localhost:8001
- MongoDB: localhost:27017
- Kafka UI (AKHQ): http://localhost:8080
- Kafka Broker: localhost:29092
- Zookeeper: localhost:2181

## Environment Variables

The application uses the following environment variables:
- `SPRING_DATA_MONGODB_URI`: MongoDB connection string
- `SPRING_REDIS_HOST`: Redis host address
- `KAFKA_BOOTSTRAP_SERVERS`: Kafka broker address (default: localhost:29092)

These are already configured in the docker-compose.yml files.

## Volumes

The following persistent volumes are created:
- `mongodb_data`: For MongoDB data persistence
- `redis_data`: For Redis data persistence

## Networks

The services are connected to the following networks:
- `app-network`: For main application services
- `kafka-local-net`: For Kafka and Zookeeper services
- `trino-local-net`: For Trino and MongoDB services

## Development

For development purposes, you can run the application directly using Maven:
```bash
./mvnw spring-boot:run
```

## License

This project is licensed under the terms specified in the project's license file. 
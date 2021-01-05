![Build](https://github.com/falcon-lab/stocks-market-admin/workflows/Build/badge.svg)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=falcon-lab_stocks-market-admin&metric=alert_status)](https://sonarcloud.io/dashboard?id=falcon-lab_stocks-market-admin)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=falcon-lab_stocks-market-admin&metric=coverage)](https://sonarcloud.io/dashboard?id=falcon-lab_stocks-market-admin)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=falcon-lab_stocks-market-admin&metric=code_smells)](https://sonarcloud.io/dashboard?id=falcon-lab_stocks-market-admin)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=falcon-lab_stocks-market-admin&metric=bugs)](https://sonarcloud.io/dashboard?id=falcon-lab_stocks-market-admin)

# stocks-market-admin
Manage Stock Shares

## Motivation

- Manager Stocks Shares by Id for a later use.

## Prerequisites

Make sure the prerequisite list below is present on your environment
    
- [JAVA 8+](https://www.java.com/en/download/) _(at least)_
- [Springframework 2.2.0](https://spring.io/)
- [Maven 3+](https://maven.apache.org/)
    - Follow the [Baeldung tutorial](https://www.baeldung.com/install-maven-on-windows-linux-mac) to configure the 
    environment variables properly 
- [Docker](https://www.docker.com/) _the latest stable version is recommended for debugging_

## API Reference (Endpoints)

Links below describes how the API endpoints are defined.

- [actuator/health](docs/actuator-health.md)
- [stocks](docs/stocks.md)

## Running (localhost)

#### Build artifacts

- In the application root, run `mvn clean install` in order to generate the proper binaries. 

```bash
$ mvn clean install
```

The statement below is expected
```bash
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```

Once the build is completed, the `jar` is now contained in the `target` folder.

#### Run the multi-container application

- Still in the application root, run `docker-compose up --build`, and wait for the application deployment in docker.

```
$ docker-compose up --build
```
 
By default, docker runs in `localhost`, anyhow check the current host in `docker host` at Docker settings.

## Logs

Not yet implemented

## Class Diagram

Not yet implemented

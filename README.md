# OSSE Assignment-4
## Group 24
- Sajith SV (2020MT93583)
- Jyothish  Thyagarajan (2021MT93021)
- Amitha  Vikraman (2021MT93031)  
- Vishnu R (2021MT93038)  
- Joel Joy (2021MT93314)

## The application
The application provides a basic CRUD api for User information as well as signup and login functionality.
It also provides basic CRUD for other entities such as portfolio and mutual funds.

## setup postgresDB using docker
- docker pull postgres:14.2-alpine
- docker pull dpage/pgadmin4:latest
- docker run --name postgresql -e POSTGRES_USER=randomuser -e POSTGRES_PASSWORD=mysecretpassword -p 5432:5432 -v postgres-storage:/var/lib/postgresql/data -d postgres:14.2-alpine
- docker run --name my-pgadmin -p 82:80 -e 'PGADMIN_DEFAULT_EMAIL=user@domain.local' -e 'PGADMIN_DEFAULT_PASSWORD=postgresmaster'-d dpage/pgadmin4



## run application
- ./gradlew clean build
-  ./gradlew run

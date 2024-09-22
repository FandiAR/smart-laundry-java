# Smart Laundry Java

## Pre-requisites

1. Install [JDK](https://www.oracle.com/id/java/technologies/downloads/)
2. Install [Maven](https://maven.apache.org/download.cgi)
3. Install [Docker](https://www.docker.com/products/docker-desktop/)

## How to run

1. Clone the repository

```
git clone https://github.com/FandiAR/smart-laundry-java.git
```

2. Go to directory

```
cd smart-laundry
```

3. Clean package

```
mvn clean package
```

4. Build Docker

```
docker-compose build
```

5. Open Docker desktop
6. Running database server

```
docker-compose up
```

7. Running application

```
java -jar .\target\smart-laundry-1.0-SNAPSHOT.jar
```

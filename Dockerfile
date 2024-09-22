# Menggunakan base image maven dengan openjdk-22
FROM maven:3.9.9-eclipse-temurin-22 AS builder

# Menentukan working directory
WORKDIR /app

# Menyalin file pom.xml dan dependencies Maven
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Menyalin semua source code
COPY src ./src

# Melakukan build project menggunakan Maven
RUN mvn package -DskipTests
CMD mvn exec:java -Dexec.args=""

# # Menggunakan openjdk-22 sebagai base image final
# FROM eclipse-temurin:22-jdk

# # Menentukan working directory
# WORKDIR /app

# # Menyalin jar file hasil build dari stage builder
# COPY --from=builder /app/target/*.jar app.jar

# # Menjalankan aplikasi
# CMD ["java", "-jar", "app.jar"]

FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copiar el proyecto
COPY . .

# Instalar Maven y compilar
RUN apt-get update && apt-get install -y maven \
    && mvn clean package -DskipTests

# Ejecutar la aplicación
EXPOSE 8080
CMD ["java", "-jar", "target/*.jar"]


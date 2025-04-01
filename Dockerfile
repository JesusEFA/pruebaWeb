FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copiar el proyecto
COPY . .

# Instalar Maven y compilar
RUN apt-get update && apt-get install -y maven \
    && mvn clean package -DskipTests

# Ejecutar la aplicación
EXPOSE 9090
CMD ["java", "-jar", "target/WebFinalEsperanza-0.0.1-SNAPSHOT.jar"]


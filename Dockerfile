# Imagen base de Java 17
FROM eclipse-temurin:17-jdk

# Crear directorio de trabajo en el contenedor
WORKDIR /app

# Copiar todo el contenido del proyecto al contenedor
COPY . .

# Dar permisos y compilar usando Maven Wrapper
RUN chmod +x ./mvnw && ./mvnw clean package -DskipTests

# Exponer el puerto que usa tu app
EXPOSE 8080

# Ejecutar el jar generado (ajustado a tu estructura)
CMD ["java", "-jar", "$(find target -name '*.jar' | head -n 1)"]

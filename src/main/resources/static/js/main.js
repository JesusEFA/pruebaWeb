
// JS para funcionalidades dinámicas de la página principal

// Ejemplo: Configuración del carrusel (Bootstrap)
document.addEventListener("DOMContentLoaded", function () {
    const carrusel = document.querySelector("#carrusel");
    if (carrusel) {
        new bootstrap.Carousel(carrusel, {
            interval: 5000, // Cambiar imagen cada 5 segundos
            wrap: true
        });
    }
});

// Ejemplo: Función para mostrar una alerta en caso de futuras expansiones
function mostrarAlerta(mensaje) {
    alert(mensaje);
}

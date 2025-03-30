package com.hermandad_virgenesperanza.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HazteHermanoController {

    private final JavaMailSender mailSender;
    
    @Autowired
    public HazteHermanoController(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @GetMapping("/hazte-hermano")
    public String showForm() {
        return "hazteHermano/hazteHermano"; // Muestra el formulario en el HTML correspondiente
    }

    @PostMapping("/hazte-hermano")
    public String processForm(
            @RequestParam("nombre") String nombre,
            @RequestParam("apellidos") String apellidos,
            @RequestParam("fechaNacimiento") String fechaNacimiento,
            @RequestParam("provincia") String provincia,
            @RequestParam("poblacion") String poblacion,
            @RequestParam("direccion") String direccion,
            @RequestParam("telefono") String telefono,
            @RequestParam(value = "domiciliacion", required = false) String domiciliacion,
            @RequestParam(value = "numeroCuenta", required = false) String numeroCuenta,
            @RequestParam(value = "costalero", required = false) String costalero,
            Model model) {

        try {
            // Crear el mensaje de correo
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("secretario.virgenesperanza@gmail.com");
            message.setSubject("Nueva solicitud de Hermano");
            message.setText("Se ha recibido una nueva solicitud para hacerse hermano.\n\n" +
                    "Nombre: " + nombre + "\n" +
                    "Apellidos: " + apellidos + "\n" +
                    "Fecha de Nacimiento: " + fechaNacimiento + "\n" +
                    "Provincia: " + provincia + "\n" +
                    "Población: " + poblacion + "\n" +
                    "Dirección: " + direccion + "\n" +
                    "Teléfono: " + telefono + "\n" +
                    "Domiciliación: " + (domiciliacion != null ? "Sí" : "No") + "\n" +
                    (numeroCuenta != null ? "Número de Cuenta: " + numeroCuenta + "\n" : "") +
                    "Quiere ser costalero: " + (costalero != null ? "Sí" : "No") + "\n");

            // Enviar el correo
            mailSender.send(message);

            // Mostrar mensaje de éxito en la vista
            model.addAttribute("successMessage", "Tu solicitud ha sido enviada correctamente.");
        } catch (Exception e) {
            // Manejo de errores
            model.addAttribute("errorMessage", "Hubo un problema al enviar tu solicitud. Inténtalo de nuevo.");
            e.printStackTrace();
        }

        return "hazteHermano/hazteHermano"; // Volver a cargar la página del formulario
    }
}

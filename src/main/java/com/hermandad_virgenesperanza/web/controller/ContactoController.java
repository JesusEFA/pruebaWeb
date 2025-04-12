package com.hermandad_virgenesperanza.web.controller;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class ContactoController {

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/contacto")
    public String mostrarFormularioContacto(Model model) {
        model.addAttribute("contactoForm", new ContactoForm());
        return "contacto/contacto";
    }

    @PostMapping("/contacto")
    public String enviarContacto(@ModelAttribute ContactoForm contactoForm, Model model) {
        try {
            MimeMessage mensaje = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mensaje, true);

            helper.setTo("secretario.virgenesperanza@gmail.com");
            helper.setSubject("Sugerencia desde el formulario de contacto");

            String cuerpo = "<p><strong>Nombre:</strong> " + contactoForm.getNombre() + "</p>" +
                            "<p><strong>Correo:</strong> " + contactoForm.getCorreo() + "</p>" +
                            "<p><strong>Mensaje:</strong><br>" + contactoForm.getMensaje() + "</p>";

            helper.setText(cuerpo, true);
            mailSender.send(mensaje);

            model.addAttribute("mensaje", "¡Gracias por tu sugerencia! La hemos recibido correctamente.");
        } catch (MessagingException e) {
            model.addAttribute("mensaje", "Ocurrió un error al enviar el mensaje.");
        }
        return "contacto/contacto";
    }
}

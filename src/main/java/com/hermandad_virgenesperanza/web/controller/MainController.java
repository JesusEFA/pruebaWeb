package com.hermandad_virgenesperanza.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
    
    @GetMapping("/")
    public String index(Model model) {
        // Añadir datos de ejemplo para el carrusel y las noticias
        model.addAttribute("carruselImages", new String[]{
            "/images/Carrusel1.jpeg",
            "/images/Carrusel5.jpeg",
            "/images/Carrusel3.jpeg",
            "/images/Carrusel7.jpeg",
            "/images/Carrusel2.jpeg",
            "/images/Carrusel4.jpeg",
            "/images/Carrusel8.jpeg"
        });
        return "index";
    }
    
    @GetMapping("/eventos/{categoria}")
    public String mostrarEvento(@PathVariable String categoria, Model model) {
        // Validar la categoría para evitar errores o accesos no permitidos
        if (!categoria.equals("costaleros") && 
            !categoria.equals("costaleras") && 
            !categoria.equals("ninos")) {
            return "error/404"; // Retorna una página de error si la categoría no es válida
        }

        // Agregar el título dinámico y otras variables si es necesario
        String titulo = "";
        switch (categoria) {
            case "costaleros":
                titulo = "Ensayos de Costaleros";
                break;
            case "costaleras":
                titulo = "Ensayos de Costaleras";
                break;
            case "ninos":
                titulo = "Ensayos de Niños";
                break;
        }

        model.addAttribute("titulo", titulo);
        model.addAttribute("categoria", categoria); // Pasamos la categoría para usarla en el HTML

        // Retorna el archivo HTML dinámico
        return "noticias/eventos";
    }
    
    @GetMapping("/hermandad/historia")
    public String historia(Model model) {
        return "historia/historia";
    }
    
    @GetMapping("/hermandad/junta-de-gobierno")
    public String juntaGobierno(Model model) {
        return "juntaGobierno/juntaGobierno";
    }
    
    @GetMapping("/hermandad/reglas")
    public String mostrarReglas() {
        // Devuelve el nombre del archivo HTML para las reglas
        return "reglas/reglas";
    }
    
    @GetMapping("/sagradasImagenes/virgen-de-la-esperanza")
    public String mostrarVirgenDeLaEsperanza() {
        return "sagradasImagenes/virgenEsperanza";
    }
    
    @GetMapping("/sagradasImagenes/jesus-en-el-descendimiento")
    public String mostrarDescendimiento() {
        return "sagradasImagenes/descendimiento";
    }
    
    @GetMapping("/sagradasImagenes/oracion-en-el-huerto")
    public String mostrarOracion() {
        return "sagradasImagenes/oracionHuerto";
    }
    
    @GetMapping("/sagradasImagenes/nino-carpintero")
    public String mostrarNinoCarpintero() {
        return "sagradasImagenes/ninoCarpintero";
    }
    
    @GetMapping("/multimedia")
    public String mostrarMultimedia() {
        // Devuelve el nombre del archivo HTML para multimedia
        return "multimedia/multimedia";
    }
    
    @GetMapping("/multimedia/construccion-capilla")
    public String mostrarConstruccionCapilla() {
        // Devuelve el nombre del archivo HTML correspondiente
        return "multimedia/construccionCapilla";
    }
    
    @GetMapping("/multimedia/imposicion-fajin")
    public String mostrarImposicionFajin() {
        // Devuelve el nombre del archivo HTML correspondiente
        return "multimedia/imposicionFajin";
    }
    
    @GetMapping("/multimedia/verbena")
    public String mostrarVerbena() {
        // Devuelve el nombre del archivo HTML correspondiente
        return "multimedia/verbena";
    }
    
   /* @GetMapping("/contacto")
    public String mostrarContacto() {
        // Devuelve el nombre del archivo HTML para multimedia
        return "contacto/contacto";
    }*/
    
}

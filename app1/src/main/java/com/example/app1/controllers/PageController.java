package com.example.app1.controllers;

import com.example.app1.models.CompraForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;//Este parametro nos permite pasarle parametros a la pagina
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/page")
public class PageController {
    @GetMapping
    public String home(Model model) {
        model.addAttribute("nombre", "Guillermo");
        model.addAttribute("nombres", Map.of(1,"uno",2,"dos"));
        return "home";
    }
    @GetMapping("compra")
    public String compra(Model model) {
        model.addAttribute("compraForm",new CompraForm(10.0,""));
        return "compra";
    }
    @PostMapping("compra")
    public String compra(Model model, @Valid @ModelAttribute CompraForm compraForm, Errors error) {
        System.out.println(error);
        //Comprobacion de errores
        if (error.hasErrors()) {
            model.addAttribute("compraForm", compraForm);
            return "compra";
        }
        System.out.println(compraForm);
        return "redirect:compra";
    }
   /* @GetMapping    ES OTRA FORMA DE HACER EL METODO DE ARRIBA
    public String home2() {
        var model = new ModelAndView("home");
        model.addObject("nombre", "Guillermo");
        return "home";
    }
*/

}


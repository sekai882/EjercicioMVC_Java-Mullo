package com.mullo.minicore.controller;

import com.mullo.minicore.dto.ComisionDTO;
import com.mullo.minicore.dto.RangoFechasDTO;
import com.mullo.minicore.service.ComisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ComisionController {

    private final ComisionService comisionService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("rango", new RangoFechasDTO());
        return "index";
    }

    @PostMapping("/calcular")
    public String calcularComisiones(@ModelAttribute RangoFechasDTO rango, Model model) {
        LocalDateTime inicio = rango.getFechaInicio() != null ? rango.getFechaInicio() : LocalDateTime.now().with(LocalTime.MIN);
        LocalDateTime fin = rango.getFechaFin() != null ? rango.getFechaFin() : LocalDateTime.now().with(LocalTime.MAX);
        
        List<ComisionDTO> resultados = comisionService.calcularComisiones(inicio, fin);
        
        model.addAttribute("resultados", resultados);
        model.addAttribute("rango", rango);
        
        return "index";
    }
}

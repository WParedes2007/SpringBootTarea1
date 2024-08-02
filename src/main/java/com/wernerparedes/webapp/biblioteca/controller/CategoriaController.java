package com.wernerparedes.webapp.biblioteca.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wernerparedes.webapp.biblioteca.model.Categoria;
import com.wernerparedes.webapp.biblioteca.service.CategoriaService;

@Controller
@RestController
@RequestMapping(value = "categoria")
public class CategoriaController{

    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/")
    public List<Categoria>listarCategorias(){
        return categoriaService.listarCategorias();
    }

    @PostMapping("/")
    public ResponseEntity<Map<String, String>> agregarCategoria(@RequestBody Categoria categoria){
        Map<String,String> response = new HashMap<>();
        try {
            categoriaService.guardarCategoria(categoria);
            response.put("message", "La Categoria Se Agrego Con Exito");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("err", "Hubo Un Error Al Crear La Categoria");
            return ResponseEntity.badRequest().body(response);
        }

        
    }

    /*@PostMapping("/")
    public ResponseEntity<Map<String, Boolean>> agregarCategoria(@RequestBody Categoria categoria){
        Map<String,Boolean> response = new HashMap<>();
        try {
            categoriaService.guardarCategoria(categoria);
            response.put("Se Agrego Con Exito", Boolean.TRUE);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("Se Agrego Con Exito", Boolean.FALSE);
            return ResponseEntity.badRequest().body(response);
        }

        
    }*/
}

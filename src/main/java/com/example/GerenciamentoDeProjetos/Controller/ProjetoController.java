package com.example.GerenciamentoProjetos.Controllers;

import com.example.GerenciamentoDeProjetos.Services.ProjetoService;
import com.example.GerenciamentoProjetos.Models.ProjetoModel;
import com.example.GerenciamentoDeProjetos.Services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @PostMapping
    public ResponseEntity<ProjetoModel> criarProjeto(@RequestBody ProjetoModel projetoModel) {
        ProjetoModel request = projetoService.criarProjeto(projetoModel);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(request.getId())
                .toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<ProjetoModel>> buscarProjetos() {
        List<ProjetoModel> request = projetoService.buscarProjetos();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoModel> buscarPorId(@PathVariable Long id) {
        ProjetoModel request = projetoService.buscarId(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProjeto(@PathVariable Long id) {
        projetoService.deletarProjeto(id);
        return ResponseEntity.noContent().build();
    }
}
package com.example.GerenciamentoDeProjetos.Services;

import com.example.GerenciamentoDeProjetos.Repositories.ProjetoRepositorie;
import com.example.GerenciamentoProjetos.Models.ProjetoModel;
import com.example.GerenciamentoDeProjetos.Repositories.ProjetoRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepositorie projetoRepositorie;

    public ProjetoModel criarProjeto(ProjetoModel projetoModel) {
        return projetoRepositorie.save(projetoModel);
    }

    public List<ProjetoModel> buscarProjetos() {
        return projetoRepositorie.findAll();
    }

    public ProjetoModel buscarId(Long id) {
        return projetoRepositorie.findById(id).get();
    }

    public void deletarProjeto(Long id) {
        projetoRepositorie.deleteById(id);
    }
}
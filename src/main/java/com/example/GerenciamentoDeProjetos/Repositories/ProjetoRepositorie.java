package com.example.GerenciamentoDeProjetos.Repositories;

import com.example.GerenciamentoProjetos.Models.ProjetoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepositorie extends JpaRepository<ProjetoModel, Long> {
}
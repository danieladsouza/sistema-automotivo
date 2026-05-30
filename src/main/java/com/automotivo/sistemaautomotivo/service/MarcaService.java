package com.automotivo.sistemaautomotivo.service;
import com.automotivo.sistemaautomotivo.entity.Marca;
import com.automotivo.sistemaautomotivo.repository.MarcaRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class MarcaService {
    private final MarcaRepository repository;

    public MarcaService(MarcaRepository repository) {
        this.repository = repository;
    }

    public List<Marca> listar() {
        return repository.findAll(); //select * from marca
    }

    public Marca buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Marca não encontrada"));
    }

    public Marca salvar(Marca marca) {
        if (marca.getNome() == null || marca.getNome().isBlank()) {
            throw new RuntimeException("Marca obrigatória");
        }
        return repository.save(marca); // insert ou update
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Optional<Marca> buscarPorNome(String nome) {
        return repository.findByNome(nome);
    }
    
}

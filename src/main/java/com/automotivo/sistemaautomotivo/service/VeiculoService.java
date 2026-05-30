package com.automotivo.sistemaautomotivo.service;

import com.automotivo.sistemaautomotivo.entity.Veiculo;
import com.automotivo.sistemaautomotivo.entity.Marca;
import com.automotivo.sistemaautomotivo.repository.VeiculoRepository;
import com.automotivo.sistemaautomotivo.repository.MarcaRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class VeiculoService {
    private final VeiculoRepository veiculoRepository;
    private final MarcaRepository marcaRepository;

    public VeiculoService(VeiculoRepository veiculoRepository,
        MarcaRepository marcaRepository) {
            this.veiculoRepository = veiculoRepository;
            this.marcaRepository = marcaRepository;
        }

    public List <Veiculo> listar() {
        return veiculoRepository.findAll();
    }

    public List<Veiculo> buscarPorMarca(Long marcaId) {
        return veiculoRepository.findByMarcaId(marcaId);
    }

    public Veiculo salvar(Long marcaId, Veiculo veiculo) {
        Marca marca = marcaRepository.findById(marcaId)
        .orElseThrow(() -> new RuntimeException("Marca não encontrada"));

        if (veiculo.getPreco() == null || veiculo.getPreco() <= 0) {
            throw new RuntimeException("Preço inválido");
        }

        veiculo.setMarca(marca);
        return veiculoRepository.save(veiculo);
    }

    public Veiculo buscarPorId(Long id) {
        return veiculoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
    }

    public Veiculo atualizarPreco(Long id, Double preco) {
        Veiculo veiculo = veiculoRepository.findById(id).orElseThrow(() -> new RuntimeException("Veiculo não encontrado"));

        veiculo.setPreco(preco);

        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> buscarPorStatus(String status) {
        return veiculoRepository.findByStatus(status);
    }

    public Veiculo atualizarStatus(Long id, String status) {
        Veiculo veiculo = buscarPorId(id);
        veiculo.setStatus(status);
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> buscarPorQuilometragem(Long quilometragem) {
        return veiculoRepository.findByQuilometragem(quilometragem);
    }

    public List<Veiculo> buscarPorCor(String cor) {
        return veiculoRepository.findByCor(cor);
    }

    public List<Veiculo> buscarPorAno(int ano) {
        return veiculoRepository.findByAno(ano);
    }

    public List<Veiculo> buscarPorPreco(double min, double max) {
        return veiculoRepository.findByPrecoBetween(min, max);

    }

    public void deletar(Long id) {
        veiculoRepository.deleteById(id);
    }
}

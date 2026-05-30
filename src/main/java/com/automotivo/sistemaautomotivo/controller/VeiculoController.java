package com.automotivo.sistemaautomotivo.controller;

import com.automotivo.sistemaautomotivo.entity.Veiculo;
import com.automotivo.sistemaautomotivo.service.VeiculoService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/veiculos")

public class VeiculoController {
    private final VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Veiculo> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Veiculo buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping("/marca/{marcaId}")
    public Veiculo salvar(
        @PathVariable Long marcaId,
        @RequestBody Veiculo veiculo
    ) {
        return service.salvar(marcaId, veiculo);
    }

    @GetMapping("/status/{status}")
    public List<Veiculo> buscarPorStatus(@PathVariable String status) {
        return service.buscarPorStatus(status);
    }

    @PatchMapping("/{id}/status")
    public Veiculo atualizarStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.atualizarStatus(id, status);
    }

    @GetMapping("/cor/{cor}")
    public List<Veiculo> buscarPorCor(@PathVariable String cor) {
        return service.buscarPorCor(cor);
    }

    @GetMapping("/ano/{ano}")
    public List<Veiculo> buscarPorAno(@PathVariable int ano) {
        return service.buscarPorAno(ano);
    }

    @GetMapping("/quilometragem/{quilometragem}")
    public List<Veiculo> buscarPorQuilometragem(@PathVariable Long quilometragem) {
        return service.buscarPorQuilometragem(quilometragem);
    }

    @GetMapping("/preco")
    public List<Veiculo> buscarPorPreco(
        @RequestParam double min,
        @RequestParam double max) {
        return service.buscarPorPreco(min, max);
    }

    @PatchMapping("/{id}/preco")
    public Veiculo atualizarPreco(
            @PathVariable Long id,
            @RequestParam Double preco) {
        return service.atualizarPreco(id, preco);
    }

    @GetMapping("/marca/{marcaId}")
    public List<Veiculo> buscarPorMarca(@PathVariable Long marcaId) {
        return service.buscarPorMarca(marcaId);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
    service.deletar(id);
    }   
}

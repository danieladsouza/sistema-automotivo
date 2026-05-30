package com.automotivo.sistemaautomotivo.controller;

import com.automotivo.sistemaautomotivo.entity.Marca;
import com.automotivo.sistemaautomotivo.entity.Veiculo;

import com.automotivo.sistemaautomotivo.service.MarcaService;
import com.automotivo.sistemaautomotivo.service.VeiculoService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/marcas")

public class MarcaController {
    private final MarcaService marcaService;
    private final VeiculoService veiculoService;

    public MarcaController(MarcaService marcaService,
        VeiculoService veiculoService) {
            this.marcaService = marcaService;
            this.veiculoService = veiculoService;
    }

    @GetMapping
    public List<Marca> listar() {
        return marcaService.listar();
    }

    @GetMapping("/{id}")
    public Marca buscarPorId(@PathVariable Long id) {
        return marcaService.buscarPorId(id);
    }

    @PostMapping
    public Marca salvar(@RequestBody Marca marca) {
        return marcaService.salvar(marca);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        marcaService.deletar(id);
    }
    
    @GetMapping("/{id}/veiculos")
    public List<Veiculo> listarVeiculosPorMarca(@PathVariable Long id) {
        return veiculoService.buscarPorMarca(id);
    }
}

package com.automotivo.sistemaautomotivo.repository;

import com.automotivo.sistemaautomotivo.entity.Veiculo;
import com.automotivo.sistemaautomotivo.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    List<Veiculo> findByMarcaId(Long marcaId);

    List<Veiculo> findByMarca(Marca marca);

    List<Veiculo> findByModelo(String modelo);

    List<Veiculo> findByStatus(String status);

    List<Veiculo> findByPrecoBetween(double min, double max);

    List<Veiculo> findByAno(int ano);

    List<Veiculo> findByQuilometragem(Long quilometragem);

    List<Veiculo> findByCor(String cor);
}

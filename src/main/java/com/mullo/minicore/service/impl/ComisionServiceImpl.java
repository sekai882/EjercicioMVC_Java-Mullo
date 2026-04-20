package com.mullo.minicore.service.impl;

import com.mullo.minicore.dto.ComisionDTO;
import com.mullo.minicore.model.Regla;
import com.mullo.minicore.model.Vendedor;
import com.mullo.minicore.model.Venta;
import com.mullo.minicore.repository.ReglaRepository;
import com.mullo.minicore.repository.VendedorRepository;
import com.mullo.minicore.repository.VentaRepository;
import com.mullo.minicore.service.ComisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ComisionServiceImpl implements ComisionService {

    private final VentaRepository ventaRepository;
    private final VendedorRepository vendedorRepository;
    private final ReglaRepository reglaRepository;

    @Override
    public List<ComisionDTO> calcularComisiones(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        List<Venta> ventas = ventaRepository.findByFechaVentaBetween(fechaInicio, fechaFin);
        List<Vendedor> vendedores = vendedorRepository.findAll();
        List<Regla> reglas = reglaRepository.findAll();

        // Sort rules from highest min amount to lowest
        reglas.sort((r1, r2) -> r2.getMontoMinimo().compareTo(r1.getMontoMinimo()));

        Map<Long, Double> ventasPorVendedor = ventas.stream()
                .collect(Collectors.groupingBy(
                        v -> v.getVendedor().getId(),
                        Collectors.summingDouble(Venta::getMonto)
                ));

        List<ComisionDTO> resultado = new ArrayList<>();

        for (Vendedor vendedor : vendedores) {
            Double totalVentas = ventasPorVendedor.getOrDefault(vendedor.getId(), 0.0);
            Double comision = 0.0;

            if (totalVentas > 0) {
                // Find matching rule (from 6% to 15%)
                for (Regla regla : reglas) {
                    if (totalVentas >= regla.getMontoMinimo()) {
                        comision = totalVentas * (regla.getPorcentaje() / 100.0);
                        break;
                    }
                }
            }

            resultado.add(new ComisionDTO(vendedor.getNombre(), totalVentas, comision));
        }

        return resultado;
    }
}

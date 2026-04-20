package com.mullo.minicore.config;

import com.mullo.minicore.model.Regla;
import com.mullo.minicore.model.Vendedor;
import com.mullo.minicore.model.Venta;
import com.mullo.minicore.repository.ReglaRepository;
import com.mullo.minicore.repository.VendedorRepository;
import com.mullo.minicore.repository.VentaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final VendedorRepository vendedorRepository;
    private final ReglaRepository reglaRepository;
    private final VentaRepository ventaRepository;

    @Override
    public void run(String... args) throws Exception {
        if (reglaRepository.count() == 0) {
            reglaRepository.saveAll(Arrays.asList(
                    new Regla(null, 6.0, 0.0),
                    new Regla(null, 12.0, 1000.0),
                    new Regla(null, 15.0, 5000.0)
            ));
        }

        if (vendedorRepository.count() == 0 && ventaRepository.count() == 0) {
            Vendedor v1 = vendedorRepository.save(new Vendedor(null, "Josué Mullo"));
            Vendedor v2 = vendedorRepository.save(new Vendedor(null, "Andrés Vega"));
            Vendedor v3 = vendedorRepository.save(new Vendedor(null, "Luis Villalba"));

            // Fechas realistas para probar el filtro (hace unos días y esta semana de abril 2026)
            LocalDateTime fecha1 = LocalDateTime.of(2026, Month.APRIL, 10, 10, 30);
            LocalDateTime fecha2 = LocalDateTime.of(2026, Month.APRIL, 12, 14, 45);
            LocalDateTime fecha3 = LocalDateTime.of(2026, Month.APRIL, 15, 9, 15);
            LocalDateTime fecha4 = LocalDateTime.of(2026, Month.APRIL, 17, 16, 20);
            LocalDateTime fecha5 = LocalDateTime.of(2026, Month.APRIL, 19, 11, 0);

            ventaRepository.saveAll(Arrays.asList(
                    // Josue Mullo: total $1700 -> 12% = $204
                    new Venta(null, 500.0, fecha1, v1),
                    new Venta(null, 1200.0, fecha2, v1),
                    // Andres Vega: total $1100 -> 12% = $132
                    new Venta(null, 800.0, fecha3, v2),
                    new Venta(null, 300.0, fecha5, v2),
                    // Luis Villalba: total $5500 -> 15% = $825
                    new Venta(null, 5500.0, fecha4, v3)
            ));
        }
    }
}

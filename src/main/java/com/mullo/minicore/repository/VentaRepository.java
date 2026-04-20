package com.mullo.minicore.repository;

import com.mullo.minicore.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
    
    @Query("SELECT v FROM Venta v JOIN FETCH v.vendedor WHERE v.fechaVenta >= :fechaInicio AND v.fechaVenta <= :fechaFin")
    List<Venta> findByFechaVentaBetween(@Param("fechaInicio") LocalDateTime fechaInicio, @Param("fechaFin") LocalDateTime fechaFin);
}

package com.mullo.minicore.service;

import com.mullo.minicore.dto.ComisionDTO;
import java.time.LocalDateTime;
import java.util.List;

public interface ComisionService {
    List<ComisionDTO> calcularComisiones(LocalDateTime fechaInicio, LocalDateTime fechaFin);
}

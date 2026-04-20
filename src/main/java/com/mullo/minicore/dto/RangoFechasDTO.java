package com.mullo.minicore.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class RangoFechasDTO {
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
}

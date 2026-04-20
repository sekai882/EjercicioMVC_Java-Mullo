package com.mullo.minicore.repository;

import com.mullo.minicore.model.Regla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReglaRepository extends JpaRepository<Regla, Long> {
}

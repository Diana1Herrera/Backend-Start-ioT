package com.StartIot.StartIot.repository;

import com.StartIot.StartIot.model.Activo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IactivoRepository extends JpaRepository<Activo, Long> {
}

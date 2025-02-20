package com.StartIot.StartIot.repository;

import com.StartIot.StartIot.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IpedidoRepository extends JpaRepository<Pedido, Long> {
}

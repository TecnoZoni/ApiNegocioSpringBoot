package com.negocio.negocioSpringBoot.repository;

import com.negocio.negocioSpringBoot.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVentaRepository extends JpaRepository<Venta, Long> {

}

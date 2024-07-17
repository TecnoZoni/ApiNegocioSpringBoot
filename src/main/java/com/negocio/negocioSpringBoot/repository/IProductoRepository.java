package com.negocio.negocioSpringBoot.repository;

import com.negocio.negocioSpringBoot.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long>{

}

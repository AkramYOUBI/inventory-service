package com.example.inventoryservice.domain.repository;

import com.example.inventoryservice.domain.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    //@Query("select i from Inventory i where i.skuCode = :skuCode")
    Inventory findBySkuCode(@Param("skuCode") String skuCode);
}

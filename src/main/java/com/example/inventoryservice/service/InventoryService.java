package com.example.inventoryservice.service;

import com.example.inventoryservice.domain.entities.Inventory;
import com.example.inventoryservice.domain.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private  final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    public Boolean findBySkuCode(String skuCode) {
        Boolean result = false;
        if(inventoryRepository.findBySkuCode(skuCode) != null){
            result = true;
        }
        return result;
    }
}

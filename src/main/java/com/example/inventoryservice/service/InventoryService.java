package com.example.inventoryservice.service;

import com.example.inventoryservice.domain.InventoryResponse;
import com.example.inventoryservice.domain.entities.Inventory;
import com.example.inventoryservice.domain.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<InventoryResponse> findBySkuCode(List<String> skuCode) {
        List<InventoryResponse> result = new ArrayList<>();
        InventoryResponse response= new InventoryResponse();
        if(!skuCode.isEmpty()){
            result = inventoryRepository.findBySkuCodeIn(skuCode).stream().map(
                    x -> response.builder().skuCode(x.getSkuCode())
                            .isInStock(x.getQuantity() > 0)
                            .build())
                    .collect(Collectors.toList());
        }
        return result;
    }
}

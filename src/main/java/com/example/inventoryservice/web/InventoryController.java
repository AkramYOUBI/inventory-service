package com.example.inventoryservice.web;

import com.example.inventoryservice.domain.InventoryResponse;
import com.example.inventoryservice.domain.entities.Inventory;
import com.example.inventoryservice.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    private Inventory saveInventory(@RequestBody Inventory inventory){
        return inventoryService.createInventory(inventory);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    private List<Inventory> getAllInventories(){
        return inventoryService.getAllInventories();
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    private List<InventoryResponse> idInStock(@RequestParam List<String> skuCode){
        return inventoryService.findBySkuCode(skuCode);
    }


}

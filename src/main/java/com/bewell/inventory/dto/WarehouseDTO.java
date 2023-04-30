package com.bewell.inventory.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseDTO {
    private Long warehouseId;
    private String name;
    private String region;
    private String city;
    private String address;
}

package com.bewell.inventory.enumeration;

public enum OperationStatusCode {
    ADD_PRODUCT(1L, "Ürün Eklendi"),
    REMOVE_PRODUCT(2L,"Ürün Çıkarıldı");

    private Long id;
    private String value;

    OperationStatusCode(Long id, String value) {
        this.id = id;
        this.value = value;
    }
}
package com.bewell.inventory.enumeration;

public enum OperationStatusCode {
    ADD_PRODUCT(1L, "Ürün Eklendi"),
    REMOVE_PRODUCT(2L,"Ürün Çıkarıldı"),
    DELETE_PRODUCT(3L, "Ürün Tükendi"),
    NEW_ADD_PRODUCT(4L, "Yeni Ürün Eklendi"),
    DROP_PRODUCT(5L, "Ürün silindi");

    private Long id;
    private String value;

    OperationStatusCode(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
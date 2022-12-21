package com.example.demo.enums;

public enum UserPermissions {
    PRODUCT_READ("product:read"),
    PRODUCT_WRITE("product:write"),
    PRODUCT_UPDATE("product:read"),
    PRODUCT_DELETE("product:write"),
    ORDER_READ("order:read"),
    ORDER_WRITE("order:write"),
    ORDER_UPDATE("order:read"),
    ORDER_DELETE("order:write");

    private final String permission;

    UserPermissions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}

package com.example.demo.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.demo.enums.UserPermissions.*;

public enum RoleEnum {
    CLIENT(Set.of(ORDER_READ,ORDER_WRITE,ORDER_UPDATE,ORDER_DELETE)) ,
    SUPPLIER(Set.of(PRODUCT_READ,PRODUCT_WRITE,PRODUCT_UPDATE,PRODUCT_DELETE)) ,
    ADMIN(
            Set.of(PRODUCT_READ,PRODUCT_WRITE,PRODUCT_UPDATE,PRODUCT_DELETE,
                 ORDER_READ,ORDER_WRITE,ORDER_UPDATE,ORDER_DELETE
    ));
    private final Set<UserPermissions> permissions;

    
    RoleEnum(Set<UserPermissions> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermissions> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}

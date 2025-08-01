
package com.boutique.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private String type = "Bearer";
    private String username;
    private String[] roles;

    public AuthResponse(String token, String username, String[] roles) {
        this.token = token;
        this.username = username;
        this.roles = roles;
    }
}
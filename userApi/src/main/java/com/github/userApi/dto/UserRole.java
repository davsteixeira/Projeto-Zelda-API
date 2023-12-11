package com.github.userApi.dto;

public enum UserRole {
    ADMIN("admin"),
    USER("user");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }

    //Esse enum é responsável por atribuir uma role para determinado usuário.

}

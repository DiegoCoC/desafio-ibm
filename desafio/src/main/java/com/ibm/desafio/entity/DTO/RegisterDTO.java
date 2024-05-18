package com.ibm.desafio.entity.DTO;

import com.ibm.desafio.entity.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}

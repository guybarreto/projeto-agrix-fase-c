package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.security.Role;

public class PersonDto {

  private Long id;
  private String username;
  private Role role;

  // Construtores, getters e setters

  public PersonDto() {
  }

  public PersonDto(Long id, String username, Role role) {
    this.id = id;
    this.username = username;
    this.role = role;
  }

  // Getters e Setters

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }
}


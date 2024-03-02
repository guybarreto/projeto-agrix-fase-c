package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.security.Role;

/**
 * The type Person dto.
 */
public class PersonDto {

  private Long id;
  private String username;
  private Role role;

  // Construtores, getters e setters

  /**
   * Instantiates a new Person dto.
   */
  public PersonDto() {
  }

  /**
   * Instantiates a new Person dto.
   *
   * @param id       the id
   * @param username the username
   * @param role     the role
   */
  public PersonDto(Long id, String username, Role role) {
    this.id = id;
    this.username = username;
    this.role = role;
  }

  // Getters e Setters

  /**
   * Gets id.
   *
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets username.
   *
   * @return the username
   */
  public String getUsername() {
    return username;
  }

  /**
   * Sets username.
   *
   * @param username the username
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Gets role.
   *
   * @return the role
   */
  public Role getRole() {
    return role;
  }

  /**
   * Sets role.
   *
   * @param role the role
   */
  public void setRole(Role role) {
    this.role = role;
  }
}


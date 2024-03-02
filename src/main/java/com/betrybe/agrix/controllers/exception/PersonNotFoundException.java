package com.betrybe.agrix.controllers.exception;

/**
 * Exception for when a person is not found.
 */
public class PersonNotFoundException extends RuntimeException {

  /**
   * Instantiates a new Person not found exception.
   */
  public PersonNotFoundException() {
    super("Pessoa não encontrada!");
  }

}

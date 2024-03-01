package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.PersonDto;
import com.betrybe.agrix.models.entities.Person;
import com.betrybe.agrix.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {

  private final PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @PostMapping
  public ResponseEntity<PersonDto> createPerson(@RequestBody Person person) {
    Person createdPerson = personService.create(person);

    PersonDto personDto = new PersonDto(createdPerson.getId(), createdPerson.getUsername(), createdPerson.getRole());

    return ResponseEntity.status(HttpStatus.CREATED).body(personDto);
  }
}

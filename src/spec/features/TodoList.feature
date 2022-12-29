@test
Feature: Je souhaite de verifier la fonctionnalite de l application todoList 
 

  @testTodoList
  Scenario Outline: Je souhaite de verifier la fonctionnalite de l application todoList 
    Given Je me connecte sur l application todoList
    When Je verifie le bouton Ajouter tache
    And Je modifie le status d une tache
    And Je supprime une tache
    Then je deconnecte de l application
    
   
  
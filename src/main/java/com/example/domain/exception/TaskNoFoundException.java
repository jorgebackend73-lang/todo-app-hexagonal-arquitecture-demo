package com.example.domain.exception;

// @SuppressWarnings("serial") funciona para un warning en eclipse, pero aquí así no furula.
public class TaskNoFoundException extends RuntimeException {

    /*TaskNoFoundException es una regla de negocio y como RuntimeException
    no necesita nada del framework Spring se puede utilizar en este contexto, 
    es decir en el dominio. */
    public TaskNoFoundException(long id) {
        super("No ha sido encontrada la tarea con ID: " + id);
    }
    

}

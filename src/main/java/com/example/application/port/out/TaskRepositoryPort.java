package com.example.application.port.out;

import java.util.List;
import java.util.Optional;

import com.example.domain.model.Task;

public interface TaskRepositoryPort {
    
    //Cramos un metodo para guardar la tarea en el puerto de salida.
    Task save(Task task);
    //Preparamos metodo a inplementar por la infraestructura. Buscar por id. 
    Optional<Task> findById(long id);

    List<Task> findAll();
}

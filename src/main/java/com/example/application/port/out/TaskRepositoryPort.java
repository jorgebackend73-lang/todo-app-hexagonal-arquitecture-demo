package com.example.application.port.out;

import com.example.domain.model.Task;

public interface TaskRepositoryPort {
    Task save(Task task); //Cramos un metodo para guardar la tarea en el puerto de salida.

}

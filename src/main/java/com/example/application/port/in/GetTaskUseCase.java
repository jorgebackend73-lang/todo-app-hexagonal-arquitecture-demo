package com.example.application.port.in;

import com.example.domain.model.Task;

public interface GetTaskUseCase {
    //Nuevo contrato de tarea para buscar tarea por id.
    //Expone al mundo una nueva tarea que nuestra aplicación pude hacer.
    Task getById(long id);


}

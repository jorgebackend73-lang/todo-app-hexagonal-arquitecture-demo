/*Esta clase es la que implementa el caso de uso */
package com.example.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.application.port.in.CreateTaskUseCase;
import com.example.application.port.in.GetTaskUseCase;
import com.example.application.port.in.ListTaskUseCase;
import com.example.application.port.out.TaskRepositoryPort;
import com.example.domain.exception.TaskNoFoundException;
import com.example.domain.model.Task;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service 
/* ¿Es correcta una anotación de Spring aquí?
Siendo puristas, no. Pero implementarlo correctamente tiene un elevado coste.

Con esta anotación estamos introduciendo una dependencia del framework en la capa de
aplicación. Si queremos o tenemos que migrar a otro framework como quarkus o si queremos
testear en aislamiento total, siempre estaría acoplada a Spring Framework.

Para resolverlo habría que crear un componente ( anotado con @Component o @Configuration)
en la capa de infraestructura donde tengamos todos los bean que sean necesarios cuando
se levant el contexto Spring y así evitar esta anotación.*/ 
public class TaskService implements CreateTaskUseCase, GetTaskUseCase, ListTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    @Override
    public Task create(Task task) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'create'");
        return taskRepositoryPort.save(task);
    }

    @Override
    public Task getById(long id) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getById'");
        return taskRepositoryPort.findById(id)
            .orElseThrow(() -> new TaskNoFoundException(id));
    }

    @Override
    public List<Task> listAll() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'listAll'");
        return taskRepositoryPort.findAll();
    }


}

package com.example.infrastructure.adapter.out.persistence;

import org.mapstruct.Mapper;
import com.example.domain.model.Task;

@Mapper(componentModel = "spring") 
public interface TaskPersistenceMapper {
    
    Task toDomain(TaskJpaEntity taskJpaEntity);
    
    TaskJpaEntity toJpaEntity(Task task);

/*    
//Está manual, hay que implementar el mapstruct para que haga el mapeo de forma automática. 

    public Task toDomain(TaskJpaEntity entity) {
    // método toDomain, que recive una entidad, que pasa al dominio, donde se raliza la tarea.
        if (entity == null)
            return null;

        return Task.builder()
            .id(entity.getId())
            .title(entity.getTitle())
            .description(entity.getDescription())
            .status(entity.getStatus())
            .createdAt(entity.getCreatedAt())
            .completedAt(entity.getCompletedAt())
            .build();

    }

    public TaskJpaEntity toJpaEntity(Task task) {

        if (task == null)
            return null;

        return TaskJpaEntity.builder()
            .id(task.getId())
            .title(task.getTitle())
            .description(task.getDescription())
            .status(task.getStatus())
            .createdAt(task.getCreatedAt())
            .completedAt(task.getCompletedAt())
            .build();
    }*/ 


}

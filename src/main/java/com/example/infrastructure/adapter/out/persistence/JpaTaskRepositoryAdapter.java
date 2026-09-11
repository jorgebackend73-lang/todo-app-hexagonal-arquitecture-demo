package com.example.infrastructure.adapter.out.persistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.application.port.out.TaskRepositoryPort;
import com.example.domain.model.Task;

import lombok.RequiredArgsConstructor;

// donde hacemos las implementaciones
@Repository 
@RequiredArgsConstructor 
public class JpaTaskRepositoryAdapter implements TaskRepositoryPort {

    private final SpringDataTaskRepository springDataTaskRepository;

    private final TaskPersistenceMapper mapper;

    //con esto se termina la implementación del metodo save.

    @Override
    public Task save(Task task) {
                
        task.initDefaults();
        TaskJpaEntity entity = mapper.toJpaEntity(task);
        TaskJpaEntity saved = springDataTaskRepository.save(entity);
        
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Task> findById(long id) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'findById'");
        
        //pasamos con mapper por referencia el metodo toDomain de entidad a dominio
        //que es lo que este metodo está esperando.
        return springDataTaskRepository.findById(id).map(mapper::toDomain);

    }

    @Override
    public List<Task> findAll() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'findAll'");
        return springDataTaskRepository.findAll()
            .stream()
            .map(mapper::toDomain)
            .collect(Collectors.toList());
    }

}

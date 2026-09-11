package com.example.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor 
@AllArgsConstructor 
@Getter 
@Setter 
@Builder 
@EqualsAndHashCode (onlyExplicitlyIncluded = true) 
// EqualAndHascode al crear un objeto o propiedad mejor diferenciarlas con propiedades de lombock
public class Task {

    @EqualsAndHashCode.Include
    private long id; //el unico incluido para crear metodos va a ser el id.

    private String title;
    private String description;
    private TaskStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;

/* Los metodos siguientes aportan comportamiento o las reglas de negocio,
 para la gestión de las tareas. */

 public void complete() {

    if (this.status == TaskStatus.COMPLETED) {
        throw new IllegalStateException("La tarea ya está completada.");
    }

    this.status = TaskStatus.COMPLETED;
    this.completedAt = LocalDateTime.now();
}

public void reopen() {

    if (this.status == TaskStatus.PENDING) {
        throw new IllegalStateException("La tarea ya está pendiente.");
    }

    this.status = TaskStatus.PENDING;
    this.completedAt = null;
}

// No pongo this. delante de status, pq en este caso no se puede confundir con 
// una propiedad de las que hemos creado arriba.
public void initDefaults() {
    if (status == null)
        status = TaskStatus.PENDING;
    if (createdAt == null)
        createdAt = LocalDateTime.now();
}

}

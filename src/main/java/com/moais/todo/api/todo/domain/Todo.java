package com.moais.todo.api.todo.domain;

import com.moais.todo.api.todo.dto.TodoRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String content;

    @Column(nullable = false, columnDefinition = "varchar(5) default 'TODO'")
    @Enumerated(EnumType.STRING)
    private Status status = Status.TODO;

    @Column(nullable = false)
    private LocalDateTime doDate;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime updatedDate;

    public Todo(TodoRequest todoRequest) {
        this.title = todoRequest.getTitle();
        this.content = todoRequest.getContent();
        this.doDate = todoRequest.getDoDate();
    }

    public void update(TodoRequest todoRequest) {
        this.title = todoRequest.getTitle();
        this.content = todoRequest.getContent();
        this.doDate = todoRequest.getDoDate();
    }

    public void updateStatus(Status status) {
        if (status.name().equals(Status.WAIT.name())) {
            if (!this.status.name().equals(Status.ING.name())) {
                throw new RuntimeException();
            }
        }
        this.status = status;
    }

}

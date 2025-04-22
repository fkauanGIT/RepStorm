package com.app.RepStorm.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "exercises")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "exercise_id")
    private UUID id;

    @Column(nullable = false, length = 100)
    private String name;

    private String description;

    @Column(name = "muscle_group", length = 50)
    private String muscleGroup;

    @Column(length = 50)
    private String equipment;

    @Column(name = "is_default")
    private boolean isDefault = true;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "exercise")
    private List<UserExercise> userExercises;
}
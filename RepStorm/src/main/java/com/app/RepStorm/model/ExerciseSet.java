package com.app.RepStorm.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "exercise_sets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExerciseSet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "set_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "workout_exercise_id", nullable = false)
    private WorkoutExercise workoutExercise;

    @Column(name = "set_number", nullable = false)
    private Integer setNumber;

    @Column(nullable = false)
    private Integer repetitions;

    @Column(name = "weight_kg", nullable = false, precision = 5, scale = 2)
    private Double weightKg;

    @Column(name = "rest_seconds")
    private Integer restSeconds;

    @Column(name = "is_completed")
    private boolean isCompleted = true;

    @Column(precision = 3, scale = 1)
    private Double rpe;

    private String notes;
}
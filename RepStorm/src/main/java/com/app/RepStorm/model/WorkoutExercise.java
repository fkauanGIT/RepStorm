package com.app.RepStorm.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "workout_exercises")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkoutExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "workout_exercise_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "workout_id", nullable = false)
    private Workout workout;

    @ManyToOne
    @JoinColumn(name = "user_exercise_id", nullable = false)
    private UserExercise userExercise;

    @Column(name = "exercise_order", nullable = false)
    private Integer order;

    private String notes;

    @OneToMany(mappedBy = "workoutExercise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExerciseSet> sets;
}
package com.app.RepStorm.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user_exercises")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_exercise_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @Column(name = "custom_name", length = 100)
    private String customName;

    private String notes;

    @Column(name = "is_favorite")
    private boolean isFavorite = false;

    @OneToMany(mappedBy = "userExercise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkoutExercise> workoutExercises;

    @OneToMany(mappedBy = "userExercise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserGoal> goals;

    @OneToMany(mappedBy = "userExercise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DailyProgress> dailyProgress;

    @OneToMany(mappedBy = "userExercise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExerciseRanking> rankings;
}
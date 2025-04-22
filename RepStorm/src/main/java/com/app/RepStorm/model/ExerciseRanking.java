package com.app.RepStorm.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "exercise_rankings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExerciseRanking {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ranking_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "user_exercise_id", nullable = false)
    private UserExercise userExercise;

    @Column(name = "metric_type", nullable = false, length = 20)
    private String metricType;

    @Column(name = "metric_value", nullable = false, precision = 10, scale = 2)
    private Double metricValue;

    @Column(name = "achieved_date", nullable = false)
    private LocalDate achievedDate;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

    private String notes;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}
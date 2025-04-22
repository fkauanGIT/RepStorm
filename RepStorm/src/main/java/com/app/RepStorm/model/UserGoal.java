package com.app.RepStorm.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "user_goals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "goal_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "user_exercise_id", nullable = false)
    private UserExercise userExercise;

    @Column(name = "target_weight", nullable = false, precision = 5, scale = 2)
    private Double targetWeight;

    @Column(name = "target_repetitions")
    private Integer targetRepetitions;

    @Column(name = "target_date", nullable = false)
    private LocalDate targetDate;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "start_weight", nullable = false, precision = 5, scale = 2)
    private Double startWeight;

    @Column(name = "current_progress_percent", precision = 5, scale = 2)
    private Double currentProgressPercent = 0.0;

    private String notes;

    @Column(name = "is_completed")
    private boolean isCompleted = false;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}
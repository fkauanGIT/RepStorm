package com.app.RepStorm.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "daily_progress")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DailyProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "progress_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "user_exercise_id", nullable = false)
    private UserExercise userExercise;

    @Column(name = "progress_date", nullable = false)
    private LocalDate progressDate;

    @Column(name = "max_weight", precision = 5, scale = 2)
    private Double maxWeight;

    @Column(name = "max_volume", precision = 10, scale = 2)
    private Double maxVolume;

    @Column(name = "total_sets")
    private Integer totalSets;

    @Column(name = "total_repetitions")
    private Integer totalRepetitions;

    @Column(name = "best_set_repetitions")
    private Integer bestSetRepetitions;

    @Column(name = "best_set_weight", precision = 5, scale = 2)
    private Double bestSetWeight;
}
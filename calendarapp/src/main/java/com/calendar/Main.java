package com.calendar;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        // --- LEFT COLUMN (Roommate) ---
        VBox leftCol = createColumn("Roommate's Schedule", "#2c3e50");
        
        // --- RIGHT COLUMN (You) ---
        VBox rightCol = createColumn("My Schedule", "#2c3e50");

        // --- CENTER COLUMN (Clock & Image) ---
        VBox centerCol = new VBox(20);
        centerCol.setAlignment(Pos.CENTER);
        centerCol.setStyle("-fx-background-color: #34495e; -fx-padding: 20;");
        
        Label timeLabel = new Label();
        timeLabel.setStyle("-fx-font-size: 60px; -fx-text-fill: white; -fx-font-weight: bold;");
        
        Label dateLabel = new Label();
        dateLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: #bdc3c7;");

        // Simple Clock Logic
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            timeLabel.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss a")));
            dateLabel.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEEE, MMMM dd")));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

        Label imagePlaceholder = new Label("[ Image Placeholder ]");
        imagePlaceholder.setStyle("-fx-text-fill: #95a5a6; -fx-border-color: #95a5a6; -fx-border-width: 2; -fx-padding: 50;");

        centerCol.getChildren().addAll(timeLabel, dateLabel, imagePlaceholder);

        // --- ROOT LAYOUT ---
        HBox root = new HBox(leftCol, centerCol, rightCol);
        HBox.setHgrow(leftCol, Priority.ALWAYS);
        HBox.setHgrow(centerCol, Priority.ALWAYS);
        HBox.setHgrow(rightCol, Priority.ALWAYS);

        Scene scene = new Scene(root, 1280, 800);
        stage.setTitle("Pi Calendar Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    private VBox createColumn(String title, String bgColor) {
        VBox col = new VBox(10);
        col.setAlignment(Pos.TOP_CENTER);
        col.setStyle("-fx-background-color: " + bgColor + "; -fx-padding: 20; -fx-border-color: #1a252f; -fx-border-width: 0 1 0 1;");
        
        Label header = new Label(title);
        header.setStyle("-fx-font-size: 28px; -fx-text-fill: white; -fx-border-color: white; -fx-border-width: 0 0 2 0;");
        
        col.getChildren().add(header);
        return col;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
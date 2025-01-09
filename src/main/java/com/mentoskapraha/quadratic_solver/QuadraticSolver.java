package com.mentoskapraha.quadratic_solver;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class QuadraticSolver extends Application {
  @Override
  public void start(Stage stage) throws IOException {
    //setup stage
    stage.setTitle("Quadratic Solver");
    stage.setMinWidth(540);
    stage.setMinHeight(300);

    //load UI
    FXMLLoader fxmlLoader = new FXMLLoader(QuadraticSolver.class.getResource("ui.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 540, 300);

    //show stage
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}

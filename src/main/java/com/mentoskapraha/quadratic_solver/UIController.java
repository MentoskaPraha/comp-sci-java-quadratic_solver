package com.mentoskapraha.quadratic_solver;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class UIController {
  @FXML
  private Label welcomeText;

  @FXML
  protected void onHelloButtonClick() {
    welcomeText.setText("Welcome World!");
  }
}

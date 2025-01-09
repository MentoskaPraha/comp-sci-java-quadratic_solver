package com.mentoskapraha.quadratic_solver;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.text.ParsePosition;

public class UIController {

  @FXML
  private TextField a0;

  @FXML
  private TextField a1;

  @FXML
  private TextField a2;

  @FXML
  private Label result1;

  @FXML
  private Label result2;

  @FXML
  private void initialize() {
    // on initialisation set the formatter
    this.a0.setTextFormatter(new DecimalTextFormatter(0, 2, true, 5));
    this.a1.setTextFormatter(new DecimalTextFormatter(0, 2, true, 5));
    this.a2.setTextFormatter(new DecimalTextFormatter(0, 2, true, 5));
  }

  @FXML
  protected void onCalculateButtonClick() {
    // create the equation
    final QuadraticEquation equation = new QuadraticEquation(
            Double.parseDouble(this.a2.getText()),
            Double.parseDouble(this.a1.getText()),
            Double.parseDouble(this.a0.getText())
    );

    //calculate it
    equation.calculate();

    //display the results
    final QuadraticEquationSolutionType solutionType = equation.getSolutionType();

    if (solutionType == QuadraticEquationSolutionType.twoSolutions) {
      this.result1.setText(Double.toString(equation.getResult1()));
      this.result2.setText(Double.toString(equation.getResult2()));
    } else if (solutionType == QuadraticEquationSolutionType.oneSolution) {
      this.result1.setText(Double.toString(equation.getResult1()));
      this.result2.setText("N/A");
    } else if (solutionType == QuadraticEquationSolutionType.infiniteSolutions) {
      this.result1.setText("INFINITY");
      this.result2.setText("INFINITY");
    } else if (solutionType == QuadraticEquationSolutionType.noSolution) {
      this.result1.setText("NO SOLUTION");
      this.result2.setText("NO SOLUTION");
    } else {
      this.result1.setText("N/A");
      this.result2.setText("N/A");
    }
  }
}

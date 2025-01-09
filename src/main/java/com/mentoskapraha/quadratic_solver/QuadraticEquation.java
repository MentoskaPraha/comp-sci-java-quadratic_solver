package com.mentoskapraha.quadratic_solver;

/**
 * A class that represents a quadratic equation
 * in the form: "ax² + bx + c = 0", allowing
 * you to calculate the results.
 */
public class QuadraticEquation {
  final private double a, b, c;

  private double result1, result2;

  private QuadraticEquationSolutionType solutionType = QuadraticEquationSolutionType.notCalculated;

  public QuadraticEquation(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  /**
   * Get the type of solution.
   * @return The type of solution for this equation.
   */
  public QuadraticEquationSolutionType getSolutionType(){
    return this.solutionType;
  }

  /**
   * Get the first result of the equation, will be 0 if solution
   * type is infinite or there are no solutions.
   * @return The first result.
   * @throws IllegalStateException if it's called before the calculate method has been called or there are no solutions.
   */
  public double getResult1() {
    if(this.solutionType == QuadraticEquationSolutionType.notCalculated) {
      throw new IllegalStateException("The solution to the equation has yet to be calculated and therefore the results cannot be fetched.");
    }

    if(this.solutionType == QuadraticEquationSolutionType.noSolution) {
      throw  new IllegalStateException("There are no solutions to this equation, therefore the results cannot be fetched.");
    }

    return this.result1;
  }

  /**
   * Get the second result of the equation, will be 0 if solution
   * type is infinite.
   * @return The first result.
   * @throws IllegalStateException if it's called before the calculate method has been called or there are no solutions or there is only 1 solution.
   */
  public double getResult2() {
    if(this.solutionType == QuadraticEquationSolutionType.notCalculated) {
      throw new IllegalStateException("The solution to the equation has yet to be calculated and therefore the results cannot be fetched.");
    }

    if(this.solutionType == QuadraticEquationSolutionType.noSolution) {
      throw  new IllegalStateException("There are no solutions to this equation and therefore the results cannot be fetched.");
    }

    if(this.solutionType == QuadraticEquationSolutionType.oneSolution) {
      throw  new IllegalStateException("There is only 1 solution to this equation and therefore the second result cannot be fetched.");
    }

    return this.result2;
  }

  /**
   * Calculates the result of the
   * equation.
   */
  public void calculate() {
    if (this.a != 0) {
      solveQuadratic();
    } else if (this.b != 0) {
      solveLinear();
    } else if (this.c != 0){
      this.solutionType = QuadraticEquationSolutionType.noSolution;
    } else {
      this.solutionType = QuadraticEquationSolutionType.infiniteSolutions;
      this.result1 = 0;
      this.result2 = 0;
    }
  }

  private void solveQuadratic() {
    final double discriminant = Math.pow(this.b, 2) - (4 * this.a * this.c);

    if (discriminant == 0) {
      this.solutionType = QuadraticEquationSolutionType.oneSolution;
      this.result1 = ((this.b * -1) + Math.sqrt(discriminant)) / (2 * this.a);
    } else {
      this.solutionType = QuadraticEquationSolutionType.twoSolutions;
      this.result1 = ((this.b * -1) + Math.sqrt(discriminant)) / (2 * this.a);
      this.result2 = ((this.b * -1) - Math.sqrt(discriminant)) / (2 * this.a);
    }
  }

  private void solveLinear() {
    this.solutionType = QuadraticEquationSolutionType.oneSolution;
    this.result1 = (this.c / this.b) * -1;
  }
}

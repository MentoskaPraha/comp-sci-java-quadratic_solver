package com.mentoskapraha.quadratic_solver;

/**
 * The possible types of solutions for a
 * Quadratic Equation.
 */
public enum QuadraticEquationSolutionType {
  /**
   * There are 2 valid solutions.
   */
  twoSolutions,

  /**
   * There is only one solution.
   */
  oneSolution,

  /**
   * There are an infinite number of solutions
   */
  infiniteSolutions,

  /**
   * There are no possible solutions.
   */
  noSolution,

  /**
   * The solution has yet to be calculated.
   */
  notCalculated,
}

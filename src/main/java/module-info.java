module com.mentoskapraha.quadratic_solver {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.controlsfx.controls;
  requires org.kordamp.bootstrapfx.core;

  opens com.mentoskapraha.quadratic_solver to javafx.fxml;
  exports com.mentoskapraha.quadratic_solver;
}
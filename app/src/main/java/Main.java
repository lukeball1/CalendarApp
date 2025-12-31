public class Main extends javafx.application.Application {

    @Override
    public void start(javafx.stage.Stage stage) {
        javafx.scene.control.Label label =
                new javafx.scene.control.Label("Pi Calendar App");
        label.setStyle("-fx-font-size: 32px;");

        javafx.scene.Scene scene =
                new javafx.scene.Scene(new javafx.scene.layout.StackPane(label), 800, 480);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

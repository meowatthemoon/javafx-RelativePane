import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {

    private int window_height = 720, window_width = 1280;
    private RelativePane rootPane;

    @Override
    public void start(Stage primaryStage){
        rootPane = new RelativePane(window_width, window_height);

        Label lbl1 = new Label("");
        lbl1.setStyle("-fx-background-color: lightblue;");
        rootPane.add_child(lbl1,0,0,0.5f,0.5f);

        Label lbl2 = new Label("");
        lbl2.setStyle("-fx-background-color: red;");
        rootPane.add_child(lbl2,0.5f,0.5f,0.25f,0.25f);

        RelativePane pane2 = new RelativePane();
        Label lbl3 = new Label("");
        lbl3.setStyle("-fx-background-color: green;");
        pane2.add_child(lbl3, 0,0,1,1);
        rootPane.add_child(pane2,0.5f,0f,0.5f,0.5f);

        Label lbl4 = new Label("");
        lbl4.setStyle("-fx-background-color: yellow;");
        pane2.add_child(lbl4, 0,0,0.5f,0.5f);

        primaryStage.setScene(new Scene(rootPane));
        primaryStage.show();

        primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
            rootPane.setWidth(newVal.intValue());
            rootPane.onWindowUpdate();
        });

        primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> {
            rootPane.setHeight(newVal.intValue());
            rootPane.onWindowUpdate();
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}

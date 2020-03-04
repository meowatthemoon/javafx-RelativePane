package sample;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.util.ArrayList;

public class RelativePane extends Pane {
    private ArrayList<Child> children;
    private double width, height;
    private boolean is_root = false;

    public RelativePane(Stage primaryStage, double width, double height) {
        super();

        this.is_root = true;
        this.setPrefSize(width, height);
        primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
            this.OnSizeUpdate((double) newVal, -1);
        });

        primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> {
            this.OnSizeUpdate(-1, (double) newVal);
        });

        this.width = width;
        this.height = height;
        children = new ArrayList<>();
    }

    public RelativePane() {
        super();
        children = new ArrayList<>();
    }


    private void OnSizeUpdate(double newWidth, double newHeight) {
        if (newWidth == -1) {
            double bar_height = 37.599998474121094;
            this.height = newHeight - bar_height;
        } else {
            double window_thickness = 14.3999938964844;
            this.width = newWidth - window_thickness;
        }

        this.redraw_children();
    }

    private void redraw_children() {
        this.getChildren().clear();

        for (int i = 0; i < children.size(); i++) {

            draw_child(children.get(i));

            if (children.get(i).object.getClass() == RelativePane.class) {
                ((RelativePane) children.get(i).object).redraw_children();
            }
        }
    }

    public void add_child(Node object, float rel_x, float rel_y, float rel_w, float rel_h) {
        Child child = new Child(object, rel_x, rel_y, rel_w, rel_h);
        children.add(child);
        this.draw_child(child);
    }

    private void draw_child(Child child) {
        if (child.object.getClass() == RelativePane.class) {
            ((RelativePane) child.object).width = child.rel_w * this.width;
            ((RelativePane) child.object).height = child.rel_h * this.height;
        }

        child.object.setLayoutX(this.width * child.rel_x);
        child.object.setLayoutY(this.height * child.rel_y);

        if (child.object.getClass() == RelativePane.class) {
            ((RelativePane) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == AnchorPane.class){
            ((AnchorPane) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == Accordion.class){
            ((Accordion) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == BorderPane.class){
            ((BorderPane) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == Button.class){
            ((Button) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == CheckBox.class){
            ((CheckBox) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == ChoiceBox.class){
            ((ChoiceBox) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == ColorPicker.class){
            ((ColorPicker) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == ComboBox.class){
            ((ComboBox) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == DatePicker.class){
            ((DatePicker) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == FlowPane.class){
            ((FlowPane) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == GridPane.class){
            ((GridPane) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == HBox.class){
            ((HBox) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == Label.class){
            ((Label) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == ListView.class){
            ((ListView) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == MenuBar.class){
            ((MenuBar) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == Pane.class){
            ((Pane) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == PasswordField.class){
            ((PasswordField) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == ProgressBar.class){
            ((ProgressBar) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == RadioButton.class){
            ((RadioButton) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == Slider.class){
            ((Slider) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == Spinner.class){
            ((Spinner) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == SplitMenuButton.class){
            ((SplitMenuButton) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == SplitPane.class){
            ((SplitPane) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == StackPane.class){
            ((StackPane) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == TableView.class){
            ((TableView) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == TabPane.class){
            ((TabPane) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == TextArea.class){
            ((TextArea) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == TextField.class){
            ((TextField) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == TextFlow.class){
            ((TextFlow) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == TilePane.class){
            ((TilePane) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == TitledPane.class){
            ((TitledPane) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == ToggleButton.class){
            ((ToggleButton) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == ToolBar.class){
            ((ToolBar) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == TreeTableView.class){
            ((TreeTableView) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == TreeView.class){
            ((TreeView) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else if(child.object.getClass() == VBox.class){
            ((VBox) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        }
        else {
            System.out.println("Implement case for type = " + child.object.getClass().toString());
            System.exit(0);
        }

        this.getChildren().add(child.object);
    }

}

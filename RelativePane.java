package UI;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class RelativePane extends Pane {

    public class Child {
        private Node object;
        private float rel_x, rel_y, rel_w, rel_h;

        public Child(Node object, float rel_x, float rel_y, float rel_w, float rel_h) {
            this.object = object;
            this.rel_x = rel_x;
            this.rel_y = rel_y;
            this.rel_w = rel_w;
            this.rel_h = rel_h;
        }
    }

    private ArrayList<Child> children;
    private int width, height;

    public RelativePane(int width, int height) {
        super();
        children = new ArrayList<>();
        this.width = width;
        this.height = height;
        this.setPrefSize(width, height);
    }

    public RelativePane() {
        super();
        children = new ArrayList<>();
        this.setPrefSize(width, height);
    }

    public void redraw() {
        this.getChildren().clear();
        //redraw
        for (int i = 0; i < children.size(); i++) {
            draw(children.get(i));
            if (children.get(i).object.getClass() == RelativePane.class)
                ((RelativePane) children.get(i).object).redraw();
        }
    }

    public void draw(Child child) {


        if (child.object.getClass() == Button.class)
            ((Button) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        else if (child.object.getClass() == Label.class)
            ((Label) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
        else if (child.object.getClass() == RelativePane.class) {
            ((RelativePane) child.object).setPrefSize(this.width * child.rel_w, this.height * child.rel_h);
            ((RelativePane) child.object).setHeight(this.width * child.rel_w);
            ((RelativePane) child.object).setWidth(this.height * child.rel_h);
        } else {
            System.out.println("Implement case for type = " + child.object.getClass().toString());
            System.exit(0);
        }

        child.object.setLayoutX(this.width * child.rel_x);
        child.object.setLayoutY(this.height * child.rel_y);

        this.getChildren().add(child.object);

    }

    public void add_child(Node object, float rel_x, float rel_y, float rel_w, float rel_h) {
        Child child = new Child(object, rel_x, rel_y, rel_w, rel_h);
        children.add(child);
        draw(child);
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

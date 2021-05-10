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

    private int current_width, current_height;
    private ArrayList<Child> children;
    private int bar_height = 39;
    private boolean root_pane;

    public RelativePane(int initial_width, int initial_height) {
        super();
        this.current_width = initial_width;
        this.current_height = initial_height - bar_height;
        this.setPrefSize(initial_width, initial_height);
        this.children = new ArrayList<>();

        this.root_pane = true;
    }

    public RelativePane() {
        super();

        this.children = new ArrayList<>();
        this.root_pane = false;
    }

    public void draw() {
        // Clear the pane
        this.getChildren().clear();

        // Draw the children
        for (int i = 0; i < children.size(); i++) {
            float rel_w = children.get(i).rel_w;
            float rel_h = children.get(i).rel_h;

            // Size
            if (children.get(i).object.getClass() == Button.class) {
                ((Button) children.get(i).object).setPrefSize(this.current_width * rel_w, this.current_height * rel_h);
            } else if (children.get(i).object.getClass() == Label.class) {
                ((Label) children.get(i).object).setPrefSize(this.current_width * rel_w, this.current_height * rel_h);
            } else if (children.get(i).object.getClass() == RelativePane.class) {
                ((RelativePane) children.get(i).object).setPrefSize(this.current_width * rel_w, this.current_height * rel_h);

                int w = (int) (this.current_width * rel_w);
                int h = (int) (this.current_height * rel_h);

                ((RelativePane) children.get(i).object).setHeight(h);
                ((RelativePane) children.get(i).object).setWidth(w);

                ((RelativePane) children.get(i).object).draw();
            } else {
                System.out.println("Implement case for type = " + children.get(i).object.getClass().toString());
                System.exit(0);
            }


            // Position
            children.get(i).object.setLayoutX(this.current_width * children.get(i).rel_x);
            children.get(i).object.setLayoutY(this.current_height * children.get(i).rel_y);

            this.getChildren().add(children.get(i).object);
        }
    }

    public void add_child(Node object, float rel_x, float rel_y, float rel_w, float rel_h) {
        Child child = new Child(object, rel_x, rel_y, rel_w, rel_h);
        children.add(child);

        draw();
    }
    
    public void remove_child(Node object){
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).object.equals(object)){
                children.remove(i);
                break;
            }
        }
        draw();
    }

    public void clear(){
        children = new ArrayList<>();
        
        draw();
    }
    
    public void onWindowUpdate() {
        //System.out.println("Updated width = "+this.current_width+" height = "+this.current_height);
        draw();
    }

    public void setWidth(int new_width) {
        this.current_width = new_width;
    }

    public void setHeight(int new_height) {
        this.current_height = new_height;
        if (this.root_pane)
            this.current_height -= bar_height;
    }
}

# Java-FX RelativePane
An implementation of a 'TKinter-like' layout for java-fx.

Instead of having to think about what type of layouts to use in order to achieve the desired look, one just has to specify the relative position and the relative size of the element to its parent. Inspired by python's TKinter library.

## Usage 
```
rootPane = new RelativePane(window_width, window_height);

primaryStage.setScene(new Scene(rootPane));
primaryStage.show();

primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
    rootPane.setWidth(newVal.intValue());
    rootPane.redraw();
});

primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> {
    rootPane.setHeight(newVal.intValue());
    rootPane.redraw();
});
```
Adding nodes to a RelativePane:
```
Button button = new Button("A button");
a_relative_pane.add_child(button, relative_x, relative_y, relative_w, relative_h);
```

## Requirements
[Java-FX Modules](https://gluonhq.com/products/javafx/)

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Panel extends JPanel {    //COMMAND(Definition from TB/Wikipedia)- Used to encapsulate all information
                                        // needed to perform an action or trigger an event at a
                                        // later time. This information includes the method name,
                                        // the object that owns the method and values for the method parameters.
                                        ////CONTROLLER(Definition from TB/Wikipedia): user interfaces and business objects
                                        //to change independently without affecting one another

    private List<Shape> shapes; // list of shapes
    private List<Shape> clearedShapes; // list of cleared shapes from undo
    private int SelectedShape;
    private Shape ShapeObject;

    public Panel(JLabel statusLabel) {

        shapes = new List<Shape>();
        clearedShapes = new List<Shape>();

        SelectedShape = 0;  //setting default values
        ShapeObject = null;  //setting default values

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        MouseHandler handler = new MouseHandler();
        addMouseListener(handler);
        addMouseMotionListener(handler);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ArrayList<Shape> shapeArray = shapes.getArray();
        for (int i = shapeArray.size() - 1; i >= 0; i--)    //ITERATOR(Definition from TB/Wikipedia): used to traverse a
                                                            // container and access the container's elements
            shapeArray.get(i).draw(g);

        if (ShapeObject != null) {
            ShapeObject.draw(g);
        }
    }


    public void setShape(int type)   //setting type for selected shape
    {
        SelectedShape = type;
    }

    public void redoLastShape() {  //redo
        if (!clearedShapes.isEmpty()) {
            shapes.frontins(clearedShapes.removeFront());
            repaint();
        }
    }

    public void clearLastShape() {  //undo
        if (!shapes.isEmpty()) {
            clearedShapes.frontins(shapes.removeFront());
            repaint();
        }
    }


    private class MouseHandler extends MouseAdapter {
        public void mouseClicked(MouseEvent event) {
            if (SelectedShape == 0) {
                ShapeObject = new Circle(event.getX(), event.getY());
            } else {
                ShapeObject = new Box(event.getX(), event.getY());
            }

            ShapeObject.setX(event.getX());
            ShapeObject.setY(event.getY());
            shapes.frontins(ShapeObject); //addFront ShapeObject onto myShapes
            ShapeObject = null; //sets ShapeObject to null
            clearedShapes.makeEmpty(); //clears clearedShapes
            repaint();
        }
    }
}

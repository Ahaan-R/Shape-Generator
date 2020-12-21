import java.awt.*;


public class Circle extends Shape {       //EXPERT(Definition from TB/Wikipedia): Stores the info
                                          // required to fulfil a request

    public Circle(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g) {
       // g.drawLine(getX() - 20, getY(), getX() + 20, getY());
        g.drawOval(getX()-10,getY()-10,20,20);
    }
}
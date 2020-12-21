import java.awt.*;

public class Box extends Shape {        //EXPERT(Definition from TB/Wikipedia): Stores the info
                                        // required to fulfil a request

    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(getX()-10, getY()-10, 20, 20);
    }

}
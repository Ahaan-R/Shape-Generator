import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFrame extends JFrame {

    private Panel panel;
    private JPanel JPanel;
    private JPanel JPadder;
    private JButton circle;
    private JButton box;
    private JButton undo;
    private JButton redo;


    public MainFrame() {

        super("SDP HW 2");
        JLabel statusLabel = new JLabel("");

        panel = new Panel(statusLabel);

        undo = new JButton("Undo");
        redo = new JButton("Redo");
        circle = new JButton("Circle");
        box = new JButton("Box");

        JPanel = new JPanel();
        JPanel.setLayout(new FlowLayout());
        JPadder = new JPanel();
        JPadder.setLayout(new FlowLayout());

        JPanel.add(circle);
        JPanel.add(box);
        JPanel.add(undo);
        JPanel.add(redo);

        JPadder.add(JPanel);
        add(JPadder, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        ButtonHandler buttonHandler = new ButtonHandler();
        undo.addActionListener(buttonHandler);
        redo.addActionListener(buttonHandler);
        circle.addActionListener(buttonHandler);
        box.addActionListener(buttonHandler);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setVisible(true);

    }


    private class ButtonHandler implements ActionListener {     //OBSERVER(Definition from TB/Wikipedia)-an object, called the subject,
                                                                // maintains a list of its dependents, called observers,
                                                                // and notifies them automatically of any state changes,
                                                                // usually by calling one of their methods.
                                                                //ADAPTER(): used to make existing classes work with others
                                                                // without modifying their source code.
            public void actionPerformed(ActionEvent event) {
            if (event.getActionCommand().equals("Undo")) {
                panel.clearLastShape();
            } else if (event.getActionCommand().equals("Redo")) {
                panel.redoLastShape();
            } else if (event.getActionCommand().equals("Circle")) {
                panel.setShape(0);  //sending 0 for Circle
            } else if (event.getActionCommand().equals("Box")) {
                panel.setShape(1);  //sending 1 for box
            }


        }
    }

}
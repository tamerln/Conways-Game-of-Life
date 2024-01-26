import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

public class GUI extends JFrame {
    GOL gol = new GOL(25);
    JButton changeSize = new JButton("change size");
    JButton reset = new JButton("reset board");
    JButton start = new JButton("start");
    JButton stop = new JButton("stop");
    JButton changeSpeed = new JButton("change speed");
    public GUI() {
        setSize(700, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setTitle("Conway's Game of Life");
        add(changeSize);
        add(reset);
        add(start);
        add(stop);
        add(changeSpeed);
        add(gol);
        setVisible(true);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This method will be called when the button is clicked
               gol.doTurn();
               gol.repaint();

            }
        };
        start.addActionListener(actionListener);

    }

}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cell extends JPanel {
    public int numNeighbors;
    public boolean isAlive;

    public Cell() {
        this.isAlive = false;
        this.numNeighbors = 0;
        if (isAlive) {
            setBackground(Color.black);
        } else {
            setBackground(null);
        }
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
              toggleAliveState();

            }
        });

        }
    public void toggleAliveState(String state) {
        if (state.equals("DEAD")) {
            isAlive = false;
            updateBackgroundColor();
        } else if (state.equals("ALIVE"))
            isAlive = true;
             updateBackgroundColor();



//create a getNumNeighbors method for a cell. use nested for loops. first loop loops through the rows, second loop does columns
    }
    public void toggleAliveState() {
        isAlive = !isAlive;
        updateBackgroundColor();



//create a getNumNeighbors method for a cell. use nested for loops. first loop loops through the rows, second loop does columns
    }

    public void updateBackgroundColor() {
        if (isAlive) {
            setBackground(Color.black);
        } else {
            setBackground(null);
        }
    }
}




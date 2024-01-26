import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class GOL extends JPanel {
    int size = 50;
    public Cell[][] boardState;

    public GOL(int size) {
        setSize(500, 500);
        setLayout(new GridLayout(size, size));
        boardState = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Cell cell = new Cell();
                cell.setBorder(BorderFactory.createLineBorder(Color.black));
                boardState[i][j] = cell; //populate 2d array with cell current object to represent state of board
                add(cell);

            }
        }


    }

    //method that loops thru whole array and gets the number of neighbors of each cell
    public void countNumNeighbors() {
        //needs fixed, counts neighbors wrong and should be reset when cell changes state
        for (int i = 0; i < boardState.length; i++) { //rows
            for (int j = 0; j < boardState[i].length; j++) { //cells in rows

                if (j + 1 < boardState[i].length && boardState[i][j + 1].isAlive) { // to the right
                    boardState[i][j].numNeighbors++;
                }
                if (j - 1 >= 0 && boardState[i][j - 1].isAlive) { // to the left
                    boardState[i][j].numNeighbors++;
                }
                if (i - 1 >= 0 && boardState[i - 1][j].isAlive) { // up
                    boardState[i][j].numNeighbors++;
                }
                if (i + 1 < boardState.length - 1 && boardState[i + 1][j].isAlive) { // down
                    boardState[i][j].numNeighbors++;
                } //diagonal upper right
                if (i - 1 >= 0 && j + 1 <= boardState[i].length - 1 && boardState[i - 1][j + 1].isAlive) {
                    boardState[i][j].numNeighbors++;
                }
//                //diagonal upper left
                if (i - 1 >= 0 && j - 1 >= 0 && boardState[i - 1][j - 1].isAlive) {
                    boardState[i][j].numNeighbors++;
                }
//                //diagonal lower right
                if (i + 1 <= boardState[i].length -1 && j + 1 <= boardState[j].length -1 && boardState[i + 1][j + 1].isAlive) {
                    boardState[i][j].numNeighbors++;
                }
////                //diagonal lower left
                if (i + 1 <= boardState[i].length -1 && j - 1 >= 0 && boardState[i+1][j-1].isAlive) {
                    boardState[i][j].numNeighbors++;
                }

                }
            }
            boardState[1][2].setBackground(Color.red);
            System.out.println("[1][2] num neighbors: " + boardState[1][2].numNeighbors);
        }

        public void resetNeighborCount () {
            for (int i = 0; i < boardState.length; i++) {
                for (int j = 0; j < boardState[i].length; j++) {
                    boardState[i][j].numNeighbors = 0;
                }
            }
        }

        public void doTurn () {
            countNumNeighbors();
            for (int i = 0; i < boardState.length; i++) {
                for (int j = 0; j < boardState[i].length; j++) {
                    if (boardState[i][j].isAlive && boardState[i][j].numNeighbors < 2) {
                        boardState[i][j].toggleAliveState("DEAD"); //dead
                    } else if (boardState[i][j].isAlive && boardState[i][j].numNeighbors == 2 || boardState[i][j].numNeighbors == 3) {
                        boardState[i][j].toggleAliveState("ALIVE"); //alive
                    } else if (boardState[i][j].isAlive && boardState[i][j].numNeighbors > 3) {
                        boardState[i][j].toggleAliveState("DEAD"); //dead
                    } else if (!boardState[i][j].isAlive && boardState[i][j].numNeighbors == 3) {
                        boardState[i][j].toggleAliveState("ALIVE"); //alive
                    }

                }

            }

            repaint();

            System.out.println("doturn called. [0][0] status: " + boardState[0][0].isAlive);
            resetNeighborCount();


        }
    }







        //now, i need to create a method







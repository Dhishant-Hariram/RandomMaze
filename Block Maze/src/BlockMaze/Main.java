package BlockMaze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Maze");
        frame.setBackground(Color.WHITE);
        Grid grid=new Grid();
        grid.setFocusable(true);//************************************
        frame.add(grid);
        frame.setVisible(true);



    }
}

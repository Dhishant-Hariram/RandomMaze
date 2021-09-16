package BlockMaze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Grid extends JPanel implements KeyListener {
    Square[][] grid= new Square[75][75];


    public Grid(){
        for(int row = 0; row < grid.length;row++){
            for(int col = 0; col < grid[row].length; col++){
                grid[row][col]=new Square(false,false,false,row,col);
            }
        }
        JButton button = new JButton();
        button.setText("Generate maze");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GenerateMazePath();
                button.setFocusable(false);
            }
        });
        addKeyListener(this);
        setLayout(new BorderLayout());
        add(button,BorderLayout.SOUTH);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GenerateMazePath();
                setFocusable(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j<grid[i].length;j++){
                grid[i][j].draw(g);
            }
        }

    }

    public void GenerateMazePath(){
        for(int row = 0; row < grid.length;row++){
            for(int col = 0; col < grid[row].length; col++){
                grid[row][col].setPath(false);
                grid[row][col].setStart(false);
                grid[row][col].setFinish(false);
            }
        }
        repaint();
        //int StartRow = (int)(Math.random()*10);
        //int StartCol = (int)(Math.random()*10);
        grid[0][0].setStart(true);
        grid[0][0].setPath(true);
        repaint();
        int row =0;
        int col = 0;
        int direction=0;
        int oldDirection=3;
        int length;
        while(((col<grid[row].length-1))||((row<grid.length-1))){
            oldDirection=direction;
            direction=(int)(Math.random()*4);
            while((direction == (oldDirection + 2))||(direction == (oldDirection - 2))){
                direction=(int)(Math.random()*4);
            }
            length=(int)(Math.random()*10);
            if(row<=0){
                row=0;
            }
            if(row>=grid.length-1){
                row=grid.length-1;
            }
            if(col<=0){
                col=0;
            }
            if(col>=grid[row].length-1){
                col=grid[row].length-1;
            }
            if((direction==0)&&(col<grid[row].length-1)){
                for(int i=0; i<=length;i++){
                    if((col<grid[row].length-1)){
                        col+=1;
                        grid[row][col].setPath(true);
                    }
                }
            }else if((direction==1)&&(row<grid.length-1)){
                for(int i=0; i<=length;i++){
                    if((row<grid.length-1)){
                        row+=1;
                        grid[row][col].setPath(true);
                    }
                }
            } else if((direction==2)&&(col>0)){
                for(int i=0; i<=length;i++){
                    if((col>0)){
                        col-=1;
                        grid[row][col].setPath(true);
                    }
                }
            } else{
                if(row>0) {
                    for(int i=0; i<=length;i++){
                        if((row>0)){
                            row -= 1;
                            grid[row][col].setPath(true);
                        }
                    }
                }
            }
       }
        grid[row][col].setPath(true);
        grid[row][col].setFinish(true);
        pointerCol=0;
        pointerRow=0;
        repaint();
        this.setFocusable(true);

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar()=='m'){
            GenerateMazePath();
        }
    }
    int pointerRow=0;
    int pointerCol=0;
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar()=='w') {
            if((pointerRow > 0)&&(grid[pointerRow-1][pointerCol].path)){
                grid[pointerRow][pointerCol].setStart(false);
                pointerRow -= 1;
            }
        }
        if(e.getKeyChar()=='a'){
            if((pointerCol > 0)&&(grid[pointerRow][pointerCol-1].path)){
                grid[pointerRow][pointerCol].setStart(false);
                pointerCol -= 1;
            }
        }
        if(e.getKeyChar()=='s'){
            if((pointerRow < grid.length-1)&&(grid[pointerRow+1][pointerCol].path)){
                grid[pointerRow][pointerCol].setStart(false);
                pointerRow += 1;
            }
        }
        if(e.getKeyChar()=='d'){
            if((pointerCol < grid[pointerRow].length-1)&&(grid[pointerRow][pointerCol + 1].path)){
                grid[pointerRow][pointerCol].setStart(false);
                pointerCol += 1;
            }
        }
        grid[pointerRow][pointerCol].setStart(true);
        repaint();
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}

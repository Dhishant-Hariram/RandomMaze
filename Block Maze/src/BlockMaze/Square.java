package BlockMaze;

import java.awt.*;

public class Square {

    boolean path,start,finish;
    int row,col;
    int size=10;

    public Square(boolean path, boolean start, boolean finish, int row, int col){
        this.col=col;
        this.finish=finish;
        this.path = path;
        this.row=row;
        this.start=start;
    }

    void draw(Graphics g){
        if(path){
            g.setColor(Color.white);
            if(finish){
                g.setColor(Color.CYAN);
            } else if(start){
                g.setColor(Color.GREEN);
            }
        } else{
            g.setColor(Color.DARK_GRAY);
        }

        g.fillRect((col * size),(row * size),size,size);

    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public void setPath(boolean path) {
        this.path = path;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

}

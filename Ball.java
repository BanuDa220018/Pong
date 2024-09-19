import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class Ball extends JLabel implements ActionListener{
    private int x = 250, y = 250;
    private int diameter = 40;
    private int xSpeed= 3;
    private int ySpeed= 2;
    private Timer timer;
    private int scoreLeft = 0, scoreRight = 0;
    private Frame frame;

    private int points;

    public void setPoints(int points) {
        this.points = points;
    }
    
    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setScoreLeft(int scoreLeft) {
        this.scoreLeft = scoreLeft;
    }

    public void setScoreRight(int scoreRight) {
        this.scoreRight = scoreRight;
    }

    public int getScoreLeft() {
        return scoreLeft;
    }

    public int getScoreRight() {
        return scoreRight;
    }

    public int getDiameter() {
        return diameter;
    }

    public Ball(Frame frame){
        this.frame = frame;
        timer = new Timer(45, this);
        timer.start();
        this.setVisible(true);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g); 
        g.setColor(new Color(4, 214, 0));
        g.fillOval(x,y,diameter,diameter);
        System.out.println("Repainting: x=" + x + ", y=" + y);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Move the ball
        x += xSpeed;
        y += ySpeed;


        //Check for collision with the edges of the panel
        if(y < 0 || y + diameter > getHeight()){
            ySpeed = -ySpeed; //Reverse direction
            if(timer.getDelay()>=30)
            {
                timer.setDelay(timer.getDelay()-7);
            }else if(timer.getDelay()<30&&timer.getDelay()>=17){
                timer.setDelay(timer.getDelay()-3);
            }else if (timer.getDelay()<16&&timer.getDelay()>1) {
                timer.setDelay(timer.getDelay()-1);
            }
        }
        if(x + diameter > getWidth()){

            if(scoreLeft<points-1){
                scoreLeft++;
                x = y = 250;
                timer.setDelay(timer.getInitialDelay());
            }else{
                frame.WINL();
                scoreLeft++;
                timer.stop();
            }
        }
        if(x + diameter < 0){

            if(scoreRight<points-1){
                scoreRight++;
                x = y = 250;
                timer.setDelay(timer.getInitialDelay());
            }else{
                frame.WINR();
                scoreRight++;
                timer.stop();
            }
        }
        //Check for collision with the paddles
        if (x + diameter >= frame.RightPaddle.getX()) {
            if (y + diameter >= frame.RightPaddle.getY() && y <= frame.RightPaddle.getY() + frame.RightPaddle.getHeight()) {
                xSpeed = -xSpeed;
                if(timer.getDelay()>=30)
                {
                    timer.setDelay(timer.getDelay()-7);
                }else if(timer.getDelay()<30&&timer.getDelay()>=17){
                    timer.setDelay(timer.getDelay()-3);
                }else if (timer.getDelay()<16&&timer.getDelay()>1) {
                    timer.setDelay(timer.getDelay()-1);
                }
            }
        }
        if (x <= frame.LeftPaddle.getX() + frame.LeftPaddle.getWidth()) {
            if (y + diameter >= frame.LeftPaddle.getY() && y <= frame.LeftPaddle.getY() + frame.LeftPaddle.getHeight()) {
                xSpeed = -xSpeed;
                if(timer.getDelay()>=30)
                {
                    timer.setDelay(timer.getDelay()-7);
                }else if(timer.getDelay()<30&&timer.getDelay()>=17){
                    timer.setDelay(timer.getDelay()-3);
                }else if (timer.getDelay()<16&&timer.getDelay()>1) {
                    timer.setDelay(timer.getDelay()-1);
                }
            }
        }
        System.out.println(timer.getDelay());
        repaint();
    }
}

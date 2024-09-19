import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import javax.swing.border.Border;

public class Frame extends JFrame implements KeyListener{
    public Paddle LeftPaddle;
    public Paddle RightPaddle;
    public Ball ball;
    private boolean[] keyTyped = new boolean[256];
    private JLabel winnerLeft;
    private JLabel winnerRight;
    private JLabel score;


    public Frame(int points){
        LeftPaddle = new Paddle();
        RightPaddle = new Paddle();
        ball = new Ball(this);
        JPanel BGPanel = new JPanel();
        Border border = BorderFactory.createDashedBorder(Color.green,2,5,4,true);
        score = new JLabel();
        winnerLeft = new JLabel();
        winnerRight = new JLabel();

        ball.setPoints(points);

        this.setTitle("Ping Pong");                                                    //sets title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                           //exit out of application by pressing X
        this.setSize(514,537);                                            //sets the width and height of frame
        this.setVisible(true);                                                         //makes the frame visible
        this.getContentPane().setBackground(new Color(0));                        //sets the BG color to black
        this.add(BGPanel);                                                             //adds BG PANEL
        this.addKeyListener(this);                                                  //adds KeyListener to frame
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        
        score.setBackground(Color.BLACK);
        score.setForeground(new Color(4, 214, 0));
        score.setOpaque(true);
        score.setBounds(200,10,130,10);

        BGPanel.setBackground(Color.BLACK);
        BGPanel.setBounds(0,0,500,500);
        BGPanel.setBorder(border);
        BGPanel.add(LeftPaddle);                                                       //adds the LeftPaddle
        BGPanel.add(RightPaddle);                                                      //adds the RightPaddle
        BGPanel.add(ball);
        BGPanel.setLayout(null);                                                       //deactivates any LayoutManager
        BGPanel.add(score);
        BGPanel.add(winnerRight);
        BGPanel.add(winnerLeft);

        LeftPaddle.setBounds(11,230,10,70);
        RightPaddle.setBounds(480,230,10,70); 
        ball.setBounds(0,0,500,500);
        ball.setScoreLeft(0);ball.setScoreRight(0);

        winnerRight.setText("Right is the winner!!!");
        winnerRight.setBackground(Color.BLACK);
        winnerRight.setForeground(new Color(4, 214, 0));
        winnerRight.setOpaque(false);
        winnerRight.setVisible(false);
        winnerRight.setBounds(180,200,200,40);
        winnerRight.setFont(new Font("Calibri",Font.BOLD, 20));

        winnerLeft.setText("Left is the winner!!!");
        winnerLeft.setBackground(Color.BLACK);
        winnerLeft.setForeground(new Color(4, 214, 0));
        winnerLeft.setOpaque(false);
        winnerLeft.setVisible(false);
        winnerLeft.setBounds(180,200,200,40);
        winnerLeft.setFont(new Font("Calibri",Font.BOLD, 20));

        while(true){
            score.setText("Left: "+ball.getScoreLeft()+"  <<|>>  Right: "+ball.getScoreRight());
            winnerRight.repaint();
            winnerRight.revalidate();
            winnerLeft.repaint();
            winnerLeft.revalidate();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode<keyTyped.length){
            keyTyped[keyCode]=true;
            handlePressedKey();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode<keyTyped.length){
            keyTyped[keyCode]=false;
        }
    }

    private void handlePressedKey(){
        if(keyTyped[KeyEvent.VK_W]){if(LeftPaddle.getY()>0){LeftPaddle.setLocation(LeftPaddle.getX(),LeftPaddle.getY()-40);}}
        if(keyTyped[KeyEvent.VK_S]){if(LeftPaddle.getY()<410){LeftPaddle.setLocation(LeftPaddle.getX(),LeftPaddle.getY()+40);}}
        if(keyTyped[KeyEvent.VK_UP]){if(RightPaddle.getY()>0){RightPaddle.setLocation(RightPaddle.getX(),RightPaddle.getY()-40);}}
        if(keyTyped[KeyEvent.VK_DOWN]){if(RightPaddle.getY()<410){RightPaddle.setLocation(RightPaddle.getX(),RightPaddle.getY()+40);}}
    }

    public void WINR(){
        winnerRight.setOpaque(true);
        winnerRight.setVisible(true);
        winnerRight.repaint();
        winnerRight.revalidate();
        ball.setVisible(false);
    }
    public void WINL(){
        winnerLeft.setOpaque(true);
        winnerLeft.setVisible(true);
        winnerLeft.repaint();
        winnerLeft.revalidate();
        ball.setVisible(false);
    }
}
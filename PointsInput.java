import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;

public class PointsInput extends JFrame {
    private JLabel Title;
    private JTextField PointsNumInput;
    private JButton PLAYbutton;

    public int getPoints() {
        return Points;
    }


    private int Points;



    public PointsInput(){
        Title = new JLabel();
        PointsNumInput = new JTextField();
        PLAYbutton = new JButton();
        Border Border = BorderFactory.createLineBorder(Color.GRAY, 2);

        this.setTitle("Ping Pong");                                                    //sets title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                           //exit out of application by pressing X
        this.setSize(514,537);                                            //sets the width and height of frame
        this.setVisible(true);                                                         //makes the frame visible
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.add(Title);
        this.add(PointsNumInput);
        this.add(PLAYbutton);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Title.setText("Number of Points: ");
        Title.setOpaque(true);
        Title.setFont(new Font("Calibri",Font.BOLD, 16));
        Title.setBounds(200,150,130,20);

        PointsNumInput.setBounds(195,200,130,30);
        PointsNumInput.setVisible(true);
        PointsNumInput.setOpaque(true);
        PointsNumInput.setBorder(Border);



        PLAYbutton.setBounds(210,400,100,30);
        PLAYbutton.setBorder(Border);
        PLAYbutton.setBackground(Color.LIGHT_GRAY);
        PLAYbutton.setText("PLAY!");

        PLAYbutton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                try {
                    int points = Integer.parseInt(PointsNumInput.getText());
                    Points = points;
                    //System.out.println(points);
                }catch (NumberFormatException a) {
                    throw new RuntimeException(a);
                }
            }
        });
    }

    public void delClass(){
        this.remove(Title);
        Title = null;
        this.remove(PointsNumInput);
        PointsNumInput = null;
        this.remove(PLAYbutton);
        PLAYbutton = null;
        this.repaint();
        this.remove(this);
        this.revalidate();
        this.setVisible(false);
    }
}

import javax.swing.SwingUtilities;

class PING_PONG{

    public static void main(String[] args){
        PointsInput pointsFrame = new PointsInput();
        int points = 0;
        while(points == 0){
            points = pointsFrame.getPoints();
            System.out.println(points);

            if(points != 0){
                pointsFrame.delClass();
                pointsFrame = null;

                Frame frame = new Frame(points);                          //actual ping pong game

                frame.ball.setPoints(points);
            }
        }

    }
}
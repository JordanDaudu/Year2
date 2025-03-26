package Graphics2D;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    Image image;

    MyPanel()
    {
        image = new ImageIcon("src/pizza.png").getImage();
        this.setPreferredSize(new Dimension(500, 500));
    }

    // called behind the scenes automatically when using Swing components
    public void paint(Graphics g)
    {
        Graphics2D g2D = (Graphics2D) g; // newer version component

        // img, x, y, imageObserver
        g2D.drawImage(image, 0, 0, null);

        g2D.setPaint(Color.blue);
        g2D.setStroke(new BasicStroke(5));
        g2D.drawLine(0,0, 500, 500); // x,y start _ x,y end

        g2D.setPaint(Color.pink);
        g2D.drawRect(0, 0, 100, 200); // x,y,width,height

        g2D.fillRect(100,100,100,200);

        g2D.setPaint(Color.orange);
        g2D.drawOval(200,0,100,100);

        g2D.fillOval(300,100,100,100);

        g2D.setPaint(Color.red);
        // x, y, width, height, startAngle, arcAngle
        //g2D.drawArc(400,0,100,100, 0, 180);
        g2D.fillArc(400, 0, 100, 100, 0, 180);
        g2D.setPaint(Color.white);
        g2D.fillArc(400, 0, 100, 100, 180, 180);

        int[] xPoints = {150, 250, 350};
        int[] yPoints ={300, 150, 300};
        g2D.setColor(Color.yellow);
        // g2D.drawPolygon(xPoints, yPoints, 3);
        g2D.fillPolygon(xPoints, yPoints, 3);

        g2D.setColor(Color.magenta);
        g2D.setFont(new Font("Ink Free", Font.BOLD, 50));
        g2D.drawString("U R A WINNER! :D", 50, 50);
    }
}

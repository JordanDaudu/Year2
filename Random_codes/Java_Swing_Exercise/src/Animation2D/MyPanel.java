package Animation2D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;
    Image enemy;
    Image backgroundImage;
    Timer timer;
    int xVelocity = 3;
    int yVelocity = 1;
    int x = 0;
    int y = 0;

    MyPanel()
    {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.black);
        enemy = new ImageIcon("src/alien.png").getImage();
        backgroundImage = new ImageIcon("src/space.png").getImage();
        timer = new Timer(10, this); // integer, ActionListener
        timer.start();
    }

    // Called behind the scenes because JPanel is a subClass of Component
    public void paint(Graphics g)
    {
        super.paint(g); // Paint background

        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(backgroundImage, 0, 0, null);
        g2D.drawImage(enemy, x, y, null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(x >= PANEL_WIDTH - enemy.getWidth(null) || x < 0)
        {
            xVelocity = xVelocity * -1;
        }
        x = x + xVelocity;
        if(y >= PANEL_HEIGHT - enemy.getHeight(null) || y < 0)
        {
            yVelocity = yVelocity * -1;
        }
        y = y + yVelocity;
        repaint(); // Call paint but in a more efficient way
    }
}

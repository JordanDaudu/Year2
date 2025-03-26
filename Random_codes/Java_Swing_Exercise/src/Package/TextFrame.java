package Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFrame extends JFrame implements ActionListener
{
    JButton button;
    TextField textField;

    TextFrame()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        this.setLayout(new FlowLayout());

        button = new JButton("Submit");
        button.addActionListener(this); // uses this actionPerformed

        textField = new TextField();
        textField.setPreferredSize(new Dimension(250, 40));
        textField.setFont(new Font("Consolas", Font.PLAIN, 35));
        textField.setForeground(Color.green);
        textField.setBackground(Color.black);
        textField.setText("username");
        // textField.setEditable(false); // If you want to disable text field

        this.add(button);
        this.add(textField);
        this.setSize(720, 720); // sets the x-dimension and y-dimension of frame
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == button)
        {
            System.out.println("Welcome " + textField.getText());
            button.setEnabled(false); // If you want to disable button
            textField.setEditable(false); // If you want to disable text field
        }
    }
}

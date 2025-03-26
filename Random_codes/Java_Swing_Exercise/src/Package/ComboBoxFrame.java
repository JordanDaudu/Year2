package Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxFrame extends JFrame implements ActionListener
{
    JComboBox comboBox;

    ComboBoxFrame()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        String[] animals = {"dog", "cat", "bird"};
        comboBox = new JComboBox(animals); // needs to be reference type passed

        comboBox.setEditable(true); // can search for item in box
        comboBox.addItem("horse");
        comboBox.insertItemAt("pig", 0); // (item, index) add at this index item
        comboBox.setSelectedIndex(0); // set default selected item
        comboBox.removeItem("cat"); // remove item from box
        comboBox.removeItemAt(0); // remove item at index 0
        // comboBox.removeAllItems(); // removes everything from box
        System.out.println(comboBox.getItemCount()); // prints number of items

        comboBox.addActionListener(this); // Add ActionListener to box

        this.add(comboBox);
        this.pack();
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == comboBox)
        {
            System.out.println(comboBox.getSelectedItem());
            System.out.println(comboBox.getSelectedIndex());
        }
    }
}

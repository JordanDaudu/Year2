package Package;

import javax.swing.*;
import javax.swing.border.Border; // for borders
import java.awt.*; // For mac to change icon
import java.awt.event.KeyListener;

public class Main {
    public static void main(String[] args)
    {
        //frames();
        // Also possible when in class - MyFrame myFrame = new MyFrame();
        //labels();
        //panels();
        //button();
        //borderLayout();
        //flowLayout();
        //gridLayout();
        //jLayeredPane();
        //jOptionPane();
        //jTextField();
        //jCheckBox();
        //radioButtons();
        //jComboBoxes();
        //jSliders();
        //progressBar();
        //menuBar();
        //fileChooser();
        //colorChooser();
        //keyListener();
        //mouseListener();
        keyBindings();
    }
    static void frames()
    {
        // JFrame = a GUI window to add components to

        JFrame frame = new JFrame(); // create a frame
        frame.setTitle("JFrame title goes here"); // sets title of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        frame.setResizable(false); // prevent frame from being resized
        frame.setSize(420, 420); // sets the x-dimension and y-dimension of frame
        frame.setVisible(true);

        ImageIcon image = new ImageIcon("src/Thors.png"); // create an ImageIcon
        frame.setIconImage(image.getImage()); // change icon of frame (for windows)
        frame.getContentPane().setBackground(Color.lightGray); // change color of background
        frame.getContentPane().setBackground(new Color(123, 50, 250)); // custom color
        //                                                                (hexadecimal possible as well)
        // This try catch block is for changing the icon on Mac
        try
        {
            Taskbar taskbar = Taskbar.getTaskbar();
            taskbar.setIconImage(image.getImage()); // Works on macOS and some Linux distros
        }
        catch (UnsupportedOperationException | SecurityException e)
        {
            System.out.println("Could not set Dock icon: " + e.getMessage());
        }
        // Note to self: This code block can be put in a class (without create frame line)
        // It's best practice to create a separate class that extends JFrame
    }
    static void labels()
    {
        // JLabel = a GUI display area for a string of text, an image, or both

        ImageIcon image = new ImageIcon("src/Thors.png"); // create an ImageIcon
        Border border = BorderFactory.createLineBorder(Color.green, 3);

        JLabel label = new JLabel(); // Create a label
        label.setText("Bro do you even code?"); // Set text of label
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER); // set text LEFT, CENTER, RIGHT of ImageIcon
        label.setVerticalTextPosition(JLabel.TOP); // set text TOP, CENTER, BOTTOM of ImageIcon
        label.setForeground(Color.green); // set font color of text
        label.setFont(new Font("MV Boli", Font.PLAIN, 20)); // set font of text
        label.setIconTextGap(50); // set gap of text to image
        label.setBackground(Color.black); // set background color
        label.setOpaque(true); // display background color
        label.setBorder(border); // change border of label
        label.setVerticalAlignment(JLabel.CENTER); // set vertical position of icon+text within label
        label.setHorizontalAlignment(JLabel.CENTER); // set horizontal position of icon+text within label
        //label.setBounds(0,0,600,600); // set x, y, width, height bounds of label

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 720);
        //frame.setLayout(null); // layout of the frame currently none
        frame.setVisible(true);
        frame.add(label);
        frame.pack(); // use pack after adding all components, resize automatically
        frame.revalidate(); // Forces layout updates
        frame.repaint();    // Refreshes the frame
    }
    static void panels()
    {
        // JPanel = a GUI component that functions as a container to hold other components

        ImageIcon icon = new ImageIcon("src/like.png");

        JLabel label = new JLabel();
        label.setText("Hi");
        label.setIcon(icon);
        //label.setVerticalAlignment(JLabel.BOTTOM); // Both used if using layoutManager
        //label.setHorizontalAlignment(JLabel.RIGHT);
        label.setBounds(200, 0, 250, 250); // set x, y, width, height bounds of label

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setBounds(0, 0, 250, 250);
        redPanel.setLayout(new BorderLayout());

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.blue);
        bluePanel.setBounds(250, 0, 250, 250);
        bluePanel.setLayout(new BorderLayout());

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.green);
        greenPanel.setBounds(0, 250, 500, 250);
        greenPanel.setLayout(null);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(750,750);
        frame.setVisible(true);
        greenPanel.add(label);
        frame.add(redPanel);
        frame.add(bluePanel);
        frame.add(greenPanel);
        frame.revalidate(); // Forces layout updates
        frame.repaint();    // Refreshes the frame
    }
    static void button()
    {
        // JButton = a button that performs an action when clicked on

        new MyFrame();
    }
    static void borderLayout()
    {
        // Layout Manager = Defines the natural layout for components within a container

        // 3 common managers

        // BorderLayout = A BorderLayout places components in five areas:
        //                NORTH, SOUTH, WEST, EAST, CENTER
        //                All extra space is placed in the center area

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout(10, 10));
        // when putting data in BorderLayout this is the width, height margin between panels
        frame.setVisible(true);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        panel1.setBackground(Color.red);
        panel2.setBackground(Color.green);
        panel3.setBackground(Color.yellow);
        panel4.setBackground(Color.magenta);
        panel5.setBackground(Color.blue);

        panel1.setPreferredSize(new Dimension(100,100));
        panel2.setPreferredSize(new Dimension(100,100));
        panel3.setPreferredSize(new Dimension(100,100));
        panel4.setPreferredSize(new Dimension(100,100));
        panel5.setPreferredSize(new Dimension(100,100));

        // ---------- sub panels ----------

        JPanel panel6 = new JPanel();
        JPanel panel7 = new JPanel();
        JPanel panel8 = new JPanel();
        JPanel panel9 = new JPanel();
        JPanel panel10 = new JPanel();

        panel6.setBackground(Color.black);
        panel7.setBackground(Color.darkGray);
        panel8.setBackground(Color.gray);
        panel9.setBackground(Color.lightGray);
        panel10.setBackground(Color.white);

        panel5.setLayout(new BorderLayout());

        panel6.setPreferredSize(new Dimension(50,50));
        panel7.setPreferredSize(new Dimension(50,50));
        panel8.setPreferredSize(new Dimension(50,50));
        panel9.setPreferredSize(new Dimension(50,50));
        panel10.setPreferredSize(new Dimension(50,50));

        panel5.add(panel6, BorderLayout.NORTH);
        panel5.add(panel7, BorderLayout.SOUTH);
        panel5.add(panel8, BorderLayout.WEST);
        panel5.add(panel9, BorderLayout.EAST);
        panel5.add(panel10, BorderLayout.CENTER);

        // ---------- sub panels ----------

        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.WEST);
        frame.add(panel3, BorderLayout.EAST);
        frame.add(panel4, BorderLayout.SOUTH);
        frame.add(panel5, BorderLayout.CENTER);

        frame.revalidate(); // Forces layout updates
        frame.repaint();    // Refreshes the frame
    }
    static void flowLayout()
    {
        // Layout Manager = Defines the natural layout for components within a container

        // 3 common managers

        // FlowLayout = Places components in a row, sized at their preferred size
        //              if the horizontal space in the container is too small
        //              the FlowLayout class uses the next available row.

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        // Center layout is the default without putting parameter, horizontal gap, vertical gap
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(250, 250));
        panel.setBackground(Color.lightGray);
        panel.setLayout(new FlowLayout());

        //JButton button1 = new JButton(); // We will use an anonymous button instead
        panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        panel.add(new JButton("4"));
        panel.add(new JButton("5"));
        panel.add(new JButton("6"));
        panel.add(new JButton("7"));
        panel.add(new JButton("8"));
        panel.add(new JButton("9"));

        frame.add(panel);
        frame.revalidate(); // Forces layout updates
        frame.repaint();    // Refreshes the frame
    }
    static void gridLayout()
    {
        // Layout Manager = Defines the natural layout for components within a container

        // 3 common managers

        // GridLayout = Places components in a grid of cells.
        //              Each component takes all the available space
        //              within a cell, and each cell is the same size.

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(3,3,10,10)); // rows, columns, horizontal spacing, vertical spacing
        frame.setVisible(true);

        // JButton button1 = new JButton("1"); // We will use an anonymous button instead
        frame.add(new JButton("1"));
        frame.add(new JButton("2"));
        frame.add(new JButton("3"));
        frame.add(new JButton("4"));
        frame.add(new JButton("5"));
        frame.add(new JButton("6"));
        frame.add(new JButton("7"));
        frame.add(new JButton("8"));
        frame.add(new JButton("9"));

        frame.revalidate(); // Forces layout updates
        frame.repaint();    // Refreshes the frame
    }
    static void jLayeredPane()
    {
        // JLayeredPane = Swing container that provides a
        //                third dimension for positioning components
        //                ex. depth, Z-index

        JLabel label1 = new JLabel();
        label1.setOpaque(true);
        label1.setBackground(Color.red);
        label1.setBounds(50, 50, 200, 200);

        JLabel label2 = new JLabel();
        label2.setOpaque(true);
        label2.setBackground(Color.green);
        label2.setBounds(100, 100, 200, 200);

        JLabel label3 = new JLabel();
        label3.setOpaque(true);
        label3.setBackground(Color.blue);
        label3.setBounds(150, 150, 200, 200);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 500, 500); // x, y, width, height

        // Integer wrapper is shortcut for JlayeredPane.DEFAULT_LAYER
        layeredPane.add(label1, Integer.valueOf(0));
        layeredPane.add(label2, Integer.valueOf(2));
        layeredPane.add(label3, Integer.valueOf(1));

        JFrame frame = new JFrame("JLayeredPane"); // passing title of frame
        frame.add(layeredPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.revalidate(); // Forces layout updates
        frame.repaint();    // Refreshes the frame
    }
    static void jOptionPane()
    {
        // import javax.swing.JOptionPane

        // JOptionPane = Pop up a standard dialog box that prompts users for a value
        //               or informs them of something

        // showMessageDialog(parentComponent, message, title, messageType)
        JOptionPane.showMessageDialog(null, "PLAIN_MESSAGE", "title", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, "INFORMATION_MESSAGE", "title", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "QUESTION_MESSAGE", "title", JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(null, "WARNING_MESSAGE", "title", JOptionPane.WARNING_MESSAGE);
        JOptionPane.showMessageDialog(null, "ERROR_MESSAGE", "title", JOptionPane.ERROR_MESSAGE);

        int answer = JOptionPane.showConfirmDialog(null, "Bro, do you even code?", "This is my title", JOptionPane.YES_NO_CANCEL_OPTION);
        // YES = 0, NO = 1, CANCEL = 2, X button = -1

        String name = JOptionPane.showInputDialog("What is your name?: ");
        System.out.println("Hello " + name);

        String[] responses = {"No, you're awesome!", "Thank you!", "*Blush*"};
        ImageIcon icon = new ImageIcon("src/like.png");
        // showOptionDialog(parentComponent, message, title, optionType, messageType, icon, options, initialValue)
        JOptionPane.showOptionDialog(null,
                "You are awesome!",
                "secret message",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                icon,
                responses,
                0);
    }
    static void jTextField()
    {
        // JTextField = A GUI textbox component that can be used to add, set or get text

        TextFrame textFrame = new TextFrame();
    }
    static void jCheckBox()
    {
        // JCheckBox = A GUI component that can be selected or deselected

        CheckBoxFrame checkBoxFrame = new CheckBoxFrame();
    }
    static void radioButtons()
    {
        RadioButtonsFrame radioButtons = new RadioButtonsFrame();
    }
    static void jComboBoxes()
    {
        // JComboBox = A component that combines a button or editable field and a drop-down list

        ComboBoxFrame comboBoxFrame = new ComboBoxFrame();
    }
    static void jSliders()
    {
        // JSlider = GUI component that lets user enter a value
        //           by using an adjustable sliding knob on a track

        SliderDemo sliderDemo = new SliderDemo();
    }
    static void progressBar()
    {
        // progress bar = Visual aid to let the user know that an operation is progressing

        ProgressBarDemo progressBar = new ProgressBarDemo();
    }
    static void menuBar()
    {
        MenuBarFrame menuBarFrame = new MenuBarFrame();
    }
    static void fileChooser()
    {
        // JFileChooser = A GUI mechanism that lets a user choose a file (helpful for opening or saving files)

        FileChooserFrame fileChooser = new FileChooserFrame();
    }
    static void colorChooser()
    {
        // JColorChooser = A GUI mechanism that lets a user choose a color

        ColorChooserFrame colorChooser = new ColorChooserFrame();
    }
    static void keyListener()
    {
        // KeyListener = A GUI mechanism that lets a user detect and respond to keyboard input

        KeyListenerFrame keyListener = new KeyListenerFrame();
    }
    static void mouseListener()
    {
        // MouseListener = A GUI mechanism that lets a user detect and respond to mouse events

        MouseListenerFrame mouseListener = new MouseListenerFrame();
    }
    static void keyBindings()
    {
        // Key Bindings = bind an Action to a KeyStroke
        //                don't require you to click a component to give it focus
        //                all Swing components use Key Bindings
        //                increased flexibility compared to KeyListeners
        //                can assign keystrokes to individual Swing components
        //                more difficult to utilize and set up :(

        Game game = new Game();
    }
}
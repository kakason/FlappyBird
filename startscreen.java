package ce1002.finalproject.s102502542;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class startscreen extends JPanel
{
    JButton button = new JButton("START");
    JLabel picture = new JLabel(new ImageIcon(getClass().getResource("flame/startscreen.png")));

    startscreen()
    {
        setSize(500,300);
        setLocation(0,0);

        button.setBounds(350,200,100,40);
        button.setForeground(Color.BLACK);
        picture.setBounds(0,0,500,300);

        add(button);
        add(picture);
        setLayout(null);
    }

}

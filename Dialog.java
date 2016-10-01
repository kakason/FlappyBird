package ce1002.finalproject.s102502542;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Dialog extends JFrame implements ActionListener
{
    gameover over = new gameover();
    JLabel ground = new JLabel(new ImageIcon(getClass().getResource("flame/sky.png")));
    JButton click = new JButton("Click ME");

    Dialog()//遊戲結束時按下確定會跳出這個frame
    {
        setTitle("TheResult");
        setSize(500,300);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        ground.setBounds(0,0,490,290);
        click.addActionListener(this);
        click.setBounds(200,120,100,30);
        click.setForeground(Color.BLACK);

        add(click);
        add(ground);
        setVisible(false);
    }
    @Override
    public void actionPerformed(ActionEvent e2)
    {
        if(e2.getSource()==click)
        {
            ground.setVisible(false);
            add(over);
            over.setBounds(0,0,490,290);

            //over.setOpaque(false);
            click.setVisible(false);
        }
    }
}

package ce1002.finalproject.s102502542;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class gameover extends JPanel implements MouseListener
{
    int pointget;
    JLabel over1 = new JLabel(new ImageIcon(getClass().getResource("flame/sky.png")));
    JLabel word = new JLabel("Game Over");
    JLabel text = new JLabel("Your Score : " + pointget);

    gameover()
    {
        setSize(500, 300);
        setLocation(0, 0);
        setLayout(null);

        over1.setBounds(0, 0, 500, 300);

        word.setBounds(350, 20, 100, 90);
        word.setForeground(Color.WHITE);
        word.addMouseListener(this);

        text.setBounds(350, 20, 100, 50);
        text.setForeground(Color.RED);

        add(text);
        add(word);
        add(over1);

        setVisible(true);
    }

    public void setpoint(int a)
    {
        pointget = a;
        text.setText("Your Score : " + pointget);
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        word.setBounds(350, 20, 200, 150);
        word.setForeground(Color.RED);
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        word.setBounds(350, 20, 100, 90);
        word.setForeground(Color.WHITE);
    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }
}

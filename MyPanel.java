package ce1002.finalproject.s102502542;

import java.awt.Color;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements Runnable
{
    JLabel label1 = new JLabel(new ImageIcon(getClass().getResource("flame/sky.png")));
    JLabel label2 = new JLabel(new ImageIcon(getClass().getResource("flame/sky.png")));

    int x1 , x2;
    int trytorun=1;
    MyPanel()
    {
        setSize(600, 500);
        setLocation(0, 0);
        setLayout(null);

        add(label1);
        add(label2);
    }

    public void setrun(int a)
    {
        trytorun=a;
    }

    public void run()
    {
        while (trytorun==1)
        {
            label1.setBounds(x1, -100, 500, 500);
            label2.setBounds(x2 + 500, -100, 500, 500);

            repaint();
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            if (x1 == -label1.getWidth())
            {
                x1 = 0;
            }
            else
            {
                x1--;
            }

            if (x2 == -label1.getWidth())
            {
                x2 = 0;
            }
            else
            {
                x2--;
            }
        }
    }
}

package ce1002.finalproject.s102502542;

import java.awt.Color;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class MyPanel3 extends JPanel implements Runnable {
    int y = -100;
    int x1 = 750;
    JLabel down = new JLabel(new ImageIcon("pipedown.png"));
    JLabel up = new JLabel(new ImageIcon("pipeup.png"));
    Random ran = new Random();

    MyPanel3()
    {
        setBounds(700, y, 65, 500);
        down.setBounds(0, 270, 50, 200);
        up.setBounds(0, 0, 50, 200);
        setOpaque(false);

        add(down);
        add(up);

        setLayout(null);
    }

    @Override
    public void run()
    {
        while (true)
        {
            repaint();

            while (x1 != -50)
            {
                x1--;
                setBounds(x1, y, 65, 500);
                try
                {
                    Thread.sleep(15);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            y = ran.nextInt(70) - 80;
            x1 = 500;
        }

    }

}

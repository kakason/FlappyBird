package ce1002.finalproject.s102502542;

import java.awt.Color;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class MyPanel2 extends JPanel implements Runnable
{
    int y = -100;
    double x1 = 500;
    boolean is_passed;
    int trytorun=1;
    JLabel down = new JLabel(new ImageIcon(getClass().getResource("flame/pipedown.png")));
    JLabel up = new JLabel(new ImageIcon(getClass().getResource("flame/pipeup.png")));

    Random ran = new Random();

    MyPanel2(int x, int y)
    {
        this.x1 = x;
        this.y = y;
        is_passed = false;
        setBounds(x, y, 60, 500);
        down.setBounds(0, 270, 70, 200);
        up.setBounds(0, 0, 70, 200);
        setOpaque(false);

        add(down);
        add(up);
        setLayout(null);
    }

    public void setrun(int a)
    {
        trytorun=a;
    }

    @Override
    public void run()
    {
        while (trytorun==1)
        {
            setBounds((int)x1, y, 65, 500);

            repaint();
            try
            {
                Thread.sleep(15);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            if (x1 == -40)
            {
                x1 = 500;
                is_passed = false;
                y = (ran.nextInt(12) - 15)*10;
            }
            else
            {
                x1 -= 1.5;
            }
        }
    }

    public int getlocation()
    {
        return (int)x1;
    }

}

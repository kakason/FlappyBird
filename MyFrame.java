package ce1002.finalproject.s102502542;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class MyFrame extends JFrame implements MouseListener, ActionListener, Runnable, MouseMotionListener
{
    int y = 150;
    int score = 0;

    JLayeredPane jlp = getLayeredPane();

    MyPanel background = new MyPanel();
    MyPanel1 bird = new MyPanel1();
    Dialog dialog = new Dialog();
    MyPanel2 pipe = new MyPanel2(500, -100);
    MyPanel2 pipe1 = new MyPanel2(650, -100);
    MyPanel2 pipe2 = new MyPanel2(800, -100);
    startscreen start = new startscreen();

    JLabel point = new JLabel("score : " + score);

    Thread thread = new Thread(background);
    Thread thread1 = new Thread(bird);
    Thread thread2 = new Thread(pipe);
    Thread thread3 = new Thread(pipe1);
    Thread thread4 = new Thread(pipe2);
    Thread thread5;

    MyFrame()
    {
        setTitle("Flappy Birds");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        addMouseListener(this);

        start.button.addMouseMotionListener(this);
        start.button.addActionListener(this);

        point.setBounds(10, -25, 200, 80);
        point.setForeground(Color.WHITE);

        jlp.add(point, new Integer(6));
        jlp.add(start, new Integer(5));

        background.setVisible(false);
        bird.setVisible(false);
        pipe.setVisible(false);
        pipe1.setVisible(false);
        pipe2.setVisible(false);

        jlp.add(background, new Integer(1));
        jlp.add(bird, new Integer(2));
        jlp.add(pipe, new Integer(3));
        jlp.add(pipe1, new Integer(4));
        jlp.add(pipe2, new Integer(5));

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e1)
    {
        if (e1.getSource() == start.button)
        {
            start.setVisible(false);
            background.setrun(1);
            pipe.setrun(1);
            pipe1.setrun(1);
            pipe2.setrun(1);
            background.setVisible(true);
            bird.setVisible(true);
            pipe.setVisible(true);
            pipe1.setVisible(true);
            pipe2.setVisible(true);

            bird.setLocation(200, 120);
            bird.torun = true;
            bird.vy = 0;
            bird.y = 120;
            pipe.setLocation(500, -100);
            pipe1.setLocation(650, -100);
            pipe2.setLocation(800, -100);
            pipe.x1 = 500;
            pipe1.x1 = 650;
            pipe2.x1 = 800;
            score = 0;
            dialog.over.setpoint(0);

            thread = new Thread(background);
            thread1 = new Thread(bird);
            thread2 = new Thread(pipe);
            thread3 = new Thread(pipe1);
            thread4 = new Thread(pipe2);
            thread5 = new Thread(this);

            thread.start();
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            thread5.start();
        }
    }

    public void mouseClicked(MouseEvent e)
    {
        bird.jump();
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    boolean is_touch(MyPanel1 bird, MyPanel2 pipe)
    {
        if (bird.getX() > pipe.getX() + 60)
        {
            if (!pipe.is_passed)
            {
                score++;
                pipe.is_passed = true;
                dialog.over.setpoint(score);
            }
            return false;
        }
        else if (bird.getX() + 30 < pipe.getX())
        {
            return false;
        }
        else if (bird.getY() < pipe.getY() + 180)
        {
            return true;
        }
        else if (bird.getY() + 30 > pipe.getY() + 290)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void run()
    {
        while (true)
        {
            if (bird.getY() < 225 && !is_touch(bird, pipe)
            && !is_touch(bird, pipe1) && !is_touch(bird, pipe2))
            {
                point.setText("score : " + score);
            }
            else
            {
                bird.torun = false;
                bird.setVisible(false);
                pipe.setVisible(false);
                pipe1.setVisible(false);
                pipe2.setVisible(false);
                JOptionPane.showMessageDialog(dialog, "You Lose!");
                dialog.setVisible(true);

                background.setrun(0);
                pipe.setrun(0);
                pipe1.setrun(0);
                pipe2.setrun(0);
                start.setVisible(true);
                return;
            }

            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent arg0)
    {

    }

    @Override
    public void mouseMoved(MouseEvent arg0)
    {
        start.button.setText("Click Now");
    }
}

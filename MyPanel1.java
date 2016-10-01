package ce1002.finalproject.s102502542;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class MyPanel1 extends JPanel implements Runnable 
{
	JLabel label = new JLabel(new ImageIcon(getClass().getResource("flame/Bird.png")));
	//MyFrame myframe = new MyFrame();
	double y = 120;
	double vy = 0;
	int time = 0;
    boolean torun=true;

	MyPanel1() 
	{
		setBounds(200, (int)y, 40, 40);
		setLayout(null);
		// setBorder(new LineBorder(Color.black,3));
		label.setBounds(0, 0, 40, 40);

		add(label);
		setOpaque(false);
		
	}
	
    public void setrun(boolean a)
    {
    	torun=a;
	}
    
	public void jump() 
	{
		this.vy = -2;
	}
	
	@Override
	public void run() //讓鳥上下移動(重力加速度)
	{
		while (torun) 
		{

			try 
			{
				Thread.sleep(10);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}

			vy += 0.04;
			if(vy > 2.5) 
			{
				vy = 2.5;
			}
			y += vy;
			if (y < 0) 
			{
				y = 0;
			}
			setLocation(200, (int)y);

			if (y >= 230) 
			{
				setLocation(200, 230);
			}

		}

	}

}

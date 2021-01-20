package Notification_Management;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ServerStart {

	public static boolean start1 = false;
	public static boolean start2 = false;

 

 
    public static void main(String s[]) {
 
        JFrame frame = new JFrame("Server Start Window");
 
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
 
        JButton pri_start = new JButton();
        pri_start.setText("Start Priority Notifications");
        pri_start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				start1=!start1;
				if(!start1)   pri_start.setText("Start Priority Notifications");
				else
			        pri_start.setText("Stop Priority Notifications");

			}
		});

    

        JButton sche_start = new JButton();
        sche_start.setText("Start Scheduled Notifications");
        sche_start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				start2=!start2;
				if(!start2)   pri_start.setText("Start Scheduled Notifications");
				else
			        pri_start.setText("Stop Scheduled Notifications");

			}
		});

     
        panel.add(pri_start);
        panel.add(sche_start);

        frame.add(panel);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        Thread th = new Thread(new Runnable() {
			
			@Override
			public void run() {
				runPri();
				runScheduled();
			}
		});
        
        th.start();
 
    }
    
    
    public static void runPri()
    {
    	while(true)
    	{
    		try {
				Thread.sleep(1000);
				if(start1)
	    		{
					send_notification.send_priority_notifications();
	    			
	    		}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    }
    
    public static  void runScheduled()
    {
    	while(true)
    	{
    		try {
				Thread.sleep(1000);
				if(start2)
	    		{
					send_notification.send_scheduled_notifications();
	    			
	    		}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    
 
}

import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class gui extends JFrame implements ActionListener
{
int z;
Container f;
JPanel a0;
JButton search;
JLabel uname;
JTextField url;
static String msg="";
String content="";

	public gui()
	{
	super("Traffic Application");
        z=1;
	JFrame.setDefaultLookAndFeelDecorated(true);	//in jdk1.6.0;
	f=getContentPane();
	f.setLayout(null);

	a0=new JPanel(null);
	a0.setVisible(true);
   
        uname=new JLabel("Enter the url");
	search=new JButton("Search");
	url=new JTextField("");
	a0.add(uname);
	a0.add(url);
	a0.add(search);
	
	
        uname.setBounds(60,30,150,50);
	url.setBounds(220,30,200,50);
	search.setBounds(150,120,150,50);
	
	
        f.add(a0);
	a0.setBounds(20,20,500,500);
	search.addActionListener(this);
    
	
	}
	
	
	
	public void actionPerformed(ActionEvent ae) 
	{   try{
	
					File f;
  					f=new File("content1.txt");
  					if(!f.exists())
  					f.createNewFile();  										
  					FileWriter out = new FileWriter(f,false);					
					PrintWriter pr= new PrintWriter(out); 
   		                        content=url.getText();
     					pr.println(content);
					out.close();
     		
			



               // pageInput.close();
                //source.close();
                    
		}catch( Exception e){}   
	}
	
	public static void main(String arg[])          //main function
	{
	gui go=new gui();
	go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	go.setVisible(true);
	go.setSize(500,500);
	go.setLocation(10,10);
	go.setResizable(false);
	}
}
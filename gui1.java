
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.lang.*;
import code.*;

class gui1 extends JFrame implements ActionListener
{
static double p_rel;
static double p_irrel;
double pij[][];
Set vocabset ;


int z;
Container f;
JPanel a0;
JButton search;
JLabel uname;
JTextField url;
static String msg="";
String content;

	public gui1()
	{
	super("Traffic Application");
        z=1;
	JFrame.setDefaultLookAndFeelDecorated(true);	//in jdk1.6.0;
	f=getContentPane();
	f.setLayout(null);

	a0=new JPanel(null);
	a0.setVisible(true);
   
        uname=new JLabel("Enter the speed");
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
    

File directory = new File("relevant");
 File files[] = directory.listFiles();
 int rel_count=files.length;
 System.out.println(rel_count);

 File directory2 = new File("irrelevant");
 File files2[] = directory2.listFiles();
 int irrel_count=files2.length;
 System.out.println(irrel_count);

 int tot_count=rel_count+irrel_count;
 p_rel=(double)rel_count/tot_count;
 p_irrel=(double)irrel_count/tot_count;
 System.out.println(p_rel+" "+p_irrel);
  
 try
 {
 int i=0;
 int j=0;
TreeMap<String,Integer> vocabmap = new TreeMap<String,Integer>();
vocabmap=vocab.create("overall", "vocab.txt");
 
TreeMap<String,Integer> relmap = new TreeMap<String,Integer>();
relmap=training.create("relevant", "relevant.txt");

TreeMap<String,Integer> irrelmap = new TreeMap<String,Integer>();
irrelmap=training.create("irrelevant", "irrelevant.txt");


 int nrel=0;
 int nirrel=0;
 int val1=0;
 
 Set relset = relmap.entrySet(); 
			// Get an iterator 
			Iterator reli = relset.iterator(); 
			// Display elements 
			while(reli.hasNext()) { 
								Map.Entry relme = (Map.Entry)reli.next();
								Object relob=relme.getValue();
								val1=((Integer) relob).intValue();
								
								nrel=nrel+val1;
													 		  
								} 
System.out.println(nrel);



 Set irrelset = irrelmap.entrySet(); 
			// Get an iterator 
			Iterator irreli = irrelset.iterator(); 
			// Display elements 
			while(irreli.hasNext()) { 
								Map.Entry irrelme = (Map.Entry)irreli.next();
								Object irrelob=irrelme.getValue();
								val1=((Integer) irrelob).intValue();
								
								nirrel=nirrel+val1;
													 		  
								} 
System.out.println(nirrel);


vocabset = vocabmap.entrySet(); 
 int vocabsize=vocabset.size();
 System.out.println(vocabsize);
 int nij[][]=new int[vocabsize][2];
 for(i=0;i<vocabsize;i++)
 for(j=0;j<2;j++)
 nij[i][j]=0;
 int count=-1;
 Iterator vocabi=vocabset.iterator();
 while(vocabi.hasNext())
			{
			 count++;
              Map.Entry vocabme = (Map.Entry)vocabi.next();
			 Object vocabob=vocabme.getKey();
			 String st=vocabob.toString();
			 Iterator reli2 = relset.iterator(); 
			 while(reli2.hasNext()) 
			 { 
			                    
				Map.Entry relme = (Map.Entry)reli2.next();
				Object relob=relme.getKey();
                 String st1=relob.toString();
				 if(st1.equals(st))
				 {
				 relob=relme.getValue();
				 int store=((Integer)relob).intValue();
				 nij[count][0]=store;
				 }
				 
	
			}
			
			Iterator irreli2 =irrelset.iterator(); 
			 while(irreli2.hasNext()) 
			 { 
			                    
				Map.Entry irrelme = (Map.Entry)irreli2.next();
				Object irrelob=irrelme.getKey();
                 String st2=irrelob.toString();
				 if(st2.equals(st))
				 {
				 irrelob=irrelme.getValue();
				 int store=((Integer)irrelob).intValue();
				 nij[count][1]=store;
				 }

	        }
			
		}	
		/*for(i=0;i<10;i++)
		{
		for(j=0;j<2;j++)
		{
		
		System.out.print(nij[i][j]+"\t");
}System.out.println();
}	*/

pij=new double[vocabsize][2];
 for(i=0;i<vocabsize;i++)
 for(j=0;j<2;j++)
 pij[i][j]=0;
	int den1=nrel+vocabsize;
	int den2=nirrel+vocabsize;
	for(i=0;i<vocabsize;i++)
 {pij[i][0]=(nij[i][0]+1)/(double)den1;
 pij[i][1]=(nij[i][1]+1)/(double)den2;
 }
	/*for(i=0;i<10;i++)
		{
		for(j=0;j<2;j++)
		{
		
		System.out.print(pij[i][j]+"\t");
}System.out.println();
}*/


	}

catch(Exception e)
 {System.out.println(e);
 }
 
	
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
     		
			



                //pageInput.close();
               // source.close();
                test1("content1.txt", vocabset, pij);


                    
		}catch( Exception e){}   
	}


public static void test1(String ftest, Set vocabset, double p[][])
 {
 try

	{
	/*for(int i=0;i<1494;i++)
	{for(int j=0;j<2;j++)
	{System.out.println(p[i][j]);}
	}*/
	double testrel=0;
	double testirrel=0;
	TreeMap<String,Integer> testmap = new TreeMap<String,Integer>();

		
			FileInputStream fis = null;
    					BufferedInputStream bis = null;
   						DataInputStream dis = null;
   						
      						fis = new FileInputStream(ftest);

     						// Here BufferedInputStream is added for fast reading.
      						bis = new BufferedInputStream(fis);
      						dis = new DataInputStream(bis);

      						// dis.available() returns 0 if the file does not have more lines.
      						while (dis.available() != 0) 	
								{

      						// this statement reads the line from the file and print it to
       						 // the console.
        					
								String s=dis.readLine();
       						 
								StringTokenizer st = new StringTokenizer(s,":,=;.'/(){}[]?#%\"",false);
								String t="";
								while (st.hasMoreElements()) t += st.nextElement();
 		
								StringTokenizer token = new StringTokenizer(t);
								while (token.hasMoreTokens())
									{
									String str = token.nextToken();
									str=str.toLowerCase();
									if((testmap.get(str)== null)&&((vocab.check(str)==true)))
									{
									 int count=-1;
									 int flag=0;
								     testmap.put(str,1);
								     Iterator vocabi=vocabset.iterator();
										while(vocabi.hasNext())
											{
												count++;
												Map.Entry vocabme = (Map.Entry)vocabi.next();
												Object vocabob=vocabme.getKey();
												String st2=vocabob.toString();
												if(str.equals(st2))
												{
												flag=1;
												break;}
											} 
							if(flag==1)
							{
											testrel=testrel+Math.log(p[count][0]);
											testirrel=testirrel+Math.log(p[count][1]);	

}											
									}						 
       						 
       						 
       						 } }
							fis.close();
      						bis.close();
     						dis.close(); 
							testrel=testrel+Math.log(p_rel);
							testirrel=testirrel+Math.log(p_irrel);
							System.out.println(testrel);
							System.out.println(testirrel);
							if(testrel>testirrel)
							System.out.println("Genuine User");
							else
							System.out.println("Malicious User");
							
     							
	}
	 catch(Exception e)
 {
 }
 }
	
	public static void main(String arg[])          //main function
	{
	gui1 go=new gui1();
	go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	go.setVisible(true);
	go.setSize(500,500);
	go.setLocation(10,10);
	go.setResizable(false);
	}
}
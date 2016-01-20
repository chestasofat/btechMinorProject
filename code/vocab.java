package code ;

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


public class vocab {
	
public static TreeMap create(String DirectoryPath,String TargetFile) throws IOException 
{
TreeMap<String,Integer> textmap = new TreeMap<String,Integer>();
File directory = new File(DirectoryPath);
File files[] = directory.listFiles();
try {
for (File file : files) {
   						FileInputStream fis = null;
    					BufferedInputStream bis = null;
   						DataInputStream dis = null;
   						
      						fis = new FileInputStream(file);

     						// Here BufferedInputStream is added for fast reading.
      						bis = new BufferedInputStream(fis);
      						dis = new DataInputStream(bis);

      						// dis.available() returns 0 if the file does not have more lines.
      						while (dis.available() != 0) {

      						// this statement reads the line from the file and print it to
       						 // the console.
        					
       						 String s=dis.readLine();
       						 
       						 StringTokenizer st = new StringTokenizer(s,":,=;.'/(){}[]%?\"#",false);
   							String t="";
 							 while (st.hasMoreElements()) t += st.nextElement();
 		
 							StringTokenizer token = new StringTokenizer(t);
 			 				while (token.hasMoreTokens()){
  			 				String str = token.nextToken();
							str=str.toLowerCase();
  			 				
  			 				if((textmap.get(str)== null)&&((check(str)==true)))
								{
								textmap.put(str,1);
								} 
							
 							 }						 
       						 
       						 //System.out.println(s);
       						 }
							fis.close();
      						bis.close();
     						dis.close();
     						}} catch (FileNotFoundException e) {
     															e.printStackTrace();
    															}
    						  catch (IOException e) {
      												System.out.println(" Number of words in the file are odd and should be even");
      												//e.printStackTrace();
   													 }
							
     
     
					File f;
  					f=new File(TargetFile);
  					if(!f.exists())
  					f.createNewFile();  										
  					FileWriter out = new FileWriter(f,false);					
					PrintWriter pr= new PrintWriter(out);    		
     		
     		Set set = textmap.entrySet(); 
			// Get an iterator 
			Iterator i = set.iterator(); 
			// Display elements 
			while(i.hasNext()) { 
								Map.Entry me = (Map.Entry)i.next(); 
								//System.out.println(me.getKey());
								Object ob=me.getKey();
								String st = ob.toString();
								pr.println(st);								 		  
								} 
								out.close();
								return textmap;
     
     }
     
     
 public static void main(String[] args) throws IOException 
{
}
public static Boolean check(String str)
{
Boolean ret=true;
try
{
FileInputStream fis2 = null;
    					BufferedInputStream bis2 = null;
   						DataInputStream dis2 = null;
   						
      						fis2 = new FileInputStream("stopwords.txt");

     						// Here BufferedInputStream is added for fast reading.
      						bis2 = new BufferedInputStream(fis2);
      						dis2 = new DataInputStream(bis2);
String strline;

      					
      						while ((strline=dis2.readLine())!= null) {

      						
						if(strline.equals(str))
{ret= false;
break;
}
}

}
catch(Exception e)
{}
return ret;


}
}
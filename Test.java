/* A program to demonstrate serialization for 
various different dependencies*/ 

import java.io.*;
 
import java.io.File;

import java.io.FileInputStream;

import java.io.FileOutputStream;


class abc implements Serializable
{
   String school;
   int Class1;
   abc(String school, int Class1)
  {
    this.school=school;
    this.Class1=Class1;
  }
}

 class def implements Serializable
{
   String Sub;
   def(String Sub)
   {
    this.Sub=Sub;
   }
}

class Demo extends abc  //implements Serializable 

{
  
  int roll; 

    String name; 
 
    def D; 

 
 public Demo(String school, int Class1, int roll,String name,String Sub) 

   { 

     super(school,Class1);
    
     D = new def( Sub);
 
     this.roll = roll; 
    
     this.name = name; 

   } 

}
 

class Test 

{
 
 public static void main(String[] args) 
 
  { 
   
     Demo obj = new Demo("LMA",10,101,"Aafreen","Computers"); 

        String filename = "file.txt"; 
 
     try
     
    {
        FileOutputStream file = new FileOutputStream(filename);
 
       ObjectOutputStream out = new ObjectOutputStream(file); 
  
        out.writeObject(obj); 
  
        out.close(); 
 
        file.close(); 
           
        
        System.out.println("Object has been serialized"); 


     } 

      catch(IOException ex) 
 
    {
 
       System.out.println("IOException is caught"+ex); 

    } 

 
    try
    
    {    
         FileInputStream file = new FileInputStream(filename); 
   
         ObjectInputStream in = new ObjectInputStream(file); 
       
         obj =(Demo)in.readObject(); 
	


         in.close(); 
  
         file.close(); 
  
         System.out.println("Object has been deserialized "); 
   
         System.out.println("Name = " + obj.name); 
    
         System.out.println("Class = " + obj.Class1); 
	
         System.out.println("Roll No = " + obj.roll); 

	 System.out.println("Subject= " + obj.D.Sub); 

	 System.out.println("School = " + obj.school); 
    } 

         catch(IOException ex) 

     {
 
       System.out.println("IOException is caught"+ex);
 
    } 
  
     
     catch(ClassNotFoundException ex) 
   
  { 
   
      System.out.println("ClassNotFoundException is caught");
 
     }
 

 }
 
}

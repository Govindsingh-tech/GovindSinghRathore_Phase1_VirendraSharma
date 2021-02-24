package project.jav.lockedme;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class mainMenu {
	
		static String path = "C:\\Users\\Govind Singh Rathore\\eclipse-workspace\\LockedMe\\";
	
public static void main(String[] args) throws IOException {
		
		int num = 0;
		String h = null;
		mainMenu obj = new mainMenu();
        
        //Take user Option from the below mentioned Menu
        Scanner input = new Scanner(System.in);
        System.out.println("**********************************************************");
        System.out.println("*********** DEVELOPED BY GOVIND SINGH RATHORE **************");
        System.out.println("*********************  LOCKEDME.COM  ********************");
        System.out.println("***********************************************************");
        System.out.println();
        
        //Show Menu
        System.out.println(" 1. Click to Display Files Available!");
        System.out.println(" 2. More");
        System.out.println(" 3. Exit");
        System.out.println();
        
        System.out.println("Select any of the following: ");
        try {
        	num = input.nextInt();   
            
            switch(num) {
            case 1:DisplayFiles();
    				System.out.println("\n");
    				obj.main(args);
    				break;
    				
            case 2: More();
            		System.out.println("\n");
            		obj.main(args);
            	
            case 3:System.out.println("Exit Successfully.");
            		System.exit(0);
            		break;
            	
    	        default:System.out.println("Please Enter one of the options given!!!");
    	        		System.out.println("\n");
    	        		obj.main(args);
            
            }
        }
        catch(InputMismatchException e) {
        	System.out.println("Please Enter one of the options given!!!");
        	obj.main(args);
        }
        
         
          
}

private static void More() throws IOException {
	
	int num = 0;
	String h = null;
	mainMenu obj = new mainMenu();
	
	System.out.println(" 1. Create new file");
    System.out.println(" 2. SearchFile");
    System.out.println(" 3. Delete file");
    System.out.println(" 4. Go back to Main Menu!");
    Scanner sc=new Scanner(System.in);
    System.out.println("Select any of the following: ");
    //String name=sc.nextLine();
    
    try {
    	
    	num = sc.nextInt();
    	switch(num) {
    	
    case 1:CreateNewFile();
    		System.out.println("\n");
    		Object args;
			obj.More();
    		break;
    	
    case 2:SearchFile();
    		System.out.println("\n");
    		Object args2;
			obj.More();
    		break;
    	
    case 3:DeleteFile();
    		System.out.println("\n");
    		Object args3;
			obj.More();
    		break;
    		
    case 4:mainMenu.main(null);
    	
        default:System.out.println("Please Enter one of the options given!!!");
        		System.out.println("\n");
			Object args4;
			obj.More();
    
    }
    
  }catch(InputMismatchException e) {
  	System.out.println("Please Enter one of the options given!!!");
  	mainMenu.main(null);
  }
}


//Method to delete the files
private static void DeleteFile() {
    Scanner sc=new Scanner(System.in);         //object of Scanner class  
	System.out.print("Enter the file name you want to delete: ");  
	String name=sc.nextLine();
	File myObj = new File(path + name);
    if (myObj.delete()) { 
      System.out.println("Deleted the file: ");
    } else {
      System.out.println("Failed to delete the file.");
    }
    
} 

//Method to get file information
private static void SearchFile() {
	Scanner sc=new Scanner(System.in);
    System.out.println("Enter the file name to get info: ");
    DisplayFiles();
    String name=sc.nextLine();
	File dir = new File(path + name);
    if (dir.exists()) {
      System.out.println("File name: " + dir.getName()); 
      System.out.println("Absolute path: " + dir.getAbsolutePath()); 
      System.out.println("Writeable: " + dir.canWrite()); 
      System.out.println("Readable: " + dir.canRead()); 
      System.out.println("File size in bytes: " + dir.length());
    } else {
      System.out.println("The file does not exist.");
    }
	
}

//Method to Display the files in ascending order
private static void DisplayFiles() {
	File dir = new File(path);		//creating object of file directory
    String[] list = dir.list();		//list files in a directory
    Arrays.sort(list);				//to sort the given array list
    if (list == null) {
       System.out.println("does not exist or is not a directory");
    } else {
       for (int i = 0; i < list.length; i++) {
          String filename = list[i];
          System.out.println(filename);
       }
    }
	
}

//Method to create a new file
private static void CreateNewFile() {
	try  
	{  
	Scanner sc=new Scanner(System.in);         //object of Scanner class  
	System.out.print("Enter the file name: ");  
	String name=sc.nextLine();              //variable name to store the file name  
	FileOutputStream fos=new FileOutputStream(name, true);  // true for append mode  
	System.out.print("Enter file content: ");         
	String str=sc.nextLine()+"\n";      //str stores the string which we have entered  
	byte[] b= str.getBytes();       //converts string into bytes  
	fos.write(b);           //writes bytes into file  
	fos.close();            //close the file  
	System.out.println("file saved."); 
	}  
	catch(Exception e)  
	{  
	e.printStackTrace();          
	}  
	
}}


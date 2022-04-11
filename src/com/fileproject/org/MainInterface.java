package com.fileproject.org;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainInterface {
		private static ArrayList<File> fileList = new ArrayList<File>();
	static Scanner scan;
	static String adminName; 
	public static void main(String args[]) {
		scan = new Scanner(System.in);
		int caseNumber;
		boolean flag = true;
		
		System.out.println("Hello welcome to our Application");
		System.out.println("LockedME.com");
		System.out.println("Developed by Madhav Bhat K");
		sleep();
		
		System.out.println("Enter your name");
		adminName = scan.nextLine();
		while(flag == true) {
			System.out.println("");
			System.out.println("");
			System.out.println("1. Show all files in the Directory");
			System.out.println("2. Show more details");
			System.out.println("3. Exit the Application");
			System.out.println("Enter your options");
			caseNumber = scan.nextInt();
			switch(caseNumber) {
				case 1: System.out.println("The files are as follows:");
					showFiles();
				break;
				case 2: showMoreDetails();
				break;
				case 3: flag = false;
				break;
				default:System.out.println("Invalid Options");
				break;
			}
		}
		System.out.println(".....Thank you for using the Application.....");
		
	}
	private static void showMoreDetails() {
		boolean flag = true;
		while(flag == true) {
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("1. Add a file");
			System.out.println("2. Delete a file");
			System.out.println("3. Go to main menu");
			System.out.println("Enter the Options:");
		int caseNumber = scan.nextInt();
		switch(caseNumber) {
			case 1:
				addFile();
			break;
			case 2:
				deleteFile();
			break;
			case 3: 
				System.out.println("Getting back to main Menu:");
				sleep();
				flag = false;
			break;
			default:System.out.println("Invalid Options"); 
				break;
		}
		}
	}
	private static void addFile() {
		Scanner scan = new Scanner(System.in);
		sleep();
		System.out.println("");

		System.out.println("Enter the file details");
		System.out.println("Enter the name of the file:");
		String filename = scan.nextLine();
		System.out.println("Enter the Directory where you want to store: (Leave empty for the root dir)");
		String dir = scan.nextLine();
		System.out.println("Enter your name: (Leave empty if you are the Admin user)");
		String userName = scan.nextLine();
		if(userName.length() == 0) {
			userName = new String(adminName);
		}
		if(dir.length() == 0) {
			fileList.add(new File(userName,filename));
			sleep();
			System.out.println("File has been inserted successfully");
			return;
		}
		fileList.add(new File(userName,filename,dir));
		System.out.println("File has been inserted successfully");
		sleep();
		
		// TODO Auto-generated method stub
		
	}
	private static void deleteFile() {
	    Scanner scan = new Scanner(System.in);
		sleep();
		int index = -1;
		if(fileList.size() == 0) {
			System.out.println("There are no files in the directory");
		}
		System.out.println("Enter the file name to delete");
		String fileName = scan.nextLine();
		for(File file: fileList) {
			if(file.get_fileName().equalsIgnoreCase(fileName)) {
				index = fileList.indexOf(file);
				break;
			}
		}
			if(index != -1){
			   System.out.println("Are you sure, that you want to remove the file? Press 'Y' to continue");
			   String status = scan.nextLine();
			   if(status.equalsIgnoreCase("y")){
			    fileList.remove(index);
				sleep();
				System.out.println("");
				System.out.println("File has been deleted successfully...");
				return;
			   }
			}
		
			System.out.println("No file is found...");
			System.out.println("Try again...");
			
		
		// TODO Auto-generated method stub
		
	}
	private static void showFiles() {
		sleep();
		 if(fileList.size() == 0) {
			 System.out.println("There are no files in the root directory");
			 return;
		 }
		 Collections.sort(fileList, new FileSortByName());
		// TODO Auto-generated method stub
		for(File file: fileList) {
			file.displayFileAttributes();
		}
	}
	private static void sleep() {
		try {
			System.out.println("Loading....");
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

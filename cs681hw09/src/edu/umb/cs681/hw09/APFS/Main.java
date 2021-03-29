package edu.umb.cs681.hw09.APFS;

import java.util.LinkedList;

public class Main {
public static void main(String args[]) {
		
		APFS apfs = new APFS("APFS File System");
		
		apfs.initFileSystem("Local", 1000);		
		ApfsDirectory root = apfs.getRootDir();
		
		ApfsDirectory applications = new ApfsDirectory(root, "applications");
		root.appendChild(applications);
		ApfsFile file1, file2;		
		file1 = new ApfsFile(applications, "file1", 40);
		file2 = new ApfsFile(applications, "file2", 40);
		applications.appendChild(file1);
		applications.appendChild(file2);
		

		Thread t1 = new Thread(apfs);				
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		ApfsDirectory home  = new ApfsDirectory(root, "home");
		root.appendChild((home));
		ApfsFile file3, file4;		
		file3 = new ApfsFile(home, "file3", 20);
		file4 = new ApfsFile(home, "file4", 30);
		home.appendChild(file3);
		home.appendChild(file4);
	

		Thread t2 = new Thread(apfs);				
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e1) {
		    e1.printStackTrace();
		}
		
		System.out.println("\nRoot total size: " + root.getTotalSize());
		LinkedList<ApfsElement> rootChildren = root.getChildren();
		for (ApfsElement child : rootChildren) {
			System.out.println(child.getName());
		}
		
	
	}
}

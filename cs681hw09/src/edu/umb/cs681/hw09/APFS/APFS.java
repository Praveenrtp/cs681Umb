package edu.umb.cs681.hw09.APFS;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class APFS extends FileSystem implements Runnable {
	private String ownerName;
	private LocalDateTime lastModified;

	public APFS(String ownerName) {
		this.ownerName = ownerName;
		this.lastModified = LocalDateTime.now();
	}

	@Override
	protected FSElement createDefaultRoot() {
		return new ApfsDirectory(null, "root");
	}

	public ApfsDirectory getRootDir() {
		ApfsDirectory rootDir = (ApfsDirectory) this.getRoot();
		return rootDir;
	}

	public String getOwnerName() {
		return this.ownerName;
	}

	public LocalDateTime getLastModified() {
		return this.lastModified;
	}
	public void run() {
		
		System.out.println("\nThread #" + Thread.currentThread().getId());
		System.out.println("Size of " + getRootDir().getName() + " dir: " + getRootDir().getTotalSize());
		LinkedList<ApfsElement> rootChildren = getRootDir().getChildren();
		for (ApfsElement child : rootChildren) {
			System.out.println("\n" +child.getName());
			LinkedList<ApfsElement> child1Children =child.getChildren();
			for (ApfsElement child1 : child1Children) {
				System.out.println(child1.getName());
				LinkedList<ApfsElement> child2Children =child1.getChildren();
				for (ApfsElement child2 : child2Children) {
					System.out.println(child2.getName());
				}
			}
		}
	}

}
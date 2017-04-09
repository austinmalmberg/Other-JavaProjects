package com.lynda.javatraining.olives;

public enum OliveName {
	KALAMATA("Kalamata"), LIGURIO("Ligurio"),
	PICHOLINE("Picholine"), GOLDEN("Golden");
	
	private String nameAsString;
	
	private OliveName(String nameAsString) {
		this.nameAsString = nameAsString;
	}
	
	public String toString() {
		return this.nameAsString;
	}
}

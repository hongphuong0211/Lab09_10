package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable, Comparable{

	public DigitalVideoDisc(int id) {
		super(id);
	}
	
	public DigitalVideoDisc(int id, String title) {
		super(id, title);
	}
	
	public DigitalVideoDisc(int id, String title, String category) {
		super(id, title, category);
	}

	public DigitalVideoDisc(int id, String title, String category, float cost, int length) {
		super(id, title, category, cost, length);
	}
	
	public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
		super(id, title, category, cost, length, director);
	}

	boolean search(String title) {
		String[] parts = title.split(" ");
		for(int i = 0; i < parts.length; i++) {
			if(!super.getTitle().contains(parts[i])) return false; 
		}
		return true;
	}

	@Override
	public void play() throws PlayerException {
		// TODO Auto-generated method stub
		if(super.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		}else {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return this.getCost() == ((DigitalVideoDisc) o).getCost()?0:(this.getCost() > ((DigitalVideoDisc) o).getCost()?1:-1);
	}

}

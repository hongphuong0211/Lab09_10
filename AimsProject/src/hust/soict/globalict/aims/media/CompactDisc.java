package hust.soict.globalict.aims.media;

import java.util.ArrayList;

import hust.soict.globalict.aims.PlayerException;

public class CompactDisc extends Disc implements Playable, Comparable{
	private String artist;
	private ArrayList<Track> tracks;

	public CompactDisc(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	public CompactDisc(int id, String title) {
		super(id, title);
	}
	
	public CompactDisc(int id, String title, String category) {
		super(id, title, category);
	}
	
	public CompactDisc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}

	public CompactDisc(int id, String title, String category, float cost, String artist) {
		super(id, title, category, cost);
		this.artist = artist;
	}
	
	public CompactDisc(int id, String title, String category, float cost, String artist, ArrayList<Track> tracks) {
		super(id, title, category, cost);
		this.artist = artist;
		this.tracks = tracks;
	}

	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track track) {
		if(!tracks.contains(track)) {
			tracks.add(track);
		}
	}
	
	public void removeTrack(Track track) {
		if(tracks.contains(track)) {
			tracks.remove(track);
		}
	}
	
	public int getLength() {
		int sum = 0;
		for(Track prep: tracks) sum += prep.getLength();
		return sum;
	}

	@Override
	public void play() throws PlayerException{
		if(this.getLength() > 0) {
			java.util.Iterator iter = tracks.iterator();
			Track nextTrack;
			while(iter.hasNext()) {
				nextTrack = (Track) iter.next();
				try {
					nextTrack.play();
				} catch (PlayerException e) {
					// TODO Auto-generated catch block
					throw e;
				}
			}
		}else {
			throw new PlayerException("ERROR: CD length is non-positive!");
		}
	}

	@Override
	public int compareTo(Object o) {
		return getTracks().size() == ((CompactDisc) o).getTracks().size()?(getLength() == ((CompactDisc) o).getLength()?0:(getLength() > ((CompactDisc) o).getLength())?1:-1):(getTracks().size() > ((CompactDisc) o).getTracks().size())?1:-1;
	}

	public ArrayList<Track> getTracks() {
		// TODO Auto-generated method stub
		return tracks;
	}

}

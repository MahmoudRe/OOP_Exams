import java.util.ArrayList;

public class PLAYLIST{
	
		private ArrayList<CD> listCD;
		private ArrayList<AudioFile> SongAndADD;
		
	public PLAYLIST (ArrayList<CD> listCD) {
		this.listCD = listCD;
		int c = -1;
		
		SongAndADD = new ArrayList<AudioFile>();
		
		for (int i = 0; i < listCD.size(); i++) {
			for (int j = 0; j < listCD.get(i).getSongList().size(); j++) {
			SongAndADD.add(listCD.get(i).getSongList().get(j));
			
			c++;
			if (c >= ADD.getListADD().size()) { c = 0; }
			SongAndADD.add(ADD.getListADD().get(c));
			}
		}
	}
	
	public String toString() {
		
		String res = "";
		int k = -1;
		
		for (int i = 0; i < listCD.size(); i++) {
			for (int j = 0; j < listCD.get(i).getSongList().size(); j++ ) {
				
				k++;
				if ( k >= ADD.getListADD().size()) {
					k = 0;
				}
				
				res += "Album: " + listCD.get(i).toStringAlbum()
					+ "\n\tTrack " + listCD.get(i).getSongList().get(j).getTitle().toString()
					+ " (" + listCD.get(i).getSongList().get(j).getLength().toString() + ")"
					+ "\nNext add: " + ADD.getListADD().get(k).getAdvertiser().toString() 
					+ " (" + ADD.getListADD().get(k).getLength().toString() + ")\n" ;
			}
		}
				
		return res;
	}
	
	
}

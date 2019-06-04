import java.util.Set;
import java.util.HashMap;

public class Hashmatique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String, String> trackList  = new HashMap<String, String>();
		trackList.put("this is songname1", "Lyrics 1 for song 1 here 1");
		trackList.put("this is songname2", "Lyrics 2 for song 2 here 2");		
		trackList.put("this is songname3", "Lyrics 3 for song 3 here 3");
		trackList.put("this is songname4", "Lyrics 4 for song 4 here 4");
		
		System.out.println("pulling by song title of: this is songname2");
		System.out.println("The lyrics are:  " + trackList.get("this is songname2"));
		System.out.println("/n");
        Set<String> keys = trackList.keySet();
		for(String key: keys) {
			System.out.println(key + ": " + trackList.get(key));
		}
		
		
		
		
		
		
		
		

	} // end main method

	
	
	
	
	
	
	
	
	
	
	
	
} // end class Hashmatique

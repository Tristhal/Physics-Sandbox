package game;

import javax.sound.sampled.*;

public class Sounds {
	public static String name;
	private Clip clip;
	
	public Sounds(Clip c, String n){
		name=n;
		clip=c;		
	}
	public Clip getClip(){
		return clip;
	}
	public String getName(){
		return name;
	}

}

package game;

import javax.sound.sampled.*;

public class Sounds {
	private String name;
	private Clip clip;
	
	public Sounds(Clip c, String n){
		name=n;
		clip=c;		
		System.out.println(name);
	}
	public Clip getClip(){
		return clip;
	}
	public String getName(){
		return name;
	}

}

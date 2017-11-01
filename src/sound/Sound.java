package sound;

import javax.sound.sampled.*;

public class Sound {
	private String name;
	private Clip clip;
	
	public Sound(Clip c, String n){
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

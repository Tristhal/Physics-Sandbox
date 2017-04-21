/*
 * Sound.java
 * 
*/
//Packages///
package game;
//Import statements///
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.sound.sampled.*;
///Main Class///
public class Sound {
	///
	private ArrayList<Clip> clips = new ArrayList<Clip>();
	//private FloatControl gainControl;
	private ArrayList<Sounds> sounds = new ArrayList<Sounds>();
    public Sound() {
    }
    
    public void play(String filename, String name){
    	try{
    		URL soundurl = Sound.class.getResource(filename);
	    	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundurl);
	        Clip clip = AudioSystem.getClip();
	        //clips.add(clip);
	        sounds.add(new Sounds(clip, name));
	        sounds.get(sounds.size()-1).getClip().open(audioInputStream);
	        sounds.get(sounds.size()-1).getClip().setFramePosition(0);
	        sounds.get(sounds.size()-1).getClip().start();
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    public void changeVolume(double i){//0 to 1
    	try{
    	for(int j=0;j<sounds.size();j++){
    		//System.out.println(clips.get(j).isControlSupported(FloatControl.Type.MASTER_GAIN)); //Run this line if master gain not supported
    		FloatControl gainControl= (FloatControl) sounds.get(j).getClip().getControl(FloatControl.Type.MASTER_GAIN);
        	float volume= 86.0f*(float)i-80;//Manipulates the data so it ranges from 0f-1f
        	gainControl.setValue(volume);
    	}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    }
    //changeVolume
    //Function: changes the volume of a specific sound
    //Input: the volume double from 0 to 1 and a string representing the sound name
    //Effect: Changes the volume of all occurrences of that sound
    public void changeVolume(double i, String soundIdentifier){//0 to 1
    	try{
    	for(int j=0;j<sounds.size();j++){
    		//System.out.println(clips.get(j).isControlSupported(FloatControl.Type.MASTER_GAIN)); //Run this line if master gain not supported
    		if(sounds.get(j).getName().equals(soundIdentifier)){//
	    		FloatControl gainControl= (FloatControl) sounds.get(j).getClip().getControl(FloatControl.Type.MASTER_GAIN);
	        	float volume= 86.0f*(float)i-80;//Manupulates the data so it ranges from 0f-1f
	        	gainControl.setValue(volume);
    		}
    	}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    }
    
}
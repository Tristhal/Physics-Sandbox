package modules;

public class FPS_Counter {
	private long now;
	private int framesCount = 0;
	private int framesCountAvg = 0; 
	private long framesTimer = 0;
	
	public FPS_Counter(){
		
	}
	public void updateFPS(){
		long beforeTime = System.nanoTime();
        //... Update program & draw program...
        // DRAW FPS: 
        now = System.currentTimeMillis(); 
        System.out.println("FPS: "+framesCountAvg);
        framesCount++; 
        if(now-framesTimer>1000)
        { 
              framesTimer=now; 
              framesCountAvg=framesCount; 
              framesCount=0; 
        }
        
        return;
	}
}


public class RunParolaGiusta {
	
	int gameDurationMinutes = 2 ;
	
	public RunParolaGiusta(){
		
	}
	
	public static void main(String[] args){
		
		RunParolaGiusta execProg = new RunParolaGiusta();
		
		execProg.execParolaGiusta();
	}
	
	
	public void execParolaGiusta(){
		
		ParolaGiustaDisplay display = new ParolaGiustaDisplay(gameDurationMinutes);
		
		delay(gameDurationMinutes*60000);
		display.endGame();
		
	}
	
	public void delay(int min_time){
		try {Thread.sleep(min_time);} 
		catch (InterruptedException e) {e.printStackTrace();}
	}
}
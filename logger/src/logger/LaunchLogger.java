package logger;


public class LaunchLogger implements Logger{


    public void debug(String category, String message){
        
        System.out.println(category + " , " + message);
        
        }
        
    public void info(String category, String message){

	}

    public void error(String category, String message){

	}

    public static void main (String[] args){
    
        LaunchLogger L = new LaunchLogger();
        
        L.debug("Boy", "Hello");
    }



}

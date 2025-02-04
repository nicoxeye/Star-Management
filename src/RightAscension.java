import java.io.Serializable;

public class RightAscension implements Serializable{
    
    private int hours;
    private int minutes;
    private int seconds;

    public RightAscension(int hours, int minutes, int seconds) {
        if (hours < 0 || hours > 24) {
            throw new RightAscensionException("Hours must be between 0 and 24.");
        }
        if (minutes < 0 || minutes > 59) {
            throw new RightAscensionException("Minutes must be between 0 and 59.");
        }
        if (seconds < 0 || seconds > 59) {
            throw new RightAscensionException("Seconds must be between 0 and 59.");
        }

        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;

    }


    public class RightAscensionException extends RuntimeException {
        public RightAscensionException(String message) {
            super(message);
        }
    }    


    /*
     Hours Properties.
    */
    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {

        if (hours < 0 || hours > 24) {
            throw new RightAscensionException("Hours must be between 0 and 24.");
        }

        this.hours = hours;

    }


    /*
    Minutes Properties.
    */
    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        
        if (minutes < 0 || minutes > 59) {
            throw new RightAscensionException("Minutes must be between 0 and 59.");
        }

        this.minutes = minutes;
        
    }


    /*
     Seconds Properties.
    */   
    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {

        if (seconds < 0 || seconds > 59) {
            throw new RightAscensionException("Seconds must be between 0 and 59.");
        }

        this.seconds = seconds;
        
    }

    // so it views normally in the menu meow 
    // before it threw RightAscension@515f550a :'D
    @Override
    public String toString() {
        return "Hours - " + hours + ", Minutes - " + minutes + ", Seconds - " + seconds;
    }

}

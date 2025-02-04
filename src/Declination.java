import java.io.Serializable;

public class Declination implements Serializable{

    private int degrees;
    private int minutes;
    private double  seconds;

    public Declination(int degrees, int minutes, double seconds) {

        if (degrees < -90 || degrees > 90) {
            throw new DeclinationException("Degrees must be between -90 and 90.");
        }

        if (minutes < 0 || minutes > 59) {
            throw new DeclinationException("Minutes must be between 0 and 59.");
        }

        if (seconds < 0 || seconds > 59.99) {
            throw new DeclinationException("Seconds must be between 0 and 59.99.");
        }

        this.degrees = degrees;
        this.minutes = minutes;
        this.seconds = seconds;

    }

    /*
     Degrees Properties.
    */
    public int getDegrees() {
        return degrees;
    }

    public void setDegrees(int degrees) {
        if (degrees < -90 || degrees > 90) {
            throw new DeclinationException("Degrees must be between -90 and 90.");
        }

        this.degrees = degrees;
        
    }

    /*
     Minutes Properties.
    */
    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        if (minutes < 0 || minutes > 59) {
            throw new DeclinationException("Minutes must be between 0 and 59.");
        }

            this.minutes = minutes;
        
    }

    /*
     Seconds Properties.
    */
    public double getSeconds() {
        return seconds;
    }

    public void setSeconds(double seconds) {
        if (seconds < 0 || seconds > 59.99) {
            throw new DeclinationException("Seconds must be between 0 and 59.99.");
        }

            this.seconds = seconds;
        
    }

    public class DeclinationException extends RuntimeException {
        public DeclinationException(String message) {
            super(message);
        }
    }    


    // prettier formating :)
    // Example output:
    // +12° 40' 50.0"
    @Override
    public String toString() {
        return String.format("%+03d° %02d' %04.1f\"", degrees, minutes, seconds);
    }
    
}

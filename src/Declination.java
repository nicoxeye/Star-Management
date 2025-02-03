import java.io.Serializable;

public class Declination implements Serializable{

    private int degrees;
    private int minutes;
    private double  seconds;

    public Declination(int degrees, int minutes, double seconds) {

        if (degrees < -90 || degrees > 90) {
            throw new IllegalArgumentException("Degrees have to be between -90 and 90.");
        }

        if (minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Minutes have to be between 0 and 59.");
        }

        if (seconds < 0 || seconds > 59.99) {
            throw new IllegalArgumentException("Seconds have to be between 0 and 59.99.");
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
            throw new IllegalArgumentException("Degrees have to be between -90 and 90.");
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
            throw new IllegalArgumentException("Minutes have to be between 0 and 59.");
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
            throw new IllegalArgumentException("Seconds have to be between 0 and 59.99.");
        }

            this.seconds = seconds;
        
    }

    //SO IT CAN BE VIEWED IN THE DISPLAY STARS IN MENUUUUuuuuuuuu
    // before it threw Declination@626b2d4a asdkaskldaklsdkasl
    @Override
    public String toString() {
        return "Degrees - " + degrees + ", Minutes - " + minutes + ", Seconds - " + seconds;
    }
}

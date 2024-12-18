public class Star {
    private String name; // REGEX; "^[A-Z]{3}[0-9]{4}$"
    private String catalogueName; // Greek Name + Constellation Name ; The brightest star -> alpha, second -> beta and so forth
    private double declination; // xx- degrees, yy- minutes, zz- seconds
    private double rightAscension; // xx- h, yy- m, zz- s
    private double apparentMagnitude; // in magnitudo (obserwowana wielkość gwiazdowa) min; -26.74, max; 15.00
    private double absoluteMagnitude; // a measure of the luminosity of a celestial object, the more luminous (intrinsically bright) an object, the lower its magnitude number
    private double distanceInLightYears;
    private String constellation;
    private String hemisphere;
    private double temperature; //Celcius; min 2000, and theres no max
    private double mass; // in relation to the mass of the Sun; min: 0.1*mass of the sun, max: 50
    private double pc; // one parsec = 3.26 light years

    public Star(){

    }
}

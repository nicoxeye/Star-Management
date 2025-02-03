import java.io.*;
import java.util.*;

public class Star implements Serializable{

    private String name;
    private Constellation constellation;
    private String catalogueName;
    private Declination declination;
    private RightAscension rightAscension;
    private double apparentMagnitude;
    private double absoluteMagnitude; // magnitudo
    private double distanceInLightYears;
    private String hemisphere;
    private double temperature;
    private double mass;


    // map of number of Stars in a Constellation!!
    private static final Map<String, Integer> StarsInConstellationMap = new HashMap<>(); 


    /*
     Constructor of Star Class.
     (privated all setters to use them in the constructor; otherwise it would've taken 100+ more lines of code just to do the constructor...)
    */
    public Star(String name, Constellation constellation, String hemisphere, Declination declination, 
                RightAscension rightAscension, double apparentMagnitude, 
                double distanceInLightYears, double temperature, double mass) {

        setName(name);
        setConstellation(constellation);
        setCatalogueName(constellation);
        setHemisphere(hemisphere);
        setDeclination(declination);
        setRightAscension(rightAscension);
        setApparentMagnitude(apparentMagnitude);
        setDistanceInLightYears(distanceInLightYears);
        setAbsoluteMagnitude();
        setTemperature(temperature);
        setMass(mass);

    }


    /*
     Star Name Properties.
     The name of a Star has to consist of 3 big letters followed by 4 numbers.
     Checked by Regex
    */
     public String getName(){
        return name;
     }

     private void setName(String name){
        if (name.matches("^[A-Z]{3}\\d{4}$")) {
            this.name = name;
        }
        else {
            throw new IllegalArgumentException("The name of a Star has to consist of 3 big letters followed by 4 numbers.");
        }
     }

    
    /*
     Star Constellation Properties. 
     Constellation given has to be an object of the class Constellation.
    */
    public Constellation getConstellation(){
        return constellation;
    }

    private void setConstellation(Constellation constellation) {
        if (constellation instanceof Constellation){
            this.constellation = constellation;
        }
        else {
            throw new IllegalArgumentException("Constellation given in the parameter has to be an object of the class Constellation");
        }
    }


    /*
     Star Catalogue Name Properties. 
     Setter checks if the number of stars in a constellation is greater or equal 24 (the number of greek characters) and if so, throws an exception.
     If not; creates a catalogue name from the Greek Alphavet and Constellation Name :D
    */
    public String getCatalogueName() {
        return catalogueName;
    }

    private void setCatalogueName(Constellation constellation) {
        int numberOfStars = StarsInConstellationMap.getOrDefault(constellation.getName(), 0); // defaultValue = 0

        if (numberOfStars >= 24) {
            throw new IllegalArgumentException("In Constellation: " + constellation.getName() + " can't be more than 23 stars.");
        } 
        else { 
            this.catalogueName = GreekAlphabet.values()[numberOfStars].toString() + " " + constellation.getName();
        }

        StarsInConstellationMap.put(constellation.getName(), numberOfStars + 1);
    }

    //overload of the method to use ONLY in deletion hehe...
    private void setCatalogueName(String newCatalogueName) {
        this.catalogueName = newCatalogueName;
    }
    

    /*
     Star Declination Properties. 
     Using the Declination Class for easier management;P
    */
    public String getDeclination() {
        return declination.toString();
    }

    private void setDeclination(Declination declination) {
        switch (hemisphere) {
            case "N" -> {
                if (declination.getDegrees() > 0 && declination.getDegrees() < 90) {
                    this.declination = declination;
                }
                else {
                    throw new IllegalArgumentException("For the Northern Hemisphere degrees have to be between 0 and 90.");
                }
            }
            case "S" -> {
                if (declination.getDegrees() < 0 && declination.getDegrees() > -90) {
                    this.declination = declination;
                }
                else {
                    throw new IllegalArgumentException("For the Southern Hemisphere degrees have to be between -90 and 0.");
                }
            }
            default -> throw new Error("This Hemisphere does not exist.");
        }
    }


    /*
     Star Right Ascension Properties. 
     Using Right Ascension Class for clarity and easier management.
    */
    public String getRightAscension() {
        return rightAscension.toString();
    }

    private void setRightAscension(RightAscension rightAscension) {
        if (rightAscension instanceof RightAscension) {
            this.rightAscension = rightAscension;
        }
        else {
            throw new IllegalArgumentException("Given parameter is not and instance of RightAscension Class.");
        }
    }


    /*
     Star Apparent Magnitute Properties. 
     Has to be between -26.74 and 15.
    */
    public double getApparentMagnitude() {
        return apparentMagnitude;
    }

    private void setApparentMagnitude(double apparentMagnitude) {
        if ( apparentMagnitude >= -26.74 && apparentMagnitude <= 15.00) {
            this.apparentMagnitude = apparentMagnitude;
        }
        else {
            throw new IllegalArgumentException("Apparent Magnitude must be between -26.74 and 15");
        }
    }


    /*
     Star Absolute Magnitude (magnitudo) Properties. 
     Equation: m - 5 * log(10)*r + 5
     m - apparent magnitude
     r - distance from the star in parsecs
     1 pc = 3.26 light years
    */
    public double getAbsoluteMagnitude() {
        return absoluteMagnitude;
    }

    private void setAbsoluteMagnitude() {
        if (this.distanceInLightYears <= 0) {
            throw new IllegalArgumentException("Distance must be greater than 0.");
        }
        this.absoluteMagnitude = this.getApparentMagnitude() - (5 * Math.log10((this.getDistanceInLightYears() / 3.26))) + 5;
    }


    /*
     Star Distance In Light Years Properties. 
    */
    public double getDistanceInLightYears() {
        return distanceInLightYears;
    }

    private void setDistanceInLightYears(double distanceInLightYears) {

        if (distanceInLightYears > 0 ) {
            this.distanceInLightYears = distanceInLightYears;
        }
        else {
            throw new IllegalArgumentException("Distance has to be greater than 0.");
        }
    }


    /*
     Star Hemisphere Properties. 
     Hemisphere where you can see the Star.
     N (Northern) or S (Southern).
    */
    public String getHemisphere() {
        return hemisphere;
    }

    private void setHemisphere(String hemisphere) {

        if (hemisphere.equals("N") || hemisphere.equals("S")) {
            this.hemisphere = hemisphere;
        }
        else {
            throw new IllegalArgumentException("Hemisphere has to be either 'N' or 'S'.");
        }
    }


    /*
     Star Temperature Properties.
     Given in Celsius (*C)
     (we don't accept Fahrenheit in this house 😈)
    */
    public double getTemperature() {
        return temperature;
    }

    private void setTemperature(double temperature) {

        if (temperature > 2000) {
            this.temperature = temperature;
        }
        else {
            throw new IllegalArgumentException("Temperature has to be greater than 2000*C.");
        }
    }


    /*
     Star Mass Properties.
     Minimal; 0.1 * the mass of the sun
     Maximum; 50 * the mass of the sun
    */
    public double getMass() {
        return mass;
    }

    private void setMass(double mass) {

        if (mass >= 0.1 && mass <= 50) {
            this.mass = mass;
        }
        else {
            throw new IllegalArgumentException("Mass has to be between 0.1 and 50 (in reference to the mass of the sun).");
        }

    }

    // OTHER METHODS 

    public static void SerialiseStar(Star star) { 
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("src\\Stars\\" + star.getName() + ".obj"))) {
            outputStream.writeObject(star);
        } 
        catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }
    }


    public static Star DeserialiseStar(String starName) {
        //a lot of error handling here cause it had a tendency to go wrong in testing ;(

        File starFile = new File("src\\Stars\\" + starName + ".obj"); 
    
        // checking if the file exists
        if (!starFile.exists()) {
            System.out.println("File for star " + starName + " not found.");
            return null;
        }
    
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(starFile))) {
            Object obj = inputStream.readObject();
            if (obj instanceof Star star) {
                return star;
            } else {
                System.out.println("The file does not contain a valid Star object.");
                return null;
            }
        } 
        catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializing star: " + e.getMessage());
            return null;
        }
    }
    

    public static void DeleteStar(String catalogueName) {

        List<Star> starsInConstellation = new ArrayList<>();

        Star starToDelete = null;
        String constellationName = null;
    
        // loading all stars from the serialized files in the Stars folder
        File starsFolder = new File("src\\Stars\\");
    
        File[] files = starsFolder.listFiles((_, name) -> name.endsWith(".obj"));
    
        // finding all stars in the same constellation and the one to delete
        for (File file : files) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
                Object obj = inputStream.readObject();
                if (obj instanceof Star star) {
                    //fiding the same stars wit hthe same catalogue name as given in the parmeter
                    if (star.getCatalogueName().equals(catalogueName)) {
                        starToDelete = star;
                        constellationName = star.getConstellation().getName();
                    } else if (star.getConstellation().getName().equals(constellationName)) {
                        starsInConstellation.add(star);
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                // just for testing
                //System.err.println("Error loading star from " + file.getName() + ": " + e.getMessage());
            }
        }
    
        if (starToDelete == null) {
            System.out.println("Star not found.");
            return;
        }
    
        // deleting the found star's file 
        File fileToDelete = new File("src\\Stars\\" + starToDelete.getName() + ".obj");
        if (fileToDelete.delete()) {
            System.out.println("Deleted star: " + starToDelete.getCatalogueName());
        } else {
            System.out.println("Failed to delete star file.");
            return;
        }
    
        // removing the star from StarsInConstellationMap!!! for correct assigment of greek alphabet to the catalogue name
        int numberOfStars = StarsInConstellationMap.getOrDefault(constellationName, 0);
        StarsInConstellationMap.put(constellationName, numberOfStars - 1);
    
        // sorting stars in the constellation by their Greek alphabet order and update catalogue names
        starsInConstellation.sort(Comparator.comparingInt(star -> 
            Arrays.asList(GreekAlphabet.values()).indexOf(GreekAlphabet.valueOf(star.getCatalogueName().split(" ")[0]))));
    
        for (int i = 0; i < starsInConstellation.size(); i++) {
            Star star = starsInConstellation.get(i);

            //updating catalogue name to reflect the new Greek letter order
            String cn = GreekAlphabet.values()[i] + " " + star.getConstellation().getName();
            star.setCatalogueName(cn);

            //saving the updated star back to the file
            SerialiseStar(star);
        }
    
        // updating the count in the map to reflect the new number of stars in the constellation
        StarsInConstellationMap.put(constellationName, starsInConstellation.size());
    
        System.out.println("Catalogue names updated successfully.");
    }


    // my addition for easier viewing of the created stars :D
    public static void DisplayAllStars() {
        //this deserialises all the stars in the src\Stars folder automatically so they dont need to be deserialised to be viewed

        File starsFolder = new File("src\\Stars\\");
        File[] files = starsFolder.listFiles();

        if (files != null && files.length > 0) {
            for (File file : files) {
                try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
                    Object obj = inputStream.readObject();
                    if (obj instanceof Star star) {
                        System.out.println("Star Name: " + star.getName());
                        System.out.println("Catalogue Name: " + star.getCatalogueName());
                        System.out.println("Constellation: " + star.getConstellation().getName());
                        System.out.println("Right Ascension: " + star.getRightAscension());
                        System.out.println("Declination: " + star.getDeclination());
                        System.out.println("Apparent Magnitude: " + star.getApparentMagnitude());
                        System.out.println("Distance in Light Years: " + star.getDistanceInLightYears());
                        System.out.println("Temperature: " + star.getTemperature());
                        System.out.println("Mass: " + star.getMass());
                        System.out.println("---------------------------------------------------------");
                    }
                    inputStream.close();
                } catch (IOException | ClassNotFoundException e) {
                    System.err.println("Error loading star from file " + file.getName() + ": " + e.getMessage());
                }
            }
        } else {
            System.out.println("No stars found.");
        }
        
    }

}

    


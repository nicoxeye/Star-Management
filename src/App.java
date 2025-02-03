import java.util.*;

public class App {
    //map to stash created stars :D
    @SuppressWarnings("FieldMayBeFinal")
    private static Map<String, Star> starsMap = new HashMap<>();

    //list of ALL the stars
    public static ArrayList<Star> starsList = new ArrayList<>();
    
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        while (true) { 
            System.out.println("\n========================================");
            System.out.println("              ☆ STAR MENU ☆            ");
            System.out.println("========================================");
            System.out.println(" [1] > Create a Star");
            System.out.println(" [2] > Search for a Star (by criteria)");
            System.out.println(" [3] > Delete a Star");
            System.out.println(" [4] > Serialise a Star");
            System.out.println(" [5] > Deserialise a Star");
            System.out.println(" [6] X Exit");
            System.out.println("========================================");
            System.out.print(" > Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1 -> {
                    System.out.println("\n=== ☆ Create a New Star ☆ ===");

                    System.out.print("Enter Star Name (e.g., ORI1234): ");
                    String name = scanner.nextLine();
        
                    System.out.print("Enter Constellation Name: ");
                    String constellationName = scanner.nextLine();
                    Constellation constellation = new Constellation(constellationName);
        
                    System.out.print("Enter Hemisphere (N/S): ");
                    String hemisphere = scanner.nextLine().toUpperCase();
                    while (!hemisphere.equals("N") && !hemisphere.equals("S")) {
                        System.out.print("Invalid hemisphere! Enter Hemisphere (N/S): ");
                        hemisphere = scanner.nextLine().toUpperCase();
                    }
        
                    System.out.println("\nEnter Declination (Degrees, Minutes, Seconds): ");
                    System.out.print("Degrees: ");
                    int degrees = scanner.nextInt();
                    System.out.print("Minutes: ");
                    int minutes = scanner.nextInt();
                    System.out.print("Seconds: ");
                    double seconds = scanner.nextDouble();
                    scanner.nextLine();
                    Declination declination = new Declination(degrees, minutes, seconds);
        
                    System.out.println("\nEnter Right Ascension (Hours, Minutes, Seconds): ");
                    System.out.print("Hours: ");
                    int hours = scanner.nextInt();
                    System.out.print("Minutes: ");
                    int raMinutes = scanner.nextInt();
                    System.out.print("Seconds: ");
                    int raSeconds = scanner.nextInt();
                    scanner.nextLine();
                    RightAscension rightAscension = new RightAscension(hours, raMinutes, raSeconds);
        
                    System.out.print("\nEnter Apparent Magnitude (-26.74 to 15): ");
                    double apparentMagnitude = scanner.nextDouble();
        
                    System.out.print("Enter Distance in Light Years: ");
                    double distanceInLightYears = scanner.nextDouble();
        
                    System.out.print("Enter Temperature in Celsius (>2000): ");
                    double temperature = scanner.nextDouble();
        
                    System.out.print("Enter Mass (relative to Sun, 0.1 to 50): ");
                    double mass = scanner.nextDouble();
                    scanner.nextLine();
        
                    try {
                        Star star = new Star(name, constellation, hemisphere, declination, 
                                             rightAscension, apparentMagnitude, 
                                             distanceInLightYears, temperature, mass);
        
                        System.out.println("\n! Star created successfully !");
                        System.out.println("    > Name: " + star.getName());
                        System.out.println("    > Constellation: " + star.getConstellation().getName());
                        System.out.println("    > Catalogue Name: " + star.getCatalogueName());
                        System.out.println("    > Hemisphere: " + star.getHemisphere());
                        System.out.println("    > Declination: " + star.getDeclination());
                        System.out.println("    > Right Ascension: " + star.getRightAscension());
                        System.out.println("    > Apparent Magnitude: " + star.getApparentMagnitude());
                        System.out.println("    > Absolute Magnitude: " + star.getAbsoluteMagnitude());
                        System.out.println("    > Distance: " + star.getDistanceInLightYears() + " light-years");
                        System.out.println("    > Temperature: " + star.getTemperature() + "°C");
                        System.out.println("    > Mass: " + star.getMass() + " solar masses");

                        //for serialisation
                        starsMap.put(name, star);
                        //for searching ([2])
                        starsList.add(star);

                        System.out.println("\n\nClick enter to continue...");
                        scanner.nextLine();
                    } 
                    catch (IllegalArgumentException e) {
                        System.out.println("X Error: " + e.getMessage());
                    }
                    break;

                }

                case 2 -> {
                    /*
                     * IMPORTANT
                     * for the stars to be viewed from point [2] onward they need to be deserialised when the program is restarted!!!
                     * 
                     * [1] works without deserialising because it automatically does so for every star in the folder.
                     * (+ this function is an addition by me and not needed)
                     */
                    System.out.println("=== Star Search Criteria ===");
                    System.out.println("[1]. Display All Stars");
                    System.out.println("[2]. Display Stars In a Constellation");
                    System.out.println("[3]. Search by Temperature Range");
                    System.out.println("[4]. Search by Absolute Magnitude Range");
                    System.out.println("[5]. Search by Hemisphere");
                    System.out.println("[6]. Search by Distance (Parsecs) from Earth");
                    System.out.println("[7]. Search for Supernovas");
                    System.out.println("========================================");
                    System.out.print(" > Choose an option: ");

                    int choice2 = scanner.nextInt();
                    scanner.nextLine();
                
                    switch (choice2) {
                        case 1 -> {
                            // Created this more for myself to see all the stars objects more easily :]
                            Star.DisplayAllStars();
                            System.out.println("\nPress Enter to continue...");
                            scanner.nextLine();
                        }
                
                        case 2 -> {
                            FindStarByConstellation();
                
                            System.out.println("\nPress Enter to continue...");
                            scanner.nextLine();
                        }
                
                        case 3 -> {
                            FindStarByTemperature();
                
                            System.out.println("\nPress Enter to continue...");
                            scanner.nextLine();
                        }
                
                        case 4 -> {
                            FindStarByMagnitude();
                
                            System.out.println("\nPress Enter to continue...");
                            scanner.nextLine();
                        }
                
                        case 5 -> {
                            FindStarByHemisphere();

                            System.out.println("\nPress Enter to continue...");
                            scanner.nextLine();
                        }
                        
                        case 6 -> {
                            FindStarByDistance();
                
                            System.out.println("\nPress Enter to continue...");
                            scanner.nextLine();
                        }

                        case 7 -> {
                            Supernovae();

                            System.out.println("\nPress Enter to continue...");
                            scanner.nextLine();
                        }
                
                        default -> {
                            System.out.println("Invalid option.");
                        }
                    }
                }

                case 3 -> {
                    System.out.print("Enter the Catalogue Name of the Star to delete (e.g., beta Ryb): ");
                    String catalogueName = scanner.nextLine();

                    //deleting it from the folder Stars only!!
                    Star.DeleteStar(catalogueName);

                    // here i delete it from the stars list since the searching in [2] bases on this list...
                    boolean found = false;
                    for (Star star : starsList) {
                        if (star.getCatalogueName().equalsIgnoreCase(catalogueName)) {
                            starsList.remove(star);
                            System.out.println("Star removed from the list: " + catalogueName);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("No star found with the catalogue name: " + catalogueName);
                    }

                    System.out.println("\nPress Enter to continue...");
                    scanner.nextLine();
                }

                case 4 -> {
                    // Serialising and existing Star (created in case 1)

                    System.out.print("Enter the name of the Star you want to serialize (e.g., ORI1234): ");
                    String nameStar = scanner.nextLine();
                
                    if (starsMap.containsKey(nameStar)) {
                        Star.SerialiseStar(starsMap.get(nameStar)); // passing the star object
                        System.out.println("Star serialized successfully :D");
                        System.out.println("\n\nClick enter to continue...");
                        scanner.nextLine();
                    } else {
                        System.out.println("\nStar not found in memory :( \nCreate one by typing [1] in MENU. \nClick enter to continnue...");
                        scanner.nextLine();
                    }
                    break;
                }
                
                case 5 -> {
                    // Deserialising a Star that exists in the /src/Stars folder

                    System.out.print("Enter the name of the Star you want to deserialize (e.g., ORI1234): ");
                    String nameStar = scanner.nextLine();
                
                    Star deserializedStar = Star.DeserialiseStar(nameStar);
                    
                    if (starsList.contains(deserializedStar)) {
                        System.out.println("\nStar already deserialised.");
                    }
                    else if (deserializedStar != null) {
                        starsList.add(deserializedStar);
                        System.out.println("\nStar deserialized successfully :D \nYou can view it by typing [2] in the MENU.");
                    } 
                    else {
                        System.out.println("\nNo such existing Star. Please check the name and try again.");
                    }
                    
                    System.out.println("Click enter to continue...");
                    scanner.nextLine();
                    break;

                }

                case 6 -> {
                    // Exiting the program
                    System.out.println("Closing...");
                    scanner.close();
                    return;
                }

                default -> {
                    System.out.println("Invalid option.");
                }
            }
        }
    }
    

    public static void FindStarByConstellation() {
        System.out.print("\nEnter a Constellation: ");
        String constel = scanner.nextLine();

        boolean found = false;
        for (Star star : starsList) {
            if (star.getConstellation().getName().equals(constel)) {
                System.out.println("Star Name: " + star.getName() + " - Catalogue Name: " + star.getCatalogueName());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No stars found in the constellation: " + constel);
        }
        
    }


    public static void FindStarByTemperature() {
        System.out.print("Enter minimum temperature: ");
        double minTemp = scanner.nextDouble();
        System.out.print("Enter maximum temperature: ");
        double maxTemp = scanner.nextDouble();
        scanner.nextLine();

        boolean found = false;
        for (Star star : starsList) {
            if (star.getTemperature() >= minTemp && star.getTemperature() <= maxTemp) {
                System.out.println("Star Name: " + star.getName() + " - Temperature: " + star.getTemperature() + "°C");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No stars found in the temperature range " + minTemp + "°C to " + maxTemp + "°C.");
        }
        
    }


    public static void FindStarByMagnitude() {
        System.out.print("Enter minimum absolute magnitude: ");
        double minAbMag = scanner.nextDouble();
        System.out.print("Enter maximum absolute magnitude: ");
        double maxAbMag = scanner.nextDouble();
        scanner.nextLine();

        boolean found = false;
        for (Star star : starsList) {
            if (star.getAbsoluteMagnitude() >= minAbMag && star.getAbsoluteMagnitude() <= maxAbMag) {
                System.out.println("Star Name: " + star.getName() + " - Absolute Magnitude: " + star.getAbsoluteMagnitude());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No stars found in the absolute magnitude range " + minAbMag + " to " + maxAbMag);
        }

    }

    public static void FindStarByHemisphere() {
        System.out.print("Enter Hemisphere (N/S): ");
        String hemisphere = scanner.nextLine();

        while (!hemisphere.equals("N") && !hemisphere.equals("S")) {
            System.out.print("Invalid hemisphere! Enter Hemisphere (N/S): ");
            hemisphere = scanner.nextLine().toUpperCase();
        }

        boolean found = false;
        for (Star star : starsList) {
            if (star.getHemisphere().equals(hemisphere)) {
                System.out.println("Star Name: " + star.getName() + " - Hemisphere: " + star.getHemisphere());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No stars found in the " + hemisphere + " hemisphere.");
        }

        
    }


    public static void FindStarByDistance() {
        System.out.print("Enter The Distance In PCs From Earth: ");
        double distance = scanner.nextDouble();

        boolean found = false;
        for (Star star : starsList) {
            if ((star.getDistanceInLightYears() / 3.26) == distance) {
                System.out.println("Star Name: " + star.getName() + " - Distance: " + star.getDistanceInLightYears() + " - Distance In Parsecs: " + (star.getDistanceInLightYears() / 3.26));
                found = true;
            }
        }

        if (!found) {
            System.out.println("No stars found in the distance of " + distance + " parsecs from Earth.");
        }
        
    }

    public static void Supernovae() {
        double chandrasekharLimit = 1.44;
        boolean foundSupernova = false;

        for (Star star : starsList) {
            if (star.getMass() > chandrasekharLimit) {
                System.out.println("Potential Supernova: " + star.getName() + " - Mass: " + star.getMass() + " solar masses");
                foundSupernova = true;
            }
        }

        if (!foundSupernova) {
            System.out.println("No potential supernovae found.");
        }
        
    }


}
    

    

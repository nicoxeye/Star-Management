import java.io.Serializable;

public class Constellation implements Serializable{
    // Any Name: not specified in the project description:D
    private String name;

    public Constellation(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

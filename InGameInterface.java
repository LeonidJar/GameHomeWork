import java.util.ArrayList;

public interface InGameInterface {

    void step(ArrayList<Unit> units1, ArrayList<Unit> units2);

    String getInfo();
    
}
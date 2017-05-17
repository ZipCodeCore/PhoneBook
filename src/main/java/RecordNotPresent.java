import java.io.IOException;

/**
 * Created by aurorabanuelos on 5/17/17.
 */
public class RecordNotPresent extends IOException {

    public RecordNotPresent() {
    }
    public RecordNotPresent(String gripe) {
        super(gripe);
    }
}

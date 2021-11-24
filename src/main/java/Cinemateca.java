import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="cinemateca")
@XmlAccessorType (XmlAccessType.FIELD)
public class Cinemateca {
    private List<Director> directores = null;

    public List<Director> getDirectores() {
        return directores;
    }

    public void setDirectores(List<Director> directorList) {
        this.directores = directorList;
    }
}

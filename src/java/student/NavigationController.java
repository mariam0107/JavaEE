package student;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named
@RequestScoped
public class NavigationController {

    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public NavigationController() {
    }

    public String navigate() {
        if (this.location.equals("Göteborg")) 
            return "confirmation";
         else 
            return "confirmation2"; 

    }
}

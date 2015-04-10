package heritage.canada.com.canadaheritage;

/**
 * Created by student on 4/9/15.
 */
public class Location_list {

    public String name = "";
    public String zone = "";


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setZone(String z) {
        this.zone = z;
    }

    public String getZone() {
        return zone;
    }

    // constructor
    public Location_list(String name,String zo){

        this.name = name;
        this.zone=zo;
    }

    //***** Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return name;
    }

   public Location_list(){

   }
}
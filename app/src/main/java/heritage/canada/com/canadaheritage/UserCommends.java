package heritage.canada.com.canadaheritage;

/**
 * Created by student on 3/20/15.
 */
public class UserCommends {
    public int _id;
    public String name ="";
    public String note ="";

    public UserCommends(){}

    public int getID() {
        return this._id;
    }

    public void setID(int id) {

        this._id = id;
    }

    public void setName(String name){this.name = name;}
    public String getName(){return name;}

    public void setNote(String note){this.note = note;}
    public String getNote(){return note;}


    public UserCommends(int id, String name, String note){
        this._id = id;
        this.name = name;
        this.note = note;

    }

    public String toString() {
        String g = note;

        return g;
    }


}

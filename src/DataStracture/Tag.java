package DataStracture;

public class Tag {

    private int ID;
    private String Name;
    private String Description;

    public Tag(int Id,String name, String description) {
        ID = Id;
        Name = name;
        Description = description;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}

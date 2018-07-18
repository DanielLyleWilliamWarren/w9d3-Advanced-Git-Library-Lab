package models;

public class Borrower {
    private int id;
    private String name;
    private List<books> itemsBorrowed;

    public borrower(String name){
        this.name = name;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<books> getItemsBorrowed() {
        return itemsBorrowed;
    }

    public void setItemsBorrowed(List<books> itemsBorrowed) {
        this.itemsBorrowed = itemsBorrowed;
    }
}

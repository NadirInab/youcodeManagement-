package main.java.com.User;

public class User {
    private int id ;
    private String name ;

    private int memberShipNumber ;

    public User( String name, int memberShipNumber) {
        this.name = name;
        this.memberShipNumber = memberShipNumber;
    }

    public void setMemberShipNumber(int memberShipNumber){
        this.memberShipNumber = memberShipNumber ;
    }

    public int getMemberShipNumber() {
        return memberShipNumber;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id ;
    }

    public String getName(){
        return name ;
    }

    public void setName(String name){
        this.name = name ;
    }
}

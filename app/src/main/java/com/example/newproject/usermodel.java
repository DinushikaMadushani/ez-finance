package com.example.newproject;

public class usermodel {

    private String Vnumber;
    private String Accno;
    private String Mounthlyin ;
    private String Amount;
    private String Cardty;
    private String Cardno ;
    private String Name ;



    public usermodel(String vnumber, String accno, String mounthlyin, String amount, String cardty, String cardno, String name) {
        Vnumber = vnumber;
        Accno = accno;
        Mounthlyin = mounthlyin;
        Amount = amount;
        Cardty = cardty;
        Cardno = cardno;
        Name = name;
    }

    public String getVnumber() {
        return Vnumber;
    }

    public String getAccno() {
        return Accno;
    }

    public String getMounthlyin() {
        return Mounthlyin;
    }

    public String getAmount() {
        return Amount;
    }

    public String getCardty() {
        return Cardty;
    }

    public String getCardno() {
        return Cardno;
    }

    public String getName() {
        return Name;
    }


    public void setVnumber(String vnumber) {
        Vnumber = vnumber;
    }

    public void setAccno(String accno) {
        Accno = accno;
    }

    public void setMounthlyin(String mounthlyin) {
        Mounthlyin = mounthlyin;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public void setCardty(String cardty) {
        Cardty = cardty;
    }

    public void setCardno(String cardno) {
        Cardno = cardno;
    }

    public void setName(String name) {
        Name = name;
    }
}

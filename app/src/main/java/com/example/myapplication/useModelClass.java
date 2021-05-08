package com.example.myapplication;

public class useModelClass {
    private String name;
    private String nic;
    private String address;
    private String con;
    private String mail;
    private String job;
    private String income;


    public useModelClass(String name, String nic, String address, String con, String mail, String job, String income) {
        this.name = name;
        this.nic = nic;
        this.address = address;
        this.con = con;
        this.mail = mail;
        this.job = job;
        this.income = income;
    }

    public String getName()
    {
        return name;
    }

    public String getNic()
    {

        return nic;
    }

    public String getAddress()
    {
        return address;
    }

    public String getCon()
    {
        return con;
    }

    public String getMail()
    {
        return mail;
    }

    public String getJob()
    {
        return job;
    }

    public String getIncome()
    {
        return income;
    }


    public useModelClass(){

    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setNic(String nic)
    {
        this.nic = nic;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setCon(String con)
    {
        this.con = con;
    }

    public void setMail(String mail)
    {
        this.mail = mail;
    }

    public void setJob(String job)
    {
        this.job = job;
    }

    public void setIncome(String income)
    {
        this.income = income;
    }
}

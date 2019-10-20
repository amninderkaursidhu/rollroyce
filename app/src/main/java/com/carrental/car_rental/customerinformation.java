package com.carrental.car_rental;

public class customerinformation {

   private int image;
   private  String Firstname,lastname,username,password,role;

      customerinformation(int image,String Firstname,String lastname,String username,String password,String role)
      {
             this.Firstname=Firstname;
             this.lastname=lastname;
             this.username=username;
             this.password=password;
             this.role=role;
      }

    public int getImage() {
        return image;
    }

    public String getFirstname() {
        return Firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}

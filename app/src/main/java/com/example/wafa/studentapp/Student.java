package com.example.wafa.studentapp;

public class Student {


    public String name ,email , password , phone , username , img , thumb_img ;

    public Student(String name, String email, String password, String phone ,String username ,String img , String thumb_img ){
            this.name= name;
        this.email= email;
        this.password= password;
        this.phone= phone;
        this.username=username;
        this.img=img;
        this.thumb_img= thumb_img;



    }

    public  Student(String name, String email,String phone){
        this.name= name;
        this.email= email;
        this.phone= phone;

    }

    public  Student()
    {}




    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String setEmail(String email) {
        this.email = email;
        return email;
    }





    public String getPassword() {
        return password;
    }

    public String setPassword(String password) {
        this.password = password;
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String setPhone(String phone) {
        this.phone = phone;
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public String setUsername(String username) {
        this.username = username;
        return username;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getThumb_img() {
        return thumb_img;
    }

    public void setThumb_img(String thumb_img) {
        this.thumb_img = thumb_img;
    }

    /*
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    */
}



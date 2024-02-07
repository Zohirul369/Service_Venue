package com.example.service_venue;

public class ViewModel {
    String vname,price,rating,rate,sname,vimage,distance,vaddress,cphone,vphone,cname,caddress,cimage,worktitle,cemail,date;

    ViewModel(){

    }
    public ViewModel(String vname, String price, String rating, String rate, String sname, String vimage, String distance, String vaddress, String cphone, String vphone, String cname, String caddress, String cimage, String worktitle, String cemail, String date) {
        this.vname = vname;
        this.price = price;
        this.rating = rating;
        this.rate = rate;
        this.sname = sname;
        this.vimage = vimage;
        this.distance = distance;
        this.vaddress = vaddress;
        this.cphone = cphone;
        this.vphone = vphone;
        this.cname = cname;
        this.caddress = caddress;
        this.cimage = cimage;
        this.worktitle = worktitle;
        this.cemail = cemail;
        this.date = date;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getVimage() {
        return vimage;
    }

    public void setVimage(String vimage) {
        this.vimage = vimage;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getVaddress() {
        return vaddress;
    }

    public void setVaddress(String vaddress) {
        this.vaddress = vaddress;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    public String getVphone() {
        return vphone;
    }

    public void setVphone(String vphone) {
        this.vphone = vphone;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public String getCimage() {
        return cimage;
    }

    public void setCimage(String cimage) {
        this.cimage = cimage;
    }

    public String getWorktitle() {
        return worktitle;
    }

    public void setWorktitle(String worktitle) {
        this.worktitle = worktitle;
    }

    public String getCemail() {
        return cemail;
    }

    public void setCemail(String cemail) {
        this.cemail = cemail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

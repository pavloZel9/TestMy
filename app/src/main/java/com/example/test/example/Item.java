package com.example.test.example;

public class Item {

    String Name;
    String Url;
    Double price;
    Double old_price;
    int rating;
    int len_rating;
    public Item(String Name, String url_image, double price, double old_price, int rating, int len_rating) {
        this.Name = Name;
        this.Url = url_image;
        this.price = price;
        this.old_price = old_price;
        this.rating = rating;
        this.len_rating = len_rating;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getOld_price() {
        return old_price;
    }

    public void setOld_price(Double old_price) {
        this.old_price = old_price;
    }




    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating_size() {
        return len_rating;
    }

    public void setRating_size(int len_rating) {
        this.len_rating = len_rating;
    }

}

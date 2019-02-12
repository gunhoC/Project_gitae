package com.example.choi.project_gitae;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;

public class Compo {
        private String image_url;
        private String book_text;
        private String book_price;

    public Compo(String image_url, String book_text, String book_price) {
        this.image_url = image_url;
        this.book_text = book_text;
        this.book_price = book_price;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getBook_text() {
        return book_text;
    }

    public void setBook_text(String book_text) {
        this.book_text = book_text;
    }

    public String getBook_price() {
        return book_price;
    }

    public void setBook_price(String book_price) {
        this.book_price = book_price;
    }
}

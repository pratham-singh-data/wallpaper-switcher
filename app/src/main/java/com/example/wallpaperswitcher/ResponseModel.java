package com.example.wallpaperswitcher;

import java.util.ArrayList;

public class ResponseModel {
    private ArrayList<ImageModel> photos;

    public ResponseModel(ArrayList<ImageModel> photos) {
        this.photos = photos;
    }

    public ArrayList<ImageModel> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<ImageModel> photos) {
        this.photos = photos;
    }
}

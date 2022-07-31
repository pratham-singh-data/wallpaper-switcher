package com.example.wallpaperswitcher;

public class ImageModel {
    private SrcModel src;

    public ImageModel(SrcModel src) {
        this.src = src;
    }

    public SrcModel getSrc() {
        return src;
    }

    public void setSrc(SrcModel src) {
        this.src = src;
    }
}

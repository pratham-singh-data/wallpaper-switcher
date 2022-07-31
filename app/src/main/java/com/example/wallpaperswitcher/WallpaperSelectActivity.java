package com.example.wallpaperswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.IOException;

public class WallpaperSelectActivity extends AppCompatActivity {
    Intent intent;
    ImageView selectedImage;
    Button applyWallpaperButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper_select);

        intent = getIntent();
        selectedImage = findViewById(R.id.selectedImage);
        applyWallpaperButton = findViewById(R.id.applyWallpaperButton);

        String image = intent.getStringExtra("image");

        final WallpaperManager wallpaperManager = WallpaperManager.getInstance((getApplicationContext()));

        Glide.with(getApplicationContext()).load(image).into(selectedImage);
        applyWallpaperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Bitmap bitmap = ((BitmapDrawable) selectedImage.getDrawable()).getBitmap();
                    wallpaperManager.setBitmap(bitmap);
                    Toast.makeText(WallpaperSelectActivity.this, "Wallpaper Added Successfully", Toast.LENGTH_SHORT).show();
                }
                catch(IOException e){
                    Toast.makeText(WallpaperSelectActivity.this, "Error Occurred", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
    }
}
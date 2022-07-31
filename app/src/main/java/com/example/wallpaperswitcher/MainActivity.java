package com.example.wallpaperswitcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ImageModel> imageList;
    RecyclerView wallpaperRecycler;
    Adapter adapter;

    CardView natureCard;
    CardView abstractCard;
    CardView spaceCard;
    CardView trendingCard;
    CardView seaCard;
    CardView cityCard;

    EditText searchEditText;
    ImageButton searchImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wallpaperRecycler = findViewById(R.id.wallpaperRecycler);

        natureCard = findViewById(R.id.natureCard);
        abstractCard = findViewById(R.id.abstractCard);
        spaceCard = findViewById(R.id.spaceCard);
        trendingCard = findViewById(R.id.trendingCard);
        cityCard = findViewById(R.id.cityCard);
        seaCard = findViewById(R.id.seaCard);

        searchEditText = findViewById(R.id.searchEditText);
        searchImageButton = findViewById(R.id.searchImageButton);

        imageList = new ArrayList<>();
        wallpaperRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        wallpaperRecycler.setHasFixedSize(true);

        adapter = new Adapter(getApplicationContext(), imageList);
        wallpaperRecycler.setAdapter(adapter);

        findImages();

        natureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = "nature";
                getSearchedImage(query);
            }
        });

        abstractCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = "abstract";
                getSearchedImage(query);
            }
        });

        seaCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = "sea";
                getSearchedImage(query);
            }
        });

        cityCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = "city";
                getSearchedImage(query);
            }
        });

        spaceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = "space";
                getSearchedImage(query);
            }
        });

        trendingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findImages();
            }
        });

        searchImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = searchEditText.getText().toString();

                if(query.isEmpty()){
                    Toast.makeText(MainActivity.this, "No query Enterred", Toast.LENGTH_SHORT).show();
                    return;
                }

                getSearchedImage(query);
            }
        });
    }

    private void getSearchedImage(String query) {
        ApiUtilities.getApiInterface().getImages(query, 1, 80).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                imageList.clear();

                if(response.isSuccessful()){
                    imageList.addAll(response.body().getPhotos());
                    adapter.notifyDataSetChanged();
                }
                else{
                    Toast.makeText(MainActivity.this, "Error Fetching Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error Fetching Data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void findImages() {
        ApiUtilities.getApiInterface().getImages(1, 80).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                imageList.clear();

                if(response.isSuccessful()){
                    imageList.addAll(response.body().getPhotos());
                    adapter.notifyDataSetChanged();
                }
                else{
                    Toast.makeText(MainActivity.this, "Error Fetching Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error Fetching Data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
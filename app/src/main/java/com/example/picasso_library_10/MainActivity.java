package com.example.picasso_library_10;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
ImageView img;
Button btn,btn1;
int i = 0;

String [] urls = {
        "https://img.freepik.com/free-photo/halloween-scene-illustration-anime-style_23-2151794318.jpg",
        "https://img.freepik.com/free-photo/anime-style-portrait-traditional-japanese-samurai-character_23-2151499089.jpg",
        "https://img.freepik.com/free-photo/anime-style-portrait-traditional-japanese-samurai-character_23-2151499075.jpg",
        "https://img.freepik.com/free-photo/mythical-dragon-beast-anime-style_23-2151112840.jpg",
        "https://img.freepik.com/free-photo/anime-style-mythical-dragon-creature_23-2151112760.jpg",
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn = findViewById(R.id.btn);
        btn1 = findViewById(R.id.btn1);

        img = findViewById(R.id.img);

        Picasso.get().load(urls[i]).into(img);

        btn1.setOnClickListener(view -> {
            if (i < urls.length -1){
                i++;
            }
            Picasso.get().load(urls[i]).into(img);
        });
        btn.setOnClickListener(view -> {
            if ( 0<i){
                i--;
            }
            Picasso.get().load(urls[i]).into(img);
        });


    }
}
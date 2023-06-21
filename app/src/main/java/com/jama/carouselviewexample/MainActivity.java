package com.jama.carouselviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jama.carouselview.CarouselView;
import com.jama.carouselview.CarouselViewListener;
import com.jama.carouselview.enums.OffsetType;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

  CarouselView carouselView;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    carouselView = findViewById(R.id.carouselView);

    List<Integer> images = new ArrayList<>();
    images.add(R.drawable.boardwalk_by_the_ocean);
    images.add(R.drawable.tying_down_tent_fly);
    images.add(R.drawable.journal_and_coffee_at_table);

    carouselView.setSize(images.size());
    carouselView.setAutoPlay(false);
    carouselView.setResource(R.layout.center_carousel_item);
    carouselView.hideIndicator(true);
    carouselView.setCarouselOffset(OffsetType.CENTER);
    carouselView.setCarouselViewListener(new CarouselViewListener() {
      @Override
      public void onBindView(View view, int position) {
        Log.e("test", "bind " + position);
        // Example here is setting up a full image carousel
        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageResource(images.get(position));


        imageView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            carouselView.setCurrentItem(position);
          }
        });
      }
    });

    carouselView.show();

  }
}

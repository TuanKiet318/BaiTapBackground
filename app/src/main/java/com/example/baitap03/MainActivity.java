package com.example.baitap03;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private final int[] images = {
            R.drawable.bg1,
            R.drawable.bg2,
            R.drawable.bg3
    };

    private ImageView backgroundImage;
    private Switch switchBackground;
    private Random random = new Random();
    private int currentImageIndex = -1;  // Lưu ảnh hiện tại

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        backgroundImage = findViewById(R.id.backgroundImage);
        switchBackground = findViewById(R.id.switchBackground);

        // Đổi hình nền khi mở app
        changeBackground();

        // Khi bấm vào Switch, đổi ảnh nền (không trùng ảnh cũ)
        switchBackground.setOnCheckedChangeListener((buttonView, isChecked) -> changeBackground());
    }

    // Đổi hình nền ngẫu nhiên, đảm bảo không trùng ảnh cũ
    private void changeBackground() {
        int newImageIndex;
        do {
            newImageIndex = random.nextInt(images.length);
        } while (newImageIndex == currentImageIndex); // Lặp lại nếu trùng ảnh cũ

        currentImageIndex = newImageIndex; // Lưu ảnh mới
        backgroundImage.setBackgroundResource(images[currentImageIndex]);
    }
}
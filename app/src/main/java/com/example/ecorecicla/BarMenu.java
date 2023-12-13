package com.example.ecorecicla;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageButton;

public class BarMenu {
    public ImageButton btnHome;
    public ImageButton btnCategories;
    public ImageButton btnEstadistics;
    public ImageButton btnConsejos;

    public BarMenu(ImageButton btnHome, ImageButton btnCategories, ImageButton btnEstadistics, ImageButton btnConsejos) {
        this.btnHome = btnHome;
        this.btnCategories = btnCategories;
        this.btnEstadistics = btnEstadistics;
        this.btnConsejos = btnConsejos;
    }

    public void goToHome(ImageButton btnHome, final Context context) {
    btnHome.setOnClickListener(v -> {
        Intent intent = new Intent(context, Home.class);
        context.startActivity(intent);
    });
    }

    public void goToCategories(ImageButton btnCategories, final Context context) {
    btnCategories.setOnClickListener(v -> {
        Intent intent = new Intent(context, categoryMenu.class);
        context.startActivity(intent);
    });
    }

    public void goToEstadistics(ImageButton btnEstadistics, final Context context) {
    btnEstadistics.setOnClickListener(v -> {
        Intent intent = new Intent(context, Estadisitica.class);
        context.startActivity(intent);
    });
    }

    public void goToConsejos(ImageButton btnConsejos, final Context context) {
    btnConsejos.setOnClickListener(v -> {
        Intent intent = new Intent(context, Consejos.class);
        context.startActivity(intent);
    });
    }

}

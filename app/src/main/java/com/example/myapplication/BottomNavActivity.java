package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);

        /**
         View viewTransactionsAction = findViewById(R.id.nav_host_fragment_activity_main);

         viewTransactionsAction.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("someData", 14);
        Navigation.findNavController(view).navigate(R.id.action_navigation_dashboard_to_navigation_home, bundle);
        }
        }); */

        BottomNavigationView navView = findViewById(R.id.navView);


        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.
                findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }
}
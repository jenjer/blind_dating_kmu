package com.example.myapplication;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_chatting, R.id.navigation_hearts).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

    }
/* 쓸대없는코드인데 어디에쓰는거야? 주석처리해도 잘 돌아감
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Actionbar item click event
        // Move to UserSettings Intent
        int id = item.getItemId();
//        if (id == R.id.user_settings){
//            Intent user_setting_activity = new Intent(getApplicationContext(), UserSettingsFragment.class);
//            startActivity(user_setting_activity);
//        }
        return super.onOptionsItemSelected(item);
    }*/

}
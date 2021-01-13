package com.example.fresherslivecompany.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.fresherslivecompany.R;
import com.example.fresherslivecompany.fragment.AboutUsFragment;
import com.example.fresherslivecompany.fragment.ApplicationFragment;
import com.example.fresherslivecompany.fragment.ContactUsFragment;
import com.example.fresherslivecompany.fragment.EditProfFragment;
import com.example.fresherslivecompany.fragment.JobFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private NavigationView navigationView;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.compToolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.nav_drawerLayout);
        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, R.string.open_navigation_drawer, R.string.close_navigation_drawer
        );

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ApplicationFragment applicationFragment = new ApplicationFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer,applicationFragment).commit();

        navigationView = (NavigationView) findViewById(R.id.compNavigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                Fragment fragment = null;
                switch (id){
                    case R.id.compStudentsApplication :
                        fragment = new ApplicationFragment();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.compJob :
                        fragment = new JobFragment();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.compEditProf :
                        fragment = new EditProfFragment();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.compContactUs :
                        fragment = new ContactUsFragment();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.compAboutUs :
                        fragment = new AboutUsFragment();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }

                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragmentContainer,fragment).commit();
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.popmenu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.logout:
                Toast.makeText(MainActivity.this, "You Clicked Logout", Toast.LENGTH_SHORT).show();
                break;
        }
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    private void showToast(String msg){
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }


}
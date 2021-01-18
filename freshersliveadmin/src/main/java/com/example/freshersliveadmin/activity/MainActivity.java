package com.example.freshersliveadmin.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.freshersliveadmin.R;
import com.example.freshersliveadmin.apputil.SharedPrefManager;
import com.example.freshersliveadmin.fragment.CompReqFragment;
import com.example.freshersliveadmin.fragment.StudentRequestFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private NavigationView navigationView;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    SharedPrefManager sharedPrefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPrefManager =  new SharedPrefManager(this);
        toolbar = (Toolbar) findViewById(R.id.compToolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.nav_drawerLayout);
        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, R.string.open_navigation_drawer, R.string.close_navigation_drawer
        );

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CompReqFragment compReqFragment = new CompReqFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer,compReqFragment).commit();

        navigationView = (NavigationView) findViewById(R.id.compNavigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                Fragment fragment = null;
                switch (id){
                    case R.id.compReq :
                        fragment = new CompReqFragment();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.studentReq :
                        fragment = new StudentRequestFragment();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }

                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragmentContainer,fragment).commit();
                return true;
            }
        });

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.popmenu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.logout:
                if(sharedPrefManager.isCompLogin()){
                    sharedPrefManager.updateAdminLoginStatus(false);
                }
                startActivity(new Intent(MainActivity.this, AdminLoginActivity.class));
                finish();
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

}
package com.example.intdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle barDrawerToggle;
    NavigationView navView;
    ViewPager2 viewPagerH;
    TabLayout tabLayoutH;
    TabItem tabContact, tabImage, tabView;
    ImageView imageView;
    TextView headerText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        String userEmail=signinActivity.getUserEmail();
        Toolbar toolbar=findViewById(R.id.toolbar);
        viewPagerH= findViewById(R.id.viewPager);
        tabLayoutH=findViewById(R.id.tabLayout);
        tabContact=findViewById(R.id.contact);
        tabImage=findViewById(R.id.images);
        tabView=findViewById(R.id.viewImages);
        setSupportActionBar(toolbar);
        drawerLayout=findViewById(R.id.drawerLayout);
        navView=findViewById(R.id.nav_View);
        navView.setNavigationItemSelectedListener(this);
        View navHeader=navView.getHeaderView(0);
        headerText=navHeader.findViewById(R.id.headerTextView);
        headerText.setText(userEmail);

        imageView=findViewById(R.id.imageView);
        barDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(barDrawerToggle);
        barDrawerToggle.setDrawerIndicatorEnabled(true);
        barDrawerToggle.syncState();
        viewPagerH.setAdapter(new PagerAdapter(this));

        TabLayoutMediator tabLayoutMediator=new TabLayoutMediator(
                tabLayoutH, viewPagerH, new TabLayoutMediator.OnConfigureTabCallback() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:{
                        tab.setText("ContactUs");
                        break;
                    }
                    case 1:{
                        tab.setText("Images");
                        break;
                    }
                    case 2:{
                        tab.setText("View Images");
                        break;
                    }

                }
            }
        }
        );
        tabLayoutMediator.attach();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){
        drawerLayout.closeDrawer(GravityCompat.START);
        if(item.getItemId() == R.id.itemLogout){
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        return false;
    }
}


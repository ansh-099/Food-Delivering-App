package com.example.anshulsingh.foodpilu;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.Target;
import com.infideap.drawerbehavior.AdvanceDrawerLayout;
import com.squareup.picasso.Picasso;

public class Dashboard extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    AdvanceDrawerLayout drawer;
    Toolbar toolbar;
    final int SHOWCASEVIEW_ID = 28;
    private static final String SHOWCASE_ID = "simple example";
    private boolean hasManualPostion = false;
    private int xPosition, yPosition, width;
    ImageView image1,image2,image3,image4,imagebig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Button next1= findViewById(R.id.next5);
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Dashboard.this,ProfilePage.class);
                startActivity(i);
            }
        });

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Foodpilu");

        image1=findViewById(R.id.image1);
        Picasso.get().load("http://www.cocinayvino.com/wp-content/uploads/2016/09/47701658_l.jpg").into(image1);

        image2= findViewById(R.id.image2);
        Picasso.get().load("https://images.pexels.com/photos/262918/pexels-photo-262918.jpeg?cs=srgb&dl=food-healthy-restaurant-262918.jpg&fm=jpg").into(image2);

        image3=findViewById(R.id.image3);
        Picasso.get().load("https://a0.muscache.com/airbnb/guidebook/v1_grocery_store_hero@2x.jpg").into(image3);

        image4=findViewById(R.id.image4);
        Picasso.get().load("https://timeincsecure-a.akamaihd.net/rtmp_uds/507936866/201703/1047/507936866_5362169819001_5360841529001-vs.jpg?pubId=507936866&videoId=5360841529001").into(image4);

        imagebig=findViewById(R.id.imagebig);



        drawer=findViewById(R.id.drawer_layout);
        drawer = (AdvanceDrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        drawer.setViewScale(Gravity.START, 0.9f);
        drawer.setViewElevation(Gravity.START, 20);
        drawer.setRadius(Gravity.START, 30);
        drawer.useCustomBehavior(Gravity.END);


//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"your icon was clicked",Toast.LENGTH_SHORT).show();
//            }
//        });


        setShowCaseView();

    }

    public void setShowCaseView(){
        Target homeTarget = new Target() {
            @Override
            public Point getPoint() {
                // Get approximate position of home icon's center
                int actionBarSize = toolbar.getHeight();
                int x = actionBarSize /2 ;
                int y = actionBarSize /2 ;
                return new Point(x, y);
            }
        };
        new ShowcaseView.Builder(this)
                .setContentTitle("Welcome to Foodpilu")
                .setContentText("Here You can manage your orders")
                .setTarget(homeTarget)
                .build();
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_settings){
            return true;
        }



        return super.onOptionsItemSelected(item);
    }

}

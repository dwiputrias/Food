package com.dwiputri.greatfood;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.dwiputri.greatfood.CRUD.Tambah;
import com.dwiputri.greatfood.CRUD_Survey.Tambah_survey;
import com.dwiputri.greatfood.Fragment.Frag_Diskon;
import com.dwiputri.greatfood.Fragment.Frag_Terbaru;
import com.dwiputri.greatfood.Fragment.TabAdapter;
import com.dwiputri.greatfood.SQLite.Login;
import com.dwiputri.greatfood.SQLite.Register;
import com.dwiputri.greatfood.SQLite.UsersList;
import com.dwiputri.greatfood.Service.Services;
import com.dwiputri.greatfood.WebService.WebServices;

public class Awal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ViewFlipper v_flipper;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Menerapkan TabLayout dan ViewPager pada Activity
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.viewPager);

        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new Frag_Diskon(), "Diskon");
        adapter.addFragment(new Frag_Terbaru(), "Terbaru");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        int images[] = {R.drawable.fd1, R.drawable.fd2, R.drawable.fd3,
                R.drawable.fd4, R.drawable.fd5};
        v_flipper = findViewById(R.id.v_flipper);

        for (int i =0; i<images.length; i++){
            fliverImages(images[i]);
        }
        for (int image: images)
            fliverImages(image);
    }

    public  void  fliverImages(int images){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(images);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this,android.R.anim.slide_out_right);

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to Exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user pressed "yes", then he is allowed to exit from application
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user select "No", just cancel this dialog and continue with app
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.awal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_tambah) {
            Intent i = new Intent (Awal.this, Tambah.class);
            startActivity(i);
            Toast.makeText(this, "Create Data", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action_tambah_survey) {
            Intent i = new Intent (Awal.this, Tambah_survey.class);
            startActivity(i);
            Toast.makeText(this, "Create Data", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action_faq) {
            Toast.makeText(this, "FAQ", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.question) {
            Toast.makeText(this, "Question", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.recommendation) {
            Toast.makeText(this, "Recommendation", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action_account) {

        } else if (id == R.id.profile) {
            Intent i = new Intent (Awal.this, UsersList.class);
            startActivity(i);
            Toast.makeText(this, "All Account", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.logout) {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setMessage("Do you want to Exit?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //if user pressed "yes", then he is allowed to exit from application
                    finish();
                }

            });

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //if user select "No", just cancel this dialog and continue with app
                    dialog.cancel();
                }
            });
//
//            android.app.AlertDialog alert = builder.create();
//            alert.show();
//            Toast.makeText(this, "Berhasil Keluar", Toast.LENGTH_SHORT).show();

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_lokasi_makanan) {
            Intent i = new Intent (Awal.this, WebServices.class);
            startActivity(i);
            Toast.makeText(this, "Daftar Lokasi", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_survey_makanan) {
            Intent i = new Intent(Awal.this, Services.class);
            startActivity(i);
            Toast.makeText(this, "Hasil Survey", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_shopping_cart) {
            Toast.makeText(this, "Keranjang", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_contact) {
            Intent i = new Intent (Awal.this,Contact.class);
            startActivity(i);
            Toast.makeText(this, "Contact", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_register) {
            Intent i = new Intent (Awal.this, Register.class);
            startActivity(i);
            Toast.makeText(this, "Register", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_login) {
            Intent i = new Intent (Awal.this, Login.class);
            startActivity(i);
            Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

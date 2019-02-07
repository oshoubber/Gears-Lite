package me.oshoubber.gearslite;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign Buttons
        Button mButton1 = (Button) findViewById(R.id.dfc);
        Button mButton2 = (Button) findViewById(R.id.rti);
        Button mButton3 = (Button) findViewById(R.id.st);
        FloatingActionButton mFloatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        // Navigation Drawer Button
        DrawerLayout mDrawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                         break;
                    case R.id.FaultCodes:
                        Intent intentFaultCodes = new Intent(MainActivity.this, FaultCodeActivity.class);
                        startActivity(intentFaultCodes);
                        break;
                    case R.id.LiveInformation:
                        final AlertDialog.Builder pro1Dialog = new AlertDialog.Builder(MainActivity.this);
                        pro1Dialog.setTitle("Gears Pro");
                        pro1Dialog.setMessage("This feature is only available to Gears Pro users.");
                        pro1Dialog.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                            }
                        });
                        pro1Dialog.setPositiveButton("Play Store", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + "me.oshoubber.gears")));
                            }
                        });
                        pro1Dialog.setCancelable(true);
                        pro1Dialog.show();
                        break;
                    case R.id.SystemTesting:
                        final AlertDialog.Builder pro2Dialog = new AlertDialog.Builder(MainActivity.this);
                        pro2Dialog.setTitle("Gears Pro");
                        pro2Dialog.setMessage("This feature is only available to Gears Pro users.");
                        pro2Dialog.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                            }
                        });
                        pro2Dialog.setPositiveButton("Play Store", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + "me.oshoubber.gears")));
                            }
                        });
                        pro2Dialog.setCancelable(true);
                        pro2Dialog.show();
                        break;
                    case R.id.Feedback:
                        Intent intentFeedback = new Intent (MainActivity.this, FeedbackActivity.class);
                        startActivity(intentFeedback);
                        break;
                }
                return false;
            }
        });
        mToggle = new ActionBarDrawerToggle(this, mDrawerlayout, R.string.open, R.string.close);
        mDrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // Bluetooth FAB
        mFloatingActionButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intentBluetooth = new Intent();
                intentBluetooth.setAction(android.provider.Settings.ACTION_BLUETOOTH_SETTINGS);
                startActivity(intentBluetooth);
            }
        });

        // Start the Fault Code Activity
        mButton1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intentFaultCodes = new Intent(MainActivity.this, FaultCodeActivity.class);
                startActivity(intentFaultCodes);
            }
        });

        // Start the Live Data Activity
        mButton2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final AlertDialog.Builder pro3Dialog = new AlertDialog.Builder(MainActivity.this);
                pro3Dialog.setTitle("Gears Pro");
                pro3Dialog.setMessage("This feature is only available to Gears Pro users.");
                pro3Dialog.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                pro3Dialog.setPositiveButton("Play Store", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + "me.oshoubber.gears")));
                    }
                });
                pro3Dialog.setCancelable(true);
                pro3Dialog.show();
            }
        });

        // Start the System Testing Activity
        mButton3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final AlertDialog.Builder pro4Dialog = new AlertDialog.Builder(MainActivity.this);
                pro4Dialog.setTitle("Gears Pro");
                pro4Dialog.setMessage("This feature is only available to Gears Pro users.");
                pro4Dialog.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                pro4Dialog.setPositiveButton("Play Store", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + "me.oshoubber.gears")));
                    }
                });
                pro4Dialog.setCancelable(true);
                pro4Dialog.show();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Navigation Drawer Button
        return (mToggle.onOptionsItemSelected(item)) || super.onOptionsItemSelected(item);
    }

}

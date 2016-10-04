package in.keepcalmandbehealthywith.yogaplus;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.sa90.materialarcmenu.ArcMenu;
import com.sa90.materialarcmenu.StateChangeListener;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ArcMenu arcMenuAndroid;
  //  CollapsingToolbarLayout collapsingToolbarLayout;

    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (activeNetwork != null) { // connected to the internet
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                // connected to wifi
                haveConnectedWifi=true;
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                // connected to the mobile provider's data plan
                haveConnectedMobile=true;
            }
        }
        return haveConnectedWifi || haveConnectedMobile;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInstancesDrawer();
        arcMenuAndroid = (ArcMenu) findViewById(R.id.arcmenu_android_example_layout);
        arcMenuAndroid.setStateChangeListener(new StateChangeListener() {
            @Override
            public void onMenuOpened() {
                FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.fab_arc_menu_1);
                fab1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                });
                FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab_arc_menu_2);
                fab2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                });
                FloatingActionButton fab3 = (FloatingActionButton) findViewById(R.id.fab_arc_menu_3);
                fab3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this,AboutActivity.class);
                        startActivity(intent);
                    }
                });


            }
            @Override
            public void onMenuClosed() {
                //TODO something when menu is closed
            }
        });

         if (!haveNetworkConnection()) {

            // Display message in dialog box if you have not internet connection
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("No Internet Connection");
            alertDialogBuilder.setMessage("You are offline please check your internet connection");
            Toast.makeText(MainActivity.this, "No Internet Connection", Toast.LENGTH_LONG).show();
            alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    //Toast.makeText(MainActivity.this,"No Internet Connection",Toast.LENGTH_LONG).show();
                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        }
    }
    public  void upa_yoga_lists_method(View view)
    {
        Intent intent = new Intent(MainActivity.this,upa_yoga_lists.class);
        startActivity(intent);
        overridePendingTransition(R.anim.right_in,R.anim.left_out);
    }
    public void speech_lists_method(View view)
    {
        Intent intent = new Intent(MainActivity.this,YoutubeActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.right_in,R.anim.left_out);
    }
    private void initInstancesDrawer() {

        toolbar = (Toolbar) findViewById(R.id.anim_toolbar);
        setSupportActionBar(toolbar);

     //   collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
     //   collapsingToolbarLayout.setTitle("Upa-Yoga");
    }
}

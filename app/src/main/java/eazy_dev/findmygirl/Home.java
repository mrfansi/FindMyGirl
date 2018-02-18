package eazy_dev.findmygirl;

import android.content.pm.ActivityInfo;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Home extends FragmentActivity implements OnMapReadyCallback {

    // Button
    private FloatingActionButton fab_opsi, fab_profil;
    private Animation FabOpen, FabClose, FabRClockWise, FabRAntiClockWise;
    private Boolean isOpen = false;

    private double latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Button
        fab_opsi = findViewById(R.id.opsi_btn);
        fab_profil = findViewById(R.id.profil_btn);

        // Animation
        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        FabClose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        FabRClockWise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);
        FabRAntiClockWise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anticlockwise);


        setRequestedOrientation(ActivityInfo
                .SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_home);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        fab_opsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isOpen) {
                    fab_profil.startAnimation(FabClose);
                    fab_profil.setClickable(false);

                    isOpen = false;
                } else {
                    fab_profil.startAnimation(FabOpen);
                    fab_profil.setClickable(true);

                    isOpen = true;
                }
            }
        });
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng myPosition = new LatLng(-6.143239, 106.724116);
        googleMap.addMarker(new MarkerOptions().position(myPosition).title("Marker My Position"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(myPosition));
    }

}

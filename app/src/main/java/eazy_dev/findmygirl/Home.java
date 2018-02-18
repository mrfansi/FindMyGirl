package eazy_dev.findmygirl;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class Home extends AppCompatActivity {

    // Button
    private FloatingActionButton fab_opsi, fab_profil;
    private Animation FabOpen, FabClose, FabRClockWise, FabRAntiClockWise;
    private Boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        // Button
        fab_opsi = findViewById(R.id.opsi_btn);
        fab_profil = findViewById(R.id.profil_btn);

        // Animation
        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        FabClose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        FabRClockWise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);
        FabRAntiClockWise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anticlockwise);



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

        fab_profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profilIntent = new Intent(Home.this, Profile.class);
                startActivity(profilIntent);

                finish();
            }
        });
    }
}

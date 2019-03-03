package edu.gatech.cs2340.game.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import edu.gatech.cs2340.game.R;
import edu.gatech.cs2340.game.entity.Ship;
import edu.gatech.cs2340.game.entity.Universe;
import edu.gatech.cs2340.game.models.Model;
import edu.gatech.cs2340.game.viewmodels.AddNewPlayerViewModel;
import edu.gatech.cs2340.game.viewmodels.UniverseViewModel;

public class GameActivity extends AppCompatActivity {

    private UniverseViewModel universeViewModel;
    private AddNewPlayerViewModel addNewPlayerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        addNewPlayerViewModel = ViewModelProviders.of(this).get(AddNewPlayerViewModel.class);

        universeViewModel = ViewModelProviders.of(this).get(UniverseViewModel.class);
        universeViewModel.initializeUniverse();
        Universe u = universeViewModel.getUniverse();
        Ship newShip = new Ship("Gnat", 20);
        newShip.setCurrentSS(universeViewModel.getRandomSS());
        addNewPlayerViewModel.setCurrentShip(newShip);


        Log.i("Universe created:\n", u.toString());
        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this,
                R.style.Theme_MaterialComponents_Dialog_Alert);
        builder.setTitle("Success")
                .setMessage("Universe created:\n" + u.toString())
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}

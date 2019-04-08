package edu.gatech.cs2340.game.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.gatech.cs2340.game.R;
import edu.gatech.cs2340.game.entity.Ship;
import edu.gatech.cs2340.game.entity.SolarSystem;
import edu.gatech.cs2340.game.entity.Universe;
import edu.gatech.cs2340.game.models.Model;
import edu.gatech.cs2340.game.viewmodels.AddNewPlayerViewModel;
import edu.gatech.cs2340.game.viewmodels.UniverseViewModel;

public class GameActivity extends AppCompatActivity {

    private TextView balanceText;
    private TextView fuelText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        AddNewPlayerViewModel addNewPlayerViewModel = ViewModelProviders.of(this).get(AddNewPlayerViewModel.class);

        UniverseViewModel universeViewModel = ViewModelProviders.of(this).get(UniverseViewModel.class);
        Universe u = universeViewModel.getUniverse();
        Ship newShip = Model.getInstance().getPlayerInteractor().getPlayer().getShip();
        SolarSystem currentSS = newShip.getCurrentSS();
        if (currentSS == null) {
            newShip = new Ship("Gnat", 20, 4000);
            currentSS = universeViewModel.getRandomSS();
        }
        newShip.setCurrentSS(currentSS);
        addNewPlayerViewModel.setCurrentShip(newShip);


        //Log.i("Universe created:\n", u.toString());
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
        Button marketplaceButton = findViewById(R.id.marketplaceButton);
        marketplaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent marketplaceIntent = new Intent(GameActivity.this, MarketplaceActivity.class);
                startActivity(marketplaceIntent);
            }
        });

        Button travelButton = findViewById(R.id.travelButton);
        travelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent travelIntent = new Intent(GameActivity.this, TravelActivity.class);
                startActivity(travelIntent);
            }
        });

        balanceText = findViewById(R.id.balanceText);

        fuelText = findViewById(R.id.fuelText);

        Button refuelButton = findViewById(R.id.refuel_button);
        refuelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Model.getInstance().getPlayerInteractor().getPlayer().refuel();
                updateText();
            }
        });

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("main_prefs", Context.MODE_PRIVATE);
                Model.getInstance().getPlayerInteractor().getPlayer().savePlayer(prefs);
                Model.getInstance().getUniverseInteractor().getUniverse().saveUniverse(prefs);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        TextView currentSStext = findViewById(R.id.current_ss_text);
        SolarSystem currentSS = Model.getInstance().getPlayerInteractor().getPlayer().getShip().getCurrentSS();
        currentSStext.setText("Current solar system: " + currentSS.getName());
        updateText();
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    private void updateText() {
        balanceText.setText("Balance: " + Model.getInstance().getPlayerInteractor().getPlayer().getBalance());
        fuelText.setText("Fuel: " + Model.getInstance().getPlayerInteractor().getPlayer().getFuelCellLevel());
    }
}

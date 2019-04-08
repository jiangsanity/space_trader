package edu.gatech.cs2340.game.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import edu.gatech.cs2340.game.R;
import edu.gatech.cs2340.game.entity.LeakFuelRandomEvent;
import edu.gatech.cs2340.game.entity.Player;
import edu.gatech.cs2340.game.entity.PriceSurgeRandomEvent;
import edu.gatech.cs2340.game.entity.SolarSystem;
import edu.gatech.cs2340.game.models.Model;
import edu.gatech.cs2340.game.viewmodels.TravelViewModel;

public class TravelActivity extends AppCompatActivity implements SSItemFragment.OnListFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);
        //Display the availableFlyPoints gui stuff here

        Toolbar myToolbar = findViewById(R.id.travelToolbar);
        setSupportActionBar(myToolbar);

        //how to take care of when no solar systems are in range???
        //the method should take care of it from here
        //travelViewModel.fly(selection);

        TextView balanceView = findViewById(R.id.fuelTitle);
        Player player = Model.getInstance().getPlayerInteractor().getPlayer();
        balanceView.setText("Fuel: " + player.getShip().getFuelCellLevel());
    }

    @Override
    public void onListFragmentInteraction(final SolarSystem system) {
        //"Fly" has been pressed
        Log.i("clicked", system.getName());

        final TravelViewModel travelViewModel;
        travelViewModel = ViewModelProviders.of(this).get(TravelViewModel.class);

        final PriceSurgeRandomEvent psre = new PriceSurgeRandomEvent(Model.getInstance().getPlayerInteractor().getPlayer());
        final LeakFuelRandomEvent lfre = new LeakFuelRandomEvent(Model.getInstance().getPlayerInteractor().getPlayer());

        if (psre.roll()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(TravelActivity.this,
                    R.style.Theme_MaterialComponents_Dialog_Alert);
            builder.setTitle("Random Event!")
                    .setMessage(psre.getMessage())
                    .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            travelViewModel.fly(system);
                            psre.doEvent();
                            finish();
                        }
                    })
                    .show();
            //shouldn't have to update here but marketplace should have high vals
        } else if (lfre.roll()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(TravelActivity.this,
                    R.style.Theme_MaterialComponents_Dialog_Alert);
            builder.setTitle("Random Event!")
                    .setMessage(lfre.getMessage())
                    .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            lfre.doEvent();
                            travelViewModel.fly(system);
                            finish();
                        }
                    })
                    .show();
        } else {
            travelViewModel.fly(system);
            finish();
        }
    }
}

package edu.gatech.cs2340.game.views;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;

import edu.gatech.cs2340.game.R;
import edu.gatech.cs2340.game.entity.SolarSystem;
import edu.gatech.cs2340.game.viewmodels.AddNewPlayerViewModel;
import edu.gatech.cs2340.game.viewmodels.TravelViewModel;

public class TravelActivity extends AppCompatActivity implements SSItemFragment.OnListFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);
        //Display the availableFlyPoints gui stuff here



        //how to take care of when no solar systems are in range???
        SolarSystem selection = null; //replace this with gui selection of solar system
        //the method should take care of it from here
        //travelViewModel.fly(selection);
    }

    @Override
    public void onListFragmentInteraction(SolarSystem system) {
        //"Fly" has been pressed
        Log.i("clicked", system.getName());

        TravelViewModel travelViewModel;
        travelViewModel = ViewModelProviders.of(this).get(TravelViewModel.class);

        travelViewModel.fly(system);
        finish();
    }
}

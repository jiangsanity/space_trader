package edu.gatech.cs2340.game.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import edu.gatech.cs2340.game.R;
import edu.gatech.cs2340.game.entity.Player;
import edu.gatech.cs2340.game.models.Model;

public class MarketplaceActivity extends AppCompatActivity implements GoodEntryFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketplace);
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        updateBalance();
    }

    /**
     * updates the balance of the player according to action being taken
     */
    private void updateBalance() {
        TextView balanceView = findViewById(R.id.balanceTitle);
        Player player = Model.getInstance().getPlayerInteractor().getPlayer();
        balanceView.setText("Balance: $" + player.getBalance());
    }

    @Override
    public void onListFragmentInteraction() {
        updateBalance();

    }
}

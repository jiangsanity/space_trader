package edu.gatech.cs2340.game.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import edu.gatech.cs2340.game.models.Model;
import edu.gatech.cs2340.game.models.PlayerInteractor;

public class BuySellViewModel extends AndroidViewModel {
    private PlayerInteractor interactor;

    public BuySellViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getPlayerInteractor();
    }

    public void buy(String item, int n) {
        interactor.buy(item, n);
    }

    public void sell(String item, int n) {
        interactor.sell(item, n);
    }
}

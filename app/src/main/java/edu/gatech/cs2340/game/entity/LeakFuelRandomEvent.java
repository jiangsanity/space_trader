package edu.gatech.cs2340.game.entity;

public class LeakFuelRandomEvent extends RandomEvent {
    private final Player player;

    public LeakFuelRandomEvent(Player p) {
        super(50, "Your ship leaked fuel during travel, you lost 10% of remaining fuel!");
        player = p;
    }

    public void doEvent() {
        int newFuel = (int) (player.getShip().getFuelCellLevel() * 0.90);
        player.getShip().setFuelCellLevel(newFuel);
    }
}

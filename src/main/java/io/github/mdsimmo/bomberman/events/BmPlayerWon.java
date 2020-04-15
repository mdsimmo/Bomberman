package io.github.mdsimmo.bomberman.events;

import io.github.mdsimmo.bomberman.game.Game;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public class BmPlayerWon extends BmEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final Game game;
    private final Player player;

    public BmPlayerWon(Game game, Player player) {
        this.game = game;
        this.player = player;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public Game getGame() {
        return game;
    }

    public Player getPlayer() {
        return player;
    }

}
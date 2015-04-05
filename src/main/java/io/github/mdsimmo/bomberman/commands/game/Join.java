package io.github.mdsimmo.bomberman.commands.game;

import io.github.mdsimmo.bomberman.Game;
import io.github.mdsimmo.bomberman.PlayerRep;
import io.github.mdsimmo.bomberman.commands.Cmd;
import io.github.mdsimmo.bomberman.commands.GameCommand;
import io.github.mdsimmo.bomberman.messaging.Chat;
import io.github.mdsimmo.bomberman.messaging.Text;
import io.github.mdsimmo.bomberman.playerstates.GamePlayingState;

import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Join extends GameCommand {

	public Join(Cmd parent) {
		super(parent);
	}

	@Override
	public Text nameShort() {
		return Text.JOIN_NAME;
	}

	@Override
	public List<String> shortOptions(CommandSender sender, List<String> args) {
		return null;
	}

	@Override
	public boolean runShort(CommandSender sender, List<String> args, Game game) {
		if (args.size() != 0)
			return false;
		if (sender instanceof Player == false) {
			Chat.sendMessage(sender, getMessage(Text.MUST_BE_PLAYER, sender));
			return true;
		}	
		if (game.isPlaying) {
			Chat.sendMessage(sender, getMessage(Text.JOIN_GAME_STARTED, sender).put( "game", game));
			return true;
		}
		PlayerRep rep = PlayerRep.getPlayerRep((Player) sender);
		rep.setActiveGame(game);
		rep.switchStates( new GamePlayingState( rep ) );
		return true;
	}
	
	@Override
	public Permission permission() {
		return Permission.PLAYER;
	}

	@Override
	public Text extraShort() {
		return Text.JOIN_EXTRA;
	}

	@Override
	public Text exampleShort() {
		return Text.JOIN_EXAMPLE;
	}

	@Override
	public Text descriptionShort() {
		return Text.JOIN_DESCRIPTION;
	}

	@Override
	public Text usageShort() {
		return Text.JOIN_USAGE;
	}

}

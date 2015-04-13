package io.github.mdsimmo.bomberman.commands.game.force;

import io.github.mdsimmo.bomberman.Game;
import io.github.mdsimmo.bomberman.PlayerRep;
import io.github.mdsimmo.bomberman.arenabuilder.ArenaGenerator;
import io.github.mdsimmo.bomberman.commands.Cmd;
import io.github.mdsimmo.bomberman.commands.GameCommand;
import io.github.mdsimmo.bomberman.messaging.Chat;
import io.github.mdsimmo.bomberman.messaging.Phrase;
import io.github.mdsimmo.bomberman.messaging.Text;

import java.util.List;

import org.bukkit.command.CommandSender;

public class Reset extends GameCommand {

	public Reset(Cmd parent) {
		super(parent);
	}

	@Override
	public Phrase nameShort() {
		return Text.RESET_NAME;
	}
	
	@Override
	public List<String> shortOptions(CommandSender sender, List<String> args) {
		return null;
	}

	@Override
	public boolean runShort(CommandSender sender, List<String> args, Game game) {
		if (args.size() != 0)
			return false;
		
		for (PlayerRep rep : game.players)
			Chat.sendMessage(getMessage(Text.RESET_SUCCESS_P, rep.getPlayer()).put( "game", game));
		game.stop();
		ArenaGenerator.switchBoard(game.board, game.board, game.box);
		Chat.sendMessage(getMessage(Text.RESET_SUCCESS, sender).put( "game", game));
		return true;
	}

	@Override
	public Permission permission() {
		return Permission.GAME_OPERATE;
	}

	@Override
	public Phrase extraShort() {
		return Text.RESET_EXTRA;
	}

	@Override
	public Phrase exampleShort() {
		return Text.RESET_EXAMPLE;
	}

	@Override
	public Phrase descriptionShort() {
		return Text.RESET_DESCRIPTION;
	}

	@Override
	public Phrase usageShort() {
		return Text.RESET_USAGE;
	}
}

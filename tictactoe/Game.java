package lld.tictactoe;
import java.util.*;

public class Game {

	private final Grid grid;
	private final GameMechanism gameMechanism;
	private final List<Player> listOfPlayers;
	private final InputGenerationStrategy aiGameStrategy;
	
	private Game(GameBuilder builder) {
		this.grid = builder.grid;
		this.gameMechanism = builder.mechanism;
		this.aiGameStrategy = builder.gameStrategy;
		this.listOfPlayers = builder.listOfPlayers;
	}
	
	public Grid getGrid() {
		return grid;
	}
	
	public List<Player> getPlayers() {
		return listOfPlayers;
	}
	
	public InputGenerationStrategy getStrategy() {
		return aiGameStrategy;
	}
	
	public void playGame() {
		gameMechanism.playGame(this);
	}
	
	
	public static class GameBuilder {
	
		protected Grid grid = new Grid(3);
		protected GameMechanism mechanism = new DefaultGameMechanism();
		protected InputGenerationStrategy gameStrategy = null;
		protected List<Player> listOfPlayers = new ArrayList<>();
		
		public GameBuilder() {
		}
		
		public GameBuilder setGrid(Grid newGrid) {
			this.grid = newGrid;
			return this;
		}
		
		public GameBuilder setGameMechanism(GameMechanism newMechanism) {
			this.mechanism = newMechanism;
			return this;
		}
		
		public GameBuilder setCustomAiGameStrategy(InputGenerationStrategy gameStrategy) {
			this.gameStrategy = gameStrategy;
			return this;
		}
		
		public GameBuilder addHumanPlayers(List<Player> users) {
			listOfPlayers.addAll(users);
			return this;
		}
		
		public GameBuilder addAiPlayers(List<Player> users) {
			listOfPlayers.addAll(users);
			this.gameStrategy = new DefaultAiGameInputGenerator();
			return this;
		}
		
		public Game build() {
			return new Game(this);
		}
	
	}
}



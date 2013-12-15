package plugins.SuperSmashBros.Main;

public class ArenaManager {
	private static ArenaManager am = new ArenaManager();
	
	public static ArenaManager getManager(){
		return am;
	}
	public Arena getArena(String name){
		for (Arena a : Arena.arenaObjects){
			if(a.getName().equals(name)){
				return a;
			}
		}
		return null;
	}

}

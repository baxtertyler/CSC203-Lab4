import java.sql.Array;
import java.util.*;

public final class CommunityLSim {
   //instance variables
  ArrayList<Player> players; 
  int numPeeps;
  Random random = new Random();
  //TODO: you will need to add more instance variables
  ArrayList<Integer> whoPlays;

  //Constructor
  public CommunityLSim( int numP) {
		numPeeps = numP;
		//create the players
  		players = new ArrayList<Player>();

		//generate a community of 30
		for (int i = 0; i < numPeeps; i++) {
			if (i < numPeeps/2.0)
				players.add(new Player(PlayerKind.POORLY_PAID, (float)(99+Math.random()))); 
			else
				players.add(new Player(PlayerKind.WELL_PAID, (float)(100.1+Math.random()))); 
		}
	
	}

	public int getSize() {return numPeeps;	}

	public Player getPlayer(int i) {return players.get(i);	}
   // TODO
	public void addPocketChange() {
	  for(Player p : players)
	  {
		  if (p.getKind() == PlayerKind.WELL_PAID)
		  {
			  p.addMoney(0.1f);
		  }
		  if (p.getKind() == PlayerKind.POORLY_PAID)
		  {
			  p.addMoney(0.03f);
		  }
	  }
   
   }

	private void reDoWhoPlays() {
	  	whoPlays = new ArrayList<>();
		int numpp = (int) (numPeeps * 0.6);
		this.randomUniqIndx(numpp, 0, numPeeps/2);
		int numwp = (int) (numPeeps * 0.4);
		this.randomUniqIndx(numpp, numPeeps/2, numPeeps);
	}

	/*TODO generate some random indices for who might play the lottery 
		in a given range of indices */ 
 	public void randomUniqIndx(int numI, int startRange, int endRange) {
		for (int i = 0; i < numI; i++)
		{
			int z = startRange + random.nextInt(endRange-startRange);
			if (this.whoPlays.contains(z))
			{
				while(this.whoPlays.contains(z))
				{
					z = startRange + random.nextInt(endRange-startRange);
				}
			this.whoPlays.add(z);
			}
		}
	}
    
	 public void simulateYears(int numYears) {
  		/*now simulate lottery play for some years */
  		for (int year=0; year < numYears; year++) {
			reDoWhoPlays();
			addPocketChange();
			Game lottery = new Game();
			lottery.generateWinningNums();
    		// TODO: add code so that each member of the community who plays, plays 
			//right now just everyone updates their list of funds each year
			for (Player p : players) {
				p.generateNums();
				int a = lottery.numOfWinningNums(p);
				if (a == 0) this.redistribute(p);
				float winnings = lottery.getWinnings(p);
				p.addMoney(winnings);
				p.updateMoneyEachYear();
			}
			System.out.println("After Year " + year + ":");
			this.printData();
    	} //years
  }

   public void redistribute(Player pl)
   {
	   int x = random.nextInt(100);
	   if (x < 30)
	   {
		   x = random.nextInt(numPeeps/2);
		   while(players.get(x) == pl)
		   {
			   x = random.nextInt(numPeeps/2);
		   }
	   }
	   else
	   {
		   x = random.nextInt(numPeeps/2) + numPeeps/2;
		   while(players.get(x) == pl)
		   {
			   x = random.nextInt(numPeeps/2) + numPeeps/2;
		   }
	   }
	   Player p = players.get(x);
	   p.addMoney(1);
   }

   public void printData()
   {
	   float min = Integer.MAX_VALUE;
	   float max = 0;
	   for(Player p: players)
	   {
		   if (p.getMoney() > max)
		   {
			   max = p.getMoney();
		   }
		   if (p.getMoney() < min)
		   {
			   min = p.getMoney();
		   }
	   }
	   System.out.println("The person with the most money has: " + max);
	   System.out.println("The person with the least money has: " + min);
   }

}

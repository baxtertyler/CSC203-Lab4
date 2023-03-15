import java.util.*;
import java.util.HashSet;
import java.util.Random;

class Player {
   //instance variables
	private PlayerKind kind;
	private float money;
	private ArrayList<Float> moneyOverTime;
    private Random random = new Random();
	private int red, green, blue;

	private HashSet<Integer> nums = new HashSet<Integer>();

	//constructor
	public Player(PlayerKind pK, float startFunds) {
		kind = pK;
		money = startFunds;
		moneyOverTime = new ArrayList<Float>();
		moneyOverTime.add(startFunds);
		red = random.nextInt(100);
		green = random.nextInt(100);
		blue = random.nextInt(100);

		//overall blue tint to POORLY_PAID	
		if (kind == PlayerKind.WELL_PAID) {
			red += 100;
		} else {
			blue += 100;
		}
	}

	public int getR() { return red; }
	public int getG() { return green; }
	public int getB() { return blue; }
	public float getMoney() { return money; }
	public PlayerKind getKind() { return kind; }
	public ArrayList<Float> getFunds() { return moneyOverTime; }

	public void updateMoneyEachYear() {
		moneyOverTime.add(money);
	}

	public void addMoney(float val) {
		this.money += val;
	}

	public void generateNums()
	{
		Random rand = new Random();
		while(this.nums.size() < 5)
		{
			int i = rand.nextInt(41) + 1;
			while(this.nums.contains(i))
			{
				i = rand.nextInt(41) + 1;
			}
			this.nums.add(rand.nextInt(41) + 1);
		}
	}

	public HashSet<Integer> getNums()
	{
		return this.nums;
	}

}

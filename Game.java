import java.util.HashSet;
import java.util.Random;

public class Game {
    private HashSet<Integer> winningNums = new HashSet<Integer>();
    private Random random = new Random();

    public HashSet<Integer> getNums()
    {
        return this.winningNums;
    }

    public void generateWinningNums()
    {
        Random rand = new Random();
        while(this.winningNums.size() < 5)
        {
            this.winningNums.add(rand.nextInt(42) + 1);
        }
    }

    public int numOfWinningNums(Player p)
    {
        int cnt = 0;
        for(Integer i : this.winningNums)
        {
            for(Integer f : p.getNums())
            {
                if (f.equals(i)) cnt += 1;
            }
        }
        return cnt;
    }

    public float getWinnings(Player p)
    {
        int cnt = numOfWinningNums(p);
        if (cnt == 2) return 1;
        if (cnt == 3) return 10.86f;
        if (cnt == 4) return 197.53f;
        if (cnt == 5) return 212534.83f;
        else return -1;
    }

}

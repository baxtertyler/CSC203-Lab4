import org.junit.jupiter.api.Test;

public class TestCases {

    Game lottery = new Game();
    Player p1 = new Player(PlayerKind.WELL_PAID, 100);
    Player p2 = new Player(PlayerKind.WELL_PAID, 100);
    Player p3 = new Player(PlayerKind.WELL_PAID, 100);
    Player p4 = new Player(PlayerKind.WELL_PAID, 100);
    Player p5 = new Player(PlayerKind.WELL_PAID, 100);

    @Test
    public void testGenerateWinningNums()
    {
        lottery.generateWinningNums();
        for (Integer i : lottery.getNums())
        {
            System.out.println(i);
        }
    }

    @Test
    public void testGeneratePlayerNums()
    {
        p1.generateNums();
        for (Integer i : p1.getNums())
        {
            System.out.println(i);
        }
    }

    @Test
    public void testWinningNumbers()
    {
        lottery.generateWinningNums();
        for (Integer i : lottery.getNums())
        {
            System.out.print(i+"__");
        }
        p1.generateNums();
        System.out.println();
        for (Integer i : p1.getNums())
        {
            System.out.print(i+"__");
        }
        System.out.println();
        System.out.println("Count: " + lottery.numOfWinningNums(p1));
    }



}

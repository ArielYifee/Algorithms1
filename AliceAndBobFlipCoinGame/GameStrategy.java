package AliceAndBobFlipCoinGame;

public class GameStrategy {
    public static int CoinFlips(){
        long result = 0;
        result = Math.round( Math.random());
        return (int)result;
    }
    public static int AliceGame(){
        return CoinFlips();
    }
    public static int BobGame(){
        return CoinFlips();
    }
    public static boolean GameStrategy(){
        boolean result = false;
        int AliceResult = AliceGame();
        int BobResult = BobGame();
        if ((AliceResult == BobResult) ||
                (BobResult == 1 - AliceResult))
            result = true;
        return result;
    }
    public static void main(String[] args) {
        int count = 10000000;
        int GameStrategy = 0;
        boolean result = false;
        for (int i = 0; i < count; i++) {
            result = GameStrategy();
            if (result == true)
                GameStrategy++;
        }
        System.out.println("Alice & Bob game : Strategy probability = " + (double) GameStrategy / (double) count);
    }
}

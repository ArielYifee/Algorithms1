package GlassBall;

public class glsBall {
    //מחלקים את הבדיקות לקומות בסדר יורד, נתחיל לזרוק מקומה P אם לא נשבר, נעלה P-1 קומות ונזרוק שוב
    //כאשר נגיע לקומה בה הכדור נשבר, נרד לקומה האחרונה שממנה זרקנו ולא נשבר ונעלה ונבדוק קומה אחת בכל פעם עד שנמצא את הקומה ממנה נשבר הכדור
    //  Complexity: O(sqrt(n)) - sqrt(2*n)
    public static void useFloorPotenial(int a, int arr[]) {
        int num = 1;
        int numFloor = arr.length;
        while (numFloor > num * (num + 1) / 2) {//נקבע את גודל העליות
            num++;
        }
        int jump = num;//הקומה בה אנחנו נמצאים
        int step = num - 1;//כמות הקומות שנעלה כל פעם שלא נשבר הכדור
        while (arr[jump] <= a) {//נחפש מתי הכדור יישבר
            jump = jump + step;
            step = step - 1;
        }
        System.out.println("the first ball break " + jump);// מהווה את הקומה הראשונה שממנה נשבר הכדור הראשון
        int Floor = jump - (step + 1);//נרד לקומה האחרונה שבה הכדור לא נשבר ונעלה קומה אחת כל פעם ונבדוק
        while (arr[Floor] <= a) {
            Floor++;
        }
        System.out.println("the Second Ball is Broking " + Floor);//מהווה את הקומה בה הכדור נשבר
    }

    /**
     * Worst Case O(n^2)
     */
    public static int numberofcheacking2(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= n; i++) {
            int min = n;
            for (int j = 1; j < i - 1; j++) {
                int x = Math.max(j, f[i - j] + 1);
                if (x < min) min = x;
            }
            f[i] = min;
        }
        return f[n];
    }

    /**
     * Worst Case O(n^2*k)
     */
    public static int numberOfCheckingK(int n, int k) {
        int numCheack = 0, min = 0;
        int[][] cheack = new int[k + 1][n + 1];
        for (int j = 0; j <= n; j++) {
            cheack[0][j] = 0;
            cheack[1][j] = j;
        }
        for (int i = 2; i <= k; i++){
            for (int j = 2; j <= n; j++) {
                min = n + 1;
                for (int p = 1; p < j; p++) {
                    min = Math.min(Math.max(cheack[i][j - p], (cheack[i - 1][p - 1])) + 1, min);
                }
                cheack[i][j] = min;
            }
        }
        numCheack = cheack[k][n];
        return numCheack;
    }

    public static void main(String[] args) {
        System.out.println(numberofcheacking2(8));
        System.out.println(numberOfCheckingK(10, 4));
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        useFloorPotenial(5, a);

    }
}
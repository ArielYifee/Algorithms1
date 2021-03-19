public class test {
    public static int setprice(nd[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        arr[0][0].price = 0;
        for (int i = 1; i < n; i++) {arr[i][0].price = arr[i-1][0].price + arr[i-1][0].y;}
        for (int i = 1; i < m; i++) {arr[0][i].price = arr[0][i-1].price + arr[0][i-1].x;}
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int fromy = arr[i][j-1].price + arr[i][j-1].x;
                int fromx = arr[i-1][j].price + arr[i-1][j].y;
                if (fromy < fromx){ arr[i][j].price = fromy;}
                else {arr[i][j].price = fromx;}
            }
        }
        return arr[n-1][m-1].price;
    }
    public static int minbetween(nd[][] arr, nd a, nd b){
        int n = b.y - a.y;
        int m = b.x - a.x;
        arr[a.y][a.x].price = 0;
        for (int i = a.y +1; i < a.y + n; i++) {arr[i][a.x].price = arr[i-1][a.x].price + arr[i-1][a.x].y;}
        for (int i = a.x + 1; i < a.x + m; i++) {arr[a.y][i].price = arr[a.y][i-1].price + arr[a.y][i-1].x;}
        for (int i = a.y +1 ; i < a.y +n ; i++) {
            for (int j = a.x + 1; j < a.x +m ; j++) {
                arr[i][j].price = Math.min(arr[i][j-1].price + arr[i][j-1].x, arr[i-1][j].price + arr[i-1][j].y);
            }
        }
        return arr[b.y][b.x].price;
    }
    public boolean belongs(nd n, nd[][] arr){
        int dist = setprice(arr);
        int statrt2n = minbetween(arr, arr[0][0], n);
        int n2end = minbetween(arr, n , arr[arr.length-1][arr[0].length-1]);
        if (dist == statrt2n+ n2end)return true;
        return false;
    }
    public boolean allNodesBelong(nd[] array, nd[][] arr){
        int dist = setprice(arr);
        int start2first = minbetween(arr, arr[0][0], array[0]);
        int sum = 0;
        for (int i = 1; i < array.length; i++) {
            sum += minbetween(arr,array[i],array[i+1]);
        }
        int last2end = minbetween(arr, array[array.length], arr[arr.length][arr[0].length]);
        if (dist == start2first + sum + last2end)return true;
        return false;
    }

    public static void main(String[] args) {
        nd a1 = new nd(1,5);
        nd b1 = new nd(4,1);
        nd c1 = new nd(0,6);
        nd d1 = new nd(4,2);

        nd a2 = new nd(4,7);
        nd b2 = new nd(2,5);
        nd c2 = new nd(0,3);
        nd d2 = new nd(1,5);

        nd a3 = new nd(1,0);
        nd b3 = new nd(2,0);
        nd c3 = new nd(0,0);
        nd d3 = new nd(6,3);

        nd a4 = new nd(1,1);
        nd b4 = new nd(5,2);
        nd c4 = new nd(1,1);
        nd d4 = new nd(1,1);

        nd[][] arr = {
                {a1, b1, c1, d1},
                {a2, b2, c2, d2},
                {a3, b3, c3, d3},
                {a4, b4, c4, d4}
        };
        System.out.println(setprice(arr));
    }
}

class nd{
    int x,y,price;
    public nd(int x,int y){
        this.x =x;
        this.y = y;
        this.price = 0;
    }
}

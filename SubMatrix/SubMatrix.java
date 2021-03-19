package SubMatrix;

public class SubMatrix {
    public static void buildMat(int[][] arr){
        int k = 0,l = 0;
        int size = 0;
        node[][] mat = new node[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {mat[i][0] = new node(arr[i][0]); }
        for (int i = 0; i < arr.length; i++) {mat[0][i] = new node(arr[0][i]); }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if(arr[i][j] == 1){
                    int n = Math.min(mat[i-1][j].val, mat[i][j-1].val);
                    n = Math.min(n, mat[i-1][j-1].val);
                    n++;
                    mat[i][j] = new node(n);
                    if(n > size){
                        size = n;
                        k = i;
                        l = j;
                    }
                }else{
                    mat[i][j] = new node(0);
                }
            }
        }
        PrintMatrix(mat);
        System.out.println("the max size is: " + size +" in pos: " + k + "," + l);
    }

    public static void PrintMatrix(node[][] mat){
        for (int i = 0; i < mat.length; i++) {
            System.out.print("[");
            for (int j = 0; j < mat[i].length; j++) {
                if (j == mat[i].length - 1) {
                    System.out.print(mat[i][j].val);
                } else {
                    System.out.print(mat[i][j].val + ", ");
                }
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,0,1,1,1},
                {0,1,1,1,1},
                {0,1,1,1,1},
                {0,1,1,1,0},
                {0,1,0,0,1},};
        buildMat(arr);
    }
}

class node{
    int val;

    public node(int val){
        this.val = val;
    }
}

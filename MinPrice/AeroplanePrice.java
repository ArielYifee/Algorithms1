package MinPrice;

public class AeroplanePrice {
    //**********  variables  **********

    static public NodeData[][] mat;    //  matrix of Nodes
    static public int row;            //  row's number
    static public int col;                //  column's number


    static public int minTurn = 100;
    static public String trackMinTurn = "";

    //****************************************************************

    public AeroplanePrice() {
        mat = initMatrix();
        row = mat.length;
        col = mat[0].length;
    }

    //****************************************************************

    public static NodeData[][] initMatrix() {
        int m = 4;    //  number of rows
        int n = 5;        //  number of columns

        NodeData mat[][] = new NodeData[m][n];
        // the first row
        mat[0][0] = new NodeData(3, 1);
        mat[0][1] = new NodeData(5, 2);
        mat[0][2] = new NodeData(10, 4);
        mat[0][3] = new NodeData(4, 2);
        mat[0][4] = new NodeData(0, 4);
        // the second row
        mat[1][0] = new NodeData(3, 8);
        mat[1][1] = new NodeData(11, 5);
        mat[1][2] = new NodeData(1, 3);
        mat[1][3] = new NodeData(5, 3);
        mat[1][4] = new NodeData(0, 2);
        // the third row
        mat[2][0] = new NodeData(8, 3);
        mat[2][1] = new NodeData(6, 3);
        mat[2][2] = new NodeData(4, 1);
        mat[2][3] = new NodeData(6, 5);
        mat[2][4] = new NodeData(0, 4);
        // the forth row
        mat[3][0] = new NodeData(4, 0);
        mat[3][1] = new NodeData(4, 0);
        mat[3][2] = new NodeData(5, 0);
        mat[3][3] = new NodeData(3, 0);
        mat[3][4] = new NodeData(0, 0);
        return mat;
    }

    //****************************************************************

    public static void buildPriceMatrix() {
        System.out.println("*****  buildPriceMatrix()  *****");
        //***************  first  row    ******************
        for (int j = 1; j < col; j++)
            mat[0][j].price = mat[0][j - 1].price + mat[0][j - 1].priceX;

        //***************  first column  ******************
        for (int i = 1; i < row; i++)
            mat[i][0].price = mat[i - 1][0].price + mat[i - 1][0].priceY;

        //***************  all prices    ******************
        for (int i = 1; i < row; i++)
            for (int j = 1; j < col; j++) {
                int y = mat[i - 1][j].price + mat[i - 1][j].priceY;
                int x = mat[i][j - 1].price + mat[i][j - 1].priceX;
                if (y < x)
                    mat[i][j].price = y;
                if (y > x)
                    mat[i][j].price = x;
                if (y == x)
                    mat[i][j].price = y;
            }
    }

    //****************************************************************

    public static void buildBestTracksMatrix() {
        System.out.println("*****  buildBestTracksMatrix()  *****");
        //***************  first  row    ******************
        for (int j = 1; j < col; j++)
            mat[0][j].bestTrNum = 1;

        //***************  first column  ******************
        for (int i = 1; i < row; i++)
            mat[i][0].bestTrNum = 1;

        //***************  all prices    ******************
        for (int i = 1; i < row; i++)
            for (int j = 1; j < col; j++) {
                int y = mat[i - 1][j].price + mat[i - 1][j].priceY;
                int x = mat[i][j - 1].price + mat[i][j - 1].priceX;
                if (y < x)
                    mat[i][j].bestTrNum = mat[i - 1][j].bestTrNum;
                if (y > x)
                    mat[i][j].bestTrNum = mat[i][j - 1].bestTrNum;
                if (y == x)
                    mat[i][j].bestTrNum = mat[i - 1][j].bestTrNum + mat[i][j - 1].bestTrNum;
            }
    }

    //****************************************************************

    public static String getOneBestTrack() {        //  O(row+col)
        System.out.println("\n*****  one best tracks  *****\n");
        String track = "";
        int i = row - 1, j = col - 1;

        while (i > 0 && j > 0) {
            int y = mat[i - 1][j].price + mat[i - 1][j].priceY;
            int x = mat[i][j - 1].price + mat[i][j - 1].priceX;
            if (y <= x) {
                track = "1" + track;
                i--;
            } else {                        // if (y >= x)
                track = "0" + track;
                j--;
            }
        }
        while (j > 0) {
            track = "0" + track;
            j--;
        }
        while (i > 0) {
            track = "1" + track;
            i--;
        }
        return track;
    }

    //****************************************************************

    public static void getOneBestTrackRec(String track, int i, int j) {        //  O(row+col)

        if (i > 0 && j > 0) {
            int y = mat[i - 1][j].price + mat[i - 1][j].priceY;
            int x = mat[i][j - 1].price + mat[i][j - 1].priceX;
            if (y <= x)
                getOneBestTrackRec("1" + track, i - 1, j);
            if (y > x)
                getOneBestTrackRec("0" + track, i, j - 1);
        }
        if (i == 0 && j > 0)
            getOneBestTrackRec("0" + track, i, j - 1);
        if (i > 0 && j == 0)
            getOneBestTrackRec("1" + track, i - 1, j);
        if (i == 0 && j == 0)            //  i == 0 && j == 0
            System.out.println("track : " + track);
    }

    //****************************************************************

    public static void getAllBestTracks(String track, int i, int j) {

        if (i > 0 && j > 0) {
            int y = mat[i - 1][j].price + mat[i - 1][j].priceY;
            int x = mat[i][j - 1].price + mat[i][j - 1].priceX;
            if (y < x)
                getAllBestTracks("1" + track, i - 1, j);
            if (y > x)
                getAllBestTracks("0" + track, i, j - 1);
            if (y == x) {
                getAllBestTracks("1" + track, i - 1, j);
                getAllBestTracks("0" + track, i, j - 1);
            }
        }
        if (i == 0 && j > 0)
            getAllBestTracks("0" + track, i, j - 1);
        if (i > 0 && j == 0)
            getAllBestTracks("1" + track, i - 1, j);
        if (i == 0 && j == 0)            //  i == 0 && j == 0
            System.out.println("track : " + track);
    }

    //****************************************************************

    public static void getAllBestTracksTurn(String track, int i, int j) {

        if (i > 0 && j > 0) {
            int y = mat[i - 1][j].price + mat[i - 1][j].priceY;
            int x = mat[i][j - 1].price + mat[i][j - 1].priceX;
            if (y < x) {
                getAllBestTracksTurn("1" + track, i - 1, j);
            }
            if (y > x) {
                getAllBestTracksTurn("0" + track, i, j - 1);
            }
            if (y == x) {
                getAllBestTracksTurn("1" + track, i - 1, j);
                getAllBestTracksTurn("0" + track, i, j - 1);
            }
        }
        if (i == 0 && j > 0) {
            getAllBestTracksTurn("0" + track, i, j - 1);
        }
        if (i > 0 && j == 0) {
            getAllBestTracksTurn("1" + track, i - 1, j);
        }
        if (i == 0 && j == 0) {            //  i == 0 && j == 0
            // add code
        }
    }

    //****************************************************************

    public static void main(String[] args) {

        new AeroplanePrice();

        buildPriceMatrix();
        printPriceMatrix();


        //************************

        buildBestTracksMatrix();
        printTrackMatrix();
        System.out.println("best tracks number : " + mat[row - 1][col - 1].bestTrNum);

        //************************

        String oneTrack = getOneBestTrack();
        System.out.println("one track : " + oneTrack);
        System.out.println("\n*****  one best tracks recursive  *****\n");
        getOneBestTrackRec("", row - 1, col - 1);

        //************************
        System.out.println("\n*****  all best tracks  *****\n");
        getAllBestTracks("", row - 1, col - 1);

        //************************
        System.out.println("\n*****  all best tracks with turns  *****\n");
        getAllBestTracksTurn("", row - 1, col - 1);
        System.out.println("trackMinTurn : " + trackMinTurn + "   minTurn = " + minTurn);
    }

    //************************************

    public static void printPriceMatrix() {
        System.out.println("\nmatrix of prices \n");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.format("%6d", mat[i][j].price);
            }
            System.out.println();
        }
        System.out.println();
    }

    //************************************

    public static void printTrackMatrix() {
        System.out.println("\nmatrix of best tracks \n");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.format("%6d", mat[i][j].bestTrNum);
            }
            System.out.println();
        }
        System.out.println();
    }

}

//************************************************

class NodeData {
    int priceX;
    int priceY;
    int price;
    int bestTrNum;

    public NodeData(int x, int y) {
        this.priceX = x;
        this.priceY = y;
        this.price = 0;
        this.bestTrNum = 0;
    }
}

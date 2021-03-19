package PrisonersProblem;

public class PrisonersProblem {
    public static boolean[] prisoners;
    public static boolean lamp = true;

    public static void init(int n){
        prisoners = new boolean[n];
        for (int i = 0; i < prisoners.length; i++){
            prisoners[i] = false;
        }
    }

    public static int sulotion(){
        int n = prisoners.length;
        int counter = 0;
        int steps = 0;
        while (counter<n){
            steps++;
            int p = (int)(Math.random()*n);
            if (p==0){
                if (!prisoners[p]){
                    prisoners[p] = true;
                    counter++;
                }
                if (!lamp){
                    lamp = true;
                    counter++;
                }
            }
            else {
                if (!prisoners[p]&&lamp){
                    lamp = false;
                    prisoners[p] = true;
                }
            }
        }
        return steps;

    }

    public static void main(String[] args){
        init(100);
        System.out.println(sulotion());
    }
}
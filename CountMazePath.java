import java.util.Scanner;

public class CountMazePath {

    public static int TotalPath(int i,int j, int n, int m){ //where 'i' is initial row and 'j' is initial column
        //there are two base case
        if(i == n||j == m){
            return 0;
        }
        if(i == n-1 && j == m-1){
            return 1;
        }

        //move horizonatally(right)

       int horizontal= TotalPath(i,j+1,n,m);

         //move vertically(down)
        int vertical=TotalPath(i+1,j,n,m);//

        //return totalpath
        return horizontal+vertical;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int m=sc.nextInt();
        System.out.println(TotalPath(0,0,n,m));
    }
}



public class t4 {
    public static void main(String[] args) {
    
        int[][] board  = {
        {0,0,0,0,0},
        {0,0,1,0,3},
        {0,2,5,0,1},
        {4,2,4,4,2},
        {3,5,1,3,1}
    };
        
        int[] moves = {1,5,3,5,1,2,1,4};

        System.out.println(solution(board,moves));
    }

    static int solution(int[][] board, int[] moves){
        int answer = 0;
        int[] trashGarbage = new int[moves.length]; 
        int k =0;
        
        for (int i = 0; i < moves.length; i++) {

        for (int j = 0; j < board.length; j++) { 
                if(board[j][moves[i]-1]!=0){
                    System.out.printf("%d %d %d gotoGarbage %d\n",i,j,k,board[j][moves[i]-1]);
                    trashGarbage[k] = board[j][moves[i]-1];
                    board[j][moves[i]-1]=0;
                    k++;
                    break;
                }
            }
            if(k>1 && trashGarbage[k-1]==trashGarbage[k-2]){
                System.out.println("same");
                trashGarbage[k-1]=0;
                trashGarbage[k-2]=0;
                k-=2;
                answer+=2;
            }
        }
        

        return answer;
    }

}

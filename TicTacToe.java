import java.util.Scanner;
class TicTacToe
{
      public static void main(String[] args) {
      Scanner get = new Scanner(System.in);
      char[][] board = new char[3][3];
      char Player = 'X';
      int row,col;
      int occurence = 0;
      for(int i = 0; i < 3; ++i) {
         for(int j = 0; j < 3; ++j) {
            board[i][j]=' ';
         }}
    
      drawboard(board);
      boolean Gameover = false;
      while(!Gameover) {
        System.out.println("Player "+Player+" Turn ");
        System.out.print("Enter the position : ");
        row = get.nextInt();
        col = get.nextInt();
        if(board[row][col]==' ')
            board[row][col]=Player;
        else
            {System.out.println("Invalid move");
            Player = Player=='X'?'O':'X';
        }
        drawboard(board);
        
        if ( occurence> 3) {

         for(int j = 0; j < 3; ++j) {
            if(board[j][0]==Player && board[j][1]==Player && board[j][2]==Player)
            {
                System.out.print("Player "+ Player+" has won ");
                Gameover = true;
            }
            if(board[0][j]==Player && board[1][j]==Player && board[2][j]==Player)
            {
                System.out.print("Player "+ Player+" has won ");
                Gameover = true;
            }
             if(board[0][0]==Player && board[1][1]==Player && board[2][2]==Player)
            {
                System.out.print("Player "+ Player+" has won ");
                Gameover = true;
            }
            if(board[2][0]==Player && board[1][1]==Player && board[0][2]==Player)
            {
                System.out.print("Player "+ Player+" has won ");
                Gameover = true;
            }
            if(board[j][0]==Player && board[j][1]==Player && board[j][2]==Player)
            {
                System.out.print("Player "+ Player+" has won ");
                Gameover = true;
            }           
        
         }}
         occurence++;
         Player = Player=='X'?'O':'X';
      

   } }
    public static void drawboard(char[][] A) {
    System.out.println("\n-------");
      for(int i = 0; i < 3; ++i) {
         for(int j = 0; j < 3; ++j) {
            System.out.print(A[i][j] + "|");
         }

         System.out.println("\n-------");
      }

   }}

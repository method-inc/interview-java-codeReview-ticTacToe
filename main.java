public class Main {
 
    public static void main(String[] args) {
 
        Scanner scanner = new Scanner(System.in);
 
        String[] board = new String[9];
        board[0] = "1";
        board[1] = "2";
        board[2] = "3";
        board[3] = "4";
        board[4] = "5";
        board[5] = "6";
        board[6] = "7";
        board[7] = "8";
        board[8] = "9";
 
        String[]players = new String[2];
        players[0] = "";
        players[1] = "";
 
        String turn = "X";
 
        print("""
                Lets Play Tic Tac Toe!
                First let's get our players
                    Whats player 1 name?""");
        players[0] = scanner.nextLine();
        print("Alright " + players[0] + ", you'll be playing as 'X's\n"+
            "   Whats player 2 name?");
        players[1] = scanner.nextLine();
        print("Alright " + players[1] + ", you'll be playing as 'O's\n"+
        players[0] + " You're going first!");
 
        while (true) {
            displayBoard(board);
            turn = playerTurn(scanner, board, players, turn);
            if (winStatus(board, players)) break;
        }
 
    }
 
    private static String playerTurn(Scanner scanner, String[] board, String[] players, String turn) {
        while (true) {
            print(players[0] + " Enter the number where you would like to place your " + turn);
            int input = scanner.nextInt();
            while (true) {
                if (input < 1 || input > 9) {
                    print("You missed :P try again");
                    print(players[0] + " Enter the number where you would like to place your " + turn);
                    input = scanner.nextInt();
 
                } else if (String.valueOf(input).equals(board[input-1])){
                    board[input - 1] = turn;
                    break;
                } else {
                    print("Try again");
                    input = scanner.nextInt();
                }
            }
            break;
        }
        if (turn.equals("X")) {
            turn = "O";
        } else {
            turn = "X";
        }
        return turn;
    }
 
    private static boolean winStatus(String[] board, String[] players) {
        if(checkWinner(board).equals("X")) {
            print("Congrats! " + players[0] + ", you win!!!");
            return true;
        } else if(checkWinner(board).equals("O")) {
            print("Congrats! " + players[1] + ", you win!!!");
            return true;
        } else if(checkWinner(board).equals("draw")) {
            print("Draw");
            return true;
        }
        return false;
    }
 
    private static String checkWinner(String[] board) {
        String winner = "0";
        for (int a = 0; a < 8; a++) {
            String line = switch (a) {
                case 0 -> board[0] + board[1] + board[2];
                case 1 -> board[3] + board[4] + board[5];
                case 2 -> board[6] + board[7] + board[8];
                case 3 -> board[0] + board[3] + board[6];
                case 4 -> board[1] + board[4] + board[7];
                case 5 -> board[2] + board[5] + board[8];
                case 6 -> board[0] + board[4] + board[8];
                case 7 -> board[2] + board[4] + board[6];
                default -> null;
            };
            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            }
        }
        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(String.valueOf(a+1))) {
                break;
            } else if (a==8) {
                return "draw";
            }
 
        }
        return winner;
    }
 
    private static void displayBoard (String[]board){
        System.out.println("\n█████████████████████████\n" +
                "█       █       █       █\n" +
                "█   " + board[0] + "   █   " + board[1] + "   █   " + board[2] + "   █\n" +
                "█       █       █       █\n" +
                "█████████████████████████\n" +
                "█       █       █       █\n" +
                "█   " + board[3] + "   █   " + board[4] + "   █   " + board[5] + "   █\n" +
                "█       █       █       █\n" +
                "█████████████████████████\n" +
                "█       █       █       █\n" +
                "█   " + board[6] + "   █   " + board[7] + "   █   " + board[8] + "   █\n" +
                "█       █       █       █\n" +
                "█████████████████████████\n");
    }
 
    private static void print (String x){
        System.out.println(x);
    }
}

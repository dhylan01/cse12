
/**
 * TODO: Add your file header
 * Name: Dhylan Patel & Yashwin Madakamutil
 * ID: A16993071 A16748638
 * Email: ddpatel@ucsd.edu ymadakamutil@ucsd.edu
 * Sources used: "None"
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * 2-4 sentence file description here
 * Is a file includes the RPS object along with the necesary import of the scanner utility
 * Is called in the tester to create objects and can also be compiled and ran from the console
 */

import java.util.Scanner;

/**
 * TODO: Add your class header (purpose and capabilities of the class)
 * RPS class can call all of the methods from RPS Abstract ad RPSInterface, the
 * purpose is to set up and
 * run the game using the methods fom abstract
 * 
 */
public class RPS extends RPSAbstract {

    /**
     * TODO: Add method header
     * Is a contructor that sets the values of possible moves, player moves, and
     * cpumoves when the a new RPS object is created
     * 
     * @param String[] moves - a string that contains the possible moves included and should be in the order given by Rock, paper, scissors
     * @return nothing - just sets values for the class
     */

    public RPS(String[] moves) {
        this.possibleMoves = moves;
        this.playerMoves = new String[MAX_GAMES];
        this.cpuMoves = new String[MAX_GAMES];
    }

    /**
     * Takes the user move, the CPU move, and determines who wins.
     * 
     * @param playerMove - move of the player
     * @param cpuMove    - move of the CPU
     * @return -1 for invalid move, 0 for tie, 1 for player win, 2 for cpu win
     */
    public int determineWinner(String playerMove, String cpuMove) {
        // TODO
        if (isValidMove(playerMove) && isValidMove(cpuMove)) {
            int pIndex = -1;
            int cIndex = -1;
            for (int i = 0; i < possibleMoves.length; i++) {
                if (playerMove.equals(possibleMoves[i])) {
                    pIndex = i;
                }
                if (cpuMove.equals(possibleMoves[i])) {
                    cIndex = i;
                }
            }
            if ((pIndex - cIndex) == -1)
                return PLAYER_WIN_OUTCOME;
            if ((cIndex - pIndex) == -1)
                return CPU_WIN_OUTCOME;
            if (pIndex == 0 || cIndex == 0) {
                if (cIndex == 0 && pIndex == (possibleMoves.length - 1))
                    return PLAYER_WIN_OUTCOME;
                if (pIndex == 0 && cIndex == (possibleMoves.length - 1))
                    return CPU_WIN_OUTCOME;
            }
            return TIE_OUTCOME;
        }
        return INVALID_INPUT_OUTCOME;
    }

    /**
     * Main method that reads user input, generates cpu move, and plays game
     * 
     * @param args - arguments passed in from command line in String form
     */
    public static void main(String[] args) {
        // If command line args are provided use those as the possible moves
        String[] moves = new String[args.length];
        if (args.length >= MIN_POSSIBLE_MOVES) {
            for (int i = 0; i < args.length; i++) {
                moves[i] = args[i];
            }
        } else {
            moves = RPS.DEFAULT_MOVES;
        }
        // Create new game and scanner
        RPS game = new RPS(moves);
        Scanner in = new Scanner(System.in);
        String cpuMove = "";
        System.out.println(PROMPT_MOVE);
        // While user does not input "q", play game
        String input;
        

        while (in.hasNext()) {
            input = in.nextLine();
            if (input.equals("q")) {
                game.end();
                
                break;
            } else {
                cpuMove = game.genCPUMove();
                game.play(input, cpuMove);

                if (game.determineWinner(input, cpuMove) == TIE_OUTCOME)
                    System.out.println(CPU_MOVE + cpuMove + ". " + TIE);
                if (game.determineWinner(input, cpuMove) == PLAYER_WIN_OUTCOME)
                    System.out.println(CPU_MOVE + cpuMove + ". " + PLAYER_WIN);
                if (game.determineWinner(input, cpuMove) == CPU_WIN_OUTCOME)
                    System.out.println(CPU_MOVE + cpuMove + ". " + CPU_WIN);
                if (game.determineWinner(input, cpuMove) == INVALID_INPUT_OUTCOME)
                    System.out.println(INVALID_INPUT);
                System.out.println(PROMPT_MOVE);
            }

        }

        // System.out.println("Game not yet implemented.");

        // TODO: Insert the code to play the game.
        // See the writeup for an example of the game play.
        // Hint: call the methods we/you have already written
        // to do most of the work!

        in.close();
    }
}

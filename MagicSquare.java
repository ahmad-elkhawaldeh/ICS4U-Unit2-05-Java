/*
* This program prints out
* the Magic Sqaures.
*
* @author  Ahmad El-khawaldeh
* @version 1.0
* @since   2020-01-01
*/

final class MagicSquare {
    private MagicSquare() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }

    /** The middle left index. */
    public static final int THREE = 3;
    /** The center index. */
    public static final int FOUR = 4;
    /** The middle right index. */
    public static final int FIVE = 5;
    /** The lower left index. */
    public static final int SIX = 6;
    /** The lower center index. */
    public static final int SEVEN = 7;
    /** The lower right index. */
    public static final int EIGHT = 8;
    /** The maximum number for magicNumbers. */
    public static final int NINE = 9;
    /** The maximum number for magicNumbers. */
    public static final int MAGICNUM = 15;

    /**
    * Process numbers.
    */
    private static int numberOfProcess = 0;


    public static void genSquare(final int[] square, final int[] currentSquare,
                                 final int index) {
        // generate the magic sqaure
        for (int counter = 0; counter < square.length; counter++) {
            numberOfProcess++;
            if (currentSquare[counter] == 0) {
                // incriment to the next step
                square[index] = counter + 1;
                currentSquare[counter] = 1;

                // only fill in spots that have not yet been filled in
                if (index < square.length - 1) {
                    genSquare(square, currentSquare, index + 1);
                } else if (isMagic(square)) {
                    // if all done and it is magic, then print it out
                    printMagicSquare(square);
                }
                currentSquare[counter] = 0;
            }
        }
    }

    public static boolean isMagic(final int[] preSquare) {
        int row1 = preSquare[0] + preSquare[1] + preSquare[2];
        int row2 = preSquare[THREE] + preSquare[FOUR] + preSquare[FIVE];
        int row3 = preSquare[SIX] + preSquare[SEVEN] + preSquare[EIGHT];
        int col1 = preSquare[0] + preSquare[THREE] + preSquare[SIX];
        int col2 = preSquare[1] + preSquare[FOUR] + preSquare[SEVEN];
        int col3 = preSquare[2] + preSquare[FIVE] + preSquare[EIGHT];
        int diag1 = preSquare[0] + preSquare[FOUR] + preSquare[EIGHT];
        int diag2 = preSquare[2] + preSquare[FOUR] + preSquare[SIX];

        return row1 == MAGICNUM && row2 == MAGICNUM && row3 == MAGICNUM
               && col1 == MAGICNUM && col2 == MAGICNUM
               && col3 == MAGICNUM && diag1 == MAGICNUM && diag2 == MAGICNUM;
    }

    public static void printMagicSquare(final int[] outputSquare) {
        System.out.println("\n*****");
        for (int count = 0; count < outputSquare.length; count++) {
            if (count == THREE || count == SIX) {
                System.out.println();
                System.out.print(outputSquare[count] + " ");
            } else {
                System.out.print(outputSquare[count] + " ");
            }
        }
        System.out.println("\n*****");
    }

    public static void main(final String[] args) {
        int[] magicSquare = {1, 2, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE};
        int[] extraArray = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println("\n");
        System.out.println("All Possible Magic Squares (3x3):\n");
        genSquare(magicSquare, extraArray, 0);

        System.out.println("Done, number of processes: " + numberOfProcess);
    }
}

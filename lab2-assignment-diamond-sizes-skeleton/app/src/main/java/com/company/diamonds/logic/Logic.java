package com.company.diamonds.logic;

import com.company.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
        implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out) {
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {

        for (int i = -size; i <= size; i++) {
            // horizontal axis
            for (int j = -size - 1; j <= size + 1; j++)
                if (j == 0) continue; // skip middle vertical
                else if (Math.abs(j) == size + 1) // vertical borders & corners
                    mOut.print(Math.abs(i) == size ? "+" : "|");
                else if (Math.abs(i) == size) // horizontal borders
                    mOut.print("-");
                else if (i == 0 && Math.abs(j) == size) // middle left & right tips
                    mOut.print(j == -size ? "<" : ">");
                else if (Math.abs(i - j) == size) // upper right & lower left edges
                    mOut.print("\\");
                else if (Math.abs(i + j) == size) // upper left & lower right edges
                    mOut.print("/");
                else if (Math.abs(i) + Math.abs(j) < size) // inner rhombus lines
                    mOut.print((size - i) % 2 != 0 ? "=" : "-");
                else // whitespace
                    mOut.print(" ");
            mOut.println(""); // new line
        }
    }
}

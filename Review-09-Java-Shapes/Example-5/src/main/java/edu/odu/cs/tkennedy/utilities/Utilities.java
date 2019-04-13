package edu.odu.cs.tkennedy.utilities;

//import java.lang.StringBuilder;

/**
 * A collection of general purpose utility functions
 * used during class discussions
 *
 * @author Thomas J Kennedy
 */
public final class Utilities{
    /**
     * Width of the terminal window
     */
    public static final int W_WIDTH = 80;

    /**
     * Default Precision (epsilon)
     */
    public static final double EPS = 1E-6;

    /**
     * Print a horizontal line
     *
     * @param lineChar symbol used in divider
     * @param width width of divider
     *
     * @return dividing line
     */
    public static String horizontalLine(final char lineChar, final int width)
    {
        return String.format("%0" + width + "d", 0).replace("0", String.format("%s", lineChar));
    }

    /**
     *  Print a centered title
     *
     * @param title heading title
     * @param width width of divider
     *
     * @return formatted centered title
     */
    public static String centeredTitle(final String title, final int width)
    {
        final int magicWidth = (width / 2) - (title.length() / 2) + title.length();

        return(String.format("%" + magicWidth + "s%n", title));
    }

    /**
     * Print a heading followed by a horizontal rule
     *
     * @param heading the title to display
     * @param width the width of the heading
     * @param border the character with which to create the horizontal rule
     *
     * @return heading with divider
     */
    public static String seperatedHeading(final String heading, final int width, final char border)
    {
        return(
            centeredTitle(heading, width) +
            horizontalLine(border, width)
        );
    }

    /**
     * Print the stylized program/project heading
     *
     * @param titles title lines to display
     * @param width the width of the heading
     *
     * @return formatted multi-line heading
     */
    public static String projectHeading(final String[] titles, final int width)
    {
        StringBuilder bld = new StringBuilder();

        //bld.append(horizontalLine('*', width));
        //bld.append("\n");
        bld.append(horizontalLine('*', width)).append("\n");

        for(final String line : titles){
            bld.append(centeredTitle(line, width));
        }

        bld.append(horizontalLine('*', width));

        return bld.toString();
    }

    /**
     *  Print a centered heading
     *
     *  @param title the title to display
     *  @param width the width of the heading
     *  @param border the character with which to create the horizontal rule
     *
     * @return formatted centered heading
     */
    public static String heading(final String title, final int width, final char border)
    {
        return(
            horizontalLine(border, width) + "\n" +
            centeredTitle(title, width  ) +
            horizontalLine(border, width)
       );
    }

    /**
     *  Compare two floating point numbers - determine if equal within
     *  a specified threshold
     *
     * @param lhs first number
     * @param rhs second number
     * @param threshold epsilon (difference) value
     *
     * @return true if the values are equal and false otherwise
     */
    public static boolean areEqual(double lhs, double rhs, double threshold)
    {
        return Math.abs(rhs - lhs) < threshold;
    }
}

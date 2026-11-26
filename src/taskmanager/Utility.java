package taskmanager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author Lamlsm
 */
public class Utility {

    Scanner sc = new Scanner(System.in);

    /**
     * Get an integer within a specific range.
     *
     * @param msg message to display
     * @param min minimum value
     * @param max maximum value
     * @return valid integer input
     */
    public int getInt(String msg, int min, int max) {
        while (true) {
            try {
                System.out.print(msg);
                int n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println("Invalid number.");
            }
        }
    }

    /**
     * Get a double value for time with step 0.5.
     *
     * @param msg message to display
     * @param min minimum value
     * @param max maximum value
     * @return valid time value
     */
    public double getDouble(String msg, double min, double max) {
        while (true) {
            try {
                System.out.print(msg);
                double n = Double.parseDouble(sc.nextLine());
                if (n < min || n > max || n % 0.5 != 0) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println("Invalid time.");
            }
        }
    }

    /**
     * Get a string from user input.
     *
     * @param msg message to display
     * @return input string
     */
    public String getString(String msg) {
        while (true) {
            System.out.print(msg);
            String m = sc.nextLine();
            if (!m.isEmpty()) {
                return m;
            } else {
                System.out.println("Invalid name.");
            }
        }
    }
    
        /**
         * Get a valid date in format dd-MM-yyyy.
         *
         * @param msg message to display
         * @return valid date string
         */
    public String getDate(String msg) {
        while (true) {
                System.out.print(msg);
                String date = sc.nextLine();
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                df.setLenient(false);
                try{
                if(!date.matches("\\d{2}-\\d{2}-\\d{4}")){
                    throw new ParseException("Invalid date",0);
                }
                df.parse(date);
                return date;
            } catch (ParseException e) {
                System.out.println("Date must format dd-MM-yyyy.");
            }
        }
    }
}

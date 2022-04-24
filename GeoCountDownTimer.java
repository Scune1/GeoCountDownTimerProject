package project1;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

/*************************************************************************
 * @Gavin Morrow & Niki Georgescu
 * @Winter 2022 CIS163
 *************************************************************************/
public class GeoCountDownTimer {
    private int year;
    private int month;
    private int day;
    private static final int MIN_YEAR = 2022;
    private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] MONTH_NAMES = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private int[] monthsOfYear;
    private int feb;


    /**********************************************************************
     * Initializes values
     **********************************************************************/
    public GeoCountDownTimer() {

        this.year = MIN_YEAR; //sets this.year to MIN_YEAR which makes sure the value is >= 2022
        this.month = 1;
        this.day = 1;

    }

    /*******************************************************************
     * @param year
     * @param month
     * @param day   checks if date fits instructions of isValidDate method
     *******************************************************************/
    public GeoCountDownTimer(int year, int month, int day) {
        if (!isValidDate(year, month, day)) {
            throw new IllegalArgumentException(); //checks to make sure date string is valid
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /******************************************************************
     * @param other sets instance variables to other values
     ******************************************************************/
    public GeoCountDownTimer(GeoCountDownTimer other) {

        this.year = other.year;
        this.month = other.month;
        this.day = other.day;
    }

    /**********************************************************************
     * @param geoDate Checks geoDate method to make sure that the amount of slashes is correct
     **********************************************************************/
    public GeoCountDownTimer(String geoDate) {
        if (geoDate == null) {//checks to make sure geoDate has a value stored
            throw new IllegalArgumentException();
        }
        String[] date = geoDate.split("/");//splits string with /
        if (date.length == 3) {//should be 3 values in a date string
            month = Integer.parseInt(date[0]);
            day = Integer.parseInt(date[1]);
            year = Integer.parseInt(date[2]);
        } else if (!isValidDate(year, month, day)) {
            throw new IllegalArgumentException();
        }
    }

    /**********************************************************************
     * @param other
     * @return Checks to see if Object other is equal to GeoCountDownTimer Object
     **********************************************************************/

    public boolean equals(Object other) {
        if (other == null) throw new IllegalArgumentException();//checks other for a value stored

        if (other != null) {// confirms value is stored
            if (other instanceof GeoCountDownTimer) {
                GeoCountDownTimer temp = (GeoCountDownTimer) other;
                if (temp.day == this.day && temp.month == this.month && temp.year == this.year) return true;
            }
        }
        return false;
    }

    /***********************************************************************
     * @param other
     * @return Compares other GeoCountDownTimer values to instance variable values.
     ***********************************************************************/
    public int compareTo(GeoCountDownTimer other) {
        int returnVal = 0;
        if (other == null) throw new IllegalArgumentException();//checks if value is stored in GEOCDT other

        if (other.year < this.year) {
            returnVal = 1;
            return 1;
        }

        if (other.year > this.year) {
            returnVal = -1;
            return returnVal;
        }
        if (other.month < this.month) {
            returnVal = 1;
            return returnVal;
        }
        if (other.month > this.month) {
            returnVal = -1;
            return returnVal;
        }
        if (other.day < this.day) {
            returnVal = 1;
            return returnVal;
        }
        if (other.day > this.day) {
            returnVal = 1;
            return returnVal;
        }
        return returnVal;
    }

    /***********************************************************************
     * @param days Checks to see if the value of each instance variable is correct and if not it sets the value
     *             what it is supposed to be
     **********************************************************************/
    public void dec(int days) {
        if (days < 1) {//checks if value is stored, int cannot be == to null
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < days; i++) {
            dec();//decrements number of days by whatever value is passed
        }
    }

    /**********************************************************************
     * method that decrements the number of days
     **********************************************************************/
    public void dec() {
        day--;
        if (day == 0) {
            if (month > 1) {
                month--;
                day = numberOfDaysInMonth(month, year);
            } else if (month <= 1) {
                month = 12;
                year--;
                day = numberOfDaysInMonth(month, year);
            }
            if (month == 2 && isLeapYear(year)){
                day = 29;
            }

        }
        if (isValidDate(year, month, day)) {


        } else {
            throw new IllegalArgumentException();
        }
    }

    /***********************************************************************
     * this method increments the day by number of days
     * @param days - day
     ***********************************************************************/
    public void inc(int days) {
        for (int i = 0; i < days; i++) {
            inc();//decrements number of days by whatever value is passed
        }


    }

    /***********************************************************************
     *
     * @param month
     * @param year
     * @return
     ***********************************************************************/

    private int numberOfDaysInMonth(int month, int year) {
        if (month == 2 && isLeapYear(year)) return 29;
        else return DAYS_IN_MONTH[month];
    }


    /************************************************************************
     * method that increments the number of days
     ************************************************************************/
    public void inc() {

        day++;
        if (day > DAYS_IN_MONTH[month]) {
            month++;
            day = 1;
            if (month > 12) {
                month = 1;
                year++;
                day = 1;



            }
        }

    }


    /*************************************************************************
     * @return Method that concatenates a string to look like: February 10, 2018
     ************************************************************************/
    public String toString() {
        String s = MONTH_NAMES[month] + " " + day + ", " + year;//glues values together
        return s;
    }

    /************************************************************************
     * @return Method that concatenates a string to look like: 2/10/2018
     ***********************************************************************/
    public String toDateString() {
        String s2 = month + "/" + day + "/" + year;
        return s2;
    }

    /**************************************************************
     * Description for what methods do...
     *
     * @param year is the year used in creating the object
     * @param month is the month used in creating the object
     * @param day is the day used in creating the object
     * @throws java.lang.IllegalArgumentException when the date is out of range
     * @throws java.lang.RuntimeException
     **************************************************************/

    public boolean isValidDate(int year, int month, int day) {
        return (month > 0) && (year >= MIN_YEAR) && (day > 0) && (month < 13) && (day <= 31);//year must be >= MIN_YEAR, impossible for day of month to be = 0
    }

    /**************************************************************
     * Method checks to see if year is = to leap year
     **************************************************************/
    private boolean isLeapYear(int year) {
        if (year % 400 == 0 || year % 100 != 0 && year % 4 == 0) //year is evenly divisible by 4, 100, and 400.
            return true;
        else return false;
    }


    /****************************************************************
     * @param fileName Method that saves the "this" GEOCDT to a file
     ****************************************************************/
    public void save(String fileName) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        } catch (IOException e) {
            throw new IllegalArgumentException();

        }

        String s = month + " " + day + " " + year;
        out.println(s);
        out.close();
    }

    /****************************************************************
     * @param fileName Method that loads the "this" GEOCDT object from a file.
     *****************************************************************/
    public void load(String fileName) {
        try {
            //open the data file
            Scanner fileReader = new Scanner(new File(fileName));

            //read one String in of data and an int
            month = fileReader.nextInt();
            day = fileReader.nextInt();
            year = fileReader.nextInt();
            System.out.println(month + " " + day + " " + year);
        }
        //could not find file
        catch (Exception error) {
            System.out.println("File not found ");
        }
    }

    /***********************************************************************
     * @param fromDate
     * @return Method that tests how many days from original date to new date
     **********************************************************************/
    public int daysToGo(String fromDate) {
        if (fromDate == null) {
            throw new IllegalArgumentException();
        }
        int count = 0;
        GeoCountDownTimer tempStart = new GeoCountDownTimer(fromDate);

        while (compareTo(tempStart) != 0) {
            count++;
            tempStart.inc();
        }
        return count;

    }

    /****************************************************************************************
     * @param n
     * @return Method that returns an integer that explains how many days are in the past
     ****************************************************************************************/
    public GeoCountDownTimer daysInFuture(int n) {
        GeoCountDownTimer s1 = new GeoCountDownTimer(this);
        if (n < 0) {
            s1.dec(-n);
        } else {
            s1.inc(n);
        }
        return s1;
    }
}
/* This util included have some basic
* standard date and time library for
* creating the class*/

import org.jetbrains.annotations.NotNull;

import java.util.*  ;

public class Task2 {

    /*Creating date class*/
    class dateTime {
        private int day;
        private int month;
        private int year;

        //.. Line 20-42: Create setter and getter.
        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        /**
         * Compare the date from the library
         * Note: getDay(), getMonth(), getYear()
         * is deprecated - no longer support
         **/
        public boolean compareTo(Date d) {
            int day1 = d.getDay();
            int month = d.getMonth();
            int year = d.getYear();
            return (this.year <= year)
                    && (this.month <= month)
                    && (this.day <= day1);
        }

        /**
         * Return a string representation
         * @return */
        public String toString() {
            return getString();
        }

        /** Returning the String formats
         * @return
         */
        @NotNull
        private String getString() {
            StringBuilder s = new StringBuilder();
            s.append(String.valueOf(this.year));
            s.append("-");
            if (this.month < 10) s.append("0");
            s.append(String.valueOf(this.month));
            s.append("-");
            if (this.day < 10) s.append("0");
            s.append(String.valueOf(this.day));
            return s.toString();
        }

        public static boolean isLeap(int year) {

            //..Using the library to save the hassling.
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, year);
            return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
        }
    }
}

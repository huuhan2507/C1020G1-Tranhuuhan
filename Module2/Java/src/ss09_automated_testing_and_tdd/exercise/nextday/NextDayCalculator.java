package ss09_automated_testing_and_tdd.exercise.nextday;


import java.util.Date;

public class NextDayCalculator {
    public static void nextDay(int day, int month, int year) {
        String date = "";
        date += day + "/" + month + "/" + year;
        System.out.println("Date: ");
        System.out.println(date);
    }

    public static void nextAfterDay(int day, int month, int year) {
        String date = "";
        if (year % 4 == 0) {
            switch (month) {
                case 2:
                    if (day >= 29) {
                        if (month >= 12) {
                            year += 1;
                            month = 1;
                            day = 1;
                        } else {
                            month += 1;
                            day = 1;
                        }
                    } else day += 1;
                    break;
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (day >= 31) {
                        if (month >= 12) {
                            year += 1;
                            month = 1;
                            day = 1;
                        } else {
                            month += 1;
                            day = 1;
                        }
                    } else day += 1;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (day >= 30) {
                        if (month >= 12) {
                            year += 1;
                            month = 1;
                            day = 1;
                        } else {
                            month += 1;
                            day = 1;
                        }
                    } else {
                        day += 1;
                    }
                    break;
                default:
            }
            System.out.println("After Day: ");
            date += day + "/" + month + "/" + year;
            System.out.println(date);

        } else {

            switch (month) {
                case 2:
                    if (day >= 28) {
                        if (month >= 12) {
                            year += 1;
                            month = 1;
                            day = 1;
                        } else {
                            month += 1;
                            day = 1;
                        }
                    } else day += 1;
                    break;
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (day >= 31) {
                        if (month >= 12) {
                            year += 1;
                            month = 1;
                            day = 1;
                        } else {
                            month += 1;
                            day = 1;
                        }
                    } else day += 1;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (day >= 30) {
                        if (month >= 12) {
                            year += 1;
                            month = 1;
                            day = 1;
                        } else {
                            month += 1;
                            day = 1;
                        }
                    } else day += 1;
                    break;
                default:
            }
            System.out.println("After Day: ");
            date += day + "/" + month + "/" + year;
            System.out.println(date);
        }

    }


}

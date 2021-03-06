import java.util.*;
import java.util.stream.IntStream;


public class NameOfTheDayScanner {
    private int year,month,day;

    public NameOfTheDayScanner(){
        year=1900;
        month=1;
        day=1;
    }

    public void setMonth(int month)          //set month, only to test
    {
        if(month>0&&month<13)
        this.month = month;
    }
    public void setYear(int year)            //set year, only to test
    {
        if(year>-1&&year<10000)
        this.year = year;
    }
    public void setYear(Scanner reader) {
        while (true) {
            System.out.print("Year: ");
            String input = reader.nextLine();
            if (input.matches("\\d{1,4}")) {
                this.year = Integer.parseInt(input);
                return;
            }
            if (input.isEmpty())
                return;
            System.out.println("Wrong year. Try again");
        }
    }

    public void setMonth(Scanner reader){
        while (true) {
            System.out.print("Month: ");
            String input = reader.nextLine();
            if (input.matches("\\d{1,2}")) {
                int month=Integer.parseInt(input);
                if(month>0&&month<13) {
                    this.month = Integer.parseInt(input);
                    return;
                }
            }
            if (input.isEmpty())
                return;
            System.out.println("Wrong month. Try again");
        }
    }

    public void setDay(Scanner reader) {
        final int[] thirtyDays = {4, 6, 9, 11};
        final int[] thirtyOneDays = {1, 3, 5, 7, 8, 10, 12};
        if (IntStream.of(thirtyOneDays).anyMatch(x -> x == this.month)) {
            dayScanner(reader, 31);
        }
        else if (IntStream.of(thirtyDays).anyMatch(x -> x == this.month)) {
            dayScanner(reader, 30);
        }
        else {
            if(this.year%4!=0||(this.year%100==0&&this.year%400!=0))
                dayScanner(reader, 28);
            else
                dayScanner(reader,29);
        }
    }

    public void setCombo(Scanner reader)  //setting year,month and day in one method
    {
        setYear(reader);
        setMonth(reader);
        setDay(reader);
    }

    public int getDay() {
        return this.day;
    }
    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }

    private void dayScanner(Scanner reader, int range)   //input Scanner to set day
    {
        while (true) {
            System.out.print("Day: ");
            String input = reader.nextLine();
            if ((input.matches("\\d{1,2}"))) {
                int day = Integer.parseInt(input);
                if (day > 0 && day <= range) {
                    this.day = day;
                    return;
                }
            }
            if (input.isEmpty())
                return;
            System.out.println("Wrong day. Try again");
        }
    }
}
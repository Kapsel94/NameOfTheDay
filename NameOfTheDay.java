import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Kapsel on 2018-02-17.
 */
public class NameOfTheDay {

    private Scanner reader;
    private int year,month,day,days;
    private final int fday=1,fmonth=1,fyear=1900; // pierwszy dzien naliczania

    public NameOfTheDay(Scanner reader){
        this.reader=reader;
        year=1900;
        month=1;
        day=1;
    }

    public static void main(String[] args){
        // Assuming that you already have this.
        int year = 1994;
        int month = 7;
        int day = 28;
        Date date=new Date();

// First convert to Date. This is one of the many ways.
        String dateString = String.format("%d-%d-%d", year, month, day);
        try{
            date = new SimpleDateFormat("yyyy-M-d").parse(dateString);
        }
        catch(Exception e){
            e.printStackTrace();
        }

// Then get the day of week from the Date based on specific locale.
        String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);

        System.out.println(dayOfWeek); // Friday
    }

    private void combo(Scanner reader)                     /* rok, miesiac, data w jednym, w tej kolejnosci*/ {
       year(reader);
       month(reader);
       day(reader);
    }
    private void year(Scanner reader)                      /* prosi o podanie roku*/             {
        while(true){
            System.out.print("Rok (dolna granica to 1900}:");
            String input=reader.nextLine();
        if(input.matches("\\d{4}")){
            this.year=Integer.parseInt(input);
            break;
        }
        else System.out.println("Niewłaściwy zakres.");
        }
    }
    private void month(Scanner reader)                     /* prosi o podanie miesiaca*/{
        while(true){
            System.out.print("Miesiąc: ");
            String input=reader.nextLine();
            if(input.matches("\\d{1,2}")&&Integer.parseInt(input)<13){
                this.month=Integer.parseInt(input);
                break;
            }
            else System.out.println("Niewłaściwe dane.");
        }
    }
    private void day(Scanner reader)                       /* prosi o podanie dnia */{
        while(true){
            System.out.print("Dzień: ");
            String input=reader.nextLine();
            if(input.matches("\\d{1,2}")&&((days30()&&Integer.parseInt(input)<31)||(days31()&&Integer.parseInt(input)<32))){
                this.day=Integer.parseInt(input);
                break;
            }
            else if(input.matches("\\d{1,2}")&&this.month==2){
                if(notFebruary(input)){
                    System.out.println("Niewłaściwe dane.");
                }
                else{
                    this.day=Integer.parseInt(input);
                    return;
                }
            }
            else System.out.println("Niewłaściwe dane.");
        }
    }
    private void days()                                    /* oblicza ile dni uplynelo od 1 stycznia 1900, poniedzielak*/{    }
    private boolean days31(){
        ArrayList<Integer> days=new ArrayList<>();
        int[] day={1,3,5,7,8,10,12};
        if(Arrays.asList(day).contains(this.month)){
            return true;
        }
        else return false;
    }
    private boolean days30(){
        ArrayList<Integer> days=new ArrayList<>();
        int[] day={4,6,9,11};
        if(Arrays.asList(day).contains(this.month)){
            return true;
        }
        else return false;
    }
    private boolean notFebruary(String input){
        if(Integer.parseInt(input)>29||
                (Integer.parseInt(input)==29&&(this.year%4!=0||(this.year%100==0&&this.year%400!=0)))){
            return true;
        }
        else return false;
    }


}

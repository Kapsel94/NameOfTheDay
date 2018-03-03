
public class NOTDLogic {
    private final static int YEAR=1900;
    private final static int MONTH=1;
    private final static int DAY=1;
    private int year,month,day;
    private int daysDifference;
    private Days daysName;

    public NOTDLogic(int year,int month,int day){
       this.year=year;
       this.month=month;
       this.day=day;
    }
    public NOTDLogic(NameOfTheDay day){
        this.year=day.getYear();
        this.month=day.getMonth();
        this.day=day.getDay();
    }

    public int counting(){
        boolean isLater=this.year>=YEAR;
        if(isLater){
        }
        return 0;
    }
    public int countingLater(){
        int daysDiff=365*(this.year-YEAR);
        return 0;
    }
    public int howManyLeapYearsLater(){
        int diff=this.year-YEAR;
        if(diff>3) {
            int notDivisiveBy400 = (((diff + 300) / 400) - 1) * 3 + ((diff + 300) % 400) / 100;
            if (!(this.month > 2 || (this.month == 2 && this.day == 29))&&isLeapYear())
                return diff / 4 - notDivisiveBy400-1;
            else return diff / 4 - notDivisiveBy400;
        }
        else return 0;
    }
    private boolean isLeapYear(){
        int year=this.year;
        if(year%400==0)
            return true;
        else if(year%100==0)
            return false;
        else if(year%4==0)
            return true;
        else return false;
    }
}

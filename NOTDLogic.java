
public class NOTDLogic {
    private final static int YEAR=1900;
    private final static int MONTH=1;
    private final static int DAY=1;
    private int year,month,day;
    //private int daysDiff;
    //private Days daysName;
    private static final int[] monthsDays={31,28,31,30,31,30,31,31,30,31,30,31};

    public NOTDLogic(int year,int month,int day){
       this.year=year;
       this.month=month;
       this.day=day;
    }
    public NOTDLogic(NameOfTheDayScanner day){
        this.year=day.getYear();
        this.month=day.getMonth();
        this.day=day.getDay();
    }

    public int howManyDaysDiff()
    {
        boolean isLater=this.year>=YEAR;
        if(isLater){
            return howManyDaysLater();
        }
        else return howManyDaysEarlier();
    }
    public int howManyDaysLater()       //howManyDaysDiff number of days since 1st January 1900
    {
        int daysDiff=365*(this.year-YEAR)+howManyLeapYearsLater();
        int days=this.day-DAY;
        for(int i=0;i<this.month-1;i++)
            daysDiff+=monthsDays[i];
        daysDiff+=days;
        if(this.month==2&&this.day==29)
            return daysDiff-1;
        return daysDiff;
    }
    public int howManyDaysEarlier()     //howManyDaysDiff number of days to 1st January 1900
    {
        int fyear,fmonth,fday;
        fyear=1899;
        fmonth=12;
        fday=31;
        int daysDiff=365*(fyear-this.year)+howManyLeapYearsEarlier();
        int days=fday-this.day;
        for(int i=fmonth;i>this.month;i--)
            daysDiff+=monthsDays[i-1];
        daysDiff+=days;
        if(this.month==2&&this.day==29)
            return daysDiff-1;
        else if(this.month==2)
            return daysDiff-2;
        return daysDiff+1;
    }
    public int howManyLeapYearsLater(){
        int diff=this.year-YEAR;
        if(diff>3) {
            //int notDivisiveBy400 = (((diff + 300) / 400) - 1) * 3 + ((diff + 300) % 400) / 100;
            int notDivisiveBy400=diff/100-(diff+300)/400;
            if (!(this.month > 2 || (this.month == 2 && this.day == 29))&&isLeapYear())
                return diff / 4 - notDivisiveBy400-1;
            else return diff / 4 - notDivisiveBy400;
        }
        else return 0;
    }

    public int howManyLeapYearsEarlier(){
        int diff=YEAR-this.year;
        if(diff>3) {
            //int notDivisiveBy400 = (((diff + 100) / 400) - 1) * 3 + ((diff + 100) % 400) / 100+2;
            int notDivisiveBy400=diff/100-(diff+100)/400;
            if ((this.month > 2 || (this.month == 2 && this.day == 29))&&isLeapYear())
                return diff / 4 - notDivisiveBy400-1;
            else return diff / 4 - notDivisiveBy400;
        }
        else return 0;
    }

    public String whichDayIsIt(){
        int day= howManyDaysDiff()%7;
        if(this.year>=YEAR) {
            switch (day) {
                case 0:
                    return Days.MONDAY.getName();
                case 1:
                    return Days.TUESDAY.getName();
                case 2:
                    return Days.WEDNESDAY.getName();
                case 3:
                    return Days.THURSDAY.getName();
                case 4:
                    return Days.FRIDAY.getName();
                case 5:
                    return Days.SATURDAY.getName();
                default:
                    return Days.SUNDAY.getName();
            }
        }
        else
            switch (day) {
                case 0:
                    return Days.MONDAY.getName();
                case 6:
                    return Days.TUESDAY.getName();
                case 5:
                    return Days.WEDNESDAY.getName();
                case 4:
                    return Days.THURSDAY.getName();
                case 3:
                    return Days.FRIDAY.getName();
                case 2:
                    return Days.SATURDAY.getName();
                default:
                    return Days.SUNDAY.getName();
            }
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

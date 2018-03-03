public enum Days{
    MONDAY (1,"Monday"),
    TUESDAY(2,"Tuesday"),
    WEDNESDAY(3,"Wednesday"),
    THURSDAY(4,"Thursday"),
    FRIDAY(5,"Friday"),
    SATURDAY(6,"Saturday"),
    SUNDAY(7,"Sunday");

    private int day;
    private String name;

    Days(int day,String name){
        this.day=day;
        this.name=name;
    }

    public int getDay() {
        return day;
    }

    public String getName() {
        return "Day: "+name;
    }
}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class NOTDLogicTest {

    @Test
    public void is2000Year25thLeapYear(){
        NOTDLogic logic=new NOTDLogic(2000,2,29);
        assertEquals(25,logic.howManyLeapYearsLater());
        logic=new NOTDLogic(2400,2,28);
        assertEquals(121,logic.howManyLeapYearsLater());
        logic=new NOTDLogic(2400,2,29);
        assertEquals(122,logic.howManyLeapYearsLater());
        logic=new NOTDLogic(2413,1,1);
        assertEquals(125,logic.howManyLeapYearsLater());
    }
    @Test
    public void is2100Year49thLeapYear(){
        NOTDLogic logic=new NOTDLogic(2053,3,1);
        assertEquals(38,logic.howManyLeapYearsLater());
        logic=new NOTDLogic(2100,2,1);
        assertEquals(49,logic.howManyLeapYearsLater());
        logic=new NOTDLogic(2200,1,1);
        assertEquals(73,logic.howManyLeapYearsLater());
        logic=new NOTDLogic(2496,1,1);
        assertEquals(145,logic.howManyLeapYearsLater());
        logic=new NOTDLogic(2501,4,1);
        assertEquals(146,logic.howManyLeapYearsLater());
    }
    @Test
    public void isXDaysLeftSince1stJanuary1900(){
        NOTDLogic logic=new NOTDLogic(1994,1,1);
        assertEquals(34333,logic.counting());
        logic=new NOTDLogic(1994,7,28);
        assertEquals(34541,logic.counting());
        logic=new NOTDLogic(2004,2,28);
        assertEquals(38043,logic.counting());
        logic=new NOTDLogic(2004,2,29);
        assertEquals(38044,logic.counting());
        logic=new NOTDLogic(2004,3,1);
        assertEquals(38045,logic.counting());
        logic=new NOTDLogic(2096,2,28);
        assertEquals(71646,logic.counting());
        logic=new NOTDLogic(2096,2,29);
        assertEquals(71647,logic.counting());
        logic=new NOTDLogic(2096,3,1);
        assertEquals(71648,logic.counting());
    }
    @Test
    public void isExactlyGoodNameDay(){
        NOTDLogic logic=new NOTDLogic(1994,7,28);
        assertEquals("Day: Thursday",logic.whichDayIsIt());
        logic=new NOTDLogic(2001,9,11);
        assertEquals("Day: Tuesday",logic.whichDayIsIt());
        logic=new NOTDLogic(2018,2,28);
        assertEquals("Day: Wednesday",logic.whichDayIsIt());
        logic=new NOTDLogic(2018,3,1);
        assertEquals("Day: Thursday",logic.whichDayIsIt());
        logic=new NOTDLogic(2016,2,28);
        assertEquals("Day: Sunday",logic.whichDayIsIt());
        logic=new NOTDLogic(2016,2,29);
        assertEquals("Day: Monday",logic.whichDayIsIt());
        logic=new NOTDLogic(2016,3,1);
        assertEquals("Day: Tuesday",logic.whichDayIsIt());

    }

}
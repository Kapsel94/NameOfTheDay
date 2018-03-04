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
        logic=new NOTDLogic(1904,2,27);
        assertEquals(0,logic.howManyLeapYearsLater());
        logic=new NOTDLogic(1904,2,29);
        assertEquals(1,logic.howManyLeapYearsLater());
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
        assertEquals(34333,logic.howManyDaysDiff());
        logic=new NOTDLogic(1994,7,28);
        assertEquals(34541,logic.howManyDaysDiff());
        logic=new NOTDLogic(2004,2,28);
        assertEquals(38043,logic.howManyDaysDiff());
        logic=new NOTDLogic(2004,2,29);
        assertEquals(38044,logic.howManyDaysDiff());
        logic=new NOTDLogic(2004,3,1);
        assertEquals(38045,logic.howManyDaysDiff());
        logic=new NOTDLogic(2096,2,28);
        assertEquals(71646,logic.howManyDaysDiff());
        logic=new NOTDLogic(2096,2,29);
        assertEquals(71647,logic.howManyDaysDiff());
        logic=new NOTDLogic(2096,3,1);
        assertEquals(71648,logic.howManyDaysDiff());
    }
    @Test
    public void isXDaysTo1stJanuary1900(){
        NOTDLogic logic=new NOTDLogic(1896,3,1);
        assertEquals(1401,logic.howManyDaysDiff());
        logic=new NOTDLogic(1896,2,29);
        assertEquals(1402,logic.howManyDaysDiff());
        logic=new NOTDLogic(1896,2,28);
        assertEquals(1403,logic.howManyDaysDiff());
        logic=new NOTDLogic(1895,2,14);
        assertEquals(1782,logic.howManyDaysDiff());
        logic=new NOTDLogic(1894,2,5);
        assertEquals(2156,logic.howManyDaysDiff());
        logic=new NOTDLogic(1703,5,25);
        assertEquals(71809,logic.howManyDaysDiff());
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
        logic=new NOTDLogic(1894,1,15);
        assertEquals("Day: Monday",logic.whichDayIsIt());
        logic=new NOTDLogic(1791,5,3);
        assertEquals("Day: Tuesday",logic.whichDayIsIt());
        logic=new NOTDLogic(1703,5,25);
        assertEquals("Day: Friday",logic.whichDayIsIt());

    }
    @Test
    public void isLeapYearsEarlier(){
        NOTDLogic logic=new NOTDLogic(1896,3,1);
        assertEquals(0,logic.howManyLeapYearsEarlier());
        logic=new NOTDLogic(1896,2,29);
        assertEquals(0,logic.howManyLeapYearsEarlier());
        logic=new NOTDLogic(1896,2,28);
        assertEquals(1,logic.howManyLeapYearsEarlier());
        logic=new NOTDLogic(1800,3,1);
        assertEquals(24,logic.howManyLeapYearsEarlier());
        logic=new NOTDLogic(1800,2,28);
        assertEquals(24,logic.howManyLeapYearsEarlier());
        logic=new NOTDLogic(1796,2,28);
        assertEquals(25,logic.howManyLeapYearsEarlier());
        logic=new NOTDLogic(1600,3,1);
        assertEquals(72,logic.howManyLeapYearsEarlier());
        logic=new NOTDLogic(1600,2,28);
        assertEquals(73,logic.howManyLeapYearsEarlier());
    }
}
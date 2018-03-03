
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class NOTDLogicTest {

    @Test
    public void is2000Year25thLeapYear(){
        NOTDLogic logic=new NOTDLogic(2000,2,29);
        assertEquals(25,logic.howManyLeapYearsLater());
        logic=new NOTDLogic(2400,1,1);
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

}
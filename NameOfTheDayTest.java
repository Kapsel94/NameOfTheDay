
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

public class NameOfTheDayTest {

    @Test
    public void isDay31Valid(){
        String data="awdwda\n40\n-10\n02";
        NameOfTheDay day=new NameOfTheDay();
        day.setMonth(1);
        day.setDay(new Scanner(data));
        assertEquals(2,day.getDay());
    }
    @Test
    public void isDay31MessageNot(){
        String data="31";
        ByteArrayOutputStream mockOut = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(mockOut);
        System.setOut(newOut);
        NameOfTheDay day=new NameOfTheDay();
        day.setMonth(1);
        day.setDay(new Scanner(data));
        try{
            assertFalse(new String(mockOut.toByteArray(), "UTF-8").contains("Wrong day. Try again"));
        }
        catch(Exception e){}
    }
    @Test
    public void isDay31Message(){
        String data="40\n02";
        ByteArrayOutputStream mockOut = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(mockOut);
        System.setOut(newOut);
        NameOfTheDay day=new NameOfTheDay();
        day.setMonth(1);
        day.setDay(new Scanner(data));
        try{
            assertTrue(new String(mockOut.toByteArray(), "UTF-8").contains("Wrong day. Try again"));
        }
        catch(Exception e){}
    }
    @Test
    public void isDay30Valid(){
        String data="31\n-10\n02";
        NameOfTheDay day=new NameOfTheDay();
        day.setMonth(4);
        day.setDay(new Scanner(data));
        assertEquals(2,day.getDay());
    }
    @Test
    public void isDay30MessageNot(){
        String data="30";
        ByteArrayOutputStream mockOut = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(mockOut);
        System.setOut(newOut);
        NameOfTheDay day=new NameOfTheDay();
        day.setMonth(4);
        day.setDay(new Scanner(data));
        try{
            assertFalse(new String(mockOut.toByteArray(), "UTF-8").contains("Wrong day. Try again"));
        }
        catch(Exception e){}
    }
    @Test
    public void isDay30Message(){
        String data="31\n02";
        ByteArrayOutputStream mockOut = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(mockOut);
        System.setOut(newOut);
        NameOfTheDay day=new NameOfTheDay();
        day.setMonth(4);
        day.setDay(new Scanner(data));
        try{
            assertTrue(new String(mockOut.toByteArray(), "UTF-8").contains("Wrong day. Try again"));
        }
        catch(Exception e){}
    }
    @Test
    public void doesNotFebruary1900Have29Days(){
        String data="29\n10";
        NameOfTheDay day=new NameOfTheDay();
        day.setMonth(2);
        day.setYear(1900);
        day.setDay(new Scanner(data));
        assertNotEquals(29,day.getDay());
    }
    @Test
    public void doesNotFebruary1901Have29Days(){
        String data="29\n10";
        NameOfTheDay day=new NameOfTheDay();
        day.setMonth(2);
        day.setYear(1901);
        day.setDay(new Scanner(data));
        assertNotEquals(29,day.getDay());
    }
    @Test
    public void doesFebruary2000Have29Days(){
        String data="30\n29";
        NameOfTheDay day=new NameOfTheDay();
        day.setMonth(2);
        day.setYear(2000);
        day.setDay(new Scanner(data));
        assertEquals(29,day.getDay());
    }
    @Test
    public void doesFebruary2004Have29Days(){
        String data="-30\n29\n15";
        NameOfTheDay day=new NameOfTheDay();
        day.setMonth(2);
        day.setYear(2004);
        day.setDay(new Scanner(data));
        assertEquals(29,day.getDay());
    }
    @Test
    public void isDay28MessageNot(){
        String data="28";
        ByteArrayOutputStream mockOut = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(mockOut);
        System.setOut(newOut);
        NameOfTheDay day=new NameOfTheDay();
        day.setMonth(2);
        day.setDay(new Scanner(data));
        try{
            assertFalse(new String(mockOut.toByteArray(), "UTF-8").contains("Wrong day. Try again"));
        }
        catch(Exception e){}
    }
    @Test
    public void isDay28Message(){
        String data="29\n02";
        ByteArrayOutputStream mockOut = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(mockOut);
        System.setOut(newOut);
        NameOfTheDay day=new NameOfTheDay();
        day.setMonth(2);
        day.setDay(new Scanner(data));
        try{
            assertTrue(new String(mockOut.toByteArray(), "UTF-8").contains("Wrong day. Try again"));
        }
        catch(Exception e){}
    }
    @Test
    public void isDay1WhenStringIsEmpty(){
        String data="\n-10\n02";
        NameOfTheDay day=new NameOfTheDay();
        day.setMonth(4);
        day.setDay(new Scanner(data));
        assertEquals(1,day.getDay());
    }
    @Test
    public void isDay1WhenStringIsFirstBlank(){
        String data="   \n-10\n02";
        NameOfTheDay day=new NameOfTheDay();
        day.setMonth(4);
        day.setDay(new Scanner(data));
        assertEquals(2,day.getDay());
    }
    @Test
    public void isYearValid(){
        String datas="-10\n02\n1994\n-197\n\n\n";
        Scanner data=new Scanner(datas);
        NameOfTheDay day=new NameOfTheDay();
        day.setYear(data);
        assertEquals(2,day.getYear());
        day.setYear(data);
        assertEquals(1994,day.getYear());
        day.setYear(data);
        assertEquals(1994,day.getYear());

    }
    @Test
    public void isMonthValid(){
        String datas="-10\n02\n1994\n13\n12\n7";
        Scanner data=new Scanner(datas);
        NameOfTheDay day=new NameOfTheDay();
        day.setMonth(data);
        assertEquals(2,day.getMonth());
        day.setMonth(data);
        assertEquals(12,day.getMonth());
        day.setMonth(data);
        assertEquals(7,day.getMonth());

    }
    @Test
    public void is1996_02_29(){
        String datas="-10\n1996\n  \n2\n30\n29";
        Scanner data=new Scanner(datas);
        NameOfTheDay day=new NameOfTheDay();
        day.setCombo(data);
        assertEquals(2,day.getMonth());
        assertEquals(29,day.getDay());
        assertEquals(1996,day.getYear());
    }
    @Test
    public void is2100_02_29False(){
        String datas="-10\n2100\n  \n2\n30\n29\n28";
        Scanner data=new Scanner(datas);
        NameOfTheDay day=new NameOfTheDay();
        day.setCombo(data);
        assertEquals(2,day.getMonth());
        assertEquals(28,day.getDay());
        assertEquals(2100,day.getYear());
    }
}
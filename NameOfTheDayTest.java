
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
        day.setDays(new Scanner(data));
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
        day.setDays(new Scanner(data));
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
        day.setDays(new Scanner(data));
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
        day.setDays(new Scanner(data));
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
        day.setDays(new Scanner(data));
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
        day.setDays(new Scanner(data));
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
        day.setDays(new Scanner(data));
        assertNotEquals(29,day.getDay());
    }
    @Test
    public void doesNotFebruary1901Have29Days(){
        String data="29\n10";
        NameOfTheDay day=new NameOfTheDay();
        day.setMonth(2);
        day.setYear(1901);
        day.setDays(new Scanner(data));
        assertNotEquals(29,day.getDay());
    }
    @Test
    public void doesFebruary2000Have29Days(){
        String data="30\n29";
        NameOfTheDay day=new NameOfTheDay();
        day.setMonth(2);
        day.setYear(2000);
        day.setDays(new Scanner(data));
        assertEquals(29,day.getDay());
    }
    @Test
    public void doesFebruary2004Have29Days(){
        String data="-30\n29\n15";
        NameOfTheDay day=new NameOfTheDay();
        day.setMonth(2);
        day.setYear(2004);
        day.setDays(new Scanner(data));
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
        day.setDays(new Scanner(data));
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
        day.setDays(new Scanner(data));
        try{
            assertTrue(new String(mockOut.toByteArray(), "UTF-8").contains("Wrong day. Try again"));
        }
        catch(Exception e){}
    }
}
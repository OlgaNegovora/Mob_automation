import org.junit.Assert;
import org.junit.Test;

public class MainClassTest
{
    MainClass Math=new MainClass();
    @Test
    public void testGetClassString()
    {
     String x = Math.getClassString();
     int actual=x.toLowerCase().indexOf("hello");
     Assert.assertTrue("In getClassString no substring Hello or hello ",actual>=0) ;
    }
}

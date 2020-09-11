import org.junit.Assert;
import org.junit.Test;

public class MainClassTest
{
    MainClass Math=new MainClass();
    @Test
    public void testGetClassString()
    {
     String x = Math.getClassString();
     int actualx=x.indexOf("Hello");
     int actualy=x.indexOf("hello");
     Assert.assertTrue("In getClassString no substring Hello or hello ",((actualx>=0) || (actualy>=0)));
    }
}

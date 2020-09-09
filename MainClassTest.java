import org.junit.Assert;
import org.junit.Test;

public class MainClassTest
{
    MainClass Math=new MainClass();
    @Test
    public void testGetClassNumber()
    {
        int actual = Math.getClassNumber();
        Assert.assertTrue("getClassNumber returned <=45, getClassNumber = "+ actual ,actual>45) ;
    }
}

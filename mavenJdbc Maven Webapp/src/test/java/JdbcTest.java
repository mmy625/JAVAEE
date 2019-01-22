import org.junit.Test;

import com.kgc.util.JdbcUtils;

public class JdbcTest
{
    @Test
    public void printTest()
    {
        System.out.println("*************"+new JdbcUtils().getConnection());
    }
}

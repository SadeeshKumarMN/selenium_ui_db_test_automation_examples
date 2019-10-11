package postgreSQLdatabase;

import com.google.common.collect.Multimap;
import org.testng.annotations.Test;
import utils.JDBCDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class PostgreSQLTests extends JDBCDriver {

    @Test
    public void testPostgreSQL() {
        String sql = "delete from person_new where id=999;";
        createPostgresqlConnection(sql);
        Multimap<String, String> multiMap;
        String verifysql = "select * from person_new";
        multiMap = createPostgresqlConnection(verifysql);
        //System.out.println("The size of the map is "+multiMap.size());
        for (var finalValue : multiMap.keySet()) {
            System.out.println("The Key: " + finalValue + " and the Value is: " + multiMap.get(finalValue));
        }
        //multiMap.forEach((k, v) -> System.out.print("The Key is " + k + " and the Value is " + v));
        assertEquals(multiMap.get("id").size(), 998, "Incorrect Size");
        assertTrue(multiMap.get("id").contains("1"), "Incorrect output");
    }

}

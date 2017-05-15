/**
 * Created by yulia on 12.05.17.
 */

import com.company.model.SQLDatabaseConnector;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-application-context.xml")
public class PostgresSQLDatabaseConnectorTest {

    //Test for specific database!!!

    @Autowired
    private SQLDatabaseConnector sqlDatabaseConnector;
    private String database;
    private String user;
    private String password;

    @Before
    public void init(){
        database = "sqlcmd";
        user = "postgres";
        password = "yes";
    }

    @Test(expected = RuntimeException.class)
    public void shouldFailedConnect() {
        sqlDatabaseConnector.connect(database, "", password);
    }

    @Test
    public void shouldConnect() throws SQLException {
        Connection connection = sqlDatabaseConnector.connect(database, user, password);
        assertNotNull(connection);
    }

    @Test
    public void shouldGetConnect() throws SQLException {
        sqlDatabaseConnector.connect(database, user, password);
        assertNotNull(sqlDatabaseConnector.getConnection());
    }

}

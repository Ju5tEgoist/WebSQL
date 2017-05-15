import com.company.model.FindProvider;
import com.company.model.SQLDatabaseConnector;
import com.company.view.TablePresenter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

import static org.junit.Assert.*;
/**
 * Created by yulia on 15.05.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-application-context.xml")
public class FindProviderTest {

    //Test for specific database

    @Autowired
    SQLDatabaseConnector sqlDatabaseConnector;
    @Autowired
    FindProvider findProvider;
    @Autowired
    TablePresenter tablePresenter;

    @Before
    public void init(){
        sqlDatabaseConnector.connect("sqlcmd", "postgres", "yes");
    }

    @Test(expected = NullPointerException.class)
    public void shouldFailedLOTablePresentation(){
        findProvider.tablePresentationLO(null, "0/0");
    }

    @Test(expected = NullPointerException.class)
    public void shouldFailedTablePresentation(){
        findProvider.tablePresentation(null, "");
    }

    @Test
    public void shouldReturnMapLOTablePresentation(){
        assertNotNull(findProvider.tablePresentationLO("first", "0/0"));
    }

    @Test
    public void shouldReturnMapTablePresentation(){
        assertNotNull(findProvider.tablePresentation("first", ""));
    }



}

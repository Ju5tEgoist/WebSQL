package builder;

import com.company.controller.query.builder.*;
import com.company.controller.query.parameter.QueryParameters;
import com.company.model.SQLDatabaseConnector;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by yulia on 15.05.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-application-context.xml")
public class QueryBuilderTest {
    @Autowired
    private QueryParameters queryParameters;
    @Autowired
    private SQLDatabaseConnector sqlDatabaseConnector;
    @Autowired
    private ClearQueryBuilder clearQueryBuilder;
    @Autowired
    private CreateQueryBuilder createQueryBuilder;
    @Autowired
    private DeleteQueryBuilder deleteQueryBuilder;
    @Autowired
    private DropQueryBuilder dropQueryBuilder;
    @Autowired
    private InsertQueryBuilder insertQueryBuilder;
    @Autowired
    private UpdateTableQueryBuilder updateTableQueryBuilder;


    @Before
    public void init(){
        sqlDatabaseConnector.connect("sqlcmd", "postgres", "yes");
    }

    @Test
    public void shouldReturnClearQuery(){
        queryParameters.setTableName("newtable");
        assertEquals(clearQueryBuilder.build(queryParameters), "DELETE FROM " + "newtable");
    }

    @Test
    public void shouldReturnCreateQuery(){
        QueryParameters queryParameters = mock(QueryParameters.class);
        assertEquals(createQueryBuilder.build(queryParameters), "CREATE TABLE " + null + "(" + ")");
    }

    @Test
    public void shouldReturnDeleteQuery(){
        queryParameters.setTableName("first");
        queryParameters.setColumn("name");
        queryParameters.setValue("NewNick");
        assertEquals(deleteQueryBuilder.build(queryParameters), "DELETE FROM " +
               "first" + " " + "WHERE" + " "
                + "name" + " " + "=" + " " + "'" + "NewNick" + "'");
    }

    @Test
    public void shouldReturnDropQuery(){
        queryParameters.setTableName("newtable");
        assertEquals(dropQueryBuilder.build(queryParameters), "DROP TABLE " + "newtable");
    }

    @Test
    public void shouldReturnInsertQuery(){
        queryParameters.setTableName("newtable");
        assertEquals(insertQueryBuilder.build(queryParameters), "INSERT INTO " + "newtable" + " " + "("
                + "name,position" + ")" + " " + "VALUES" + " " + "(" +  ")");
    }

    @Test
    public void shouldReturnUpdateQuery(){
        queryParameters.setTableName("newtable");
        assertEquals(updateTableQueryBuilder.build(queryParameters), "UPDATE " + "newtable" + " " + "SET"
                + " " + null + " " + "=" + " " + null + " " + "WHERE" + " " + null + " " + "=" + null);
    }

}

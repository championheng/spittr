import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import spittr.DAO.JdbcSpittleRepository;
import spittr.DAOImpl.SpittleRepository;
import spittr.config.DataSourceConfiguration;
import spittr.config.RootConfig;
import spittr.model.Spittle;
import spittr.web.SpittleController;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by hg_yi on 17-11-7.
 */
//@ContextConfiguration(classes={RootConfig.class, DataSourceConfiguration.class})
public class SpittleControllerTest {
//    @Autowired
//    private JdbcSpittleRepository jdbcSpittleRepository;
//
//    @Autowired
//    private JdbcOperations jdbcOperations;

    @Test
    public void shouldShowPagedSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(20);
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView(
                "/views/spittles.jsp"
        )).build();

        mockMvc.perform(get("/spittles")).andExpect(
                view().name("spittles")).andExpect(model().attributeExists(
                        "spittleList")).andExpect(model().attribute(
                                "spittleList", hasItems(expectedSpittles.toArray()))
        );
    }

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i = 0; i < count; i++) {
            Spittle spittle = new Spittle(i, "Spittle " + i, new Date());
//            jdbcSpittleRepository.addSpittle(spittle);
            spittles.add(spittle);
        }

        return spittles;
    }
}

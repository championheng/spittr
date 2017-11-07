package spittr.DAO;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import spittr.DAOImpl.SpitterRepository;
import spittr.model.Spittle;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by hg_yi on 17-11-7.
 */
@Repository
public class JdbcSpitterRepository implements SpitterRepository {
    JdbcOperations jdbcOperations;
    private final static String INSERT_SPITTER = "INSERT INTO spitter (username, password, " +
            "fullname) VALUES (?, ?, ?)";

    @Inject
    public JdbcSpitterRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public List<Spittle> findSpittles(long max, int count) {
        return null;
    }

    public void addSpittle(Spittle spittle) {
//        jdbcOperations.update(INSERT_SPITTER, )
    }
}

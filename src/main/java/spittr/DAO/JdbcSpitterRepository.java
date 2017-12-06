package spittr.DAO;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import spittr.DAOImpl.SpitterRepository;
import spittr.model.Spitter;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by hg_yi on 17-11-7.
 */
@Repository
public class JdbcSpitterRepository implements SpitterRepository {
    JdbcOperations jdbcOperations;
    private final static String INSERT_SPITTER = "INSERT INTO spitter (username, password, " +
            "firstname, lastname) VALUES (?, ?, ?, ?)";
    private final static String QUERY_SPITTER_BY_USERNAME = "SELECT * FROM spitter " +
            "WHERE username = ?";

    @Inject
    public JdbcSpitterRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public Spitter save(Spitter spitter) {
        jdbcOperations.update(INSERT_SPITTER, spitter.getUsername(), spitter.getPassword(),
                spitter.getFirstName(), spitter.getLastName());

        return spitter;
    }

    public List<Spitter> findByUsername(String username) {
        return jdbcOperations.query(QUERY_SPITTER_BY_USERNAME,
                new SpitterRowMapper(), username);
    }

    private final static class SpitterRowMapper implements RowMapper<Spitter> {
        public Spitter mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return new Spitter(
                    resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("firstname"),
                    resultSet.getString("lastname")
            );
        }
    }
}

package spittr.DAO;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import spittr.DAOImpl.SpittleRepository;
import spittr.model.Spittle;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hg_yi on 17-11-2.
 */
@Repository
public class JdbcSpittleRepository implements SpittleRepository {
    private JdbcOperations jdbcOperations;
    private final static String INSERT_SPITTLE = "INSERT INTO spittle (message, created_at, " +
            "latitude, longitude) VALUES (?, ?, ?, ?)";
    //查询小于指定数字的id，并按照创建时间降序排序并且选取前20的结果
    private final static String QUERY_SPITTLE = "SELECT * FROM spittle WHERE id < ? " +
            "ORDER BY created_at DESC LIMIT 20";
    private final static String QUERY_SPITTLE_BYID = "SELECT * FROM spittle WHERE id = ?";

    @Inject
    public JdbcSpittleRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();
        spittles.add(new Spittle(1, "spittle1", new Date()));

        return spittles;
//        return jdbcOperations.query(
//                QUERY_SPITTLE, new SpittleRowMapper(), max);
    }

    public void addSpittle(Spittle spittle) {
        jdbcOperations.update(INSERT_SPITTLE, spittle.getMessage(), spittle.getTime(),
                spittle.getLatitude(), spittle.getLongitude());
    }

    public List<Spittle> findOne(long spittleId) {
        return  jdbcOperations.query(QUERY_SPITTLE_BYID, new SpittleRowMapper(),
                spittleId);
    }

    private final static class SpittleRowMapper implements RowMapper<Spittle> {
        public Spittle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return new Spittle(
                    resultSet.getInt("id"),
                    resultSet.getString("message"),
                    resultSet.getDate("created_at"),
                    resultSet.getDouble("latitude"),
                    resultSet.getDouble("longitude")
            );
        }
    }
}

package spittr.DAOImpl;

import spittr.model.Spittle;

import java.util.List;

/**
 * Created by hg_yi on 17-10-12.
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
    void addSpittle(Spittle spittle);
    List<Spittle> findOne(long spittleId);
}

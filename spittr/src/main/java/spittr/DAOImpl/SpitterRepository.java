package spittr.DAOImpl;

import spittr.model.Spittle;

import java.util.List;

/**
 * Created by hg_yi on 17-11-7.
 */
public interface SpitterRepository {
    List<Spittle> findSpittles(long max, int count);
    void addSpittle(Spittle spittle);
}

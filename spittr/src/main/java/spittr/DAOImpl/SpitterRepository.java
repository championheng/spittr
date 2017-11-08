package spittr.DAOImpl;

import spittr.model.Spitter;

import java.util.List;

/**
 * Created by hg_yi on 17-11-7.
 */
public interface SpitterRepository {
    Spitter save(Spitter spitter);
    List<Spitter> findByUsername(String username);
}

package service;

import dao.CollectibleDao;
import model.Collectible;

import java.util.List;

public class CollectibleService {
    private final CollectibleDao dao = new CollectibleDao();

    public List<Collectible> findAll() { return dao.findAll(); }

    public Collectible findById(Long id) { return dao.findById(id); }

    public boolean createWithId(Collectible c) { return dao.createWithId(c); }

    public Long create(Collectible c) { return dao.create(c); }

    public boolean update(Collectible c) { return dao.update(c); }

    public boolean delete(Long id) { return dao.delete(id); }
}

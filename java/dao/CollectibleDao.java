package dao;

import model.Collectible;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class CollectibleDao {
    private static final AtomicLong idCounter = new AtomicLong(1);
    private static final List<Collectible> data = new ArrayList<>();

    public CollectibleDao() {
        Collectible sample = new Collectible();
        sample.setId(idCounter.getAndIncrement());
        sample.setName("Vintage Comic");
        sample.setDescription("Rare 1980 Marvel Edition");
        sample.setPrice(new BigDecimal("450.00"));
        data.add(sample);
    }

    public List<Collectible> findAll() { return data; }

    public Collectible findById(Long id) {
        return data.stream()
                .filter(x -> Objects.equals(x.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public boolean createWithId(Collectible c) {
        if (findById(c.getId()) != null) return false;
        data.add(c);
        return true;
    }

    public Long create(Collectible c) {
        c.setId(idCounter.getAndIncrement());
        data.add(c);
        return c.getId();
    }

    public boolean update(Collectible c) {
        return data.stream()
                .filter(x -> Objects.equals(x.getId(), c.getId()))
                .findFirst()
                .map(x -> {
                    x.setName(c.getName());
                    x.setDescription(c.getDescription());
                    x.setPrice(c.getPrice());
                    return true;
                })
                .orElse(false);
    }
    public boolean updatePrice(Long id, BigDecimal newPrice) {
        return data.stream()
                .filter(x -> Objects.equals(x.getId(), id))
                .findFirst()
                .map(x -> {
                    x.setPrice(newPrice);
                    return true;
                })
                .orElse(false);
    }

    public boolean delete(Long id) {
        return data.removeIf(x -> Objects.equals(x.getId(), id));
    }
}

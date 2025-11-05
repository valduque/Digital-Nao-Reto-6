package service;

import dao.CollectibleDao;
import store.exception.BadRequestException;
import store.exception.NotFoundException;
import model.Collectible;

import java.math.BigDecimal;
import java.util.List;

public class CollectibleService {
    private final CollectibleDao dao = new CollectibleDao();

    public List<Collectible> findAll() { return dao.findAll(); }

    public Collectible findById(Long id) {
        Collectible c = dao.findById(id);
        if (c == null) throw new NotFoundException("Collectible not found with ID: " + id);
        return c;
    }

    public boolean createWithId(Collectible c) { return dao.createWithId(c); }

    public Long create(Collectible c) { return dao.create(c); }

    public boolean update(Collectible c) { return dao.update(c); }

    public boolean delete(Long id) {
        boolean removed = dao.delete(id);
        if (!removed) throw new NotFoundException("Collectible not found with ID: " + id);
        return true;
    }

    // ✅ Nuevo método: gestionar ofertas
    public boolean placeOffer(Long id, BigDecimal offer) {
        Collectible c = dao.findById(id);
        if (c == null) throw new NotFoundException("Item not found with ID: " + id);

        // Validar oferta
        if (offer.compareTo(c.getPrice()) <= 0) {
            throw new BadRequestException("Offer must be higher than the current price");
        }

        // Actualizar precio
        c.setPrice(offer);
        return dao.update(c);
    }
}

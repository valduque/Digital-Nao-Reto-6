package controller;

import com.google.gson.Gson;
import model.Collectible;
import service.CollectibleService;

import static spark.Spark.*;

public class CollectibleController {
    private final CollectibleService service = new CollectibleService();
    private final Gson gson = new Gson();

    public void routes() {
        path("/api/collectibles", () -> {

            // GET /api/collectibles — Listar todos
            get("", (req, res) -> {
                res.type("application/json");
                return gson.toJson(service.findAll());
            });

            // GET /api/collectibles/:id — Obtener uno por ID
            get("/:id", (req, res) -> {
                res.type("application/json");
                Long id = Long.valueOf(req.params("id"));
                Collectible c = service.findById(id);

                if (c == null) {
                    res.status(404);
                    return "{ \"error\": \"Collectible not found\" }";
                }
                return gson.toJson(c);
            });

            // POST /api/collectibles/:id — Crear (según tu modelo)
            post("/:id", (req, res) -> {
                res.type("application/json");
                Long id = Long.valueOf(req.params("id"));
                Collectible c = gson.fromJson(req.body(), Collectible.class);
                c.setId(id);

                boolean created = service.createWithId(c);

                if (!created) {
                    res.status(409);
                    return "{ \"error\": \"ID already exists\" }";
                }

                res.status(201);
                return "{ \"status\": \"created\", \"id\": " + id + " }";
            });

            // PUT /api/collectibles/:id — Actualizar
            put("/:id", (req, res) -> {
                res.type("application/json");
                Long id = Long.valueOf(req.params("id"));
                Collectible c = gson.fromJson(req.body(), Collectible.class);
                c.setId(id);

                boolean updated = service.update(c);
                return "{ \"updated\": " + updated + " }";
            });

            // OPTIONS /api/collectibles/:id — Verificar si existe
            options("/:id", (req, res) -> {
                Long id = Long.valueOf(req.params("id"));
                boolean exists = service.findById(id) != null;
                res.status(exists ? 200 : 404);
                return "{ \"exists\": " + exists + " }";
            });

            // DELETE /api/collectibles/:id — Eliminar
            delete("/:id", (req, res) -> {
                Long id = Long.valueOf(req.params("id"));
                boolean deleted = service.delete(id);
                return "{ \"deleted\": " + deleted + " }";
            });
        });
    }
}


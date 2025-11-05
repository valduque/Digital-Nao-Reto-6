package store.exception;

import static spark.Spark.exception;

public class GlobalExceptionHandler {

    public static void register() {

        exception(NotFoundException.class, (ex, req, res) -> {
            res.status(404);
            res.body("{\"error\":\"" + ex.getMessage() + "\"}");
        });

        exception(AppException.class, (ex, req, res) -> {
            res.status(400);
            res.body("{\"error\":\"" + ex.getMessage() + "\"}");
        });

        exception(Exception.class, (ex, req, res) -> {
            res.status(500);
            res.body("{\"error\":\"Internal Server Error\"}");
        });
    }
}

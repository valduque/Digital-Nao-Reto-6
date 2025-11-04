package controller;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.*;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@WebSocket
public class WebSocketPriceChannel {

    private static final CopyOnWriteArraySet<Session> sessions = new CopyOnWriteArraySet<>();

    @OnWebSocketConnect
    public void onConnect(Session session) {
        sessions.add(session);
    }

    @OnWebSocketClose
    public void onClose(Session session, int status, String reason) {
        sessions.remove(session);
    }

    public static void broadcast(String msg) {
        for (Session s : sessions) {
            try { s.getRemote().sendString(msg); }
            catch (IOException ignored) {}
        }
    }
}

package uz.epam.webproject.pool;

public class ConnectionPool {

    private static ConnectionPool instance;

    private ConnectionPool() {
    }

    public static ConnectionPool getInstance() {
        if(instance == null) {
            return instance = new ConnectionPool();
        }
        return instance;
    }

}

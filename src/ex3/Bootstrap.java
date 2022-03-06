package ex3;

import ex3.connector.http.HttpConnector;

public class Bootstrap {
    public static void main(String[] args) {
        HttpConnector httpConnector = new HttpConnector();
        httpConnector.start();
    }
}

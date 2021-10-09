package br.com.alura.loja.http;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class JavaHttpClient implements HttpAdapter {

    @Override
    public void post(String url, Map<String, Object> dados) {

        try {
            URL urlDaAPi = new URL(url);
            URLConnection openConnection = urlDaAPi.openConnection();
            openConnection.connect();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

}

package com.conversor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.Scanner;
import java.net.URL;

public class Api{
    private String to;
    private String url;
    private String from;
    private String apiKey;
    private String amount;

    public void setUrl(String url){
        this.url = url;
    }

    public void setApiKey(String apiKey){
        this.apiKey = "&apikey=" + apiKey;
    }

    public String convert(String from, String to, double amount) throws IOException {
        this.to = "&to=" + to;
        this.from = "&from=" + from;
        this.amount = "&amount=" + amount;

        final URL URL = new URL(this.url + this.to + this.from + this.amount + this.apiKey);

        HttpURLConnection connection = (HttpURLConnection) URL.openConnection();
        connection.setRequestMethod("GET");

        Scanner scanner = new Scanner(connection.getInputStream());
        String response = scanner.useDelimiter("\\A").next();

        scanner.close();
        connection.disconnect();

        response = response.split(",")[7].split(" ")[5].replaceAll("[^0-9\\.]", "");

        return response;
    }
}

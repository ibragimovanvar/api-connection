package com.generation;

import com.generation.user.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Scanner;

public class GetRequestUsersFakeData {
    public static void main(String[] args) {

//        Scanner in = new Scanner(System.in);
//        System.out.println("ID ni kiriting: ");
//        int id = in.nextInt();

        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/users");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String streamLine;
            StringBuilder response = new StringBuilder();

            streamLine = reader.readLine();
            while (streamLine != null) {
                response.append(streamLine);
                streamLine = reader.readLine();
            }

//            System.out.println("Status code: " + connection.getResponseCode());
//            System.out.println("---------------------------------");
//            System.out.println("Response: " + response);
//            System.out.println("---------------------------------");

            Gson gson = new Gson();
            Type type = new TypeToken<List<User>>(){}.getType();
            List<User> users = gson.fromJson(response.toString(), type);

            System.out.println(users);

            reader.close();
            connection.disconnect();
        } catch (IOException e) {
            System.out.println("Foydalanuvchi topilmadi");
        }

    }
}

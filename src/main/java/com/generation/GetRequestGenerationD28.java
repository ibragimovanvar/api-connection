package com.generation;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

class Post {
    int userId;
    int id;
    String title;
    String body;

    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}

public class GetRequestGenerationD28 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
                response.append(inputLine);
            }
            in.close();

            System.out.println("Response: " + response);

            Gson gson = new Gson();
            Type postListType = new TypeToken<List<Post>>(){}.getType();
            List<Post> posts = gson.fromJson(response.toString(), postListType);

            System.out.println("Parsed Post objects:");
            for (Post post : posts) {
                System.out.println(post);
            }

            System.out.println("Total number of posts: " + posts.size());
            System.out.println(posts);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


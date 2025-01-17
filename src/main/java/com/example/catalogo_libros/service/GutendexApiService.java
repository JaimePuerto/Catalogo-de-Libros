package com.example.catalogo_libros.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;


import org.springframework.stereotype.Service;

@Service
public class GutendexApiService {
    private final ObjectMapper objectMapper;

    public GutendexApiService() {
        this.objectMapper = new ObjectMapper();
    }

    public List<Libro> buscarLibroPorTitulo(String titulo) {
        List<Libro> libros = new ArrayList<>();
        try {
            HttpClient client = HttpClient.newHttpClient();
            String url = "https://gutendex.com/books/?search=" + URLEncoder.encode(titulo, StandardCharsets.UTF_8);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Parsear la respuesta JSON
            JsonNode root = objectMapper.readTree(response.body());
            JsonNode results = root.path("results");

            for (JsonNode node : results) {
                Libro libro = objectMapper.treeToValue(node, Libro.class);
                libros.add(libro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return libros;
    }
}

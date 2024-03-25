package reposervice;

import repository.*;

import java.io.File;
import java.io.IOException;

import com.example.repository.Repository;
import com.fasterxml.jackson.databind.*;

public class RepositoryService {
    public void export(Repository repo, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), repo);
    }

    public Repository read(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(path), Repository.class);
    }
}

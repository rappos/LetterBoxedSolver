import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class DictionaryManager {


    public static HashMap<String, Integer> getDictionary() {
        HashMap<String, Integer> dictionaryHashMap = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get("src/words_dict.json"));
            // Convert JSON to HashMap
            dictionaryHashMap = mapper.readValue(jsonData, new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not read dictionary file");
        }
        return dictionaryHashMap;
    }
}

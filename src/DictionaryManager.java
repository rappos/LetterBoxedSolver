import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class DictionaryManager {

    /**
     * A method to retrieve and parse a dictionary from a JSON file.
     *
     * @return the parsed dictionary as a HashMap
     */
    public static HashMap<String, Integer> getDictionary() {
        HashMap<String, Integer> dictionaryHashMap = new HashMap<String, Integer>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get("src/words_dict.json"));
            // Convert JSON to HashMap
            dictionaryHashMap = mapper.readValue(jsonData, new TypeReference<HashMap<String, Integer>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dictionaryHashMap;
    }
}

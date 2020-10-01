package api;

import org.junit.jupiter.api.Test;
import java.util.List;

import static io.restassured.RestAssured.*;
import static io.restassured.path.json.JsonPath.from;

public class ApiTestOne {

    @Test
    public void checkThat() {
        String response = get("https://www.wiley.com/en-us/search/autocomplete/comp_00001H9J?term=Java").asString();
        List<String> terms = from(response).getList("suggestions.term");

        //4 suggestions contain attribute “term” : value starting with the preformatted
        //highlighted word java inside like <span class=\"search-highlight\">java</span>
        if (terms.size()!=4)
            assert false;
        for (Object s : terms){
            if (!s.toString().contains("<span class=\"search-highlight\">java</span>"))
                assert false;
        }

        //4 pages with attribute “title”: value includes word Wiley
        List<String> titles = from(response).getList("pages.title");
        if (titles.size()!=4)
            assert false;
        for (Object s : titles){
            if (!s.toString().contains("Wiley"))
                assert false;
        }
    }
}

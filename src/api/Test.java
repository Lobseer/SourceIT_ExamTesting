package api;

import java.util.List;
import java.util.Map;

/**
 * Created by denis.selutin on 29.07.2016.
 */
public interface Test {
    Long getNumber();
    List<Question> getQuestions();
    Map<String, List<Integer>> getAnswers();
}

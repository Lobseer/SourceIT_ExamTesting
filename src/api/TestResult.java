package api;

/**
 * Created by denis.selutin on 29.07.2016.
 */
public interface TestResult {
    Long getTestNumber();
    Long getNumberOfCorrectAnswers();
    Long getNumberOfQuestions();
    Long getNumberOfIncorrectAnswers();
}

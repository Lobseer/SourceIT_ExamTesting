package impl;

import api.TestResult;

/**
 * Class description
 * @author Lobseer on 10.02.2017.
 */
public class TestResultImpl implements TestResult {
    private Long testNumber;
    private Long numberOfQuestions;
    private Long numberOfCorrectAnswers;

    public TestResultImpl(){}

    public TestResultImpl(Long testNumber, Long numberOfQuestions, Long numberOfCorrectAnswers) {
        this.testNumber = testNumber;
        this.numberOfQuestions = numberOfQuestions;
        this.numberOfCorrectAnswers = numberOfCorrectAnswers;
    }

    @Override
    public Long getTestNumber() {
        return testNumber;
    }

    @Override
    public Long getNumberOfCorrectAnswers() {
        return numberOfCorrectAnswers;
    }

    @Override
    public Long getNumberOfQuestions() { return numberOfQuestions; }

    @Override
    public Long getNumberOfIncorrectAnswers() {
        return numberOfQuestions-numberOfCorrectAnswers;
    }
}

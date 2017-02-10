package impl;

import api.*;

import java.util.*;

/**
 * Class description
 * @author Lobseer on 10.02.2017.
 */
public class ServiceImpl implements Service {
    private List<Theme> themes;
    private List<Question> questions;

    private long testCount;

    public ServiceImpl() {
        themes = new LinkedList<>();
        questions = new LinkedList<>();
    }

    @Override
    public void addQuestion(Question question) {
        if(question!=null && !questions.contains(question) && themes.contains(question.getTheme())) {
            questions.add(question);
        }
    }

    @Override
    public void addThem(Theme theme) {
        if(theme!=null && !themes.contains(theme)) {
            themes.add(theme);
        }
    }

    @Override
    public Test createRandomTest() {
        Random rnd = new Random();
        List<Question> temp = new ArrayList<>(questions);
        List<Question> testQuestion = new LinkedList<>();
        for(int i=0;i<5;i++) {
            testQuestion.add(temp.remove(rnd.nextInt(temp.size())));
        }
        return new TestImpl(++testCount, testQuestion);
    }

    @Override
    public TestResult performTest(Test test, Map<String, List<Integer>> answers) {
        if(test!=null && answers!=null) {
            Map<String, List<Integer>> correctAnswers = test.getAnswers();
            long correctAnswerCount = 0;
            for (String quest : correctAnswers.keySet()) {
                if(correctAnswers.get(quest).equals(answers.get(quest))) {
                    correctAnswerCount++;
                }
            }
            return new TestResultImpl(test.getNumber(), (long) correctAnswers.size(), correctAnswerCount);
        }
        return null;
    }
}

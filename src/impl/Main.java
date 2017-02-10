package impl;

import api.*;

import java.util.*;

/**
 * Created by denis.selutin on 29.07.2016.
 */
public class Main {
    public static void main(String[] args) {
        Service service = new ServiceImpl();//your init here

        List<Theme> themes = Arrays.asList(
                new ThemeImpl("math", "math questions"),
                new ThemeImpl("nature", "nature questions"),
                new ThemeImpl("cosmos", "cosmos questions")
        );
        for(Theme th: themes) {
            service.addThem(th);
        }

        List<Question> quesitons = Arrays.asList(
                new QuestionImpl("1", themes.get(0), "2+2*2=?", Arrays.asList("4","6","8"), Arrays.asList(1)),
                new QuestionImpl("2", themes.get(2), "how many planets has the solar system", Arrays.asList("9","7","8"), Arrays.asList(2)),
                new QuestionImpl("3", themes.get(1), "how many colors has a rainbow", Arrays.asList("3","7","8"), Arrays.asList(1)),
                new QuestionImpl("4", themes.get(0), "sin(3600)", Arrays.asList("1","0.5","36", "0"), Arrays.asList(3)),
                new QuestionImpl("5", themes.get(1), "how many legs have an ant", Arrays.asList("6","8","12"), Arrays.asList(0)),
                new QuestionImpl("6", themes.get(2), "what is the biggest planet in the solar system", Arrays.asList("Earth","Jupiter","Solar", "Saturn"), Arrays.asList(1)),
                new QuestionImpl("7", themes.get(0), "question", Arrays.asList("1","2","3"), Arrays.asList(1)),
                new QuestionImpl("8", themes.get(0), "question", Arrays.asList("1","2","3"), Arrays.asList(1)),
                new QuestionImpl("9", themes.get(2), "what is the closest star to us", Arrays.asList("Mars","Aldebaran","Solar"), Arrays.asList(2)),
                new QuestionImpl("10", themes.get(1), "who is a mammal", Arrays.asList("spider","human","dolphin","penguin","whale"), Arrays.asList(1,2,4)));
        for(Question q: quesitons) {
            service.addQuestion(q);
        }

        Test t = service.createRandomTest();
        assertCondition(t != null);
        assertCondition(t.getAnswers() != null);
        assertCondition(t.getAnswers().size() > 0);
        assertCondition(t.getNumber() != null);
        assertCondition(t.getNumber() > 0);
        assertCondition(t.getQuestions() != null);
        assertCondition(t.getQuestions().size() > 0);

        Map<String, List<Integer>> answers = new HashMap<>();
        int numberOfCorrect = 0;
        int numberOfInCorrect = 0;
        Random r = new Random();
        for(Question q : t.getQuestions()) {
            if(numberOfCorrect == 0) {
                answers.put(q.getName(), q.getCorrectAnswers());
                numberOfCorrect++;
                continue;
            }
            if(numberOfInCorrect == 0) {
                answers.put(q.getName(), Collections.EMPTY_LIST);
                numberOfInCorrect++;
                continue;
            }
            if(r.nextBoolean()) {
                answers.put(q.getName(), q.getCorrectAnswers());
                numberOfCorrect++;
            } else {
                answers.put(q.getName(), Collections.EMPTY_LIST);
                numberOfInCorrect++;
            }
        }

        TestResult tr = service.performTest(t, answers);
        assertCondition(tr.getNumberOfCorrectAnswers() == numberOfCorrect);
        assertCondition(tr.getNumberOfIncorrectAnswers() == numberOfInCorrect);
        assertCondition(tr.getNumberOfQuestions() == t.getQuestions().size());
    }

    private static void assertCondition(boolean condition) {
        assert condition;
        if(!condition) {
            throw new RuntimeException("HERE!!!");
        }
    }
}

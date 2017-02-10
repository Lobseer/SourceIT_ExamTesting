package impl;

import api.Question;
import api.Test;

import java.util.*;

/**
 * Class description
 * @author Lobseer on 10.02.2017.
 */

public class TestImpl implements Test {
    private Long number;
    private List<Question> questions;

    public TestImpl() {
        questions = new LinkedList<>();
    }

    public TestImpl(Long number, List<Question> questions) {
        if(number==null) throw new NullPointerException();
        this.number = number;
        if(questions!=null) {
            this.questions = new LinkedList<>(questions);
        } else
        {
            this.questions = new LinkedList<>();
        }
    }

    @Override
    public Long getNumber() {
        return number;
    }

    public boolean addQuestion(Question quest) {
        if(quest==null || questions.contains(quest)) return false;
        questions.add(quest);
        return true;
    }

    @Override
    public List<Question> getQuestions() {
        return new LinkedList<>(questions);
    }

    @Override
    public Map<String, List<Integer>> getAnswers() {
        Map<String, List<Integer>> result = new HashMap<>();
        for(Question quest : questions) {
            result.put(quest.getName(), quest.getCorrectAnswers());
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestImpl test = (TestImpl) o;
        return Objects.equals(number, test.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}

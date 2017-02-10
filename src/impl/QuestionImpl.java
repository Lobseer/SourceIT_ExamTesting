package impl;


import api.Question;
import api.Theme;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class description
 * @author Lobseer on 10.02.2017.
 */
public class QuestionImpl implements Question {
    private String name;
    private Theme theme;
    private String question;

    private List<String> possibleAnswers;
    private List<Integer> correctAnswers;

    public QuestionImpl() {
        possibleAnswers = new ArrayList<>();
        correctAnswers = new ArrayList<>();
    }

    public QuestionImpl(String name, Theme theme, String question, List<String> possibleAnswers, List<Integer> correctAnswers) {
        if(possibleAnswers.size() < correctAnswers.size()) throw new IllegalArgumentException();
        for(Integer i : correctAnswers) {
            if(i>possibleAnswers.size() || i<0) throw new IllegalArgumentException();
        }

        this.name=name;
        this.question=question;
        this.theme = new ThemeImpl(theme.getName(), theme.getDescription());

        this.possibleAnswers = new ArrayList<>(possibleAnswers);
        this.correctAnswers = new ArrayList<>(correctAnswers);
    }

    @Override
    public Theme getTheme() {
        return theme;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<String> getPossibleAnswers() {
        return possibleAnswers;
    }

    @Override
    public List<Integer> getCorrectAnswers() {
        return correctAnswers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionImpl question1 = (QuestionImpl) o;
        return name.equalsIgnoreCase(question1.name) &&
                Objects.equals(theme, question1.theme) &&
                question.equalsIgnoreCase(question1.question) &&
                Objects.equals(possibleAnswers, question1.possibleAnswers) &&
                Objects.equals(correctAnswers, question1.correctAnswers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, theme, question, possibleAnswers, correctAnswers);
    }

    @Override
    public String toString() {
        return String.format("QuestionImpl{ name=%s; theme=%s; question=%s; possibleAnswers=%s; correctAnswers=%s;}",
                name, theme, question, possibleAnswers, correctAnswers);
    }
}

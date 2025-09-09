package avanis.comunidad.model;

public class AnswerResults {
    private long answerId;
    private String answer;
    private int countAnswers;
    private float percentage;

    // Constructor
    public AnswerResults(long answerId, String answer, int countAnswers, float percentage) {
        this.answerId = answerId;
        this.answer = answer;
        this.countAnswers = countAnswers;
        this.percentage = percentage;
    }

    // Getters y setters
    public long getAnswerId() {
        return answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public int getCountAnswers() {
        return countAnswers;
    }

    public float getPercentage() {
        return percentage;
    }

    // Setters
    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setCountAnswers(int countAnswers) {
        this.countAnswers = countAnswers;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }
}

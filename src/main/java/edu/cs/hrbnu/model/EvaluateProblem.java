package edu.cs.hrbnu.model;

public class EvaluateProblem {
    private int id;
    private String evaluateProblemContent;
    private int forWho;
    private int score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvaluateProblemContent() {
        return evaluateProblemContent;
    }

    public void setEvaluateProblemContent(String evaluateProblemContent) {
        this.evaluateProblemContent = evaluateProblemContent;
    }

    public int getForWho() {
        return forWho;
    }

    public void setForWho(int forWho) {
        this.forWho = forWho;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

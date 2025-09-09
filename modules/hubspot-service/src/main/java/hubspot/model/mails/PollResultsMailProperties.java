package hubspot.model.mails;

import java.time.Instant;

public class PollResultsMailProperties {
    String userEmail;
    String name;
    String urlPost;
    String pollTitle;
    String winnerOption;
    String winnerOptionText;
    Instant percentage;
    String numVotes;

    public String getUserEmail() {
        return userEmail;
    }

    public String getName() {
        return name;
    }

    public String getUrlPost() {
        return urlPost;
    }

    public String getPollTitle() {
        return pollTitle;
    }

    public String getWinnerOption() {
        return winnerOption;
    }

    public String getWinnerOptionText() {
        return winnerOptionText;
    }

    public Instant getPercentage() {
        return percentage;
    }

    public String getNumVotes() {
        return numVotes;
    }
}

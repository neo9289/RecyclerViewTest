package francescoluise.com.recyclerviewtest.Model;

/**
 * Created by francescoluise on 01/06/17.
 */

public class Answer {


    Nation nation;
    int percentage;

    public Answer(Nation nation, int percentage) {
        this.nation = nation;
        this.percentage = percentage;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
}

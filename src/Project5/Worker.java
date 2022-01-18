package Project5;

public class Worker extends Client{

    private int rank;

    public Worker(String firstName, String lastName, String username,
                  String password, boolean isClubMember,  int rank) {
        super(firstName, lastName, username, password, isClubMember);
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String toString() {
        return "Worker{" +
                "rank=" + rank +
                '}';
    }
}
package ohtuesimerkki;

public class Player implements Comparable<Player> {

    private String name;
    private String team;
    private int goals;
    private int assists;

    public Player(String name, String team, int goals, int assists) {
        this.name = name;
        this.team = team;
        this.goals = goals;
        this.assists = assists;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getPoints() {
        return goals + assists;
    }

    @Override
    public String toString() {
        return String.format("%-20s", name) + " " + team + " " + String.format("%2d", goals) + " + "
                + String.format("%2d", assists) + " = " + getPoints();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }

        Player p = (Player) o;

        if (p.getName() != this.getName() || p.getTeam() != this.getTeam()
                || p.getPoints() != this.getPoints()) {
            return false;
        }

        return true;
    }

    public int compareTo(Player t) {
        return t.getPoints() - this.getPoints();
    }
}

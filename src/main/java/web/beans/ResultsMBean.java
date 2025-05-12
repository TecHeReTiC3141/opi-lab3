package web.beans;

public interface ResultsMBean {
    int getTotalAttempts();
    int getTotalMisses();
    void updateStats(boolean hit);
}

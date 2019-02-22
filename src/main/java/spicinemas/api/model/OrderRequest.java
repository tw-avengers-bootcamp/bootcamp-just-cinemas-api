package spicinemas.api.model;

public class OrderRequest {
    private Long numberOfTickets;
    private Long showId;
    private String emailId;

    public Long getNumberOfTickets() {
        return this.numberOfTickets;
    }

    public void setNumberOfTickets(Long numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public Long getShowId() {
        return this.showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}

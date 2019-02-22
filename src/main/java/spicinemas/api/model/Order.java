package spicinemas.api.model;

public class Order {
    private String orderId;
    private String emailId;
    private Long numberOfSeats;
    private Boolean orderSuccess;
    private String message;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Long getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Long seats) {
        this.numberOfSeats = seats;
    }

    public Boolean getOrderSuccess() {
        return orderSuccess;
    }

    public void setOrderSuccess(Boolean orderSuccess) {
        this.orderSuccess = orderSuccess;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

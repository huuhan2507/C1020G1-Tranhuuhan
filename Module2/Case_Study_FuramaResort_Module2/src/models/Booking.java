package models;

public class Booking {
    private String nameCustomer;
    private String cardIdCustomer;
    private String nameService;
    private String idService;
    private String startDateService;
    private String endDateService;
    private int totalMoney;

    public Booking(String nameCustomer, String cardIdCustomer, String nameService, String idService, String startDateService,
                   String endDateService, int totalMoney) {
        this.nameCustomer = nameCustomer;
        this.cardIdCustomer = cardIdCustomer;
        this.nameService = nameService;
        this.idService = idService;
        this.startDateService = startDateService;
        this.endDateService = endDateService;
        this.totalMoney = totalMoney;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getCardIdCustomer() {
        return cardIdCustomer;
    }

    public void setCardIdCustomer(String cardIdCustomer) {
        this.cardIdCustomer = cardIdCustomer;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getStartDateService() {
        return startDateService;
    }

    public void setStartDateService(String startDateService) {
        this.startDateService = startDateService;
    }

    public String getEndDateService() {
        return endDateService;
    }

    public void setEndDateService(String endDateService) {
        this.endDateService = endDateService;
    }


    @Override
    public String toString() {
        return nameCustomer + ", " + cardIdCustomer + ", " + nameService + ", " + idService + ", " + startDateService +
                ", " + endDateService + ", " + totalMoney;
    }


}

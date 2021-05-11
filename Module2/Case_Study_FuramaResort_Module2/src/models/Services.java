package models;

public abstract class Services {
    private String idService;
    private String nameService;
    private String areaService;
    private String amountPeople;
    private String dateService;
    private String priceService;

    public Services(String idService, String nameService, String areaService, String amountPeople, String dateService, String priceService) {
        this.idService = idService;
        this.nameService = nameService;
        this.areaService = areaService;
        this.amountPeople = amountPeople;
        this.dateService = dateService;
        this.priceService = priceService;
    }

    protected Services() {
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getUnitService() {
        return areaService;
    }

    public void setUnitService(String areaService) {
        this.areaService = areaService;
    }

    public String getAmountPeople() {
        return amountPeople;
    }

    public void setAmountPeople(String amountPeople) {
        this.amountPeople = amountPeople;
    }

    public String getDateService() {
        return dateService;
    }

    public void setDateService(String dateService) {
        this.dateService = dateService;
    }

    public String getPriceService() {
        return priceService;
    }

    public void setPriceService(String priceService) {
        this.priceService = priceService;
    }

    @Override
    public String toString() {
        return idService + ", " + nameService + ", " + areaService + ", " +
                amountPeople + ", " + dateService + ", " + priceService ;
    }

    public abstract String showInformationService();

}

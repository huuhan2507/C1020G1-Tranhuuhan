package models;

public class Room extends Services {
    private String freeService;

    public Room(String idService, String nameService, String areaService, String amountPeople, String dateService, String priceService, String freeService) {
        super( idService, nameService, areaService, amountPeople, dateService, priceService );
        this.freeService = freeService;
    }

    public Room() {
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return super.toString()+", "+freeService;
    }

    @Override
    public String showInformationService() {
        return super.toString() + ", " + toString();
    }
}

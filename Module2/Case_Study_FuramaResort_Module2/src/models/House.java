package models;

public class House extends Services {
    private String numberFloor;
    private String standardRoom;
    private String otherService;

    public House(String idService, String nameService, String areaService, String amountPeople, String dateService, String priceService, String numberFloor, String standardRoom, String otherService) {
        super( idService, nameService, areaService, amountPeople, dateService, priceService );
        this.numberFloor = numberFloor;
        this.standardRoom = standardRoom;
        this.otherService = otherService;
    }

    public House() {
    }

    public String getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(String numberFloor) {
        this.numberFloor = numberFloor;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getOtherService() {
        return otherService;
    }

    public void setOtherService(String otherService) {
        this.otherService = otherService;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + numberFloor + ", " +
                standardRoom + ", " +
                otherService;
    }

    @Override
    public String showInformationService() {
        return super.toString() + ", " + toString();

    }
}

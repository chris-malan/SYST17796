package malanc.realestateapp.Models;

public class Property {
    private int id;
    private String name;
    private String address;
    private City city;  // Use City enum instead of String
    private int floors;
    private int rooms;
    private int bathrooms;
    private PropertyType type;  // Use PropertyType enum instead of String
    private int squareFootage;
    private int yearBuilt;
    private int price;
    private boolean energyEfficient;
    private boolean hoaFees;
    private boolean petFriendly;
    private String proximityToAmenities;
    private String safetyRating;
    private double propertyTaxRate;
    private String schoolDistrict;
    private String ownerName; // Changed field to ownerName

    // Constructor with enums for city and type, including ownerName
    public Property(int id, String name, String address, City city, int floors, int rooms, int bathrooms, PropertyType type,
                    int squareFootage, int yearBuilt, int price, boolean energyEfficient, boolean hoaFees, boolean petFriendly,
                    String proximityToAmenities, String safetyRating, double propertyTaxRate, String schoolDistrict, String ownerName) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.floors = floors;
        this.rooms = rooms;
        this.bathrooms = bathrooms;
        this.type = type;
        this.squareFootage = squareFootage;
        this.yearBuilt = yearBuilt;
        this.price = price;
        this.energyEfficient = energyEfficient;
        this.hoaFees = hoaFees;
        this.petFriendly = petFriendly;
        this.proximityToAmenities = proximityToAmenities;
        this.safetyRating = safetyRating;
        this.propertyTaxRate = propertyTaxRate;
        this.schoolDistrict = schoolDistrict;
        this.ownerName = ownerName; // Initialize ownerName
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public City getCity() { return city; }
    public void setCity(City city) { this.city = city; }
    public int getFloors() { return floors; }
    public void setFloors(int floors) { this.floors = floors; }
    public int getRooms() { return rooms; }
    public void setRooms(int rooms) { this.rooms = rooms; }
    public int getBathrooms() { return bathrooms; }
    public void setBathrooms(int bathrooms) { this.bathrooms = bathrooms; }
    public PropertyType getType() { return type; }
    public void setType(PropertyType type) { this.type = type; }
    public int getSquareFootage() { return squareFootage; }
    public void setSquareFootage(int squareFootage) { this.squareFootage = squareFootage; }
    public int getYearBuilt() { return yearBuilt; }
    public void setYearBuilt(int yearBuilt) { this.yearBuilt = yearBuilt; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
    public boolean isEnergyEfficient() { return energyEfficient; }
    public void setEnergyEfficient(boolean energyEfficient) { this.energyEfficient = energyEfficient; }
    public boolean hasHoaFees() { return hoaFees; }
    public void setHoaFees(boolean hoaFees) { this.hoaFees = hoaFees; }
    public boolean isPetFriendly() { return petFriendly; }
    public void setPetFriendly(boolean petFriendly) { this.petFriendly = petFriendly; }
    public String getProximityToAmenities() { return proximityToAmenities; }
    public void setProximityToAmenities(String proximityToAmenities) { this.proximityToAmenities = proximityToAmenities; }
    public String getSafetyRating() { return safetyRating; }
    public void setSafetyRating(String safetyRating) { this.safetyRating = safetyRating; }
    public double getPropertyTaxRate() { return propertyTaxRate; }
    public void setPropertyTaxRate(double propertyTaxRate) { this.propertyTaxRate = propertyTaxRate; }
    public String getSchoolDistrict() { return schoolDistrict; }
    public void setSchoolDistrict(String schoolDistrict) { this.schoolDistrict = schoolDistrict; }
    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city=" + city +
                ", floors=" + floors +
                ", rooms=" + rooms +
                ", bathrooms=" + bathrooms +
                ", type=" + type +
                ", squareFootage=" + squareFootage +
                ", yearBuilt=" + yearBuilt +
                ", price=" + price +
                ", energyEfficient=" + energyEfficient +
                ", hoaFees=" + hoaFees +
                ", petFriendly=" + petFriendly +
                ", proximityToAmenities='" + proximityToAmenities + '\'' +
                ", safetyRating='" + safetyRating + '\'' +
                ", propertyTaxRate=" + propertyTaxRate +
                ", schoolDistrict='" + schoolDistrict + '\'' +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}

package pos.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Product {
    private int id;
    private String name;
    private String description;
    private int categoryId;
    private int supplierId;
    private String sku;
    private String barcode;
    private String inventoryTracking;
    private String baseUnit;
    private BigDecimal price;
    private BigDecimal cost;
    private int initialStock;
    private int currentStock;
    private String image;
    private boolean isActive;
    private Timestamp createdAt;

    public Product(int id, String name, String description, int categoryId, int supplierId, String sku,
                   String barcode, String inventoryTracking, String baseUnit,
                   BigDecimal price, BigDecimal cost, int initialStock, int currentStock,
                   String image, boolean isActive, Timestamp createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
        this.supplierId = supplierId;
        this.sku = sku;
        this.barcode = barcode;
        this.inventoryTracking = inventoryTracking;
        this.baseUnit = baseUnit;
        this.price = price;
        this.cost = cost;
        this.initialStock = initialStock;
        this.currentStock = currentStock;
        this.image = image;
        this.isActive = isActive;
        this.createdAt = createdAt;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getCategoryId() { return categoryId; }
    public int getSupplierId() { return supplierId; }
    public String getSku() { return sku; }
    public String getBarcode() { return barcode; }
    public String getInventoryTracking() { return inventoryTracking; }
    public String getBaseUnit() { return baseUnit; }
    public BigDecimal getPrice() { return price; }
    public BigDecimal getCost() { return cost; }
    public int getInitialStock() { return initialStock; }
    public int getCurrentStock() { return currentStock; }
    public String getImage() { return image; }
    public boolean getIsActive() { return isActive; }
    public Timestamp getCreatedAt() { return createdAt; }
}

package kr.ac.duksung.cookey_bottom;

public class FrequentlyItem {
    private String ingredientName;
    private int quantity;
    private String expiryDate;
    private String remainingDays;
    private String storageDuration;
    private String url;
    private String imageFileName; // 새로운 필드 추가



    public FrequentlyItem(String ingredientName, int quantity, String expiryDate, String remainingDays, String storageDuration, String imageFileName) {
        this.ingredientName = ingredientName;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.remainingDays = remainingDays;
        this.storageDuration = storageDuration;
        this.imageFileName = imageFileName; // 생성자에서 초기화

    }
    public String getImageFileName() {
        return imageFileName;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getRemainingDays() {
        return remainingDays;
    }

    public void setRemainingDays(String remainingDays) {
        this.remainingDays = remainingDays;
    }

    public String getStorageDuration() {
        return storageDuration;
    }

    public void setStorageDuration(String storageDuration) {
        this.storageDuration = storageDuration;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

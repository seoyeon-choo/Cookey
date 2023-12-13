package kr.ac.duksung.cookey_bottom;

public class FrequentlyItem {
    private String ingredientName;
    private int quantity;
    private String expiryDate;
    private String remainingDays;
    private String storageDuration;
    private String url;

    // 생성자, getter 및 setter 메서드는 필요에 따라 추가하세요.

    public FrequentlyItem(String ingredientName, int quantity, String expiryDate, String remainingDays, String storageDuration) {
        this.ingredientName = ingredientName;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.remainingDays = remainingDays;
        this.storageDuration = storageDuration;
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

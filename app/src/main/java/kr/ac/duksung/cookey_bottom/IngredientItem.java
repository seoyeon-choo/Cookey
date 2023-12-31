package kr.ac.duksung.cookey_bottom;

public class IngredientItem {
    private String ingredientName;
    private int quantity;
    private String expiryDate;
    private String remainingDays;
    private String storageDuration;
    private int freshness;

    // 생성자 및 getter, setter 메서드 생략

    public IngredientItem(String ingredientName, int quantity, String expiryDate, String remainingDays, String storageDuration, int freshness) {
        this.ingredientName = ingredientName;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.remainingDays = remainingDays;
        this.storageDuration = storageDuration;
        this.freshness = freshness;
    }

    // getter, setter 메서드 추가
}

package kr.ac.duksung.cookey_bottom;

public class Recipe {
    private String title;
    private String summary;

    // 다른 필요한 속성들을 추가할 수 있음

    public Recipe(String title, String summary) {
        this.title = title;
        this.summary = summary;
        // 다른 필요한 필드들도 초기화
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public boolean getId() {
        return false;
    }

    // 다른 getter 및 setter 메서드 추가 가능
}

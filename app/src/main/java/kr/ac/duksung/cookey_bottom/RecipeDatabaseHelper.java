package kr.ac.duksung.cookey_bottom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

public class RecipeDatabaseHelper extends SQLiteOpenHelper {

    // 데이터베이스 버전
    private static final int DATABASE_VERSION = 1;

    // 데이터베이스 이름
    private static final String DATABASE_NAME = "recipe_database";

    // 테이블 생성 쿼리
    private static final String CREATE_TABLE =
            "CREATE TABLE recipes (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "title TEXT," +
                    "summary TEXT," +
                    "minute TEXT," +
                    "servings TEXT," +
                    "difficulty TEXT," +
                    "mainIngredient TEXT," +
                    "step TEXT" +
                    ")";

    // getRecipeById 메서드 정의
    public Recipe getRecipeById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"title", "summary", /* ... 다른 필요한 컬럼들 */};
        String selection = "id=?";
        String[] selectionArgs = {String.valueOf(id)};

        Cursor cursor = db.query("recipes", columns, selection, selectionArgs, null, null, null);
        Recipe recipe = null;

        if (cursor.moveToFirst()) {
            // 컬럼 인덱스는 실제 필드에 따라 달라질 수 있습니다.
            @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex("title"));
            @SuppressLint("Range") String summary = cursor.getString(cursor.getColumnIndex("summary"));
            // ... 다른 필요한 필드들 가져오기

            // Recipe 객체 생성
            recipe = new Recipe(title, summary);
        }

        cursor.close();
        db.close();

        return recipe;
    }

    public RecipeDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 테이블 생성
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 데이터베이스 업그레이드 시 호출됨 (버전이 변경될 때)
        // 여기서는 간단하게 테이블을 삭제하고 다시 생성하는 방식으로 처리
        db.execSQL("DROP TABLE IF EXISTS recipes");
        onCreate(db);
    }

    public List<Recipe> getAllRecipes() {
        return null;
    }
}


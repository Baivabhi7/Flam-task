package BookReview.app.main.java.data;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;
import BookReview.app.main.java.model.Book;

@Database(entities = { Book.class }, version = 1)
public abstract class BookDatabase extends RoomDatabase {
  public abstract BookDao bookDao();

  private static volatile BookDatabase INSTANCE;

  public static BookDatabase getInstance(Context context) {
    if (INSTANCE == null) {
      synchronized (BookDatabase.class) {
        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
            BookDatabase.class, "book_database").build();
      }
    }
    return INSTANCE;
  }
}

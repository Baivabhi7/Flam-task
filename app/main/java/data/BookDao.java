package BookReview.app.main.java.data;

import androidx.lifecycle.LiveData;
import androidx.room.*;
import BookReview.app.main.java.model.Book;
import java.util.List;

@Dao
public interface BookDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insert(Book book);

  @Query("SELECT * FROM Book WHERE isFavorite = 1")
  LiveData<List<Book>> getFavorites();
}

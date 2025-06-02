package BookReview.app.main.java.data;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import BookReview.app.main.java.model.Book;
import BookReview.app.main.java.utils.FakeBookApi;
import java.util.List;

public class BookRepository {
  private final BookDao dao;

  public BookRepository(Application app) {
    dao = BookDatabase.getInstance(app).bookDao();
  }

  public LiveData<List<Book>> getBooks() {
    MutableLiveData<List<Book>> data = new MutableLiveData<>();
    data.setValue(FakeBookApi.getBooks());
    return data;
  }

  public void saveFavorite(Book book) {
    new Thread(() -> dao.insert(book)).start();
  }

  public LiveData<List<Book>> getFavorites() {
    return dao.getFavorites();
  }
}

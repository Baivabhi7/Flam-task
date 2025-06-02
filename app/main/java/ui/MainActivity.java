package BookReview.app.main.java.ui;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import BookReview.app.main.java.R;
import BookReview.app.main.java.model.Book;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  private BookViewModel viewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    TextView text = findViewById(R.id.textView);

    viewModel = new ViewModelProvider(this).get(BookViewModel.class);
    viewModel.getBooks().observe(this, books -> {
      StringBuilder builder = new StringBuilder();
      for (Book book : books) {
        builder.append(book.title).append(" by ").append(book.author).append("\n");
      }
      text.setText(builder.toString());
    });
  }
}

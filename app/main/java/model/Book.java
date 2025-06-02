package BookReview.app.main.java.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Book {
  @PrimaryKey
  public int id;
  public String title;
  public String author;
  public String thumbnail;
  public String description;
  public float rating;
  public boolean isFavorite;
}

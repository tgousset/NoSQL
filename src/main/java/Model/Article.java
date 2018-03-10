package Model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.ArrayList;
import java.util.List;

@Entity("article")
public class Article {

  @Id
  private ObjectId id = new ObjectId();
  private String name;
  private int stars;
  @Reference
  private List<Person> buyers;

  public Article(String name, int stars) {
    this.name = name;
    this.stars = stars;
    this.buyers = new ArrayList<Person>();
  }

  public Article() {
    this.buyers = new ArrayList<Person>();
  }

  public ObjectId getId() {
    return id;
  }

  public void setId(ObjectId id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getStars() {
    return stars;
  }

  public void setStars(int stars) {
    this.stars = stars;
  }

  public List<Person> getBuyers() {
    return buyers;
  }

  public void setBuyers(List<Person> buyers) {
    this.buyers = buyers;
  }

  public void addBuyer(Person p){
    this.buyers.add(p);
  }

  public void removeBuyer(Person p){
    this.buyers.remove(p);
  }
}

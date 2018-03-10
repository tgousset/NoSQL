package Model;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.net.UnknownHostException;

public class App {

  public static void main( String[] args ) throws UnknownHostException
  {
    Morphia morphia = new Morphia();
    MongoClient mongo = new MongoClient();
    morphia.map(Person.class).map(Address.class);
    Datastore ds = morphia.createDatastore(mongo, "nosql");

    // Address
    Address address = new Address();
    address.setStreet("123 Some street");
    address.setCity("Some city");
    address.setPostCode("123 456");
    address.setCountry("Some country");

    Address address2 = new Address();
    address2.setStreet("47 street view");
    address2.setCity("New York");
    address2.setPostCode("668 845");
    address2.setCountry("USA");

    //Person
    Person p = new Person();
    p.setName("Tintin");

    Person p2 = new Person();
    p2.setName("Mary");

    //Article
    Article a = new Article("Poster",5);
    Article a2 = new Article("Computer",4);

    //Add
    p.addAddress(address);
    p2.addAddress(address2);
    a.addBuyer(p);
    a.addBuyer(p2);

    // Save the POJO
    ds.save(address);
    ds.save(address2);
    ds.save(p);
    ds.save(p2);
    ds.save(a);
    ds.save(a2);

    System.out.println("Liste des personnes :");
    for (Person e : ds.find(Person.class)) {
      System.out.println("Name : " + e.getName());
      for (Address addr : e.getAddressList()) {
        System.out.println("Addresse  : " + addr.getStreet() + " " + addr.getPostCode() + " " +  addr.getCity() + " " + addr.getCountry());
      }
    }

    System.out.println("Liste des articles :");

    for (Article article : ds.find(Article.class)){
      System.out.println("Article : " + article.getName() + " ; Stars : " + article.getStars());
      for (Person person : article.getBuyers()){
        System.out.println("Person : " + person.getName());
      }
    }
  }


}

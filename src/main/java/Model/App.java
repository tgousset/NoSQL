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

    Person p = new Person();
    p.setName("Tintin");

    Address address = new Address();
    address.setStreet("123 Some street");
    address.setCity("Some city");
    address.setPostCode("123 456");
    address.setCountry("Some country");
    //set address
    p.addAddress(address);
    // Save the POJO

    ds.save(address);
    ds.save(p);
    for (Person e : ds.find(Person.class))
      System.err.println(e);

  }


}

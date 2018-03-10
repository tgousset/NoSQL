package Model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.ArrayList;
import java.util.List;

@Entity("person")
public class Person {

  @Id
  private ObjectId id = new ObjectId();
  private String name;
  @Reference
  private List<Address> addressList;

  public Person(String name) {
    this.name = name;
    this.addressList = new ArrayList<Address>();
  }

  public Person() {
    this.addressList = new ArrayList<Address>();
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

  public List<Address> getAddressList() {
    return addressList;
  }

  public void setAddressList(List<Address> addressList) {
    this.addressList = addressList;
  }

  public void addAddress(Address a){
    this.addressList.add(a);
  }

  public void removeAddress(Address a){
    this.addressList.remove(a);
  }
}

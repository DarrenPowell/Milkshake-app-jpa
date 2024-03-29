package milkshake;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@Entity
public class Ingredient {
  @Id
  private final String id;
  private final String name;
  private final Type type;
  
  public static enum Type {
    CREAM, FLAVOUR, SYRUP, TOPPINGS, PACKAGE
  }

}

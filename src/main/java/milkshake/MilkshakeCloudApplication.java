package milkshake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication   // <1>
public class MilkshakeCloudApplication {

  public static void main(String[] args) {
    SpringApplication.run(MilkshakeCloudApplication.class, args); // <2>
  }

}

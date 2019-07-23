// tag::head[]
package milkshake.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import milkshake.Ingredient;
import milkshake.Milkshakes;
import milkshake.Ingredient.Type;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

//end::head[]

@ModelAttribute
public void addIngredientsToModel(Model model) {
	List<Ingredient> ingredients = Arrays.asList(
	  new Ingredient("FC", "Full Cream", Type.CREAM),
	  new Ingredient("LF", "Low Fat", Type.CREAM),
	  new Ingredient("COF SENS", "Coffee Sensations", Type.FLAVOUR),
	  new Ingredient("CARMKNG", "Caramel King", Type.FLAVOUR),
	  new Ingredient("CHOC", "Choclolate", Type.SYRUP),
	  new Ingredient("STWBERY", "Strawberry", Type.SYRUP),
	  new Ingredient("SPRINK", "Sprinkles", Type.TOPPINGS),
	  new Ingredient("WHISP", "Whispers", Type.TOPPINGS),
	  new Ingredient("GLSS", "Glass", Type.PACKAGE),
	  new Ingredient("PLSTIC", "Plastic", Type.PACKAGE)
	);
	
	Type[] types = Ingredient.Type.values();
	for (Type type : types) {
	  model.addAttribute(type.toString().toLowerCase(),
	      filterByType(ingredients, type));
	}
}
	
//tag::showDesignForm[]
  @GetMapping
  public String showDesignForm(Model model) {
    model.addAttribute("design", new Milkshakes());
    return "design";
  }

//end::showDesignForm[]

/*
//tag::processDesign[]
  @PostMapping
  public String processDesign(Design design) {
    // Save the taco design...
    // We'll do this in chapter 3
    log.info("Processing design: " + design);

    return "redirect:/orders/current";
  }

//end::processDesign[]
 */

//tag::processDesignValidated[]
  @PostMapping
  public String processDesign(@Valid @ModelAttribute("design") Milkshakes design, Errors errors, Model model) {
    if (errors.hasErrors()) {
      return "design";
    }

    // Save the taco design...
    // We'll do this in chapter 3
    log.info("Processing design: " + design);

    return "redirect:/orders/current";
  }

//end::processDesignValidated[]

//tag::filterByType[]
  private List<Ingredient> filterByType(
      List<Ingredient> ingredients, Type type) {
    return ingredients
              .stream()
              .filter(x -> x.getType().equals(type))
              .collect(Collectors.toList());
  }

//end::filterByType[]
// tag::foot[]
}
// end::foot[]

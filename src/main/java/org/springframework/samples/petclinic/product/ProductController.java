package org.springframework.samples.petclinic.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    
	@Autowired
	private ProductService productService;
	
	private static final String VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM = "products/createOrUpdateProductForm";
	
	@GetMapping(value = "/product/create")
	public String initCreationForm(ModelMap modelMap) {
		modelMap.addAttribute("product", new Product());
		modelMap.addAttribute("productType", productService.findAllProductTypes());
		return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
	}
	
	@PostMapping(value = "/product/create")
	public String processCreationForm(@Valid Product product, BindingResult result, ModelMap modelMap) {
		String view = "welcome";
		if (result.hasErrors()) {
			modelMap.addAttribute("product", product);
			modelMap.addAttribute("productType", productService.findAllProductTypes());
			return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
		}
		else {
			//creating product
			productService.save(product);
			modelMap.addAttribute("message", "Product succesfully saves!");
		}
		return view;
	}
}

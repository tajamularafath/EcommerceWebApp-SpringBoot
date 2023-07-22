package com.qci.ecommercewebapp.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.qci.ecommercewebapp.Model.Category;
import com.qci.ecommercewebapp.Model.Item;
import com.qci.ecommercewebapp.Model.Subcategory;
import com.qci.ecommercewebapp.Repository.ItemRepo;
import com.qci.ecommercewebapp.Service.CatalogService;
import com.qci.ecommercewebapp.Service.ItemService;
import com.qci.ecommercewebapp.Service.SubcategoryService;

import jakarta.servlet.http.HttpSession;

@Controller
//@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemRepo itemRepo;
	
	@Autowired
	private CatalogService catalogService; 
	
	@Autowired
	private SubcategoryService subcategoryService;
	
	@GetMapping("/item")
	public String viewItem(Model model) {
		model.addAttribute("item", itemService.findAllItem());
//		model.addAttribute("catagory", catalogService.getCatalog());

		return "item";
	}
	
	@GetMapping("/items")
	public List<Item> viewItem1(Model model) {
		model.addAttribute("item", itemService.findAllItem());
//		model.addAttribute("catagory", catalogService.getCatalog());

		return itemService.findAllItem();
	}
	
	@GetMapping("/itemform")
	public String addItem(Model model) {
		Item item = new Item();
		List<Category> category = catalogService.getCatalog();
		model.addAttribute("categories", category);
		List<Subcategory> subcategory = subcategoryService.getSubcategory();
		model.addAttribute("subcategory", subcategory);
		model.addAttribute("item", item);
		return "itemform";
	}
	
	//Uploading image
	@RequestMapping("/saveitem")
	public String saveItem(@ModelAttribute("item") Item item, @RequestParam("image_name") MultipartFile image, HttpSession session) {
	    if (!image.isEmpty()) {
	        try {
	            // Get the filename of the uploaded image
	            String filename = StringUtils.cleanPath(image.getOriginalFilename());
	            System.out.println(filename+"file----------name");
	            
	            // Set the image filename in the item object
	            item.setImage_Filename(filename);

	            // Save the item
	            itemService.saveItem(item);

	            // Save the image file
	            File uploadDir = new File("static/css/images");
	            if (!uploadDir.exists()) {
	                uploadDir.mkdirs();
	            }
	            Path imagePath = Paths.get(uploadDir.getAbsolutePath(), filename);
	            Files.copy(image.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);
	            System.out.println(imagePath+"image----------path");
	            
	            // Set success message in the session
	            session.setAttribute("msg", "Image uploaded successfully");
	        } catch (IOException e) {
	            e.printStackTrace();
	            // Handle any exceptions that occurred during file upload or saving
	        }
	    } else {
	        // Handle the case when no image is uploaded
	    	System.out.println("No image Found");
	    }

	    return "redirect:/item";
	}




	
	@GetMapping("/itemedit/{id}")
	public String itemId(@PathVariable Integer id, Model model) {
		Item item = itemService.getItemId(id);
		model.addAttribute("item", item);
		List<Category> category = catalogService.getCatalog();
		model.addAttribute("categories", category);
		List<Subcategory> subcategory = subcategoryService.getSubcategory();
		model.addAttribute("subcategory", subcategory);
		return "itemedit";
	}
	
	@RequestMapping("deleteitem/{id}")
	public String deleteItem(@PathVariable Integer id) {
		
		itemService.deleteItem(id);
		System.out.println("--------->+1");
		return "redirect:/item";
	}
	
	@GetMapping("/allproducts")
	public String userProducts(Model model) {
		List<Item> items = itemService.findAllItem();
		model.addAttribute("items", items);
		return "allproducts";
	}
	@GetMapping("/viewproducts/{id}")
	public String viewproducts(@PathVariable("id") Integer id) {
		System.out.println(id);
		return "viewproducts";
	}
	
	
	
	
	
	
	
	
	
	
}

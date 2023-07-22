package com.qci.ecommercewebapp.Controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qci.ecommercewebapp.Model.CartPojo;
import com.qci.ecommercewebapp.Model.Item;
import com.qci.ecommercewebapp.Model.User;
import com.qci.ecommercewebapp.Repository.UserRepo;
import com.qci.ecommercewebapp.Service.ItemService;
import com.qci.ecommercewebapp.Service.UserService;
import com.qci.ecommercewebapp.alterEntity.AlterItem;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired private UserService userService;
	
	@Autowired private UserRepo userRepo;

	@Autowired private ItemService itemService;
	
	@GetMapping("/userlogin")
	public String userLogin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return "userlogin";
	}
	
	@GetMapping("/userregister")
	public String userRegister() {
		return "userregister";
	}
	
	@RequestMapping("/userreg")
	public String userReg(@ModelAttribute("user") User user) {
		userRepo.save(user);
		return "redirect:/userlogin";
	}
	
	@GetMapping("/checkuserlogin")
	public String checkUserLogin(@ModelAttribute("user") User user) {
		
		Optional<User> useroptional = userService.findByUsername(user.getUsername());
		
		if(useroptional.isPresent()) {
			
			User users = useroptional.get();
			
			if(user.getPassword().equals(users.getPassword())){
				
				return "redirect:/allproducts";
			}
			else {
				return "redirect:/userlogin";
			}
			}
		else {
				return "redirect:/userregister";
		}
	}

	@GetMapping("/userviewproduct/{id}")
//	public String viewProduct(@PathVariable("id") Integer productId, Model model) {

	public String viewProduct(@ModelAttribute("user") User user, Model model) {
	    AlterItem item1 = itemService.findById(user.getId());

//	    System.out.println(item1.getPrice());
//	    System.out.println(item1.getItem_title());
//	    System.out.println(item1.getImage_Filename());
	    model.addAttribute("item", item1); // Change the attribute key to "item"

	    return "userviewproduct";
	}
	
//	@GetMapping("/userviewproduct")
//	public String userViewProduct() {
//		return "userviewproduct";
//	}
	
//	@RequestMapping("userviewproduct/addcart/{id}")
//	public String addToCart(@RequestParam("quantity") int quantity,@RequestParam("price") String price, @RequestParam("item_title") String item_title  ,HttpServletRequest request) {
//		HttpSession httpSession = request.getSession();
//		httpSession.getAttribute(item_title);
//		System.out.println(id);
	
	@RequestMapping("/userviewproduct/addcart/{id}")
	public String addtoCart(@PathVariable Integer id , @ModelAttribute("cart") CartPojo cartPojo, HttpServletRequest request,Model model ) {
		HttpSession httpSession = request.getSession();
		
		//Getting image_Filename()
		AlterItem item = itemService.findById(id);
		httpSession.setAttribute("image_name", item.getImage_Filename());
		
		cartPojo.setImage_name(item.getImage_Filename());
//		
//		
//		
//		System.out.println(" Pojo "+cartPojo.getId());
//		System.out.println("Session ID "+ httpSession.getId().toString());
//		
//		System.out.println(cartPojo.getItem_title());
//		
//		
//		System.out.println(httpSession.getAttribute("image_name"));
//		
//		ArrayList<CartPojo> sessionList = (ArrayList<CartPojo>) httpSession.getAttribute("sessionList");
//	    if (sessionList == null) {
//	        sessionList = new ArrayList<>();
//	        httpSession.setAttribute("sessionList", sessionList);
//	    }
//	    // Add cartPojo to the session list
//	    sessionList.add(cartPojo);
//
//	    model.addAttribute("cart", sessionList);

	    return "usercart";
	}
	
	
	@GetMapping("/removecart/{id}")
	public String removeCart(@PathVariable Integer id, CartPojo cartPojo, HttpServletRequest request) {
	    HttpSession httpSession = request.getSession();

	    // Retrieve the session list
	    ArrayList<CartPojo> sessionList = (ArrayList<CartPojo>) httpSession.getAttribute("sessionList");
	    if (sessionList != null) {
	        // Remove the CartPojo object with matching id from the session list
	        sessionList.removeIf(item -> item.getId().equals(id));
	        
	        
	        System.out.println("============>" + sessionList.toString());
	    }
		return "redirect:/userviewproduct/addcart/{id}";
	}
	
	
	@RequestMapping("/logoutuser")
	public String logoutUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
//		session.removeAttribute("loginadmin");
		session.invalidate();
//		session.setMaxInactiveInterval(0);
//		session = null;
//		System.out.println("logoutmethod ===>"+session.toString());
		return "redirect:/userlogin";
	}
	
	@GetMapping("/ordernow")
	public String orderNow() {
		return "ordernow";
	}
	
	@GetMapping("/localstorage")
	public String savelocalstorage() {
		return "localStorageEg";
	}
	
	@RequestMapping("/savelocalstorage")
	public String saveLocalstorage() {
		return "redirect:/locatstorage";
	}
}
// 	@RequestMapping("/userviewproduct/addcart/{id}")
//		httpSession.setAttribute("cart", cartPojo);
//		httpSession.setAttribute("quantity", cartPojo.getQuantity());
//		httpSession.setAttribute("price", cartPojo.getPrice());
//		httpSession.setAttribute("item_title", cartPojo.getItem_title());

//		model.addAttribute("quantity", httpSession.getAttribute("quantity"));
//		model.addAttribute("price", httpSession.getAttribute("price"));
//		model.addAttribute("item_title", httpSession.getAttribute("item_title"));
//		model.addAttribute("image_name", httpSession.getAttribute("image_name"));

//		Enumeration<String> attributeNames = httpSession.getAttributeNames();
//	    while (attributeNames.hasMoreElements()) {
//	        String attributeName = attributeNames.nextElement();
//	        Object attributeValue = httpSession.getAttribute(attributeName);
//	        System.out.println(attributeName + ": " + attributeValue);
//	        sessionList.add(attributeValue.toString()); 
//	    }
//	    for (Object sessionData : sessionList) {
//	        System.out.println(sessionData);
//	    }
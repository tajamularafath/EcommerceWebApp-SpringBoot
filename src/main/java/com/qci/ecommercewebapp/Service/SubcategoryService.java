package com.qci.ecommercewebapp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qci.ecommercewebapp.Controller.SubcategoryController;
import com.qci.ecommercewebapp.JoinEntity.CategorySubcategoryJoin;
import com.qci.ecommercewebapp.Model.Category;
import com.qci.ecommercewebapp.Model.Subcategory;
import com.qci.ecommercewebapp.Repository.CatalogRepo;
import com.qci.ecommercewebapp.Repository.SubcategoryRepo;
import com.qci.ecommercewebapp.alterEntity.AlterSubcategory;
import com.qci.ecommercewebapp.alterRepo.AlterSubcategoryRepo;

@Service
public class SubcategoryService {

	@Autowired
	private SubcategoryRepo subcategoryrepo;
	
	@Autowired
	private AlterSubcategoryRepo altersubcategoryrepo;
	
	public List<Subcategory> getSubcategory(){
		return subcategoryrepo.findAll();
	}
	
//	public List<CategorySubcategoryJoin> joined(){
//		return subcategoryrepo.join();
//	}
	
//	public Subcategory savesubcategory(Subcategory subcategory) {
//		return subcategoryrepo.save(subcategory);
//	}
	
	public AlterSubcategory savesubcategory(AlterSubcategory altersubcategory) {
		return altersubcategoryrepo.save(altersubcategory);
	}
	
	public AlterSubcategory findedit(Integer id) {
		return altersubcategoryrepo.findById(id).orElse(null);
	}
	
	public AlterSubcategory getSubcatalogId(Integer id) {
		Optional<AlterSubcategory> optional = altersubcategoryrepo.findById(id);
		AlterSubcategory subcategory = null;
		
		if(optional.isPresent()) {
			subcategory=optional.get();
		}
		else {
			System.out.println("Item not found:"+id);
		}
		return subcategory;
	}
	
	public String deletesubcategory(Integer id) {
	   altersubcategoryrepo.deleteById(id);
	return "deleted";
	}
	
public AlterSubcategory updatealterSubcategory(AlterSubcategory alterSubcategory) {
//		AlterSubcategory alSubcategory = altersubcategoryrepo.findById(alSubcategory.getId()).orElse(null);
		AlterSubcategory subalter = altersubcategoryrepo.findById(alterSubcategory.getId()).orElse(null);
		if (subalter != null) {
		subalter.setSubcategory_title(alterSubcategory.getSubcategory_title());
		subalter.setCategory(alterSubcategory.getCategory());
//		subalter.setStatus(alterSubcategory.getStatus());
		return altersubcategoryrepo.save(alterSubcategory);
		}
		else {
			System.out.println("Not get data");
		}
		return alterSubcategory;
	}
	
//	public String deleteSubcategory(Integer id) {
//		altersubcategoryrepo.deleteById(id);
//		
//		return "deleted";
//	}
	
	
	
	
	
	
	
	
	

}
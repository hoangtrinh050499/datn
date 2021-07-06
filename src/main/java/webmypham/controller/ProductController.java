package webmypham.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import webmypham.DTO.CategoryDTO;
import webmypham.DTO.CompositionDTO;
import webmypham.DTO.ImportdetailDTO;
import webmypham.DTO.ProductDTO;
import webmypham.DTO.ProductclassDTO;
import webmypham.DTO.SkintypeDTO;
import webmypham.DTO.TitleCategoryDTO;
import webmypham.DTO.TrademarkDTO;
import webmypham.convert.TitleCategoryConvert;
import webmypham.model.Category;
import webmypham.model.Composition;
import webmypham.model.Importdetail;
import webmypham.model.Products;
import webmypham.model.Skintype;
import webmypham.model.Trademark;
import webmypham.repository.ProductRipository;
import webmypham.service.CategoryService;
import webmypham.service.CatogorytitleService;
import webmypham.service.CompositionService;
import webmypham.service.ImageService;
import webmypham.service.ProductService;
import webmypham.service.Product_CategoryService;
import webmypham.service.Product_CompositionService;
import webmypham.service.Product_SkintypeService;
import webmypham.service.SkintypeService;
import webmypham.service.TrademarkService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	@Autowired
	ProductRipository productRipository;
	@Autowired
	private ProductService productService;
	@Autowired
	private TrademarkService trademarkService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	Product_CompositionService product_compositionService;
	@Autowired
	Product_CategoryService product_categoryService;
	@Autowired
	Product_SkintypeService product_skintypeService;
	@Autowired
	ImageService imageService;
	@Autowired
	SkintypeService skintypeService;
	@Autowired
	CompositionService compositionService;
	
	@Autowired
	CatogorytitleService categorytitleservice;
	 
	
	@GetMapping(value="/product")
	public List<ProductDTO> getAllDTO(){
		return (List<ProductDTO>) productService.findAll();
	}
	@GetMapping(value="/products")
	public List<Products> tatca(){
		return (List<Products>) productService.tatca();
	}
	
	@GetMapping(value="/productclass")
	public List<ProductclassDTO> getAllproduct(){
		return (List<ProductclassDTO>) productService.getproductclass();
	}
	
	@GetMapping(value="/product/caocap")
	public List<ProductDTO> getAllproductcaocap(){
		return productService.findcaocap();
	}
	
	@GetMapping(value="/product/discount")
	public List<ProductDTO> getAllproductdiscount(){
		return productService.finddiscount();
	}
	

	@GetMapping(value="/product/{id}")
	public ProductDTO getOne(@PathVariable("id")int id) {
		return productService.findOne(id);
	}
	
	@PostMapping(value="/product/insert")
	public List<String> insert(@RequestBody ProductDTO product) {
		productService.save(product);
		int id = productRipository.findIDProduct();
		product.setId(id);
		product_compositionService.save(product);
//		product_categoryService.save(product);
		product_skintypeService.save(product);
		imageService.save(product);
		return product.getImageproduct();
	}
	
	@PutMapping(value="/product/update/{id}")
	public String update(@PathVariable("id") int id,@RequestBody ProductDTO product) {
		Products pro = productService.findone(id);
		if(pro != null) {
			product.setId(id);
			productService.save(product);
			product_compositionService.delete(id);
			product_compositionService.save(product);
//			product_categoryService.save(product);
			product_skintypeService.delete(id);
			product_skintypeService.save(product);
			imageService.delete(id);
			imageService.save(product);
			return "Update thành công";
		}
		return "Update không thành công";
	}
	
	@DeleteMapping(value="/product/delete/{id}")
	public String delete(@PathVariable("id")int id) {
		Products pro = productService.findone(id);
		if(pro != null) {
			productService.delete(id);
			return "Delete thành công";
		}
		return "Delete không thành công";
	}
	
	
	// Trademark đa sửa xong theo dto
	
	@GetMapping(value="/trademark")
	public List<TrademarkDTO> get(){
		return trademarkService.findAll();
	}
	
	@GetMapping(value="/trademark/product/{id}")
	public List<ProductDTO> getAllproductstra(@PathVariable int id){
		return trademarkService.getproducts(id);
	}
	
	
	@PostMapping(value="/trademark/insert")
	public void insertTrademark(@RequestBody TrademarkDTO tdm) {
		trademarkService.save(tdm);
	}
	
	@PutMapping(value="/trademark/udpate/{id}")
	public String updateTrademark(@PathVariable("id") int id,@RequestBody TrademarkDTO tdm) {
		TrademarkDTO tdm1 = trademarkService.findOne(id);
		if(tdm1 != null) {
			tdm.setId(id);
			trademarkService.save(tdm);
			return "Update thành công";
		}
		return "Update không thành công";
	}
	
	@GetMapping(value="/trademark/findone/{id}")
	public TrademarkDTO getOneTrademark(@PathVariable("id") int id) {
		return trademarkService.findOne(id);
	}
	
	@DeleteMapping(value="/trademark/delete/{id}")
	public String deletTrademark(@PathVariable("id") int id) {
		TrademarkDTO tdm1 = trademarkService.findOne(id);
		if(tdm1 != null) {
			trademarkService.delete(id);
			return "Delete thành công";
		}
		return "Deletes không thành công";
	}
	
	//Category
	
	@GetMapping(value="/category")
	public List<CategoryDTO> getAllCategory(){
		return categoryService.findAll();
	}
	
	@GetMapping(value="/category/product/{id}")
	public List<ProductDTO> getAllproducts(@PathVariable int id){
		return categoryService.getproducts(id);
	}
	
	
	@GetMapping(value ="/category/{id}")
	public CategoryDTO getNameCate(@PathVariable("id") int id) {
		return categoryService.findOne(id);
	}
	
	@PostMapping(value="/category/insert")
	public void addCategory(@RequestBody CategoryDTO category) {
		categoryService.save(category);
	}
	
	@PutMapping(value="/category/update/{id}")
	public String update(@PathVariable("id") int id, @RequestBody CategoryDTO category) {
		CategoryDTO cat = categoryService.findOne(id);
		if(cat != null) {
			category.setId(id);
			categoryService.save(category);
			return "Update thành công";
		}
		return "Update không thành công";
	}
	
	@DeleteMapping(value = "/category/delete/{id}")
	public String deleteCategory(@PathVariable("id") int id) {
		CategoryDTO cat = categoryService.findOne(id);
		if(cat != null) {
			categoryService.delete(id);
			return "Delete thành công";
		}
		return "Delete không thành công";
	}
	
	
	//Title category
	
	@GetMapping(value = "/titlecategory")
	public List<TitleCategoryDTO> getTitlecategory(){
		return categorytitleservice.getAll();
	}
	
	
	

	//Skintype
	
	@GetMapping(value="/skintype")
	public List<SkintypeDTO> getAllSkintype(){
		return skintypeService.findAll();
	}
	
	@GetMapping(value="/skintype/product/{id}")
	public List<ProductDTO> getAllproductsskintype(@PathVariable int id){
		return skintypeService.getproducts(id);
	}
	
	
	
	
	@GetMapping(value ="/skintype/{id}")
	public SkintypeDTO getNameSkin(@PathVariable("id") int id) {
		return skintypeService.findOne(id);
	}
	
	//Composition
	
	@GetMapping(value="/composition")
	public List<CompositionDTO> getAllComposition(){
		return compositionService.findAll();
	}
	
	@GetMapping(value="/composition/product/{id}")
	public List<ProductDTO> getAllproductscomposition(@PathVariable int id){
		return compositionService.getproducts(id);
	}
	
	
	@GetMapping(value ="/composition/{id}")
	public CompositionDTO getNameCom(@PathVariable("id") int id) {
		return compositionService.findOne(id);
	}
	
	
	
	
	
}

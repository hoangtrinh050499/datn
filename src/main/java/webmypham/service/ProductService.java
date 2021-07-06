package webmypham.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webmypham.DTO.CategoryDTO;
import webmypham.DTO.CompositionDTO;
import webmypham.DTO.ImageproductDTO;
import webmypham.DTO.ImportdetailDTO;
import webmypham.DTO.ProductDTO;
import webmypham.DTO.ProductclassDTO;
import webmypham.DTO.SkintypeDTO;
import webmypham.DTO.TrademarkDTO;
import webmypham.convert.CategoryConvert;
import webmypham.convert.CompositionConvert;
import webmypham.convert.ImageproductConvert;
import webmypham.convert.ProductConverter;
import webmypham.convert.SkintypeConvert;
import webmypham.convert.TrademarkConvert;
import webmypham.model.Category;
import webmypham.model.CategoryTitle;
import webmypham.model.Composition;
import webmypham.model.ImageProduct;
import webmypham.model.Importdetail;
import webmypham.model.Product_Composition;
import webmypham.model.Product_Skintype;
import webmypham.model.Products;
import webmypham.model.Skintype;
import webmypham.model.Trademark;
import webmypham.model.product_category;
import webmypham.repository.CategoryRipository;
import webmypham.repository.CompositionRepository;
import webmypham.repository.ImportdetailRipository;
import webmypham.repository.ProductRipository;
import webmypham.repository.Product_CategoryRepository;
import webmypham.repository.TrademarkRipository;




@Service
public class ProductService {
	
	@Autowired
	CompositionConvert compositionconvert;
	@Autowired
	CategoryConvert categoryconvert;
	@Autowired
	TrademarkConvert trademarkconvert;
	@Autowired
	SkintypeConvert skintypeconvert;
	@Autowired
	ImageproductConvert imageconvert;
	@Autowired
	ProductConverter productconvert;

	
	@Autowired
	ProductRipository productRipository;
	@Autowired
	CompositionService compositionService;
	@Autowired
	TrademarkService trademarkService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	SkintypeService skinService;
	@Autowired
	ImageService imageService;
	@Autowired
	Product_CompositionService product_CompositionService;
	@Autowired
	Product_CategoryService product_CategoryService;
	@Autowired
	Product_SkintypeService product_SkintypeService;
	@Autowired
	CatogorytitleService cateCatogorytitleService;
	@Autowired
	ImportdetailService importdetailService;
	
	@Autowired
	Product_DiscountService product_discountService;
	

	public List<Products> tatca(){
		return productRipository.findAll();
	}

	public Iterable<ProductDTO> findAll(){
		List<ProductDTO> listproductdto = new ArrayList<ProductDTO>();
		
		List<Products> products = productRipository.findAll();
		int price=0;
		int discount=0;
		for(Products pro : products) {
			
			ProductDTO productdto = new ProductDTO();
			TrademarkDTO trademarkDTO = new TrademarkDTO();
			List<CompositionDTO> listcompositiondto = new ArrayList<CompositionDTO>();
			CategoryDTO listcategorydto = new CategoryDTO();
			List<SkintypeDTO> listskintypedto = new ArrayList<SkintypeDTO>();
			List<String> listimage = new ArrayList<String>();
			
			if(importdetailService.findprice(pro.getId())!=null){
				price = importdetailService.findprice(pro.getId());
			}
			else {
				price=0;
			}

			if(product_discountService.discount(pro.getId()) !=  null) {
				discount = product_discountService.discount(pro.getId());
			}
			else {
				discount=0;
			}
			
			List<Product_Composition> product_composition = new ArrayList<Product_Composition>();
			product_composition = product_CompositionService.getidProduct(pro.getId());
			for(Product_Composition i : product_composition) {
				listcompositiondto.add(compositionconvert.mapCompositionEntityToDto( i.getComposition()));
			}
			
			
			
//			Trademark tra = pro.getTrademark();
//			trademarkDTO = trademarkconvert.mapTrademarkEntityToDto(tra);

			
//			List<product_category> product_categoryn = new ArrayList<product_category>();
//			product_categoryn = product_CategoryService.getAll(pro.getId());
			
//			for(product_category i : product_categoryn) {
//				CategoryTitle cate = cateCatogorytitleService.findOne(i.getCategory().getId());
//				listcategorydto.add(categoryconvert.mapCategoryEntityToDto( i.getCategory(),cate));
//			}
//			CategoryTitle cate = cateCatogorytitleService.findOne(pro.getCategory().getIdtitlecategory());
//			listcategorydto = categoryconvert.mapCategoryEntityToDto(pro.getCategory(),cate);
//			
			
			
			List<Product_Skintype> product_Skintypes = new ArrayList<Product_Skintype>();
			product_Skintypes = product_SkintypeService.getAll(pro.getId());
			for(Product_Skintype i : product_Skintypes) {		
				listskintypedto.add(skintypeconvert.mapSkintypeEntityToDto(i.getSkintype()));
			}
			
			List<ImageProduct> imageProduct = new ArrayList<ImageProduct>();
			imageProduct = imageService.getProduct(pro);
			for(ImageProduct i : imageProduct) {
				listimage.add(i.getImage());
			}
			listproductdto.add(productconvert.mapProductEntityToDto( pro,price,discount ,listcompositiondto,
					 listskintypedto, listimage));

		}
		return listproductdto;
		
	}
	
	public void save(ProductDTO pro) {
		productRipository.save(productconvert.mapProductDtoToEntity(pro));
	}
	
	public Products findone(int id) {
		return productRipository.findOne(id);
	}
	
	public ProductDTO findOne(int id) {
		Products pro = productRipository.findOne(id);
		ProductDTO productdto = new ProductDTO();
		TrademarkDTO trademarkDTO = new TrademarkDTO();
		List<CompositionDTO> listcompositiondto = new ArrayList<CompositionDTO>();
		CategoryDTO listcategorydto = new CategoryDTO();
		List<SkintypeDTO> listskintypedto = new ArrayList<SkintypeDTO>();
		List<String> listimage = new ArrayList<String>();
		int price = 0;
		if(importdetailService.findprice(pro.getId())!= null) {
			price = importdetailService.findprice(pro.getId());
		}
		int discount =0;
		if(product_discountService.discount(pro.getId()) !=  null) {
			discount = product_discountService.discount(pro.getId());
		}
		else {
			discount=0;
		}

		
		List<Product_Composition> product_composition = new ArrayList<Product_Composition>();
		product_composition = product_CompositionService.getidProduct(pro.getId());
		for(Product_Composition i : product_composition) {
			listcompositiondto.add(compositionconvert.mapCompositionEntityToDto( i.getComposition()));
		}
//		Trademark tra = pro.getTrademark();
//		trademarkDTO = trademarkconvert.mapTrademarkEntityToDto(tra);

		
//		List<product_category> product_categoryn = new ArrayList<product_category>();
//		product_categoryn = product_CategoryService.getAll(pro.getId());
//		for(product_category i : product_categoryn) {
//			CategoryTitle cate = cateCatogorytitleService.findOne(i.getCategory().getId());
//			listcategorydto.add(categoryconvert.mapCategoryEntityToDto( i.getCategory(),cate));
//		}
		
//		CategoryTitle cate = cateCatogorytitleService.findOne(pro.getCategory().getIdtitlecategory());
//		listcategorydto = categoryconvert.mapCategoryEntityToDto(pro.getCategory());
		
		List<Product_Skintype> product_Skintypes = new ArrayList<Product_Skintype>();
		product_Skintypes = product_SkintypeService.getAll(pro.getId());
		for(Product_Skintype i : product_Skintypes) {		
			listskintypedto.add(skintypeconvert.mapSkintypeEntityToDto(i.getSkintype()));
		}
		
		List<ImageProduct> imageProduct = new ArrayList<ImageProduct>();
		imageProduct = imageService.getProduct(pro);
		for(ImageProduct i : imageProduct) {
			listimage.add(i.getImage());
		}
	
		return productconvert.mapProductEntityToDto( pro,price,discount ,listcompositiondto,
				listskintypedto, listimage);
	}
	
	public void delete(int id) {
		productRipository.delete(id);
	}
	
	public List<Products> get(){
		return productRipository.findAll();
	}
	
	public List<Products> getproducts(int id){
		return productRipository.findAllproducts(id);
	}
	
	public List<ProductclassDTO> getproductclass() {
		List<ProductclassDTO> products = new ArrayList<ProductclassDTO>();
		for (Products i : productRipository.findAll()) {
			products.add(productconvert.mapProductclassEntityToDto(i));
		}
		
		return products;
	}
	
	public List<ProductDTO> findcaocap(){
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		for (ImportdetailDTO i : importdetailService.caocap()) {
			list.add(findOne(i.getProduct().getId()));
		}
		
		return list;
	}
	
	public List<ProductDTO> finddiscount(){
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		for (ProductDTO i : findAll()) {
			if(i.getDiscount() != 0 ) {
				list.add(i);
			}
			
		}
		return list;
	}
	
	
	public List<ProductDTO> findAllcategory(int id){
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		for (Products i : productRipository.findAllproductscategory(id)) {
			list.add(findOne(i.getId()));
			
		}
		return list;
	}

}

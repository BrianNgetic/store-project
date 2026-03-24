package com.storeproject.service.product;



import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.*;
import java.util.*;

import com.storeproject.repository.*;

import com.storeproject.Exceptions.invalidProductCategoryException;
import com.storeproject.Exceptions.noProductsFoundException;
import com.storeproject.Exceptions.ProductNotFoundException;
import com.storeproject.model.*;
import com.storeproject.dto.CreatedProduct;
import com.storeproject.dto.NutritionDto;
import com.storeproject.mapping.ProductMapper;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductServiceTest {
    
    @Mock
    private ProductRepository productRepository;

    @Mock
    private ElectronicsRepository electronicsRepository;

    @Mock
    private ClothingRepository clothingRepository;

    @Mock
    private FoodRepository foodRepository;

    // @Spy
    // private ProductMapper productMapper ;

   

    // @InjectMocks
    // private ProductService productService;

   

    //dtos
    CreatedProduct clothing =  new CreatedProduct();
    CreatedProduct fakeClothing = new CreatedProduct();
    CreatedProduct electronics = new CreatedProduct();
    CreatedProduct food  = new CreatedProduct();
    NutritionDto foodNutrition = new NutritionDto();

    //Regular entityclass
    Clothing otherClothing = new Clothing();
    Electronics otherElectronic = new Electronics();

    //all
  
    ProductMapper productMapper = new ProductMapper();
    ProductService productService;
  



    @BeforeEach
    public void setUp(){
         //create a  new product


        productService = new ProductService(clothingRepository, electronicsRepository, foodRepository, productMapper, productRepository);
        clothing = CreatedProduct.builder()
               .name( "North Face Puffer Jacket")
                .category("Clothing")
                .type("jacket")
                .price(45.0)
                .stock(45)
                .clothSize("M")
                .clothColor("Blue")
                .build();

            fakeClothing =  CreatedProduct.builder()
               .name( "North Face Puffer Jacket")
                .category("fakeCategory")
                .type("jacket")
                .price(45.0)
                .stock(45)
                .clothSize("M")
                .clothColor("Blue")
                .build();
        

        electronics = CreatedProduct.builder()
                    .name("Samsung Galaxy S23")
                    .category("Electronic")
                    .type("phone")
                    .price(244.99)
                    .stock(26)
                    .warrantyEligible(true)
                    .warrantyPeriod(30)
                    .productVersion(2.0)
                    .build();
       
      foodNutrition = new NutritionDto(
                159,
                14,
                29,
                13);
        food = CreatedProduct.builder()
            .name("Almond Butter Jar")
            .category("Food")
            .type("grocery")
            .price(10.09)
            .stock(109)

            .expiryDate(LocalDate.parse("2026-02-07"   ))
            .foodNutrition(foodNutrition)
            .build();
            

    otherClothing =  new Clothing(
            
                "ski mask",
                "Clothing",
                "jacket",
                45.0,
                45,
                "M",
                "Blue");
    otherElectronic = new Electronics(
                    "Samsung Galaxy S23",
                    "Electronic" ,
                    "phone",
                    244.99,
                    26,
                    true, 
                    30,
                     2.0);

     

    //     productService = new ProductService(clothingRepository, electronicsRepository, foodRepository, productMapper, productRepository);
    // 
    }


    @Test
    public void createProduct_shouldSaveProduct_whenValidInput() throws Exception{

        
    
        List<CreatedProduct>   allProductDTosToBeSaved = List.of(electronics, food, clothing);
    
    
        ArgumentCaptor<Product> ProductCaptor = 
                            ArgumentCaptor.forClass(Product.class);

        productService.addProduct(allProductDTosToBeSaved);

            
                        
        verify(productRepository, times(allProductDTosToBeSaved.size())).save(ProductCaptor.capture());

        List<Product> savedProducts = ProductCaptor.getAllValues();

        assertEquals(savedProducts.size(), allProductDTosToBeSaved.size());
        
        assertEquals(savedProducts.get(0).getName(), allProductDTosToBeSaved.get(0).getName() );


        
    

    }

    @Test
    public void viewProductById_shouldReturnProduct_whenProductExists() throws Exception{

        Long Id = 1L;
        when(productRepository.existsById(Id)).thenReturn(true);

        when(productRepository.getReferenceById(Id)).thenReturn(otherClothing);

        CreatedProduct tempClothDto =   productService.viewProductById(Id);
        
        verify(productRepository, times(1)).existsById(Id);

       
        //did the repository call the method
        verify (productRepository, times(1)).getReferenceById(Id);
        
        //verify that the two  are same
        assertEquals(tempClothDto.getName(), otherClothing.getName());
        

    
    }

    @Test
     public void getProductById_shouldThrowException_whenProductDoesntExists() {

        Long Id = 1L;
        when(productRepository.existsById(Id)).thenReturn(false);

        assertThrows(ProductNotFoundException.class ,() ->  productService.viewProductById(Id));
     
    }

    @Test
    public void getAllProducts_shouldReturnListOfProducts_whenProductsExist() throws Exception{
        
          List<Product> allRegularEntities = List.of(otherClothing, otherElectronic);


            when(productRepository.findAll()).thenReturn(allRegularEntities);

            List<CreatedProduct> allProducts = productService.viewAllProducts();

            assertEquals(allProducts.size(), allRegularEntities.size() );
            assertEquals(allRegularEntities.get(1).getName(), allProducts.get(1).getName());


            verify(productRepository, times(1)).findAll();

    }

    @Test
     public void getAllProducts_shouldReturnEmptyList_whenProductsDontExist() throws Exception{

        when(productRepository.findAll()).thenReturn(new ArrayList<>());

        // List<CreatedProduct> allproducts = productService.viewAllProducts();

        assertThrows(noProductsFoundException.class, () -> productService.viewAllProducts());
       
        verify(productRepository, times(1)).findAll();

        // assertEquals(0, allproducts.size());

        
     }

    @Test
    public void updateProduct_shouldUpdateFields_whenProductExists() throws Exception{
        
       /*
        @param - this method accepts an id, and an updatedversion of the dto 
                whose id you passed and want to update
       */
       
       //updated dto  ..chaning price to 144.99
        CreatedProduct newUpdatedElectronicDTO = CreatedProduct.builder()
                    .name("Samsung Galaxy S23")
                    .category("Electronic")
                    .type("phone")
                    .price(144.99)
                    .stock(26)
                    .warrantyEligible(true)
                    .warrantyPeriod(30)
                    .productVersion(2.0)
                    .build();
                
       
        Long Id = 1L;

        when(productRepository.existsById(Id)).thenReturn(true);
        
        when(productRepository.getReferenceById(Id)).thenReturn(otherElectronic);
      
       ArgumentCaptor<Product> captor = ArgumentCaptor.forClass(Product.class);

         productService.updatedProduct(Id, newUpdatedElectronicDTO);

        //inspect the new updated entity passed to the saved
     

        /*lets us know if the .save repository function was called
        doesnt actually tell us what was saved or if the correct thing was saved, only that 
        something was saved*/

        // System.out.println(captor.capture());
        verify(productRepository, times(1))
                        .save(captor.capture());

        
        Product savedProduct = captor.getValue();


        //verify/assert that the price was updated
        assertEquals(newUpdatedElectronicDTO.getPrice(), savedProduct.getPrice() );

        


    }

    @Test
    public void updateProduct_shouldThrowException_whenDoesntExist() throws Exception{

        Long Id = 1L;

        when(productRepository.existsById(1L)).thenReturn(false);

      

        assertThrows(ProductNotFoundException.class, () -> productService.updatedProduct(Id, clothing));

       
    }

    @Test
    public void updateProduct_shouldThrowException_whenProdCategory_DoesntExist() throws Exception{

          Long otherId = 2L;

        when(productRepository.existsById(otherId)).thenReturn(true);

        // // verify(productRepository).existsById(otherId);
        // when(productRepository.getReferenceById(otherId)).thenReturn(otherClothing);


        assertThrows(invalidProductCategoryException.class, () -> productService.updatedProduct(otherId, fakeClothing));

    }

    //realized this should be an intergration test because rn there is no memory to delete from
    // @Test
    // public void deleteProduct_shouldRemoveProduct_whenProductExists() throws Exception{
        
    //        Long Id = 1L;

    //        when(productRepository.existsById(Id)).thenReturn(true);
    //        when(productRepository.deleteByid(Id)).thenReturn()
            
    //         productService.deleteProduct(otherClothing.getId());

    //         verify(productRepository).deleteById(otherClothing.getId());
        

    
    // }

    @Test
    public void deleteProduct_shouldThrowException_WhenItDoesntExist() throws Exception{
        Long Id = 1L;

        when(productRepository.existsById(Id)).thenReturn(false);

        assertThrows(ProductNotFoundException.class , () -> productService.deleteProduct(Id));


    }

}

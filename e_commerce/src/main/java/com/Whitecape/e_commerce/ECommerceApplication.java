package com.Whitecape.e_commerce;


import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.core.io.ClassPathResource;

import com.Whitecape.e_commerce.controller.ProductController;

import com.Whitecape.e_commerce.model.Product;
import com.Whitecape.e_commerce.repository.ProductRepository;





@SpringBootApplication
public class ECommerceApplication extends SpringBootServletInitializer implements CommandLineRunner {
	@Autowired 
	ProductRepository productRep;
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ECommerceApplication.class);
    }

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ECommerceApplication.class, args);
	}
	/*implements CommandLineRunner
	@Override
	public void run(String... args) throws Exception {
		ClassPathResource backImgFile = new ClassPathResource("images/img2.jpg");
		byte[] arrayPic = new byte[(int) backImgFile.contentLength()];
		backImgFile.getInputStream().read(arrayPic);
		ImageModel blackImage = new ImageModel(1, "JSA-ABOUT-IMAGE-BLACK-BACKGROUND", "png", arrayPic);
	  Collection<Product> prod;
	  Collection<ImageModel> img = null;
	  prod = productRep.findAll();
	  for (Product itProd : prod) {
		  itProd.setImage(blackImage);
	  }
	  
	  productRep.saveAll(prod);
	  for(Product product : productRep.findAll()){
		   img.add(product.getImage());
	  }
		   for( ImageModel imageModel :img ) {
		  Files.write(Paths.get("retrieve-dir/" + imageModel.getName() + "." + imageModel.getType()), imageModel.getPic());
		}
		
	}
	*/

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method 
		File file = new File("images/img2.jpg");
        byte[] bFile = new byte[(int) file.length()];
 
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Product p = new Product();
        p.setName("efdfsd");
        p.setDescription("dsfqsfqsd");
        p.setPrice(50);
        p.setQuantity(3);
        p.setImage(bFile);
        productRep.save(p);
	}

	
}

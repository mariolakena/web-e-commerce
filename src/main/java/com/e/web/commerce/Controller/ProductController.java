package com.e.web.commerce.Controller;

import com.e.web.commerce.dto.ProductRequestDto;
import com.e.web.commerce.dto.ProductResponseDto;
import com.e.web.commerce.entity.Product;
import com.e.web.commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
  @Autowired
  private ProductService productService;
  @PostMapping
  public ResponseEntity<ProductRequestDto>
    createProduct(@RequestBody
                  ProductRequestDto
                          productRequestDto){
    return new ResponseEntity<>(productRequestDto,
            HttpStatus.CREATED);
  }
  @GetMapping("{id}")
  public ResponseEntity<Product> getProductById(@PathVariable Long id) {

    return new ResponseEntity<>(productService.findById(id),
            HttpStatus.OK);
  }

  @PatchMapping("{productId}")
  public ResponseEntity<ProductResponseDto> updateProduct(
          @RequestBody ProductRequestDto productRequestDto, @PathVariable Long productId){
    ProductResponseDto product = productService.updateProduct(productId, productRequestDto);
    return new ResponseEntity<>(product,HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<Product>> getAllProducts() {
    return new ResponseEntity<>(this.productService.getAllProducts(), HttpStatus.OK);
  }
}

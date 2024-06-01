package com.e.web.commerce.service;

import com.e.web.commerce.dto.ProductRequestDto;
import com.e.web.commerce.dto.ProductResponseDto;
import com.e.web.commerce.entity.Product;
import com.e.web.commerce.repository.ProductRepository;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private ProductRepository productRepository;
    public Product createProduct(ProductRequestDto requestDto) {
        Product product = modelMapper.map(requestDto, Product.class);
        return productRepository.save(product);
    }

    public Product findById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        return null;

    }
    public ProductResponseDto updateProduct(Long id, ProductRequestDto productResponseDto){
        Product existingProduct =  this.findById(id);
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(productResponseDto,existingProduct);
        return modelMapper.map(productRepository.save(existingProduct),
                ProductResponseDto.class);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}

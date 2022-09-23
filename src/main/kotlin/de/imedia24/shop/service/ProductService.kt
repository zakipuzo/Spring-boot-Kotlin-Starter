package de.imedia24.shop.service

import de.imedia24.shop.db.entity.ProductEntity
import de.imedia24.shop.db.repository.ProductRepository
import de.imedia24.shop.domain.product.ProductResponse
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.ZonedDateTime

@Service
class ProductService(private val productRepository: ProductRepository) {

    fun findProductBySku(sku: String): ProductResponse? {
        // val z= ProductResponse(sku,"k","e", BigDecimal(412415))
        // return z
        val res: ProductResponse
        val product = productRepository.findBySku(sku)
        return if (product != null) {

            res = ProductResponse(product.sku, product.name, product.description ?: "", product.price)
            res
        } else
            null

    }
    fun findProductBySkus(skus:Array<String>):   List<ProductResponse> {

        val products =productRepository.findBySkuIn(skus);

        val list : ArrayList<ProductResponse> = ArrayList()

        for (product in products){
            list.add(ProductResponse(product.sku, product.name, product.description ?: "", product.price))
        }

        return list
    }
    fun addProduct(product: ProductResponse): ProductResponse? {
        val product=ProductEntity(product .sku,product.name,product.description,product.price, ZonedDateTime.now(), ZonedDateTime.now())

      val savedProduct=  productRepository.save(product)

        return ProductResponse(savedProduct.sku,savedProduct.name,savedProduct.description?:"",savedProduct.price)


    }

    fun all():   List<ProductResponse> {

        val products =productRepository.findAll();

        val list : ArrayList<ProductResponse> = ArrayList()

        for (product in products){
            list.add(ProductResponse(product.sku, product.name, product.description ?: "", product.price))
        }

        return list
    }
}
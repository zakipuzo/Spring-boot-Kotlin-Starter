package de.imedia24.shop.controller

import de.imedia24.shop.db.entity.ProductEntity
import de.imedia24.shop.domain.product.ProductResponse
import de.imedia24.shop.service.ProductService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import java.time.ZonedDateTime
import javax.websocket.server.PathParam

@RestController
class ProductController(private val productService: ProductService) {

    private val logger = LoggerFactory.getLogger(ProductController::class.java)!!

    @GetMapping("/products/{sku}", produces = ["application/json;charset=utf-8"])
    fun findProductsBySku(
        @PathVariable("sku") sku: String
    ): ResponseEntity<ProductResponse> {
        val z= ProductResponse(sku,"k","e", BigDecimal(412415))
        //return ResponseEntity.ok(z)
        logger.info("Request for product $sku")

        val product = productService.findProductBySku(sku)
        //logger.info("product:"+product.toString())
        return if(product == null) {
            ResponseEntity.notFound().build()
        } else {
            ResponseEntity.ok(product)
        }
    }

    @GetMapping("/products", produces = ["application/json;charset=utf-8"])
    fun findProductsBySkus (
            @RequestParam skus: Array<String>
    ):ResponseEntity<List<ProductResponse>>{

        logger.info("Request for product $skus")

        val products = productService.findProductBySkus(skus)

           return ResponseEntity.ok(products)

    }
 

    @PostMapping("/product",consumes = ["application/json;charset=utf-8"])
    fun addNewProduct(@RequestBody  product:ProductResponse): ResponseEntity<ProductResponse> {

        logger.info("new product: $product")
        val product = productService.addProduct(product)

        return if(product == null) {
            ResponseEntity.notFound().build()
        } else {
            ResponseEntity.ok(product)
        }
    }

    @GetMapping("/products/list",consumes = ["application/json;charset=utf-8"])
    fun all(): ResponseEntity<List<ProductResponse>> {


        val products = productService.all()

        return ResponseEntity.ok(products)

    }
}

package mx.edu.tecdesoftware.market_backend.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import mx.edu.tecdesoftware.market_backend.domain.Purchase;
import mx.edu.tecdesoftware.market_backend.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
@Tag(name = "Purchase", description = "Manage purchases in the store")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    @Operation(summary = "Get all purchases",
    description = "Return a list of all purchases")

    @ApiResponse(responseCode = "200", description = "Successful retrieval of purchases")
    @ApiResponse(responseCode = "500", description = "Internal server error")

    public ResponseEntity<List<Purchase>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get purchases by ID",
            description = "Return a purchase by its Client ID if it exists")
    @ApiResponse(responseCode = "200", description = "Purchase found")
    @ApiResponse(responseCode = "404", description = "Purchase not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")

    public ResponseEntity<List<Purchase>> getByClient(
            @Parameter(description = "ID of the Client", example = "4546221", required = true)
            @PathVariable("id") String clientId) {
        return purchaseService.getByClient(clientId)
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @Operation(
            summary = "Save a new purchase",
            description = "Register a new purchase and return the created purchase",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            examples = @ExampleObject(
                                    name = "Example purchase",
                                    value = """
                                            {
                                               "idCliente": "4546221",
                                               "fecha": "2026-07-16T14:26:18.729Z",
                                               "medioPago": "C",
                                               "comentario": "New purchase",
                                               "estado": "A",
                                               "productos": [
                                                 {
                                                   "idProducto": 1,
                                                   "cantidad": 5,
                                                   "active": true
                                                 }
                                               ]
                                             }
                                           """
                            )
                    )
            )
    )

    @ApiResponse(responseCode = "201", description = "Purchase created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid purchase data")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @ApiResponse(responseCode = "403", description = "Forbidden")
    @ApiResponse(responseCode = "409", description = "Purchase conflict(duplicate)")
    @ApiResponse(responseCode = "500", description = "Unauthorized")

    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }
}
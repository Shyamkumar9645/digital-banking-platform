package com.project.digital_banking_platform.controller;

import com.project.digital_banking_platform.entity.Transaction;
import com.project.digital_banking_platform.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@Tag(name = "Transaction", description = "Transaction management APIs")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @Operation(summary = "Get all transactions", description = "Retrieves a list of all transactions")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved transactions",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Transaction.class)))
    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return ResponseEntity.ok(service.findAll());
    }

    @Operation(summary = "Get a transaction by ID", description = "Retrieves a transaction by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the transaction",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Transaction.class))),
            @ApiResponse(responseCode = "404", description = "Transaction not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(
            @Parameter(description = "ID of the transaction to be retrieved") @PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new transaction", description = "Creates a new transaction")
    @ApiResponse(responseCode = "201", description = "Transaction created successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Transaction.class)))
    @PostMapping
    public ResponseEntity<Transaction> createTransaction(
            @Parameter(description = "Transaction object to be created") @RequestBody Transaction transaction) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(transaction));
    }

    @Operation(summary = "Update an existing transaction", description = "Updates an existing transaction by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transaction updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Transaction.class))),
            @ApiResponse(responseCode = "404", description = "Transaction not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(
            @Parameter(description = "ID of the transaction to be updated") @PathVariable Long id,
            @Parameter(description = "Updated transaction object") @RequestBody Transaction transaction) {
        if (!service.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        transaction.setId(id);
        return ResponseEntity.ok(service.save(transaction));
    }

    @Operation(summary = "Delete a transaction", description = "Deletes a transaction by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Transaction deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Transaction not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(
            @Parameter(description = "ID of the transaction to be deleted") @PathVariable Long id) {
        if (!service.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
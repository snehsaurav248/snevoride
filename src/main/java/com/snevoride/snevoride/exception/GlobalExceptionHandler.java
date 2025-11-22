package com.snevoride.snevoride.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Ride not found
    @ExceptionHandler(RideNotFoundException.class)
    public ResponseEntity<?> handleRideNotFound(RideNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(
                        404,
                        ex.getMessage(),
                        "Ride does not exist"
                ));
    }

    // ⭐ Add this new block for Fare Calculation errors
    @ExceptionHandler(FareCalculationException.class)
    public ResponseEntity<?> handleFareCalculationError(FareCalculationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(
                        400,
                        ex.getMessage(),
                        "Fare calculation failed"
                ));
    }

    // Fallback for any other errors
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneralException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(
                        500,
                        ex.getMessage(),
                        "Unexpected error occurred"
                ));
    }
}

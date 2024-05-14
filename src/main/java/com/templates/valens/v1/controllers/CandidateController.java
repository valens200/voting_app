package com.templates.valens.v1.controllers;

import com.templates.valens.v1.dtos.requests.CreateCandidateDTO;
import com.templates.valens.v1.models.User;
import com.templates.valens.v1.payload.ApiResponse;
import com.templates.valens.v1.services.ICandidateService;
import com.templates.valens.v1.utils.ExceptionsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/candidates")
public class CandidateController {

    @Autowired
    private ICandidateService candidateService;

    @PostMapping
    public ResponseEntity<ApiResponse> create(@RequestBody CreateCandidateDTO dto) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "The candidate was created successfully", candidateService.create(dto)));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @PutMapping("/{candidateId}")
    public ResponseEntity<ApiResponse> update(@RequestBody CreateCandidateDTO dto, @PathVariable UUID candidateId) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "The candidate was updated successfully", candidateService.update(dto, candidateId)));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @DeleteMapping("/{candidateId}")
    public ResponseEntity<ApiResponse> delete(@PathVariable UUID candidateId) {
        try {
            candidateService.delete(candidateId);
            return ResponseEntity.ok(new ApiResponse(true, "The candidate was deleted successfully"));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping("/{candidateId}")
    public ResponseEntity<ApiResponse> getById(@PathVariable UUID candidateId) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Candidate retrieved successfully", candidateService.getById(candidateId)));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping("/profile")
    public ResponseEntity<ApiResponse> getByProfile(@RequestParam User profile) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Candidate retrieved successfully", candidateService.getByProfile(profile)));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAll() {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "All candidates were retrieved successfully", candidateService.getAll()));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping("/paginated")
    public ResponseEntity<ApiResponse> getAllPaginated(Pageable pageable) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Candidates retrieved successfully", candidateService.getAllPaginated(pageable)));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping("/position/{positionId}")
    public ResponseEntity<ApiResponse> getAllByPosition(Pageable pageable, @PathVariable UUID positionId) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Candidates retrieved successfully", candidateService.getAllByPosition(pageable, positionId)));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }
}

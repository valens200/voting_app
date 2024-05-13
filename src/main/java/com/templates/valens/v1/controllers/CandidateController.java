package com.templates.valens.v1.controllers;
import com.templates.valens.v1.dtos.requests.CreateCandidateDTO;
import com.templates.valens.v1.payload.ApiResponse;
import com.templates.valens.v1.services.ICandidateService;
import com.templates.valens.v1.utils.ExceptionsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/candidates")
@RequiredArgsConstructor
public class CandidateController {
    private final ICandidateService candidateService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> create(@RequestBody @Validated CreateCandidateDTO dto) {
        try{
            return ResponseEntity.ok(new ApiResponse(true,"The candidate was created successfully", candidateService.create(dto)));
        }catch (Exception exception){
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @PostMapping("update/{candidateId}")
    public ResponseEntity<ApiResponse> update(@RequestBody@Validated CreateCandidateDTO dto, @PathVariable("candidateId") UUID candidateId) {
        try{
            return ResponseEntity.ok(new ApiResponse(true,"The candidate was updated successfully", this.candidateService.update(dto,candidateId)));
        }catch (Exception exception){
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @DeleteMapping("/{candidateId}")
    public ResponseEntity<ApiResponse> delete(@PathVariable("candidateId") UUID candidateId) {
        try{
            this.candidateService.delete(candidateId);
            return ResponseEntity.ok(new ApiResponse(true,"The candidate as deleted successfully"));

        }catch (Exception exception){
            return ExceptionsUtils.handleControllerExceptions(exception);
        }

    }

    @GetMapping("all")
    public ResponseEntity<ApiResponse> getAll() {
        try{
            return ResponseEntity.ok(new ApiResponse(true,"All candidates were retrieved successfully", this.candidateService.getAll()));
        }catch (Exception exception){
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }
    @GetMapping("all/paginated")
    public ResponseEntity<ApiResponse> getAllPaginated(Pageable pageable) {
        try{
            return ResponseEntity.ok(new ApiResponse(true,"Paginated candidates were retrieved successfully", this.candidateService.getAllPaginated(pageable)));
        }catch (Exception exception){
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping("/{positionId}")
    public ResponseEntity<ApiResponse> getAllByPosition(Pageable pageable, @PathVariable("positionId") UUID positionId) {
        try{
            return ResponseEntity.ok(new ApiResponse(true,"Candidates were retrieved successfully", candidateService.getAllByPosition(pageable,positionId)));
        }catch (Exception exception){
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }
}

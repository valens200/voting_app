package com.templates.valens.v1.controllers;

import com.templates.valens.v1.dtos.requests.CreateVotingSessionDTO;
import com.templates.valens.v1.payload.ApiResponse;
import com.templates.valens.v1.services.IVotingSessionService;
import com.templates.valens.v1.utils.ExceptionsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/voting-sessions")
@RequiredArgsConstructor
public class VotingSessionController {

    private final IVotingSessionService votingSessionService;

    @PostMapping
    public ResponseEntity<ApiResponse> create(@RequestBody CreateVotingSessionDTO sessionDTO) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "The voting session was created successfully", votingSessionService.create(sessionDTO)));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @PutMapping("/{sessionId}")
    public ResponseEntity<ApiResponse> update(@RequestBody CreateVotingSessionDTO sessionDTO, @PathVariable UUID sessionId) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "The voting session was updated successfully", votingSessionService.update(sessionDTO, sessionId)));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping("/{sessionId}")
    public ResponseEntity<ApiResponse> getById(@PathVariable UUID sessionId) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Voting session retrieved successfully", votingSessionService.getById(sessionId)));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @DeleteMapping("/{sessionId}")
    public ResponseEntity<ApiResponse> delete(@PathVariable UUID sessionId) {
        try {
            votingSessionService.delete(sessionId);
            return ResponseEntity.ok(new ApiResponse(true, "The voting session was deleted successfully"));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAll() {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "All voting sessions were retrieved successfully", votingSessionService.getAll()));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping("/paginated")
    public ResponseEntity<ApiResponse> getAllPaginated(Pageable pageable) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Voting sessions retrieved successfully", votingSessionService.getAllPaginated(pageable)));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }
}

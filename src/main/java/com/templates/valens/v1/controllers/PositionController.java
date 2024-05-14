package com.templates.valens.v1.controllers;
import com.templates.valens.v1.dtos.requests.CreatePositionDTO;
import com.templates.valens.v1.payload.ApiResponse;
import com.templates.valens.v1.services.IPositionService;
import com.templates.valens.v1.utils.ExceptionsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/positions")
public class PositionController {

    @Autowired
    private IPositionService positionService;

    @PostMapping
    public ResponseEntity<ApiResponse> create(@RequestBody CreatePositionDTO dto) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "The position was created successfully", positionService.create(dto)));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @PutMapping("/{positionId}")
    public ResponseEntity<ApiResponse> update(@RequestBody CreatePositionDTO dto, @PathVariable UUID positionId) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "The position was updated successfully", positionService.update(dto, positionId)));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @DeleteMapping("/{positionId}")
    public ResponseEntity<ApiResponse> delete(@PathVariable UUID positionId) {
        try {
            positionService.delete(positionId);
            return ResponseEntity.ok(new ApiResponse(true, "The position was deleted successfully"));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping("/{positionId}")
    public ResponseEntity<ApiResponse> getById(@PathVariable UUID positionId) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Position retrieved successfully", positionService.getById(positionId)));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAll() {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "All positions were retrieved successfully", positionService.getAll()));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping("/paginated")
    public ResponseEntity<ApiResponse> getAllPaginated(Pageable pageable) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Positions retrieved successfully", positionService.getAllPaginated(pageable)));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @PutMapping("/assign-candidate/{positionId}/{candidateId}")
    public ResponseEntity<ApiResponse> assignCandidate(@PathVariable UUID positionId, @PathVariable UUID candidateId) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Candidate assigned to position successfully", positionService.assignCandidate(candidateId, positionId)));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @PutMapping("/remove-candidate/{positionId}/{candidateId}")
    public ResponseEntity<ApiResponse> removeCandidate(@PathVariable UUID positionId, @PathVariable UUID candidateId) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Candidate removed from position successfully", positionService.removeCandidate(candidateId, positionId)));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @PutMapping("/assign-session/{positionId}/{sessionId}")
    public ResponseEntity<ApiResponse> assignVotingSession(@PathVariable UUID positionId, @PathVariable UUID sessionId) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Voting session assigned to position successfully", positionService.assignVotingSession(sessionId, positionId)));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @PutMapping("/remove-session/{positionId}/{sessionId}")
    public ResponseEntity<ApiResponse> removeVotingSession(@PathVariable UUID positionId, @PathVariable UUID sessionId) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Voting session removed from position successfully", positionService.removeVotingSession(sessionId, positionId)));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping("/session/{sessionId}")
    public ResponseEntity<ApiResponse> getAllBySession(@PathVariable UUID sessionId, Pageable pageable) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Positions retrieved successfully", positionService.getAllBySession(sessionId, pageable)));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping("/session-all/{sessionId}")
    public ResponseEntity<ApiResponse> getAllBySession(@PathVariable UUID sessionId) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Positions retrieved successfully", positionService.getAllBySession(sessionId)));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }
}

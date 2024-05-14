package com.templates.valens.v1.controllers;

import com.templates.valens.v1.dtos.requests.CreateVoteDTO;
import com.templates.valens.v1.payload.ApiResponse;
import com.templates.valens.v1.services.IVoteService;
import com.templates.valens.v1.utils.ExceptionsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/votes")
@RequiredArgsConstructor
public class VoteController {
    private final IVoteService voteService;
    @PostMapping
    public ResponseEntity<ApiResponse> create(@RequestBody CreateVoteDTO dto) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "The vote was created successfully", voteService.create(dto)));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @PostMapping("/bulk")
    public ResponseEntity<ApiResponse> voteMany(@RequestBody List<CreateVoteDTO> voteDTOS) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Votes were created successfully", voteService.voteMany(voteDTOS)));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @PutMapping("/{voteId}")
    public ResponseEntity<ApiResponse> update(@RequestBody CreateVoteDTO dto, @PathVariable UUID voteId) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "The vote was updated successfully", voteService.update(dto, voteId)));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable UUID id) {
        try {
            voteService.delete(id);
            return ResponseEntity.ok(new ApiResponse(true, "The vote was deleted successfully"));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAll() {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "All votes were retrieved successfully", voteService.getAll()));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping("/{voteId}")
    public ResponseEntity<ApiResponse> getById(@PathVariable UUID voteId) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Vote retrieved successfully", voteService.getById(voteId)));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping("/paginated")
    public ResponseEntity<ApiResponse> getAllPaginated(Pageable pageable) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Votes retrieved successfully", voteService.getAllPaginated(pageable)));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping("/results/{sessionId}")
    public ResponseEntity<ApiResponse> getResults(@PathVariable UUID sessionId) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Results retrieved successfully", voteService.getResults(sessionId)));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping("/count/{candidateId}/{votingSessionId}")
    public ResponseEntity<ApiResponse> countVotesByCandidate(@PathVariable UUID candidateId, @PathVariable UUID votingSessionId) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Vote count retrieved successfully", voteService.countVotesByCandidate(candidateId, votingSessionId)));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping("/position/{positionId}")
    public ResponseEntity<ApiResponse> getAllByPosition(@PathVariable UUID positionId, Pageable pageable) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Votes retrieved successfully", voteService.getAllBYPosition(positionId, pageable)));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping("/position/{positionId}/candidate/{candidateId}")
    public ResponseEntity<ApiResponse> getAllPositionAndCandidate(@PathVariable UUID positionId, @PathVariable UUID candidateId, Pageable pageable) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Votes retrieved successfully", voteService.getAllPositionAndCandidate(positionId, candidateId, pageable)));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping("/candidate/{candidateId}")
    public ResponseEntity<ApiResponse> getAllByCandidate(@PathVariable UUID candidateId, Pageable pageable) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Votes retrieved successfully", voteService.getAllByCandidate(candidateId, pageable)));
        } catch (Exception exception) {
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }
}

package com.framedrop.upload_api.adapters.in.controller;

import com.framedrop.upload_api.adapters.in.controller.dto.UserDTO;
import com.framedrop.upload_api.core.domain.ports.in.TokenInputPort;
import com.framedrop.upload_api.core.domain.ports.in.UploadVideoInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/uploads")
@RequiredArgsConstructor
public class UploadController {

    private final UploadVideoInputPort uploadVideoInputPort;
    private final TokenInputPort tokenInputPort;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadVideo(@RequestHeader("Authorization") String bearerToken, @RequestParam("videoFile") MultipartFile videoFile) {

        if (videoFile == null || videoFile.isEmpty()) {
            return org.springframework.http.ResponseEntity.badRequest().body("No file provided");
        }

        UserDTO userId = tokenInputPort.getUserFromToken(bearerToken);
        uploadVideoInputPort.uploadVideo(videoFile,userId);

        return ResponseEntity.ok("Video was sent to processing");

    }
}

package com.framedrop.upload_api.adapters.config;

import com.framedrop.upload_api.adapters.out.dynamodb.VideoDynamoAdapter;
import com.framedrop.upload_api.core.application.usecases.UploadVideoUseCase;
import com.framedrop.upload_api.core.application.usecases.VideoUseCase;
import com.framedrop.upload_api.core.domain.ports.in.UploadVideoInputPort;
import com.framedrop.upload_api.core.domain.ports.out.UploadVideoOutputPort;
import com.framedrop.upload_api.core.domain.ports.out.ValidateVideoOutputPort;
import com.framedrop.upload_api.core.domain.ports.out.VideoOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class VideoConfig {

    @Bean
    public VideoUseCase createVideoUseCase(VideoOutputPort videoOutputPort) {
        return new VideoUseCase(videoOutputPort);
    }

}

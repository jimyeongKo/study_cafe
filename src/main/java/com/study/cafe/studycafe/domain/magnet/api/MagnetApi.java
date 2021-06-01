package com.study.cafe.studycafe.domain.magnet.api;

import com.study.cafe.studycafe.domain.magnet.application.MagnetService;
import com.study.cafe.studycafe.domain.magnet.dto.MagnetRequest;
import com.study.cafe.studycafe.domain.magnet.dto.MagnetResponse;
import com.study.cafe.studycafe.domain.magnet.model.MagnetType;
import com.study.cafe.studycafe.global.common.Response.ApiListResponse;
import com.study.cafe.studycafe.global.common.Response.ApiPagingResponse;
import com.study.cafe.studycafe.global.common.Response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("magnet")
public class MagnetApi {

    private final MagnetService service;

    @PostMapping
    public ApiResponse<MagnetResponse> create(@RequestBody MagnetRequest request) {
        return new ApiResponse<>(HttpStatus.CREATED, service.create(request));
    }

    @GetMapping()
    public ApiListResponse<MagnetResponse> findAll(@RequestParam(required = false) MagnetType title) {
        return new ApiListResponse<>(HttpStatus.OK, service.findAll(title));
    }


}

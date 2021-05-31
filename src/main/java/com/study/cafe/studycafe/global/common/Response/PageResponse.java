package com.study.cafe.studycafe.global.common.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse<T> {

    private int page;

    private int totalPage;

    private Long totalCount;

    private List<T> data;
}

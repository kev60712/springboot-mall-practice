package com.kevinliu.springboogmallpractice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderQueryParams {

    private Integer userId;
    private Integer limit;
    private Integer offset;

}

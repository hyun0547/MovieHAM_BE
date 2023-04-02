package com.movieHam.movie.service.com;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchVO {
    Object groupKeyword;
    String orderType;
    Integer pageIndex;
    Integer countPerPage;
    Long userId;
    String ClassifiedYn;
}

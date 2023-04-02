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
    String classifiedYn;

    public boolean isClassified(){
        if("Y".equals(classifiedYn)){
            return true;
        }else{
            return false;
        }
    }

}

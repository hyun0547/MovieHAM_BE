package com.movieHam.movie.service.movie;

import com.movieHam.movie.service.com.SearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import util.StringHandler;
import util.com.CommonUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public Movie findMovieById(Integer movieId){
        return movieRepository.findById(movieId).get();
    }

    public List<Movie> searchList(String group, String order, SearchVO searchVO) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String groupFirstUpper = StringHandler.firstLetterUpperCase(group);

        Class repositoryBean = movieRepository.getClass();
        Method m;

        String methodName = "";
        Sort sort = Sort.by(order);

        PageRequest pageRequest =
                PageRequest.of(
                        CommonUtil.checkNullEmpty(searchVO.getPageIndex(), 0),
                        CommonUtil.checkNullEmpty(searchVO.getCountPerPage(), 100),
                        "asc".equals(searchVO.getOrderType())?sort.ascending():sort.descending()
                );
        List<Movie> resultList=null;

        if("All".equals(groupFirstUpper)){
            methodName = "findAll";
            m = repositoryBean.getMethod(methodName, Pageable.class);
            Page<Movie> tmpList = (Page<Movie>) m.invoke(movieRepository, pageRequest);
            resultList = tmpList.getContent();
        }else{
            methodName = "findBy" + groupFirstUpper + "Contains";
            m = repositoryBean.getMethod(methodName, searchVO.getGroupKeyword().getClass(), Pageable.class);
            resultList = (List<Movie>) m.invoke(movieRepository, searchVO.getGroupKeyword(), pageRequest);
        }

        return resultList;
    }

    public List<Movie> searchNotClassifiedList(String group, String order, SearchVO searchVO) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        {
            String groupFirstUpper = StringHandler.firstLetterUpperCase(group);

            Class repositoryBean = movieRepository.getClass();
            Method m;

            String methodName = "";
            Sort sort = Sort.by(order);

            PageRequest pageRequest = PageRequest.of(CommonUtil.checkNullEmpty(searchVO.getPageIndex(), 0), CommonUtil.checkNullEmpty(searchVO.getCountPerPage(), 100), "asc".equals(searchVO.getOrderType()) ? sort.ascending() : sort.descending());
            List<Movie> resultList = null;

            if ("All".equals(groupFirstUpper)) {
                methodName = "findAllNotClassified";
                m = repositoryBean.getMethod(methodName, Pageable.class, Long.class);
                resultList = (List<Movie>) m.invoke(movieRepository, pageRequest, searchVO.getUserId());
            } else {
                methodName = "findBy" + groupFirstUpper + "ContainsNotClassified";
                m = repositoryBean.getMethod(methodName, searchVO.getGroupKeyword().getClass(), Pageable.class, Long.class);
                resultList = (List<Movie>) m.invoke(movieRepository, searchVO.getGroupKeyword(), pageRequest, searchVO.getUserId());
            }

            return resultList;
        }
    }

    public void saveAll(List<Movie> movieBeanList) {
        movieRepository.saveAll(movieBeanList);
        movieRepository.flush();
    }


    public List<Movie> searchClassifiedList(String group, String order, SearchVO searchVO) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String groupFirstUpper = StringHandler.firstLetterUpperCase(group);

        Class repositoryBean = movieRepository.getClass();
        Method m;

        String methodName = "";
        Sort sort = Sort.by(order);

        PageRequest pageRequest = PageRequest.of(CommonUtil.checkNullEmpty(searchVO.getPageIndex(), 0), CommonUtil.checkNullEmpty(searchVO.getCountPerPage(), 100), "asc".equals(searchVO.getOrderType()) ? sort.ascending() : sort.descending());
        List<Movie> resultList = null;

        if ("All".equals(groupFirstUpper)) {
            methodName = "findAllClassified";
            m = repositoryBean.getMethod(methodName, Pageable.class, Long.class);
            resultList = (List<Movie>) m.invoke(movieRepository, pageRequest, searchVO.getUserId());
        } else {
            methodName = "findBy" + groupFirstUpper + "ContainsClassified";
            m = repositoryBean.getMethod(methodName, searchVO.getGroupKeyword().getClass(), Pageable.class, Long.class);
            resultList = (List<Movie>) m.invoke(movieRepository, searchVO.getGroupKeyword(), pageRequest, searchVO.getUserId());
        }

        return resultList;
    }
}

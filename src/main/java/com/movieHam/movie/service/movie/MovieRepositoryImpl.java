package com.movieHam.movie.service.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RequiredArgsConstructor
public class MovieRepositoryImpl implements MovieRepository {

    @Autowired
    MovieRepository movieRepository;

    private final EntityManager entityManager;

    @Override
    public List<MovieVO> findAll(Sort sort) {
        return movieRepository.findAll(sort);
    }

    @Override
    public Page<MovieVO> findAll(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    @Override
    public List<MovieVO> findAllById(Iterable<String> strings) {
        return movieRepository.findAllById(strings);
    }

    @Override
    public long count() {
        return movieRepository.count();
    }

    @Override
    public void deleteById(String s) {
        movieRepository.deleteById(s);
    }

    @Override
    public void delete(MovieVO entity) {
        movieRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {
        movieRepository.deleteAllById(strings);
    }

    @Override
    public void deleteAll(Iterable<? extends MovieVO> entities) {
        movieRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        movieRepository.deleteAll();
    }

    @Override
    public <S extends MovieVO> S save(S entity) {
        return movieRepository.save(entity);
    }

    @Override
    public List<MovieVO> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public <S extends MovieVO> List<S> saveAll(Iterable<S> movieList) {
        return movieRepository.saveAll(movieList);
    }

    @Override
    public MovieVO getById(String Id) {
        return movieRepository.getById(Id);
    }

    @Override
    public Optional<MovieVO> findById(String s) {
        return movieRepository.findById(s);
    }

    @Override
    public boolean existsById(String s) {
        return movieRepository.existsById(s);
    }

    @Override
    public void flush() {
        movieRepository.flush();
    }

    @Override
    public <S extends MovieVO> S saveAndFlush(S entity) {
        return movieRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends MovieVO> List<S> saveAllAndFlush(Iterable<S> entities) {
        return movieRepository.saveAllAndFlush(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<MovieVO> entities) {
        movieRepository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> strings) {
        movieRepository.deleteAllByIdInBatch(strings);
    }

    @Override
    public void deleteAllInBatch() {
        movieRepository.deleteAllInBatch();
    }

    @Override
    public MovieVO getOne(String s) {
        return movieRepository.getOne(s);
    }


    @Override
    public List<MovieVO> findByNationContains(String nation) {
        return movieRepository.findByNationContains(nation);
    }

    @Override
    public List<MovieVO> findByTitleContains(String title) {
        return movieRepository.findByTitleContains(title);
    }

    @Override
    public List<MovieVO> findByRatingContains(String queryParam) {
        return movieRepository.findByRatingContains(queryParam);
    }

    @Override
    public List<MovieVO> findByGenreContains(String queryParam) {
        return movieRepository.findByGenreContains(queryParam);
    }

    @Override
    public List<MovieVO> findByTypeContains(String queryParam) {
        return movieRepository.findByTypeContains(queryParam);
    }

    @Override
    public List<MovieVO> findByActorIdContains(String queryParam) {

        String jpql = "select * from tn_movie";
        String whereSql = " where ";

////        String[] actorIdList = CommonUtil.checkNullEmpty(queryParam, "").split("\\|");
////        List<String> whereCondition = new ArrayList<>();
////        for(String actorId : actorIdList){
////            whereCondition.add("actorId INSTR("+ actorId +") > 0");
////        }
//        if (!whereCondition.isEmpty()) {
//            jpql += whereSql;
//            jpql += String.join(" or ", whereCondition);
//        }
//
//        jpql += whereSql;
//        jpql += String.join(" and ", whereCondition);
//
//        TypedQuery<MovieVO> query = entityManager.createQuery(jpql, MovieVO.class);
//        List<MovieVO> movieList = query.getResultList();

        return null;
    }

    @Override
    public List<MovieVO> findByDirectorIdContains(String queryParam) {
        return movieRepository.findByDirectorIdContains(queryParam);
    }

    @Override
    public List<MovieVO> findByRepRlsDateContains(String queryParam) {
        return movieRepository.findByRepRlsDateContains(queryParam);
    }

    @Override
    public List<MovieVO> findByKeywordsContains(String queryParam) {
        return movieRepository.findByKeywordsContains(queryParam);
    }

    @Override
    public List<MovieVO> findByMovieSeqContains(String movieSeq) {
        return movieRepository.findByMovieSeqContains(movieSeq);
    }

    @Override
    public List<MovieVO> findByDocidContains(String docid) {
        return movieRepository.findByDocidContains(docid);
    }

    @Override
    public MovieVO getReferenceById(String s) {
        return movieRepository.getReferenceById(s);
    }

    @Override
    public <S extends MovieVO> Optional<S> findOne(Example<S> example) {
        return movieRepository.findOne(example);
    }

    @Override
    public <S extends MovieVO> List<S> findAll(Example<S> example) {
        return movieRepository.findAll(example);
    }

    @Override
    public <S extends MovieVO> List<S> findAll(Example<S> example, Sort sort) {
        return movieRepository.findAll(example, sort);
    }

    @Override
    public <S extends MovieVO> Page<S> findAll(Example<S> example, Pageable pageable) {
        return movieRepository.findAll(example, pageable);
    }

    @Override
    public <S extends MovieVO> long count(Example<S> example) {
        return movieRepository.count(example);
    }

    @Override
    public <S extends MovieVO> boolean exists(Example<S> example) {
        return movieRepository.exists(example);
    }

    @Override
    public <S extends MovieVO, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return movieRepository.findBy(example, queryFunction);
    }

}

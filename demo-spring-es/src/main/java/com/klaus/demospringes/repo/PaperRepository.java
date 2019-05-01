package com.klaus.demospringes.repo;

import com.klaus.demospringes.doc.Paper;
import com.klaus.demospringes.doc.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringes UserRepository
 * @description:
 * @date 2019/3/22 15:31
 */
public interface PaperRepository extends ElasticsearchRepository<Paper, String> {


    /**
     * find paper by author
     * @param author\
     * @param pageable
     * @return
     */
    public Page<Paper> findPaperByAuthor(String author, Pageable pageable);

}

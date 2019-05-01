package com.klaus.demospringes.repo;

import com.klaus.demospringes.doc.Paper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringes.repo PaperRepositoryTest
 * @description:
 * @date 2019/4/22 23:25
 */



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class PaperRepositoryTest {

    @Autowired
    private PaperRepository paperRepository;

    @Test
    public void testSavePaper() {

        Paper paper = new Paper();

        paper.setAuthor("klaus");
        List<String> tags = Arrays.asList("male","30-40","college","IT");
        paper.setTags(tags);
        paper.setCreateDate( new Date());
        paper.setTitle("random thinking");
        paper.setContent("today is not really good day, maybe we could find a fun way to get done with it");
        paper.setEmail("love20141002@126.com");
        paperRepository.save(paper);

        Page<Paper> optional = paperRepository.findPaperByAuthor("klaus", PageRequest.of(0,10));
        optional.getContent().forEach(i -> log.info("paper is {}",i));
    }
}
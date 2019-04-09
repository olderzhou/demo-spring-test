package com.klaus.demospringes;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileNotFoundException;

import static org.springframework.util.ResourceUtils.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DemoSpringEsApplicationTests {

    @Test
    public void contextLoads() {
    }




    @Test
    public void testResource() {
        try {
            //File file = getFile("resources/jaas.conf");
            File file = getFile("classpath:jaas.conf");


            log.info("file.getName() is :{}", file.getName());
            log.info("file.getAbsolutePath() is :{}", file.getAbsolutePath());
            log.info("file.getPath() is :{}", file.getPath());



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

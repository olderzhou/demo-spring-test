package com.klaus.demographdcarango.repo;

import com.klaus.demographdcarango.DemoGraphDcArangoApplication;
import com.klaus.demographdcarango.model.Activity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demographdcarango.repo ActivityRepositoryTest
 * @description:
 * @date 2019/5/21 23:32
 */


@SpringBootTest(classes = DemoGraphDcArangoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Slf4j
public class ActivityRepositoryTest {

    @Autowired
    private ActivityRepository activityRepository;


    @Test
    public void testFindActivitiesByType() {


        Activity activity  = new Activity();

        activity.setCreateDt(new Date());
        activity.setDescription("it's for test activity");
        activity.setEndDt(new Date());
        activity.setType("team");
        List<String> tips = new ArrayList<>();
        tips.add("please take you mate");
        tips.add("please take a apple");
        activity.setTips(tips);
        activity = activityRepository.save(activity);
        log.info("new data is :{}", activity);

    }

}
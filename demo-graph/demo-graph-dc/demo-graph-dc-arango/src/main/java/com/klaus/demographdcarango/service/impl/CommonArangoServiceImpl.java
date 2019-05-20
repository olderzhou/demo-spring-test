package com.klaus.demographdcarango.service.impl;

import com.arangodb.entity.DocumentEntity;
import com.arangodb.model.CollectionCreateOptions;
import com.arangodb.model.DocumentCreateOptions;
import com.arangodb.springframework.core.ArangoOperations;
import com.klaus.demographdcarango.model.User;
import com.klaus.demographdcarango.service.CommonArangoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demographdcarango.service.impl CommonArangoServiceImpl
 * @description:
 * @date 2019/5/2 04:09
 */
@Service
@Slf4j
public class CommonArangoServiceImpl implements CommonArangoService {

    @Autowired
    private ArangoOperations arangoOperations;

    @Override
    public boolean saveData(Map<String, Object> map) {


//        arangoOperations.insert();



        log.info("---1----------------------------data is :{}", "started");
        Iterable<User> docs = arangoOperations.find(Arrays.asList("42496498", "some-other-id"), User.class);
        log.info("---1----------------------------data is :{}", docs);







//        ArangoCursor<User> docs1 = arangoOperations.query("FOR doc IN user\n" +
//                "  FILTER doc.`_id` == 'user/42496498'\n" +
//                "  RETURN doc",User.class);
//
//        docs1.forEach(i -> log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~result is :{}", i));
//
//        Map<String, Object> bindVars = new HashMap<>(2);
//        bindVars.put("@collection","user");
//        bindVars.put("value","user/42496498");
//        ArangoCursor<User> docs2 = arangoOperations.query("FOR doc IN @@collection\n" +
//                "  FILTER doc.`_id` == @value\n" +
//                "  RETURN doc", bindVars, User.class);
//
//        docs2.forEach(i -> log.info("~~~~~~~~~~~docs2~~~~~~~~~~~~~~~result is :{}", i));

        DocumentCreateOptions options = new DocumentCreateOptions();
        options.overwrite(true);
        options.waitForSync(true);
        User user = new User();
        user.setName("vivian");
        user.setMobile("18664878888");
        user.setGender((short)2);
        user.setAge(24);


        Map<String,Object> userObject = new HashMap<>();
        userObject.put("name","vivian");
        userObject.put("mibile","18664878888");
        userObject.put("gender",1);
        userObject.put("age",24);

//        Gson gson = new Gson();
//        JSONPObject jsonpObject = new JSONPObject(user);

//        jsonpObject.
        DocumentEntity du = arangoOperations.insert("user", userObject, options);
        log.info("#################result is {}", du);
        return false;
    }

    @Override
    public boolean createDataBases(String database) {






        return false;
    }

    @Override
    public boolean createCollection(String database, Map<String, String> options) {

        log.info("create collection from options :{}, database :{}", options, database);
        CollectionCreateOptions createOptions = new CollectionCreateOptions();
//        collectionOperations.
//        userOperations.




        return false;
    }
}

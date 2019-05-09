package com.klaus.demographdcarango.service;

import com.arangodb.ArangoCollection;
import com.arangodb.entity.DocumentUpdateEntity;
import com.arangodb.entity.MultiDocumentEntity;
import com.arangodb.model.DocumentUpdateOptions;
import com.arangodb.springframework.core.ArangoOperations;
import com.arangodb.velocypack.VPackBuilder;
import com.arangodb.velocypack.VPackSlice;
import com.arangodb.velocypack.ValueType;
import com.arangodb.velocypack.exception.VPackException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.Map.Entry;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demographdcarango.service CommonArangoServiceTest
 * @description:
 * @date 2019/5/5 22:59
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Slf4j
public class CommonArangoServiceTest {



    @Autowired
    private CommonArangoService arangoService;

    @Autowired
    private ArangoOperations operations;

    @Test
    public void testSaveData() {

//        CollectionOperations collectionOperations = operations.collection("user");
//        log.info("--------------------------collection info is:{}", collectionOperations);
//        log.info("collection size is:{}", collectionOperations.count());
//        log.info("collection name is:{}", collectionOperations.name());
        //arangoService.saveData(null);

//        collectionOperations.truncate();


//        operations.insert();
        ArangoCollection arangoCollection = operations.driver().db("graph_klaus").collection("user");


        Collection<Map<String, Object>> values = new LinkedList<Map<String,Object>>();
        Map<String,Object> userObject = new HashMap<>();
//        userObject.put("name","vivian2");
//        userObject.put("mibile","18664878888");
        userObject.put("gender",1);
        userObject.put("age",29);
        userObject.put("_key", "65765654");
        ((LinkedList<Map<String, Object>>) values).add(userObject);

//        DocumentCreateOptions options = new DocumentCreateOptions();
//        options.waitForSync(true);
//        options.overwrite(true);
//        options.returnNew(true);
//        MultiDocumentEntity<DocumentCreateEntity<Map<String, Object>>> result =  arangoCollection.insertDocuments(values, options);
//        result.getDocuments().forEach( i -> log.info("-----------return document is :{}", i.getNew()));

        DocumentUpdateOptions updateOptions = new DocumentUpdateOptions();
        updateOptions.waitForSync(true);
        updateOptions.mergeObjects(true);
        updateOptions.returnNew(true);
        MultiDocumentEntity<DocumentUpdateEntity<Map<String, Object>>> updateResult =  arangoCollection.updateDocuments(values, updateOptions);
        updateResult.getDocuments().forEach( i -> log.info("-----------return document is :{}", i.getNew()));


//        VPackSlice vPackSlice = new VPackSlice();

    }



    @Test
    public void buildObject() throws VPackException {
        final VPackBuilder builder = new VPackBuilder();
        builder.add(ValueType.OBJECT);// object start
        builder.add("foo", 1); // add field "foo" with value 1
        builder.add("bar", 2); // add field "bar" with value 2
        builder.close();// object end

        final VPackSlice slice = builder.slice(); // create slice
        assertThat(slice.isObject(), is(true));
        assertThat(slice.size(), is(2)); // number of fields

        final VPackSlice foo = slice.get("foo"); // get field "foo"
        assertThat(foo.isInteger(), is(true));
        assertThat(foo.getAsInt(), is(1));

        final VPackSlice bar = slice.get("bar"); // get field "bar"
        assertThat(bar.isInteger(), is(true));
        assertThat(bar.getAsInt(), is(2));

        // iterate over the fields
        for (final Iterator<Entry<String, VPackSlice>> iterator = slice.objectIterator(); iterator.hasNext();) {
            final Entry<String, VPackSlice> field = iterator.next();
            assertThat(field.getValue().isInteger(), is(true));
        }
    }


    @Test
    public void buildArray() throws VPackException {
        final VPackBuilder builder = new VPackBuilder();
        builder.add(ValueType.ARRAY); // array start
        builder.add(1);// add value 1
        builder.add(2);// add value 2
        builder.add(3);// add value 3
        builder.close(); // array end

        final VPackSlice slice = builder.slice();// create slice
        assertThat(slice.isArray(), is(true));
        assertThat(slice.size(), is(3));// number of values

        // iterate over values
        for (int i = 0; i < slice.size(); i++) {
            final VPackSlice value = slice.get(i);
            assertThat(value.isInteger(), is(true));
            assertThat(value.getAsInt(), is(i + 1));
        }

        // iterate over values with Iterator
        for (final Iterator<VPackSlice> iterator = slice.arrayIterator(); iterator.hasNext();) {
            final VPackSlice value = iterator.next();
            assertThat(value.isInteger(), is(true));
        }
    }

    @Test
    public void buildObjectInObject() throws VPackException {
        final VPackBuilder builder = new VPackBuilder();
        builder.add(ValueType.OBJECT);// object start
        builder.add("foo", ValueType.OBJECT); // add object in field "foo"
        builder.add("bar", 2); // add field "bar" with value 2 to object "foo"
        builder.close();// object "foo" end
        builder.close();// object end

        final VPackSlice slice = builder.slice(); // create slice
        assertThat(slice.isObject(), is(true));

        final VPackSlice foo = slice.get("foo");
        assertThat(foo.isObject(), is(true));

        final VPackSlice bar = foo.get("bar"); // get field "bar" from "foo"
        assertThat(bar.isInteger(), is(true));
    }



}
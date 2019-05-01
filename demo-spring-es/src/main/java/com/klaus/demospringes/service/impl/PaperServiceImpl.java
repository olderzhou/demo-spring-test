package com.klaus.demospringes.service.impl;

import com.klaus.demospringes.service.PaperService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.exists.types.TypesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.types.TypesExistsResponse;
import org.elasticsearch.client.AdminClient;
import org.elasticsearch.common.Strings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringes.service.impl PaperServiceImpl
 * @description:
 * @date 2019/4/23 00:39
 */

@Service
@Slf4j
public class PaperServiceImpl implements PaperService {

    private ElasticsearchTemplate elasticsearchTemplate;

    private AdminClient adminClient;


    public PaperServiceImpl(ElasticsearchTemplate elasticsearchTemplate) {
        this.elasticsearchTemplate = elasticsearchTemplate;
        adminClient = elasticsearchTemplate.getClient().admin();

    }



    @Override
    public Map findPaperDifinition(String index, String  type) {
        Map mapping = elasticsearchTemplate.getMapping(index, type);
        log.info("index's mapping is :{}", "demo-spring-es-paper" , mapping);
        return mapping;
    }

    @Override
    public boolean isTypeExists(String index, String type) {
        TypesExistsRequest typesExistsRequest = new TypesExistsRequest(
                Strings.splitStringByCommaToArray(index), Strings.splitStringByCommaToArray(type)
        );
//        AdminClient adminClient = elasticsearchTemplate.getClient().admin();
        ActionFuture<TypesExistsResponse> actionFuture = adminClient.indices().typesExists(typesExistsRequest);
        try {
            Long start  = System.currentTimeMillis();
            TypesExistsResponse typesExistsResponse = actionFuture.get(10, TimeUnit.MINUTES);
            log.info("-----result is :{} -----------time use is :{}----------", typesExistsResponse.isExists(), System.currentTimeMillis() -start);
            return typesExistsResponse.isExists();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String  createIndex(String index, String type) {
//        curl -X PUT "localhost:9200/twitter" -H 'Content-Type: application/json' -d'
//        {
//            "settings" : {
//            "index" : {
//                "number_of_shards" : 3,
//                        "number_of_replicas" : 2
//            }
//        }
//        }
//        '



        try {
            Settings settings = Settings.builder()
                    .put("index.name", "test")
                    .put("index.number_of_shards", 3)
                    .put("index.number_of_replicas", 2)
                    .build();
            CreateIndexRequest indexRequest = new CreateIndexRequest();
            indexRequest.settings(settings);
//            Map<String, Object> message = new HashMap<>();
//            message.put("type", "text");
//            Map<String, Object> properties = new HashMap<>();
//            properties.put("message", message);
//            Map<String, Object> mapping = new HashMap<>();
//            mapping.put("properties", properties);

            XContentBuilder xbMapping = jsonBuilder()
                    .startObject() // start root
                        .startObject("_all")
                            .field("enabled", "false")
                            .field("dynamic", "false")
                        .endObject()
                        .startObject("_timestamp")
                            .field("enabled", true)
                            .field("store", true)
                        .endObject()
                        .startObject("title")
                        .endObject()
                        .startObject("name")
                            .field("type", "string").endObject()
                        .endObject()
                        .startObject("id")
                            .field("type", "string")
                        // INNER MAPPING HERE!!
                        .endObject()
                    .endObject();

            indexRequest.mapping("test", xbMapping);
            ActionFuture<CreateIndexResponse>  actionFuture = this.adminClient.indices().create(indexRequest);
            CreateIndexResponse createIndexResponse = actionFuture.get(10, TimeUnit.MINUTES);


            return createIndexResponse.index();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }
}

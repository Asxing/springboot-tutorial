package com.holddie.springboot.elasticsearch.tutorial.search.services;



import com.holddie.springboot.elasticsearch.tutorial.search.IndexObject;
import com.holddie.springboot.elasticsearch.tutorial.search.SearchConstants;
import com.holddie.springboot.elasticsearch.tutorial.search.services.worker.KeywordIndexerImpl;
import com.holddie.springboot.elasticsearch.tutorial.search.services.worker.ObjectIndexerImpl;
import com.holddie.springboot.elasticsearch.tutorial.search.services.workflow.*;
import com.holddie.springboot.elasticsearch.tutorial.search.utils.SearchClient;
import org.apache.log4j.Logger;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * This is the main class for indexing and searching services
 * @author Carl Samson
 */
@Service
public class RZSearchService {

    private static Logger log = Logger.getLogger(RZSearchService.class);

    @Autowired
    private DeleteObjectWorkflow deleteWorkflow;

    @Autowired
    private IndexWorkflow indexWorkflow;

    @Autowired
    private GetWorkflow getWorkflow;

    @Autowired
    private SearchWorkflow searchWorkflow;

    @Autowired
    private ObjectIndexerImpl index;

    @Autowired
    private KeywordIndexerImpl keyword;

    @Autowired
    private ImportWorkflow importWorkflow;

    @Autowired
    private SearchClient searchClient;


    @PostConstruct
    public void initService() {
        log.debug("Initializing search service");
        try {
            index.init(searchClient);
            keyword.init(searchClient);
        } catch (Exception e) {
            log.error("Cannot initialize SearchService correctly, will be initialized lazily", e);
        }
    }

    public void deleteObject(String index, String type, Long id)
            throws Exception {
        deleteWorkflow.deleteObject(index, type, id);
    }

    public RZGetResponse getObject(String index, String type, String id)
            throws Exception {
        return getWorkflow.getObject(index, type, id);
    }

    public void index(IndexObject jsonObj, String index, String type)
            throws Exception {
        indexWorkflow.index(jsonObj, index, type);
    }

    public RZSearchResponse searchAutoComplete(String index, String type, String keyword,
                                               int size) throws Exception {
        String json = QueryBuilders.termQuery(SearchConstants.KEYWORD, keyword).toString();
        return searchWorkflow.searchAutoComplete(index, json, type, size);
    }

    public RZSearchResponse search(RZSearchRequest request) throws Exception {
        return searchWorkflow.search(request);
    }

    public void importFromMysql(String sql, String index, String type, String river) throws Exception {
        importWorkflow.importFromDB(sql, index, type, river);
    }
}

package com.holddie.springboot.elasticsearch.tutorial.search.services.workflow;


import com.holddie.springboot.elasticsearch.tutorial.common.jsontool.JsonMapper;
import com.holddie.springboot.elasticsearch.tutorial.search.IndexObject;
import com.holddie.springboot.elasticsearch.tutorial.search.services.worker.IndexWorker;
import org.apache.log4j.Logger;

import java.util.List;


public class IndexWorkflow extends Workflow {

    private static Logger log = Logger.getLogger(IndexWorkflow.class);

    private List<IndexWorker> indexWorkflow;

    public List<IndexWorker> getIndexWorkflow() {
        return indexWorkflow;
    }

    public void setIndexWorkflow(List<IndexWorker> indexWorkflow) {
        this.indexWorkflow = indexWorkflow;
    }

    public void index(IndexObject jsonObj, String index, String type) throws Exception {
        Long id = jsonObj.getId();
        if (id == null || id.longValue() <= 0) {
            log.warn("No id exist for object.");
            throw new Exception("Invalid index object.");
        }
        String json = JsonMapper.toJsonString(jsonObj);
        if (indexWorkflow != null) {
            for (IndexWorker iw : indexWorkflow) {
                iw.execute(this.getSearchClient(), json, index, type, id);
            }
        }
    }

}

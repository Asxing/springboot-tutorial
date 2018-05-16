package com.holddie.springboot.freemarker.config;//package com.holddie.springboot.freemarker.config;

import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Component;

@Component
class EsClientConfig {

    private final ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    public EsClientConfig(ElasticsearchTemplate elasticsearchTemplate) {
        this.elasticsearchTemplate = elasticsearchTemplate;
    }

}
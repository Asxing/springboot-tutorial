package com.holddie.springboot.elasticsearch.tutorial.search.services.worker;



import com.holddie.springboot.elasticsearch.tutorial.common.utils.FileUtils;
import com.holddie.springboot.elasticsearch.tutorial.search.services.delegate.SearchDelegate;
import com.holddie.springboot.elasticsearch.tutorial.search.utils.IndexConfiguration;
import com.holddie.springboot.elasticsearch.tutorial.search.utils.SearchClient;
import org.apache.log4j.Logger;
import org.elasticsearch.common.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ObjectIndexerImpl implements IndexWorker {

	private static boolean init = false;

	@Autowired
	private SearchDelegate searchDelegate;

	private List<IndexConfiguration> indexConfigurations;

	public List<IndexConfiguration> getIndexConfigurations() {
		return indexConfigurations;
	}

	public void setIndexConfigurations(
			List<IndexConfiguration> indexConfigurations) {
		this.indexConfigurations = indexConfigurations;
	}

	private static Logger log = Logger.getLogger(ObjectIndexerImpl.class);

	public synchronized void init(SearchClient client) {
		if (init) {
			return;
		}
		init = true;
		if (getIndexConfigurations() != null && getIndexConfigurations().size() > 0) {
			for (IndexConfiguration config : indexConfigurations) {
				String mappingFile = null;
				String settingsFile = null;
				if (!StringUtils.isBlank(config.getMappingFileName())) {
					mappingFile = config.getMappingFileName();
				}
				if (!StringUtils.isBlank(config.getSettingsFileName())) {
					settingsFile = config.getSettingsFileName();
				}
				if (mappingFile != null || settingsFile != null) {
					String metadata = null;
					String settingsdata = null;
					try {
						if (mappingFile != null) {
							metadata = FileUtils.readFileAsString(mappingFile);
						}
						if (settingsFile != null) {
							settingsdata = FileUtils.readFileAsString(settingsFile);
						}
						if (!StringUtils.isBlank(config.getTypeName())) {
                            if(!searchDelegate.indexExist(config.getIndiceName())) {
                                searchDelegate.createIndice(metadata, settingsdata, config.getIndiceName(), config.getTypeName());
                            }
                            if(!searchDelegate.typeExist(config.getIndiceName(), config.getTypeName())) {
                                searchDelegate.createType(metadata, settingsdata, config.getIndiceName(), config.getTypeName());
                            }
						}
					} catch (Exception e) {
						log.error("******************Create index fail*******************", e);
						init = false;
					}
				}
			}
		}
	}

	//insert object into es
	@Override
	public void execute(SearchClient client, String json, String index, String type, Long id)
			throws Exception {
		try {
			if (!init) {
				init(client);
			}
			searchDelegate.index(json, index, type, id.toString());
		} catch (Exception e) {
			log.error("Exception while indexing a product, maybe a timing ussue for no shards available", e);
		}

	}

}

/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.solr.showcase.product;

import java.io.IOException;
import java.util.Map;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Component initializing a hand full of example Products and persisting them through a {@link SolrClient}.
 * 
 * @author Christoph Strobl
 */
@Component
public class DemoDataInitializer {

	@Autowired
	public DemoDataInitializer(SolrClient client) {

		try {
			init(client);
		} catch (IOException | SolrServerException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private void init(SolrClient sc) throws JsonProcessingException, IOException, SolrServerException {

		QueryResponse response = sc.query(SearchableProductDefinition.COLLECTION_NAME,
				new SolrQuery("*:*").setRows(0).setStart(0));

		if (response.getResults() != null && response.getResults().getNumFound() > 0) {
			return;
		}

		ObjectMapper om = new ObjectMapper();
		MappingIterator<Object> jsonMapInterator = om.readerFor(java.util.HashMap.class)
				.readValues(new ClassPathResource("products.json").getFile());

		while (jsonMapInterator.hasNext()) {

			SolrInputDocument document = new SolrInputDocument();
			Map<String, Object> rawData = (Map<String, Object>) jsonMapInterator.next();
			rawData.entrySet().forEach(entry -> {
				document.addField(entry.getKey(), entry.getValue());
			});
			sc.add(SearchableProductDefinition.COLLECTION_NAME, document);
		}
		sc.commit(SearchableProductDefinition.COLLECTION_NAME);
	}
}

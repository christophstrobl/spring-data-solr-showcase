/*
 * Copyright 2012 - 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.solr.showcase.product;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.SolrOperations;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.FacetOptions;
import org.springframework.data.solr.core.query.FacetQuery;
import org.springframework.data.solr.core.query.SimpleFacetQuery;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.showcase.product.model.Product;

/**
 * @author Christoph Strobl
 */
class ProductRepositoryImpl implements ProductRepositoryCustom {

	private SolrOperations operations;

	@Override
	public FacetPage<Product> findByNameStartsWith(Collection<String> nameFragments, Pageable pagebale) {
		Criteria criteria = new Criteria(Product.NAME_FIELD_NAME);
		for (String s : nameFragments) {
			criteria.startsWith(s);
		}

		FacetQuery query = new SimpleFacetQuery(criteria).setFacetOptions(new FacetOptions(Product.NAME_FIELD_NAME));
		query.setPageRequest(pagebale);

		return operations.queryForFacetPage(query, Product.class);
	}

	@Autowired
	public void setOperations(SolrOperations operations) {
		this.operations = operations;
	}

}

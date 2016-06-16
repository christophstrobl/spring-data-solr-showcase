/*
 * Copyright 2012 - 2016 the original author or authors.
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

/**
 * @author Christoph Strobl
 */
public interface SearchableProductDefinition {

	String COLLECTION_NAME = "collection1";

	String ID_FIELD_NAME = "id";
	String NAME_FIELD_NAME = "name";
	String AVAILABLE_FIELD_NAME = "inStock";
	String LOCATION_FIELD_NAME = "store";
	String CATEGORIES_FIELD_NAME = "cat";
	String PRICE_FIELD_NAME = "price";
	String FEATURES_FIELD_NAME = "features";

}

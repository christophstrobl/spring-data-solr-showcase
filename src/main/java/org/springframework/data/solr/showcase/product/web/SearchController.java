/*
 * Copyright 2012 - 2013 the original author or authors.
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
package org.springframework.data.solr.showcase.product.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.showcase.product.ProductService;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Christoph Strobl
 */
@Controller
@Component
@Scope("prototype")
public class SearchController {

	private ProductService productService;

	@RequestMapping("/search")
	public void search(Model model, @RequestParam(value = "q", required = false) String query,
			@PageableDefault(page = 0, size = ProductService.DEFAULT_PAGE_SIZE) Pageable pageable, HttpServletRequest request) {

		model.addAttribute("page", productService.findByName(query, pageable));
		model.addAttribute("pageable", pageable);
		model.addAttribute("query", query);
	}

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

}

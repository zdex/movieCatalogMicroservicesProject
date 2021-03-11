package io.microservice.moviecatalogservice.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.microservice.moviecatalogservice.models.CatalogItem;

@RestController
@RequestMapping("/catalog")
public class MovieCatalog {

	@RequestMapping("/{userId}")
	public List<CatalogItem> getMovieCatalog(@PathVariable("userId") String userId) {
		/*
		 * List<CatalogItem> list = new ArrayList<CatalogItem>();
		 * CatalogItem item = new CatalogItem("gaurav1", "transformer", 5); 
		 * list.add(item); 
		 * return list;
		 */
		return Collections.singletonList(new CatalogItem("gaurav1", "transformer", 5));
		
	}
}

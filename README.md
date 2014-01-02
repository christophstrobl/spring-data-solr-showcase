Spring Data Solr Showcase
=========================

This example shows basic usage concepts of [Spring Data Solr](http://projects.spring.io/spring-data-solr).

The commit order from initial to latest guides you through:

1. STEP 1: Initial setup and configuration.
2. STEP 2: Custom `Repository` implementation for autocomplete.
3. STEP 3: `@Facet` annotation as alternative to custom implementation.
4. STEP 4: Highlighting of search terms in result.
5. STEP 5: Type mapping for custom types.
6. STEP 6: Use multicore support to enable automatic template configuration.

In order to run this example a 4+ [Solr Server](http://lucene.apache.org/solr/downloads.html) and [Maven](http://maven.apache.org/download.cgi) are required.

The application is meant to work with the example data provided by the Solr distribution.

### Running Solr
```emacs
:solr> cd example
:example> java -jar start.jar
:example> cd exampledocs
:exampledocs> java -jar post.jar *.xml
```

Access via [localhost:8983/solr/](http://localhost:8983/solr/#/collection1)

### Running Showcase
```emacs
:spring-data-solr-showcase> mvn spring-boot:run
```

Access via [localhost:8080/search](http://localhost:8080/search)
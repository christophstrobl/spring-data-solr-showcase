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

In order to run this example a 4+ or 5+ [Solr Server](http://lucene.apache.org/solr/downloads.html) and [Maven](http://maven.apache.org/download.cgi) are required.

The application will add 32 documents to the Solr installation on startup as long as the collection in use is empty. Please see the solr distribution documentation for details on manually adding documents.

## Solr 4.x

### Running Solr 4.x (with Schema)

```emacs
:solr> cd example
:example> java -jar start.jar
```

### Running Solr 4.x Schemaless

```emacs
:solr> cd example
:example> java -Dsolr.solr.home=example-schemaless/solr -jar start.jar
```

Access via [localhost:8983/solr/](http://localhost:8983/solr/#/collection1)

### Running Showcase (Solr 4)
```emacs
:spring-data-solr-showcase> mvn spring-boot:run
```

Access via [localhost:8080/search](http://localhost:8080/search)

## Solr 5.x

### Running Solr 5.x Schemaless

```emacs
:solr> bin/solr -e schemaless
```

Access via [localhost:8983/solr/](http://localhost:8983/solr/#/gettingstarted)

### Running Showcase (Solr 5)

Solr 5 uses a different collection name as its default for the example. Please alter `SearchableProductDefinitio.COLLECTION_NAME` to `gettingstarted` prior to running the example.

```emacs
:spring-data-solr-showcase> vi src/main/java/org/springframework/data/solr/showcase/product/SearchableProductDefinition.java
> :%s/collection1/getttingstarted
> :wq

:spring-data-solr-showcase> mvn spring-boot:run
```

Access via [localhost:8080/search](http://localhost:8080/search)
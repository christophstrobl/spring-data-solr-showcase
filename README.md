Spring Data Solr Showcase
=========================

In order to run this example a 4+ Solr Server is required. 
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
:spring-data-solr-showcase> mvn tomcat7:run
```

Access via [localhost:8080/spring-data-solr-showcase](http://localhost:8080/spring-data-solr-showcase/search)
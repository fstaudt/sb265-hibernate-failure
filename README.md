# sb265-hibernate-failure
Spring reproducer for [spring-boot#30421](https://github.com/spring-projects/spring-boot/issues/30421)

IllegalArgumentException thrown by hibernate on second call query method of JpaRepository
```
java.lang.IllegalArgumentException: Parameter value [\] did not match expected type [java.lang.String (n/a)]
  at org.hibernate.query.spi.QueryParameterBindingValidator.validate(QueryParameterBindingValidator.java:54) ~[hibernate-core-5.6.7.Final.jar:5.6.7.Final]
  ...
  at com.sun.proxy.$Proxy110.findAllByNameContaining(Unknown Source) ~[na:na]
  at com.spring.reproducer.sb265.hibernate.failure.resource.UserResource.findAllByPartialName(UserResource.java:27) ~[main/:na]
  ...
```

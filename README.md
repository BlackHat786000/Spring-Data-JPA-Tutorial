"# Spring-Data-JPA-Tutorial" 

Install lombok in your eclipse. Do the following steps

Help->install new software
Type https://projectlombok.org/p2
Add and finish
Rebuild project using maven -> update.

Fix for display of packages in eclipse
Go to 'Project Explorer' window, click on three dots menu, then 'Package Presentation' -> 'Hierarchical'.


Code Contents:
---------------

Connecting Springboot App with DB
Mapping Entities with DB
Different JPA Annotations
Understanding Repositories and their methods
@Embeddable and @Embedded
Creating JPA Repositories & methods
@Query Annotation
Native Queries
Query Named Params
@Transactional and @Modifying Annotation
JPA One-To-One Relationship (one course material has one course)
Cascade Types
Fetch Types
Uni & Bi-directional relationship (fetch course using course material and fetch course material using course)
JPA One-To-Many Relationship (one teacher can teach multiple courses)
JPA Many-To-One Relationship (multiple courses can be taught by one teacher)
Paging and Sorting
JPA Many-To-Many Relationship (multiple students can opt for multiple courses)

Prerequisities:

1. Gradle
2. JKD 19.0.2
3. Node.JS
4. JDBC
5. Intellij IDEA IDE 2022.3.2

Technologies used:

1. Spring Boot 3.2.0
2. Spring Web
3. Swagger UI 2.2.0
4. JPA 3.2.0
5. H2 Database
6. Hibernate
7. Lombok
8. Axios 1.6.2
9. Pinia 2.1.7
10. Vue 3.3.8
11. Vue-Router 4.2.5
12. Booststrap 5.3.2
13. Serve 14.2.1
14. Rollup 4.8.0


KNOWN BUGS AND HOW TO FIX THEM:
1. BUG: Holidays or Reservations not showing up even tho they are created. (Rare)
   SOLUTION: Delete every row from each table (Including locations) and start creating everything again. (Works every time.)
2. BUG: Reservation's customer name and/or phone number doesn't change after editing it (Happens everytime, not sure if it's a bug or it just works this way)
   SOLUTION: Click the "Search" button again after editing the details so the reservation shows up again, this time displaying the updated customer name and phone number. 

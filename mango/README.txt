Install MySql in your local
create two databases ( ex: car_db, mango_db)
insert some data into car table and mango table.
start your spring boot (mvn clean spring-boot:run)

excute curl, to get data from 2 data sources.
curl http://localhost:8090/demo/
{"cars":[{"id":"a","name":"fda","age":"da"},{"id":"b","name":"fdada","age":"da"}],"mangos":[{"id":"123","name":"fdaf","location":"fda"},{"id":"45","name":"fdaf","location":"fda"}]}%

!!DONE -- you are able to get data from two datasources. Configured two data sources. In this example you are using only one sql with 2 different database, as if you are using two databases
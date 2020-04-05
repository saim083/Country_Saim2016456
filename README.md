# Country_Saimcode

1. Singletone Pattern:
	Whenever we have to perform operations related to database we need connection with database. This connection object is very heavy so, 
  creating multiple objects effects performance. Therefore I have used singletone pattern. This pattern ensures creation of only one 
  object Connection. So, whenever we try to make multiple objects it returns same object instead of creating new.
  
2. Data Access Object:
	Data access object separates low level data accessing operation from business layer operations. This business layer doesn't know from
  where data is coming so, in future if database is changed we won't have to change the whole project just dao layer is changed. This
  helps easily to control the data from the database.

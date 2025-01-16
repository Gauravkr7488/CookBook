package com.example.cookbook

1. Main Sequence/Ideas 
    1. Functionality 
        1. To be able to search recipes via inputting ingridents 
        2. To be able to search Recipes
        3. Option to get the Local Crusine priority
    2. Beauty  -> Relese after finishing this
    3. Ease
        1. To be able to give input via voice
        2. To be able to give input via video/image
    4. Extra features
        1. A live help while cooking like a chatbot maybe or alarms 

2. Process
   1. Create the Home page -> Done
      1. A search bar  -> Done
      2. A search button -> Done
   2. Add functionality 
      1. Save the text written in the search field in a string to a file when the search button is pressed.  -> Done
      2. Get the recipe data via the name of the recipe
         1. Convert the xlsx into sqlite -> Done
         2. Add the functionality to get the data 
            1. Set up the database file and ensure it can be queried.
               1. add the database in the app's internal storage. -> Done
            2. Use SQLite or Room Database to access and search for data in the database.
               1. Add room in the project -> Done
               2. make the room to get the data for you -> 
                  1. I am unable to understand how to do it so lets make a mini project with room -> done
                  2. Debug and understand the code -> 
                     1. Dataclass -> done
                     2. Dao -> done
                     3. Database -> done 90%
                     4. DatabaseProvider -> done 50%
                     5. viewModel -> 90%
                     6. factory -> 
            3. Display the query results in your Compose UI. 
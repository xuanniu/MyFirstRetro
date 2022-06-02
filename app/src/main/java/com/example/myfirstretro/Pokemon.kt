package com.example.myfirstretro

data class Pokemon (
    var id : Int,
    var num : String,
    var name : String,
    var img : String,
    var type : List<String>,
    var height : String,
    var weight : String,
    var candy : String,
    var candy_count : Int,
    var egg : String,
    var spawn_chance : Float,
    var avg_spawns : String,
    var spawn_time : String,
    var multipliers : List<Float>,
    var weaknesses : List<String>,
    var next_evolution  : List<Evolution>
    )
data class Evolution (
    var num:String,
    var name:String
    )


//1 Form with all the fields from the entity
//2 when user submits it get all the filled data
//create a json object using the data filled
//3 convert that json to string .tostring
//4 convert the string to responseBody

//Form
//1 Label
//2 Textbox - EditText
//3 Radio Button - Choose one
//4 Check box - Choose multiple
//5 Select - Dropdown, choose one or more
//6 Autocomplete -
//7 Date Picker - month view calender to pick date
//8 File Upload - RAID redundant array of independent disk
// (s3) HADR - high availability and disaster recovery
//9 Map -
package com.example.recyclerlistview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recycler_view_row.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpFoodModels()

    }

    // it will store all the Food items, that will be sent to the rcv
    var foodList: ArrayList<FoodModel> = ArrayList()

    // images
    var images: Array<Int> = arrayOf(
        R.drawable.coffee_pot,
        R.drawable.espresso,
        R.drawable.french_fries,
        R.drawable.honey,
        R.drawable.strawberry_ice_cream,
        R.drawable.sugar_cubes
    )

    // create a model class for each of our items
    fun setUpFoodModels(){
        // get the array from the resources
        var foodName = resources.getStringArray(R.array.foodsName)
        var recipes = resources.getStringArray(R.array.recipe)

//            for( (index,name) in foodName.withIndex()){
//                foodList.add(FoodModel(name, recipes[index]))
//            }
        // create a instance of the foodModel with each item in the array
      
        for(i in foodName.indices){
            foodList.add(FoodModel(foodName[i], recipes[i], images[i]))
        }

      // rcv.layoutManager = LinearLayoutManager(this)
        rcv.layoutManager = GridLayoutManager(this, 2)

        val adaptor = MyAdaptor(this, foodList)
        rcv.adapter = adaptor
//        rcv.layoutManager = GridLayout(this)

        }



}
package com.examen.task

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.examen.task.data.model.Cars
import com.examen.task.databinding.ActivityMainBinding
import com.examen.task.presentation.adapter.CarAdapter


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var carAdapter: CarAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()

    }


        val carList:MutableList<Cars> = mutableListOf(
            Cars(
                id = 1,
                name = "Tesla Model S",
                brand = "Tesla",
                price = 79999,
                image_url = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4a/Tesla_Model_S_Japan_trimmed.jpg/435px-Tesla_Model_S_Japan_trimmed.jpg"
            ),
            Cars(
                id = 2,
                name = "Ford Mustang",
                brand = "Ford",
                price = 55999,
                image_url = "https://s1.cdn.autoevolution.com/images/gallery/TESLA-MOTORS-Model-S-4693_64.jpg"
            ),
            Cars(
                id = 3,
                name = "Toyota Corolla",
                brand = "Toyota",
                price = 24999,
                image_url = "https://media.autoexpress.co.uk/image/private/s--3XzRB3yS--/v1565798347/autoexpress/2019/08/04_7.jpg"
            ),
            Cars(
                id = 4,
                name = "BMW X5",
                brand = "BMW",
                price = 60999,
                image_url = "https://platform.cstatic-images.com/xxlarge/in/v2/stock_photos/c3d8733e-38a0-4083-9ead-b37334a17c0b/a127df43-e904-4827-8390-7890cda6d4b3.png"
            ),
            Cars(
                id = 5,
                name = "Tesla Model X",
                brand = "Tesla",
                price = 89999,
                image_url = "https://img2.thejournal.ie/article/3058597/river?version=3058644&width=1300"
            ),
            Cars(
                id = 6,
                name = "Tesla Model 3",
                brand = "Tesla",
                price = 46999,
                image_url = "https://example.com/images/tesla_model_3.jpg"
            )
        )


    fun initView(){
        linearLayoutManager = LinearLayoutManager(this)
        binding.rvCar.layoutManager = linearLayoutManager
        binding.rvCar.adapter = CarAdapter(carList)

    }

}
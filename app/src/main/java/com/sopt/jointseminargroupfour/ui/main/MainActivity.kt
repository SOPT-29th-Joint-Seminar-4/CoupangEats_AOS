package com.sopt.jointseminargroupfour.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.sopt.jointseminargroupfour.R
import com.sopt.jointseminargroupfour.databinding.ActivityMainBinding
import com.sopt.jointseminargroupfour.ui.main.adapter.EatsRestaurantAdapter
import com.sopt.jointseminargroupfour.ui.main.adapter.FoodTypeAdapter
import com.sopt.jointseminargroupfour.ui.main.adapter.FoodTypeData
import com.sopt.jointseminargroupfour.ui.sub.SubActivity
import com.sopt.jointseminargroupfour.util.BaseView

class MainActivity : BaseView.BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initRestaurantAdapter()
        initFoodListAdapter()
        initRecommendButton()
    }

    private fun initRestaurantAdapter() {
        val eatsRestaurantAdapter = EatsRestaurantAdapter()
        eatsRestaurantAdapter.initItemList(viewModel.getRestaurantData())
        binding.rvEatsRestaurantList.adapter = eatsRestaurantAdapter
    }

    private fun initFoodListAdapter() {
        val foodTypeAdapter = FoodTypeAdapter()
        foodTypeAdapter.initItemList(viewModel.getFoodTypeData())
        binding.rvFoodType.adapter = foodTypeAdapter
    }

    private fun initRecommendButton() {
        binding.btnRecoMenu.setOnClickListener {
            startActivity(Intent(this, SubActivity::class.java))
        }
    }
}
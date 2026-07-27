package com.suresh.task2splashscreen.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.suresh.task2splashscreen.MainActivity
import com.suresh.task2splashscreen.R
import com.suresh.task2splashscreen.adapter.OnBoardingAdapter
import com.suresh.task2splashscreen.databinding.ActivityOnBoardingBinding
import com.suresh.task2splashscreen.model.OnBoardingData
import com.suresh.task2splashscreen.utils.PrefManager

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingBinding
    private lateinit var adapter: OnBoardingAdapter
    private lateinit var prefManager: PrefManager
    private lateinit var list: ArrayList<OnBoardingData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefManager = PrefManager(this)

        list = arrayListOf(

            OnBoardingData(
                R.drawable.onboarding1,
                "Welcome",
                "Your journey starts here."
            ),

            OnBoardingData(
                R.drawable.onboarding2,
                "Explore",
                "Discover amazing features."
            ),

            OnBoardingData(
                R.drawable.onboarding3,
                "Get Started",
                "Let's begin your journey."
            )
        )
        adapter = OnBoardingAdapter(list)
        binding.viewPager.adapter = adapter
        binding.dotsIndicator.attachTo(binding.viewPager)

        // Skip Button
        binding.btnSkip.setOnClickListener {
            prefManager.setFirstTimeLaunch(false)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        // Next Button
        binding.btnNext.setOnClickListener {

            if (binding.viewPager.currentItem < list.size - 1) {

                binding.viewPager.currentItem += 1

            } else {

                prefManager.setFirstTimeLaunch(false)

                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }

        binding.viewPager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    if (position == list.size - 1) {
                        binding.btnNext.text = getString(R.string.get_started)
                        binding.btnSkip.visibility = android.view.View.GONE
                    } else {
                        binding.btnNext.text = getString(R.string.next)
                        binding.btnSkip.visibility = android.view.View.VISIBLE
                    }
                }
            }
        )
    }
}
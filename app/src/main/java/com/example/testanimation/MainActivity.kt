package com.example.testanimation

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.core.view.isVisible
import com.example.testanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var isImageVisible = binding.targetView.isVisible
        binding.ivArrow.setOnClickListener {

            com.example.testanimation.animations.AnimationUtils.animateDropDownIcon(binding.ivArrow,isImageVisible)
            if (isImageVisible) {
                binding.targetView.visibility = View.VISIBLE
                val slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down)

                binding.targetView.startAnimation(slideDown)
            } else {
                val slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up)
                binding.targetView.startAnimation(slideUp)
                binding.targetView.visibility = View.GONE
            }
            isImageVisible = !isImageVisible
        }

    }
}

fun View.toggleVisibility() {
    if (this.isVisible) {
        this.visibility = View.GONE
    } else {
        this.visibility = View.VISIBLE
    }
}

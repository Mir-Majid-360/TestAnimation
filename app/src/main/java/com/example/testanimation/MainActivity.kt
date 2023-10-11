package com.example.testanimation

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import com.example.testanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.title.setOnClickListener {
            showDialog()
        }

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




    fun showDialog(){
        val builder = AlertDialog.Builder(this,R.style.MyCustomTheme)
        builder.setTitle("Androidly Alert")
        builder.setMessage("We have a message")
//builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

        builder.setPositiveButton(R.string.yes) { dialog, which ->
            Toast.makeText(applicationContext,
                R.string.yes, Toast.LENGTH_SHORT).show()
        }

        builder.setNegativeButton(android.R.string.no) { dialog, which ->
            Toast.makeText(applicationContext,
               R.string.no, Toast.LENGTH_SHORT).show()
        }

        builder.setNeutralButton("Maybe") { dialog, which ->
            Toast.makeText(applicationContext,
                "Maybe", Toast.LENGTH_SHORT).show()
        }
        builder.show()
    }

}

fun View.toggleVisibility() {
    if (this.isVisible) {
        this.visibility = View.GONE
    } else {
        this.visibility = View.VISIBLE
    }
}

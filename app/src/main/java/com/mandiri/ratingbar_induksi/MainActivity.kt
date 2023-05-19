package com.mandiri.ratingbar_induksi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import android.widget.Toast
import com.mandiri.ratingbar_induksi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            btnSubmit.isEnabled = false
            var ratingValue = 0.0f

            rbStars.setOnRatingBarChangeListener(){ ratingBar, rating, fromUser ->
                ratingValue = rbStars.rating
                if (ratingValue > 0){
                    btnSubmit.isEnabled = true
                }
            }

            btnSubmit.setOnClickListener(){
                if (switchTips.isChecked){
                    Toast.makeText(this@MainActivity,
                        "Berhasil memberikan " + ratingValue.toInt() + " bintang dengan tips",
                        Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this@MainActivity,
                        "Berhasil memberikan " + ratingValue.toInt() + " bintang",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}
package com.dicoding.myrecyclerview

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailHero : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_hero)

        val dataHero = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Hero>("key_hero", Hero::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Hero>("key_hero")
        }

        val tvDetailName = findViewById<TextView>(R.id.tv_detail_name)
        val tvDetailPower = findViewById<TextView>(R.id.tv_detail_power)
        val tvDetailDescription = findViewById<TextView>(R.id.tv_detail_description)
        val tvDetailDurability = findViewById<TextView>(R.id.tv_detail_durability)
        val tvDetailInfo = findViewById<TextView>(R.id.tv_detail_info)
        val tvDetailPhoto = findViewById<ImageView>(R.id.tv_detail_photo)
        val actionShare = findViewById<Button>(R.id.action_share)

        tvDetailName.text = dataHero?.name
        tvDetailPower.text = dataHero?.power
        tvDetailDescription.text = dataHero?.description
        tvDetailDurability.text = dataHero?.durability
        tvDetailInfo.text = dataHero?.info
        dataHero?.photo?.let { tvDetailPhoto.setImageResource(it) }

        actionShare.setOnClickListener {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Share some text here")
            }
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }
    }


}
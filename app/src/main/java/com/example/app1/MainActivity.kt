package com.example.app1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    var miLista : List<Card> = listOf(
        Card(imageUrl = "https://yt3.googleusercontent.com/Hiv60uIBtN_E21fsj3OHRVvCNR-PGROq4a2wRZviX1zEw_O5Yg4lXbPig6HLiri95boJ5aH15g=s160-c-k-c0x00ffffff-no-rj", title = "BaityBait", description = "Youtuber centrado en la crítica de videojuegos y de la industria, siempre en clave de comedia", buttonUrl = "https://www.youtube.com/channel/UCNnNCBgckxzqIh1Txw5cgSg"),
        Card(imageUrl = "https://yt3.googleusercontent.com/ytc/AIdro_kjVOHrGHHiqdb24aVdK67h5hfOk6V00eEzAYd1QaTddQ=s160-c-k-c0x00ffffff-no-rj", title = "Reseñas Cortas", description = "Youtuber centrado en videojuegos, usando un formato de video corto para hacer críticas paródicas de videojuegos", buttonUrl = "https://www.youtube.com/channel/UCHfalPsz0SOhwzHmPTd_cEw"),
        Card(imageUrl = "https://yt3.googleusercontent.com/ytc/AIdro_n4AfRnBQkjmBQlqKDtqABiNSDUPQNY2_bfhw5MycGoJQ=s160-c-k-c0x00ffffff-no-rj", title = "Eurogamerspain", description = "Canal de noticias, avances y crítica de videojuegos. Incluye secciones de opinión y videos de humor", buttonUrl = "https://www.youtube.com/@eurogamerspain"),
        Card(imageUrl = "https://yt3.googleusercontent.com/iA4RghLRhXDAZl8URUurUGKReNNP48zH_orO5pquD3QfwyaprX5VIMVt61weYjzRpAPEcLA0_A=s160-c-k-c0x00ffffff-no-rj", title = "DayoScript", description = "Youtuber centrado en ensayos sobre videojuegos, su historia, sus características...", buttonUrl = "https://www.youtube.com/@DayoScript")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
       val linearLayout = findViewById<LinearLayout>(R.id.miLista)
        for (card in miLista){
            val cardView = LayoutInflater.from(this).inflate(R.layout.card_layout, linearLayout,false)
            val pictureImageView = cardView.findViewById<ImageView>(R.id.imagen)
            val titleTextView = cardView.findViewById<TextView>(R.id.title)
            val descriptonTextView = cardView.findViewById<TextView>(R.id.description)
            val button = cardView.findViewById<Button>(R.id.button)

            Glide.with(this)
                .load(card.imageUrl)
                .into(pictureImageView)
            titleTextView.text = card.title
            descriptonTextView.text = card.description
            button.setOnClickListener{
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(card.buttonUrl))
                startActivity(intent)
            }
            linearLayout.addView(cardView)
        }
        }
    }

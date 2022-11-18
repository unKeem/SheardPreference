package com.example.sheardpreference

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.sheardpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        const val KEY_FIRST_OPEN = "key_first"
    }

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("kimSP", Context.MODE_PRIVATE)
        binding.tvMessage.text = sharedPreferences.getString(KEY_FIRST_OPEN, "First")

        if(binding.tvMessage.text.equals("First")){
            binding.ivPicture.visibility = View.INVISIBLE
        }else{
            binding.ivPicture.visibility = View.VISIBLE
        }
        Log.d("sheardpreference", "onCreate()")
    }

    override fun onDestroy() {
        super.onDestroy()
        val sharedPreferences = getSharedPreferences("kimSP", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(KEY_FIRST_OPEN,"Second")
        editor.commit()
        Log.d("sheardpreference", "onDestroy() pustring")
    }
}
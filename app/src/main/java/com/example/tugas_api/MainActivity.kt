package com.example.tugas_api

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas_api.databinding.ActivityMainBinding
import com.example.tugas_api.model.Hero
import com.example.tugas_api.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val client = ApiClient.getInstance()
        val response = client.getAllHeroes()
        val userList = ArrayList<String>()

        response.enqueue(object : Callback<Hero> {
            override fun onResponse(call: Call<Hero>, response: Response<Hero>) {
                for (i in response.body()!!.data) {
                    userList.add(i.title)
                }
                val listAdapter = ArrayAdapter(
                    this@MainActivity,
                    R.layout.simple_list_item_1,
                    userList
                )
                //sambungan ke rv
                with(binding){
                    rvHero.apply {
                        adapter = HeroAdapter(response.body()!!.data)
                        layoutManager = LinearLayoutManager(context)
                        val gridLayoutManager = GridLayoutManager(context, 2)
                        layoutManager = gridLayoutManager
                    }
                }
            }
            override fun onFailure(call: Call<Hero>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Koneksi error",
                    Toast.LENGTH_LONG).show()
            }
        })
    }
}
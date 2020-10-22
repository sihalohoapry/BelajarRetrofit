package com.sihaloho.belajarretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<DraftHistoryResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_data.setHasFixedSize(true)
        rv_data.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getDraftHistory().enqueue(object : Callback<ArrayList<DraftHistoryResponse>>{
            override fun onFailure(call: Call<ArrayList<DraftHistoryResponse>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<ArrayList<DraftHistoryResponse>>,
                response: Response<ArrayList<DraftHistoryResponse>>
            ) {
                val responseCode =response.code().toString()
                tv_status.text = responseCode
                response.body()?.let { list.addAll(it) }
                val adapter = DrafHistoryAdapter(list)
                rv_data.adapter = adapter
            }

        })

    }
}
package org.rakulee.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import com.google.gson.Gson
import org.rakulee.retrofitexample.databinding.ActivityMainBinding
import org.rakulee.retrofitexample.network.CoinGeckoExchangeListApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // init retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl(Configs.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(CoinGeckoExchangeListApi::class.java)
        val getExchangeCall : Call<ArrayList<ExchangeResult.ExchangeItem>> = api.getExchangeLists(50, 1)


        getExchangeCall.enqueue(object : Callback<ArrayList<ExchangeResult.ExchangeItem>> {

            override fun onResponse(
                call: Call<ArrayList<ExchangeResult.ExchangeItem>>,
                response: Response<ArrayList<ExchangeResult.ExchangeItem>>
            ) {
                Log.d("Response", "onResponse: ${response.body()?.get(0)?.name}")
                attachRecyclerView(response.body()!!)

            }

            override fun onFailure(
                call: Call<ArrayList<ExchangeResult.ExchangeItem>>,
                t: Throwable
            ) {
                t.printStackTrace()
            }
        })


    }


    fun attachRecyclerView(lists : ArrayList<ExchangeResult.ExchangeItem>){

        val adapter = RvExchangeAdapter()
        adapter.update(lists)
        binding.rvList.adapter = adapter
        binding.rvList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }
}
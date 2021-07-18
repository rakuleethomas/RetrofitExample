package org.rakulee.retrofitexample.network

import org.rakulee.retrofitexample.ExchangeResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinGeckoExchangeListApi {

    @GET("exchanges")
    fun getExchangeLists(@Query("per_page") per_page : Int, @Query("page") page : Int ) : Call<ArrayList<ExchangeResult.ExchangeItem>>



}
package com.github.goutarouh.graphqlpokemonpaging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.apollographql.apollo3.ApolloClient
import com.example.GetPokemonQuery
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create a client
        val apolloClient = ApolloClient.Builder()
            .serverUrl("https://graphql-pokemon2.vercel.app")
            .build()

        // Execute your query. This will suspend until the response is received.
        runBlocking {
            val response = apolloClient.query(GetPokemonQuery()).execute()
            findViewById<TextView>(R.id.text_text).text = response.data?.pokemon?.name
        }
    }
}
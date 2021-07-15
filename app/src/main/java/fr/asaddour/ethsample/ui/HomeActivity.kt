package fr.asaddour.ethsample.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import fr.asaddour.ethsample.R

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val receipt = viewModel.sendFunds().sendAsync().get()
        Log.d("MainActivity", "Transaction complete: " + receipt.transactionHash)
    }


}
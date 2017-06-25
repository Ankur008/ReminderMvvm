package com.example.itstym.logina

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.itstym.logina.`interface`.ClickListener
import com.example.itstym.logina.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding= DataBindingUtil.setContentView<ActivityMainBinding>(this@MainActivity,R.layout.activity_main)

        // Lets Set Value Of XML properties PROGRAMMATICALY

        val viewModel:LoginViewModel = LoginViewModel("Enter Email Address","Enter password","Log-in")

        binding.login=viewModel

        binding.modelClickListener = object : ClickListener {
            override fun onSubmitButtonClick() {

                Toast.makeText(this@MainActivity, binding.login.userEmailAddress, Toast.LENGTH_SHORT).show()
                Toast.makeText(this@MainActivity, binding.login.userPassword, Toast.LENGTH_SHORT).show()

                // On Click It will display all the values
            }
        }

    }
}

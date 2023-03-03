package com.example.firebase

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firebase.databinding.ActivityFinalBinding
import com.google.firebase.auth.FirebaseAuth

class FinalActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var binding:ActivityFinalBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityFinalBinding.inflate(layoutInflater)

        setContentView(binding.root)



        binding.textView3.setOnClickListener {
            var login = Google_Facebook_login()
            login.auth.signOut()
        }

    }
}
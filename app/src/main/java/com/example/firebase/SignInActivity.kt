package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firebase.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {
    //    private lateinit var binding1:ActivitySignUpBinding
    private lateinit var binding: ActivitySignInBinding

    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)

        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.button2.setOnClickListener {
             val userName = binding.editTextTextEmailAddress2.text.toString()
             val password = binding.editTextTextPassword3.text.toString()

               if (userName.isNullOrEmpty().not() && password.isNullOrEmpty().not()){
                   firebaseAuth.signInWithEmailAndPassword(userName,password).addOnCompleteListener {
                       if (it.isSuccessful){
                           val intent = Intent(this@SignInActivity,FinalActivity::class.java)
                           startActivity(intent)
                       }
                       else{
                           Toast.makeText(this, "Wrong Password!", Toast.LENGTH_SHORT).show()
                       }
                   }
               }
            else{
                   Toast.makeText(this, "Please Fill Blank!", Toast.LENGTH_SHORT).show()
               }
        }




    }
}
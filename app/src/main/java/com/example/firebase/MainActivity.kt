package com.example.firebase

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.firebase.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.textView.setOnClickListener {
            val intent =Intent(this,SignInActivity::class.java)
            startActivity(intent)
        }
        binding.button.setOnClickListener {

            val email = binding.editTextTextEmailAddress.text.toString()
            val password = binding.editTextTextPassword.text.toString()
            val confirmPassword = binding.editTextTextPassword2.text.toString()

            if(email.isNullOrEmpty().not() || password.isNullOrEmpty().not() || confirmPassword.isNullOrEmpty().not()){
                if (password==confirmPassword){
                    Toast.makeText(this, "Matched", Toast.LENGTH_SHORT).show()
                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                        if (it.isSuccessful){

                            val intent =Intent(this,SignInActivity::class.java)
                            startActivity(intent)
                            Toast.makeText(this, "$email ,$password,$confirmPassword", Toast.LENGTH_SHORT).show()

                        }
                        else{
                            Log.e("exp", "onCreate: "+it.exception.toString() )
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                        }
                    }

                }
                else{
                    println("Password Matched!")
                    Toast.makeText(this, "Password is Not Matched", Toast.LENGTH_SHORT).show()

                }

                binding.button4.setOnClickListener {
                val resetEmail  = binding.editTextTextEmailAddress3.text.toString()
                    if (resetEmail.isNullOrEmpty().not()){
                        firebaseAuth.sendPasswordResetEmail(resetEmail).addOnCompleteListener {
                            if (it.isSuccessful){
                                Toast.makeText(this, "isSuccessfull", Toast.LENGTH_SHORT).show()
                            }
                            else{
                                Toast.makeText(this, "UnSuccessfull", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    else{
                        Log.e("check123", "null or empty", )
                    }
                }
                Log.e("check123", "null or empty", )

            }
            else{
                Toast.makeText(this, "Please Fill All The Blanks", Toast.LENGTH_SHORT).show()
                Log.e("check123", "null or empty", )

            }


        }




    }
}
package com.example.firebase

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.firebase.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.textView.setOnClickListener {
            val intent =Intent(this,Google_Facebook_login::class.java)
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

                Log.e("check123", "null or empty", )

            }
            else{
                Toast.makeText(this, "Please Fill All The Blanks", Toast.LENGTH_SHORT).show()
                Log.e("check123", "null or empty", )

            }



        }
//        binding.button4.setOnClickListener {
//            try {
//                val info = packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNATURES)
//                for (signature in info.signatures) {
//                    val md = MessageDigest.getInstance("SHA")
//                    md.update(signature.toByteArray())
//                    val hashKey = String(Base64.encode(md.digest(), 0))
//                    Log.d("KeyHash", hashKey)
//                }
//            } catch (e: PackageManager.NameNotFoundException) {
//                Log.e("KeyHash", "Package name not found", e)
//            } catch (e: NoSuchAlgorithmException) {
//                Log.e("KeyHash", "No such algorithm", e)
//            } catch (e: Exception) {
//                Log.e("KeyHash", "Exception", e)
//            }
//            var intent = Intent(this,Google_Facebook_login::class.java)
//            startActivity(intent)
////                val resetEmail  = binding.editTextTextEmailAddress3.text.toString()
////                    if (resetEmail.isNullOrEmpty().not()){
////                        firebaseAuth.sendPasswordResetEmail(resetEmail).addOnCompleteListener {
////                            if (it.isSuccessful){
////                                Toast.makeText(this, "isSuccessfull", Toast.LENGTH_SHORT).show()
////                            }
////                            else{
////                                Toast.makeText(this, "UnSuccessfull", Toast.LENGTH_SHORT).show()
////                            }
////                        }
////                    }
////                    else{
////                        Log.e("check123", "null or empty", )
////                    }
//        }





    }
}
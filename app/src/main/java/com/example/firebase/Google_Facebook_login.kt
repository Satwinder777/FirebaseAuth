package com.example.firebase

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firebase.databinding.ActivityGoogleLoginBinding
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.FacebookSdk
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
//import com.pbs.testnavgraph.MainActivity1


class Google_Facebook_login : AppCompatActivity() {
    private lateinit var binding: ActivityGoogleLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
//    private lateinit var oneTapClient: SignInClient
    private lateinit var signInRequest: BeginSignInRequest
    private lateinit var callbackManager:CallbackManager
    lateinit var auth: FirebaseAuth
    private val REQ_ONE_TAP = 2  // Can be any integer unique to the Activity
    private var showOneTapUI = true

    @SuppressLint("SuspiciousIndentation")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoogleLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)
        auth = Firebase.auth

            callbackManager =CallbackManager.Factory.create()
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.client_id))
            .requestEmail()
            .build()

        val googleSignInClient = GoogleSignIn.getClient(this, gso)




        binding.googleBtn.setOnClickListener {
            auth = Firebase.auth

//            googleSignInClient.signOut()
            startActivityForResult(googleSignInClient.signInIntent  ,13)


        }
        binding.textView7.setOnClickListener {
            auth = Firebase.auth

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.normal.setOnClickListener {
            auth = Firebase.auth

            val intent = Intent(this,SignInActivity::class.java)
            startActivity(intent)
        }







        binding.facebookBtn.setPermissions("email", "public_profile")
        binding.facebookBtn.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {


            override fun onSuccess(result: LoginResult) {
                firebaseAuth = FirebaseAuth.getInstance()
                // Successful Facebook login
                val credential = FacebookAuthProvider.getCredential(result.accessToken.token)
                firebaseAuth.signInWithCredential(credential)
                    .addOnCompleteListener(this@Google_Facebook_login) { task ->
                        if (task.isSuccessful) {
                            val intent = Intent(this@Google_Facebook_login,MainActivity1::class.java)
                            startActivity(intent)
                            val user = firebaseAuth.currentUser
                            // Do something with the user object
                        } else {
                            // Firebase authentication failed
                            Toast.makeText(this@Google_Facebook_login, "Authentication failed.   ",
                                Toast.LENGTH_SHORT).show()
                            Log.e("tag1234", "onSuccess: ${task.exception?.message}", )
                        }
                    }
            }

            override fun onCancel() {
                // User cancelled Facebook login
                Toast.makeText(this@Google_Facebook_login, "Login cancelled.",
                    Toast.LENGTH_SHORT).show()
            }

            override fun onError(error: FacebookException) {
                // Facebook login error
                Toast.makeText(this@Google_Facebook_login, "Login error: ${error.message}",
                    Toast.LENGTH_SHORT).show()
            }
        })

        signInRequest = BeginSignInRequest.builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    // Your server's client ID, not your Android client ID.
                    .setServerClientId(getString(R.string.client_id))
                    // Only show accounts previously used to sign in.
                    .setFilterByAuthorizedAccounts(true)
                    .build()
            )
            .build()

        FacebookSdk.sdkInitialize(applicationContext)
        callbackManager = CallbackManager.Factory.create()
    }

    // ...

    @SuppressLint("SuspiciousIndentation")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
//        oneTapClient = oneTapClient as SignInClient



//        val googleCredential = oneTapClient.getSignInCredentialFromIntent(data)
//        val idToken = googleCredential.googleIdToken

        if(requestCode ==13 && resultCode==resultCode){
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            val account = task.getResult(ApiException::class.java)
            firebaseAuthWithGoogle(account.idToken!!)

        }



        callbackManager.onActivityResult(requestCode, resultCode, data)

    }




    override fun onStart() {
        auth = Firebase.auth

        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }


    private fun updateUI(user: FirebaseUser?) {

    }

    companion object {
        private const val TAG = "GoogleActivity"
        private const val RC_SIGN_IN = 9001}

    private fun firebaseAuthWithGoogle(idToken:String){
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val intent = Intent(this,MainActivity1::class.java)
                    startActivity(intent)
                    val user = auth.currentUser
                    // ...
                } else {
                    // Sign in failed, display a message to the user
                    // ...
                }
            }.addOnFailureListener {
                Toast.makeText(this, it.localizedMessage.toString(), Toast.LENGTH_SHORT).show()
            }
        }
}
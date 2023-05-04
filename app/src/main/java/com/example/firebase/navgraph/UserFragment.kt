package com.example.firebase

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firebase.R
import com.example.firebase.databinding.FragmentUserBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.pbs.testnavgraph.VegAdapter

class UserFragment : Fragment() {
    private lateinit var binding: FragmentUserBinding
//    private lateinit var googleSignInClient:GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account1, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.client_id))
            .requestEmail()
            .build()
        var c = Google_Facebook_login()
//        var context = c.
        var googleSignInClient = GoogleSignIn.getClient(requireContext(), gso)

        val lgText = view?.findViewById<TextView>(R.id.logoutId)
        lgText?.setOnClickListener {
            googleSignInClient.signOut()
            if (googleSignInClient.signOut().isComplete.not()){
            val intent = Intent(this.requireContext(),Google_Facebook_login::class.java)
            startActivity(intent)}
            else{
                Toast.makeText(this.requireContext(), "something went Wrong", Toast.LENGTH_SHORT).show()
            }
        }


    }
}
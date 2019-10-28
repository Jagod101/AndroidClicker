package com.example.bigboisonly.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import com.example.bigboisonly.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    //onCreate, on Initialization, the app looks for User information
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginUsernameField.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //unused
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //unused
            }
            override fun afterTextChanged(p0: Editable?) {
                //unused
            }
        })

        //Takes the data entered by the User and creates an updating count for them stored to their specific username
        loginButton.setOnClickListener {
            startActivity(Intent( this, MainActivity::class.java).apply { putExtra("username", loginUsernameField.text)})
        }
    }
}
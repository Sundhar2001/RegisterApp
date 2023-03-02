package com.example.registration

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var userName: EditText
    lateinit var password: EditText
    lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        userName = findViewById(R.id.et_username)
        password = findViewById(R.id.et_password)
        btnLogin = findViewById(R.id.btn_login)

        btnLogin.setOnClickListener {

            var nameText: String = userName.text.toString()
            var passwordText: String = password.text.toString()

            if (nameText.isEmpty() || passwordText.isEmpty()){
                Toast.makeText(this,"please enter all the details",Toast.LENGTH_SHORT).show()
            }else {

                val sharedPreferences = getSharedPreferences("loginPreference", MODE_PRIVATE)
                val editor = sharedPreferences.edit()

                editor.apply {

                    putString("USER_NAME",nameText)
                    putString("PASSWORD",passwordText)

                }.apply()


                val intent = Intent(this,RegistrationActivity::class.java)
                startActivity(intent)

            }

            userName.setText("")
            password.setText("")

        }

    }
}
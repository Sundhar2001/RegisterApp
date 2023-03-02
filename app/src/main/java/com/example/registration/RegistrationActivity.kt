package com.example.registration

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegistrationActivity : AppCompatActivity() {

    lateinit var name: EditText
    lateinit var password: EditText
    lateinit var phone: EditText
    lateinit var email: EditText
    lateinit var address: EditText
    lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        supportActionBar?.hide()

        name = findViewById(R.id.et_username)
        password = findViewById(R.id.et_password)
        phone = findViewById(R.id.et_phone)
        email = findViewById(R.id.et_email)
        address = findViewById(R.id.et_address)

        btnSubmit = findViewById(R.id.btn_submit)

        val sharedPreferences = getSharedPreferences("loginPreference", MODE_PRIVATE)
        val userName: String? = sharedPreferences.getString("USER_NAME",null)
        val userPassword: String? = sharedPreferences.getString("PASSWORD",null)

        name.setText(userName)
        password.setText(userPassword)

        btnSubmit.setOnClickListener {

            var nameTxt: String = name.text.toString()
            var passwordTxt: String = password.text.toString()
            var phoneTxt: String = phone.text.toString()
            var emailTxt: String = email.text.toString()
            var addressTxt: String = address.text.toString()


            if (nameTxt.isEmpty() || passwordTxt.isEmpty() || phoneTxt.isEmpty() || emailTxt.isEmpty() || addressTxt.isEmpty()){
                Toast.makeText(this,"please enter all the details",Toast.LENGTH_SHORT).show()
            } else {

                val sharedPreferences = getSharedPreferences("sharePrefs", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.apply {

                    putString("PHONE",phoneTxt)
                    putString("EMAIL",emailTxt)
                    putString("ADDRESS",addressTxt)
                }.apply()

                Toast.makeText(this,"Successfully submitted",Toast.LENGTH_SHORT).show()
                finish()

            }
        }

    }
}
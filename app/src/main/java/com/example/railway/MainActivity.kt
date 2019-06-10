package com.example.railway

import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSend.setOnClickListener {
            val email = Email(editEmail.text.toString(), editSubject.text.toString(), editField.text.toString())
            val result = validate(email)
            when (result) {
                is Success -> Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
                is Failure -> Toast.makeText(this, result.errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun validate(email: Email) = validAddress(email) then ::notBlank

    fun validAddress(email: Email): Result<Email> {
        if (email.to.isEmpty()) {
            return Failure("Please enter email")
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email.to).matches()) {
            return Failure("Invalid email address")
        }
        return Success(email)
    }

    fun notBlank(email: Email): Result<Email> {
        if (email.subject.isEmpty() || email.body.isEmpty()) {
            return Failure("Subject or body must not be blank")
        }
        return Success(email)
    }

}

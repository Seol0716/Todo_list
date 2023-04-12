package com.example.todo_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.example.todo_project.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var db_data = ArrayList<String>()
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var id: EditText = binding.userId
        var pw: EditText = binding.userPw

        //타이틀바 숨기기
        var actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

        //회원가입 버튼
        val create: Button = binding.createBtn

        //로그인 폼
        val login: Button = binding.loginBtn

        //Firebase 연결
        auth = Firebase.auth

        create.setOnClickListener() {

            val intent = Intent(this, Create::class.java)
            startActivity(intent)
        }

        login.setOnClickListener() {

            login(id.text.toString(), pw.text.toString())
        }
    }


    private fun login(id: String, pw: String) {

        if (id.isNullOrEmpty() || pw.isNullOrEmpty()) {
            Toast.makeText(this, "빈 값을 입력하셨습니다.", Toast.LENGTH_SHORT).show()
        } else {
            auth.signInWithEmailAndPassword(id, pw)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "로그인에 성공했습니다!", Toast.LENGTH_SHORT).show()

                        val intent = Intent(this, Main::class.java)
                        startActivity(intent)
                    }
                    else {
                        Toast.makeText(this, "아이디와 비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}








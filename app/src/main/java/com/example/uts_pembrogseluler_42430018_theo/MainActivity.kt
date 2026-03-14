package com.example.uts_pembrogseluler_42430018_theo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNamaDosen = findViewById<EditText>(R.id.etNamaDosen)
        val btnMasuk = findViewById<Button>(R.id.btnMasuk)

        btnMasuk.setOnClickListener {
            val namaDosen = etNamaDosen.text.toString()

            // Validasi agar tidak kosong
            if (namaDosen.isNotEmpty()) {
                // Modul 4: Pindah halaman dengan Intent
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("EXTRA_NAMA_DOSEN", namaDosen)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Nama Dosen tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
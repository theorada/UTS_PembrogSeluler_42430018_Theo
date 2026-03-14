package com.example.uts_pembrogseluler_42430018_theo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Binding view
        val tvSapaan = findViewById<TextView>(R.id.tvSapaan)
        val etJumlahMahasiswa = findViewById<EditText>(R.id.etJumlahMahasiswa)
        val etRataRataNilai = findViewById<EditText>(R.id.etRataRataNilai)
        val btnProsesData = findViewById<Button>(R.id.btnProsesData)
        val tvStatusKelas = findViewById<TextView>(R.id.tvStatusKelas)
        val tvDaftarAbsen = findViewById<TextView>(R.id.tvDaftarAbsen)

        // Menerima data dari halaman 1
        val namaDosen = intent.getStringExtra("EXTRA_NAMA_DOSEN")
        tvSapaan.text = "Selamat bertugas, Dosen $namaDosen"

        btnProsesData.setOnClickListener {
            val inputJumlah = etJumlahMahasiswa.text.toString()
            val inputRataRata = etRataRataNilai.text.toString()

            if (inputJumlah.isNotEmpty() && inputRataRata.isNotEmpty()) {
                val jumlahMahasiswa = inputJumlah.toInt()
                val rataRataNilai = inputRataRata.toDouble()

                // LOGIKA 1: Percabangan If-Else
                val statusKelas: String
                if (rataRataNilai >= 80) {
                    statusKelas = "Sangat Baik"
                } else if (rataRataNilai >= 60) {
                    statusKelas = "Cukup"
                } else {
                    statusKelas = "Kurang"
                }
                tvStatusKelas.text = "Status Kelas: $statusKelas"

                // LOGIKA 2: Perulangan For
                val builderAbsen = java.lang.StringBuilder()
                for (i in 1..jumlahMahasiswa) {
                    builderAbsen.append("Mahasiswa $i: ______ \n")
                }
                tvDaftarAbsen.text = builderAbsen.toString()

            } else {
                Toast.makeText(this, "Harap isi semua kolom!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
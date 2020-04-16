package robby.hermando.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var ViewModel: DataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewModel = ViewModelProvider(this).get(DataViewModel::class.java)
        ViewModel.getHitung().observe(this, getHitung)

        btn_hitung.setOnClickListener {
            hitung(edt_panjang.text.toString().trim(), edt_panjang.text.toString().trim())
        }
    }


    fun hitung(panjang: String, lebar: String) {
        if (panjang.isEmpty() || lebar.isEmpty()) {
            Toast.makeText(applicationContext, "Data KOSONG", Toast.LENGTH_SHORT).show()
        } else {
            ViewModel.setHitung(
                edt_panjang.text.toString().trim(),
                edt_lebar.text.toString().trim()
            )
        }
    }

    val getHitung = Observer<Result> {
        it.let {
            tv_result.text = it?.result
        }
    }
}

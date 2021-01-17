package id.ac.amikom.appserba_0645.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import id.ac.amikom.appserba_0645.R
import id.ac.amikom.appserba_0645.databinding.ActivityMainBinding
import id.ac.amikom.appserba_0645.ui.auth.AppserbaAuth
import id.ac.amikom.appserba_0645.ui.auth.AuthActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.buttonLogout.setOnClickListener {
            AppserbaAuth.logout(this){
                startActivity(Intent(this, AuthActivity::class.java))
                finish()
            }
        }
    }
}
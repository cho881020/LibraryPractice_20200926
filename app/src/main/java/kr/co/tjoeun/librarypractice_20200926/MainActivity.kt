package kr.co.tjoeun.librarypractice_20200926

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        loadWebImageButton.setOnClickListener {

            Glide.with(mContext).load("https://lh3.googleusercontent.com/proxy/LTmNdp347w0ZC0EqVyQjmIkuBD3ZDzfpV7qD0I2T53yfjm9gCF2iNkKfnn8gpTohMaO21CLVvQddvEy1deJ97HIvza_B7n01Ps9h7vLF29X1ZLszrlS8hTGW2fXnJTGx1YzXNMalvEiE458").into(otherPersonImg)

        }

        profilePhotoImg.setOnClickListener {
//            Toast.makeText(mContext, "사진 클릭됨", Toast.LENGTH_SHORT).show()

            val myIntent = Intent(mContext, ViewProfilePhotoActivity::class.java)
            startActivity(myIntent)

        }

    }

}
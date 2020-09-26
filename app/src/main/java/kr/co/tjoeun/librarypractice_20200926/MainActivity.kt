package kr.co.tjoeun.librarypractice_20200926

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        callPhoneBtn.setOnClickListener {

            val pl = object : PermissionListener {
                override fun onPermissionGranted() {
                    val phoneNum = phoneNumTxt.text.toString()

                    val myUri = Uri.parse("tel:${phoneNum}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext, "권한이 거부되어 통화가 안됩니다.", Toast.LENGTH_SHORT).show()
                }

            }

            TedPermission.with(mContext)
                .setPermissionListener(pl)
                .setDeniedMessage("권한이 거부되었습니다. [설정] 에서 권한을 켜주세요.")
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()


        }

        loadWebImageButton.setOnClickListener {

            Glide.with(mContext).load("http://lh3.googleusercontent.com/proxy/LTmNdp347w0ZC0EqVyQjmIkuBD3ZDzfpV7qD0I2T53yfjm9gCF2iNkKfnn8gpTohMaO21CLVvQddvEy1deJ97HIvza_B7n01Ps9h7vLF29X1ZLszrlS8hTGW2fXnJTGx1YzXNMalvEiE458").into(otherPersonImg)

        }

        profilePhotoImg.setOnClickListener {
//            Toast.makeText(mContext, "사진 클릭됨", Toast.LENGTH_SHORT).show()

            val myIntent = Intent(mContext, ViewProfilePhotoActivity::class.java)
            startActivity(myIntent)

        }

    }

    override fun setValues() {


    }

}
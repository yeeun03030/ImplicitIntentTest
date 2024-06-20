package kr.ac.kopo.implicitintenttest

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnCall = findViewById<Button>(R.id.btn_call)
        var btnHome = findViewById<Button>(R.id.btn_home)
        var btnMap = findViewById<Button>(R.id.btn_map)
        var btnSearch = findViewById<Button>(R.id.btn_search)
        var btnSms = findViewById<Button>(R.id.btn_sms)
        var btnCamera = findViewById<Button>(R.id.btn_camera)

        btnCall.setOnClickListener(btnListener)
        btnHome.setOnClickListener(btnListener)
        btnMap.setOnClickListener(btnListener)
        btnSearch.setOnClickListener(btnListener)
        btnSms.setOnClickListener(btnListener)
        btnCamera.setOnClickListener(btnListener)

    }

    val btnListener = View.OnClickListener {
        var uri = Uri.parse("tel:/010-1234-5078")
        var intent = Intent(Intent.ACTION_DIAL, uri)
        when(it.id) {
            R.id.btn_home -> {
                uri = Uri.parse("http://www.hanbit.co.kr")
                intent = Intent(Intent.ACTION_VIEW, uri)
            }
            R.id.btn_map -> {
                uri = Uri.parse("http://maps.google.com/maps?q=" + 37.5290615+ "," + 126.996542)
                intent = Intent(Intent.ACTION_VIEW, uri)
            }
            R.id.btn_search -> {
                intent = Intent(Intent.ACTION_WEB_SEARCH)
                intent.putExtra(SearchManager.QUERY, "한국폴리텍대학 인공지능소프트웨어학과")
            }
            R.id.btn_sms -> {
                intent = Intent(Intent.ACTION_SENDTO)
                intent.putExtra("sms_body", "조금 있으면 나도 방학이야 우리 한번 볼까?")
                intent.data = Uri.parse("smsto: " + Uri.encode("010-5063-2647"))
            }
            R.id.btn_camera -> {
                intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            }
            R.id.btn_call -> {
                uri = Uri.parse("tel:/010-1234-5078")
                intent = Intent(Intent.ACTION_DIAL, uri)
            }
        }
        startActivity(intent)
    }
}
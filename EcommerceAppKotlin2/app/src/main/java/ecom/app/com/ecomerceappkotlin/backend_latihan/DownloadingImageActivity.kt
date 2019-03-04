package ecom.app.com.ecomerceappkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_downloading_image.*

class DownloadingImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_downloading_image)

        btnDownloadImage.setOnClickListener{

            val imageURL = "http://192.168.43.249/ecom/gambar.png"

            Picasso.get().load(imageURL).into(imgDownloadedImage)
        }
    }
}

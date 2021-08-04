package satellite.tistory.mango_contents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<ContentsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bookmarkButton = findViewById<TextView>(R.id.bookmarkBtn)
        bookmarkButton.setOnClickListener{

            val intent = Intent( this, BookmarkActivity::class.java)
            startActivity(intent)
        }

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/9Olbjly_qarL",
                "https://mp-seoul-image-production-s3.mangoplate.com/26362_1591597118248730.jpg?fit=around|359:240&crop=359:240;*,*&output-format=jpg&output-quality=80",
                "해운대양과자점"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/9uqsT4u65zu8",
                "https://mp-seoul-image-production-s3.mangoplate.com/54992_1621708795081660.jpg?fit=around|359:240&crop=359:240;*,*&output-format=jpg&output-quality=80",
                "프라한"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/2CK4QZdJXLmA",
                "https://mp-seoul-image-production-s3.mangoplate.com/1846926_1607171302881994.jpg?fit=around|359:240&crop=359:240;*,*&output-format=jpg&output-quality=80",
                "서랍"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/nEHI8wr0n0ju",
                "https://mp-seoul-image-production-s3.mangoplate.com/389589/585002_1598534914300_48373?fit=around|359:240&crop=359:240;*,*&output-format=jpg&output-quality=80",
                "고메빵집"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/sV62jmXg3f",
                "https://mp-seoul-image-production-s3.mangoplate.com/27636_1428827699270?fit=around|359:240&crop=359:240;*,*&output-format=jpg&output-quality=80",
                "가내수공업양식당비토"
            )
        )
        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/3WkmpDJffyh1",
                "https://mp-seoul-image-production-s3.mangoplate.com/752490_1493718883913545.jpg?fit=around|359:240&crop=359:240;*,*&output-format=jpg&output-quality=80",
                "카페마코토"
            )
        )
        baseContext

        val recyclerview = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(this, items)
        recyclerview.adapter = rvAdapter

        rvAdapter.itemClick = object: RVAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {

                val intent = Intent(baseContext, ViewActivity::class.java)
//                intent.putExtra("url", items[position].url)
                intent.putExtra("url", items[position].url)
                intent.putExtra("title", items[position].titleText)
                intent.putExtra("imageUrl", items[position].imageUrl)

                startActivity(intent)

            }
        }

        recyclerview.layoutManager = GridLayoutManager(this, 2)

    }
}

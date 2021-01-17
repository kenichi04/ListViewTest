package jp.techacademy.kenichi04.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Map<String, String>型のArrayList
        val list = ArrayList<Map<String, String>>()

        for (i in 0 .. 10) {
            val map = HashMap<String, String>()
            map.put("main", "メイン $i")
            map.put("sub", "サブ $i")
            list.add(map)
        }

        val adapter = SimpleAdapter(
                this,
                list,
                // ListViewの各行のレイアウト設定: ここでは2行のテキスト表示
                android.R.layout.simple_list_item_2,
                // 設定するデータのリストのキーを設定: 1行目->main,2行目->sub
                arrayOf("main", "sub"),
                // 各行のレイアウトのid
                intArrayOf(android.R.id.text1, android.R.id.text2)
        )

        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            Log.d("UI_PARTS", "クリックposition $position")
            Log.d("UI_PARTS", "クリックid $id")
        }

    }
}
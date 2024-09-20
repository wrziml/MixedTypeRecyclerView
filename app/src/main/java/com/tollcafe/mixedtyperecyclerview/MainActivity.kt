package com.tollcafe.mixedtyperecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tollcafe.mixedtyperecyclerview.R

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MultiTypeAdapter
    private lateinit var itemList: List<ListItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)

        // 初始化数据列表
        itemList = listOf(
            ListItem(ItemType.TEXT, text = "This is a text item"),
            ListItem(ItemType.TEXT, text = "This is a text item"),
            ListItem(ItemType.IMAGE, imageResId = R.drawable.ic_launcher_foreground),
            ListItem(ItemType.TEXT, text = "This is a text item"),
            ListItem(ItemType.TEXT, text = "This is a text item"),
            ListItem(ItemType.IMAGE, imageResId = R.drawable.ic_launcher_foreground),
            ListItem(ItemType.TEXT, text = "This is a text item"),
            ListItem(ItemType.IMAGE, imageResId = R.drawable.ic_launcher_foreground),
            ListItem(ItemType.TEXT, text = "This is a text item"),
            ListItem(ItemType.TEXT, text = "This is a text item"),
            ListItem(ItemType.IMAGE, imageResId = R.drawable.ic_launcher_foreground),
            ListItem(ItemType.IMAGE, imageResId = R.drawable.ic_launcher_foreground),
            ListItem(ItemType.TEXT, text = "This is a text item"),
            ListItem(ItemType.IMAGE, imageResId = R.drawable.ic_launcher_foreground),
            ListItem(ItemType.IMAGE, imageResId = R.drawable.ic_launcher_foreground),
            ListItem(ItemType.TEXT_IMAGE, text = "Text with Image", imageResId = R.drawable.ic_launcher_foreground),
            ListItem(ItemType.TEXT, text = "Another text item"),
            ListItem(ItemType.IMAGE, imageResId = R.drawable.ic_launcher_foreground),
            ListItem(ItemType.TEXT_IMAGE, text = "Text with Image", imageResId = R.drawable.ic_launcher_foreground),
            ListItem(ItemType.TEXT_IMAGE, text = "Text with Image", imageResId = R.drawable.ic_launcher_foreground),
            ListItem(ItemType.TEXT_IMAGE, text = "Text with Image", imageResId = R.drawable.ic_launcher_foreground),
            ListItem(ItemType.TEXT_IMAGE, text = "Text with Image", imageResId = R.drawable.ic_launcher_foreground),


            )

        // 设置布局管理器
        recyclerView.layoutManager = LinearLayoutManager(this)

        // 设置适配器
        adapter = MultiTypeAdapter(itemList)
        recyclerView.adapter = adapter
    }
}

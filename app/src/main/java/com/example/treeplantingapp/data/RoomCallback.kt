package com.example.treeplantingapp.data

import android.content.Context
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.treeplantingapp.R
import org.json.JSONArray
import org.json.JSONException
import java.io.BufferedReader
import javax.inject.Inject

class StartingTrees @Inject constructor(
    private val context: Context,
    private val database: TreeDatabase? = null,
) : RoomDatabase.Callback() {
    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        fillWithStartingNotes(context)
    }

    private fun loadJSONArray(context: Context): JSONArray? {
        val inputStream = context.resources.openRawResource(R.raw.constituencies)

        BufferedReader(inputStream.reader()).use {
            return JSONArray(it.readText())
        }
    }

    private fun fillWithStartingNotes(context: Context) {

        val dao = database?.constituencyDao

        try {
            val constituencies = loadJSONArray(context)
            if (constituencies != null) {

                val constituencyArray = arrayListOf<Constituency>()

                (0 until constituencies.length()).forEach { index ->
                    val item = constituencies.getJSONObject(index)

                    val name = item.getString("name")
                    val wards = item.getJSONArray("wards") as List<String>

                    val entity = Constituency(
                        name = name, wards = wards
                    )
                    constituencyArray.add(entity)
                }
                dao?.insertAll(constituencyArray)
            }
        } catch (e: JSONException) {
            // Timber.d("fillWithStartingNotes: $e")
        }
    }
}
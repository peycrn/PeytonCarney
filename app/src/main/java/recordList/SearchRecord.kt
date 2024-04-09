package recordList

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import za.ac.iie.historyapp.R
import java.io.Serializable

class SearchRecordActivity : AppCompatActivity() {

    data class Record(
        val name: String,
        val age: Int
    ) : Serializable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_record)

        val intent = intent
        val age = intent.getIntExtra("age", 0)

        val textView = findViewById<TextView>(R.id.textView)
        val editText = findViewById<EditText>(R.id.editText)
        val button1 = findViewById<Button>(R.id.button1)

        button1.setOnClickListener {
            val query = editText.text.toString().trim()
            val results = searchRecords(query)
            // Do something with the results
        }
    }

    private fun searchRecords(query: String): List<Record> {
        val results = mutableListOf<Record>()

        // Sample list of records, replace it with your actual data source
        val records = listOf(
            Record("Peyton", 30),
            Record("Tracy", 25),
            Record("Ferdi", 35)
        )

        for (record in records) {
            if (record.name.contains(query, ignoreCase = true)) {
                results.add(record)
            }
        }

        return results
    }
}

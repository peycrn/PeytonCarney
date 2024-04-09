package recordList

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import za.ac.iie.historyapp.R
import java.io.Serializable

class ResultActivity : AppCompatActivity() {

    data class Record(
        val fullName: String,
        val birthYear: Int,
        val deathYear: Int,
        val occupation: String,
        val place: String
    ) : Serializable

    private val records = mutableListOf<Record>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val record = Record("Peyton Carney", 2005, 7071, "Doctor", "England")
            records.add(record)
            // You can perform other actions here, such as updating UI or saving records to a database
        }
    }
}
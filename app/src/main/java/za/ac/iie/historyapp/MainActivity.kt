package za.ac.iie.historyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import recordList.ResultActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ageInput: EditText = findViewById(R.id.ageInput)
        val matchButton: Button = findViewById(R.id.match)

        matchButton.setOnClickListener {
            Log.d("MainActivity", "Starting ResultActivity")
            val ageText = ageInput.text.toString().trim()
            if (ageText.isNotEmpty() && ageText.toIntOrNull() != null) {
                val age = ageText.toInt()
                if (age in 20..100) {
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra("age", age)
                    startActivity(intent)
                } else {
                    showToast("Enter an age between 20 and 100.")
                }
            } else {
                showToast("Please enter a valid age.")

            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}




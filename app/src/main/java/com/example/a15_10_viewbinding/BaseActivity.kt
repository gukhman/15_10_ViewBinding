package com.example.a15_10_viewbinding

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

open class BaseActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
    }

    fun setupToolbar(toolbarId: Int, needBackArrow: Boolean) {
        toolbar = findViewById(toolbarId)
        setSupportActionBar(toolbar)
        if (needBackArrow) {
            // Настройка Action Bar с кнопкой "Назад"
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        } else {
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
        }
    }

    protected fun setupWindowInsets(viewId: Int) {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(viewId)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                // Если в back stack есть фрагменты, вернуться к предыдущему
                if (supportFragmentManager.backStackEntryCount > 0) {
                    supportFragmentManager.popBackStack()
                } else {
                    finish()  // Закрыть активность, если фрагментов нет
                }
                true
            }

            R.id.action_exit -> {
                finishAffinity()  // Закрыть все активности
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.exit, menu)
        return true
    }
}
package app.tamasha.live.activity

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.tamasha.live.R
import app.tamasha.live.adapter.UserListAdapter
import app.tamasha.live.viewmodel.ListViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ListViewModel
    lateinit var usersList: RecyclerView
    private val userListAdapter = UserListAdapter(arrayListOf())
    private lateinit var progressBar: ProgressBar
    private lateinit var errorTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[ListViewModel::class.java]

        progressBar = findViewById(R.id.loadingView)
        errorTextView = findViewById(R.id.listError)
        usersList = findViewById(R.id.usersList)

        usersList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = userListAdapter
        }
        observeViewModel()
        viewModel.refresh()
    }

    private fun observeViewModel() {
        viewModel.users.observe(this) { countries ->
            countries?.let {
                usersList.visibility = View.VISIBLE
                userListAdapter.updateCountries(it)
            }
        }
        viewModel.usersLoadError.observe(this) { isError ->
            errorTextView.visibility = if (isError == "") View.GONE else View.VISIBLE
        }
        viewModel.loading.observe(this) { isLoading ->
            isLoading?.let {
                progressBar.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    errorTextView.visibility = View.GONE
                    usersList.visibility = View.GONE
                }
            }
        }
    }
}
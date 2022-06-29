package com.example.hiltdemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mydaggerdemo.adapters.RepositoryAdapter
import com.example.mydaggerdemo.model.ReposDataList
import com.example.mydaggerdemo.model.RepositoriesDataClass
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var reposListAdapter: RepositoryAdapter
    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initRecyclerView()
        initViewModel()

    }

    private fun initViewModel() {
        mainActivityViewModel = ViewModelProvider(this@MainActivity).get(MainActivityViewModel::class.java)
        mainActivityViewModel.getLiveDataObserver().observe(this, object :
            Observer<List<ReposDataList>> {
            override fun onChanged(t: List<ReposDataList>?) {
                if(t != null){
                    reposListAdapter.setUpdateData(t)
                    reposListAdapter.notifyDataSetChanged()
                }else{
                    Toast.makeText(this@MainActivity, "Some data issues.....", Toast.LENGTH_SHORT).show()
                }
            }
        })

        mainActivityViewModel.loadListofData()

    }


    private fun initRecyclerView(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        reposListAdapter = RepositoryAdapter()
        recyclerView.adapter = reposListAdapter
    }


}
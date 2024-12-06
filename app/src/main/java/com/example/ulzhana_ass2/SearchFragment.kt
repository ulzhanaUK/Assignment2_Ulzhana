package com.example.ulzhana_ass2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.SearchView

class SearchFragment : Fragment() {

    private lateinit var searchAdapter: UserAdapter
    private lateinit var users: List<User>
    private lateinit var filteredUsers: MutableList<User>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.search_page, container, false)
        val searchView: SearchView = view.findViewById(R.id.searchView)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewSearch)

        users = listOf(
            User("user1", "User 1 Bio"),
            User("user2", "User 2 Bio"),
            User("user3", "User 3 Bio")
        )
        filteredUsers = users.toMutableList()

        searchAdapter = UserAdapter(filteredUsers)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = searchAdapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterUsers(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterUsers(newText)
                return true
            }
        })

        return view
    }

    private fun filterUsers(query: String?) {
        filteredUsers.clear()
        if (!query.isNullOrEmpty()) {
            filteredUsers.addAll(users.filter { it.username.contains(query, true) })
        } else {
            filteredUsers.addAll(users)
        }
        searchAdapter.notifyDataSetChanged()
    }
}
package com.example.ulzhana_ass2
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ulzhana_ass2.PostAdapter
import com.example.ulzhana_ass2.Post


class HomeF : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.home_feed_fragment, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewHome)

        val posts = listOf(
            Post(R.drawable.test_1, "user1", "Caption 1", 10),
            Post(R.drawable.test_1, "user2", "Caption 2", 20)
        )

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = PostAdapter(posts)

        return view
    }
}

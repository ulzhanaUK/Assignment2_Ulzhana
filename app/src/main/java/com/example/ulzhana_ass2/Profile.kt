package com.example.ulzhana_ass2
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ulzhana_ass2.PostAdapter
import com.example.ulzhana_ass2.Post
import android.widget.TextView


class Profile : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.profile, container, false)
        val profilePicture: ImageView = view.findViewById(R.id.profilePicture)
        val bio: TextView = view.findViewById(R.id.bio)
        val postsCount: TextView = view.findViewById(R.id.postsCount)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewProfile)

        bio.text = "Hi everyone :)"
        postsCount.text = "Posts: 55"

        val posts = listOf(
            Post(R.drawable.test_1, "user1", "Caption 1", 10),
            Post(R.drawable.test_2, "user2", "Caption 2", 20)
        )

        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        recyclerView.adapter = PostAdapter(posts)

        return view
    }
}

package com.example.ulzhana_ass2
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Post(val imageRes: Int, val username: String, val caption: String, val likes: Int)

class PostAdapter(private val posts: List<Post>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.postImage)
        val username: TextView = itemView.findViewById(R.id.username)
        val caption: TextView = itemView.findViewById(R.id.caption)
        val likes: TextView = itemView.findViewById(R.id.likes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.image.setImageResource(post.imageRes)
        holder.username.text = post.username
        holder.caption.text = post.caption
        holder.likes.text = "Likes: ${post.likes}"
    }

    override fun getItemCount(): Int = posts.size
}

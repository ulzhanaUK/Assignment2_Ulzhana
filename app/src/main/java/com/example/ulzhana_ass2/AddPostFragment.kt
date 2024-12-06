package com.example.ulzhana_ass2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment

class AddPostFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_post_page, container, false)
        val imagePreview: ImageView = view.findViewById(R.id.imagePreview)
        val captionEditText: EditText = view.findViewById(R.id.captionEditText)
        val uploadButton: Button = view.findViewById(R.id.uploadButton)

        uploadButton.setOnClickListener {
            val caption = captionEditText.text.toString()
            if (caption.isNotBlank()) {
                val newPost = Post(R.drawable.test_1, "currentUser", caption, 0)
                Toast.makeText(requireContext(), "Post uploaded!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Please add a caption.", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}

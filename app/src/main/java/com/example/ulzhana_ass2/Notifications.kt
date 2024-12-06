package com.example.ulzhana_ass2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Notifications : Fragment() {

    private lateinit var notificationAdapter: NotificationAdapter
    private lateinit var notifications: List<Notification>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.notifications_page, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewNotifications)

        notifications = listOf(
            Notification("User1 liked your post", "10m ago"),
            Notification("User2 commented: Nice post!", "1h ago"),
            Notification("User3 started following you", "3h ago")
        )

        notificationAdapter = NotificationAdapter(notifications)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = notificationAdapter

        return view
    }
}

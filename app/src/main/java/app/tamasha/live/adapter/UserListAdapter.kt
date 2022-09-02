package app.tamasha.live.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import app.tamasha.live.R
import app.tamasha.live.utils.beGone
import app.tamasha.live.utils.beVisible
import app.tamasha.live.model.User
import coil.load


class UserListAdapter(var users: ArrayList<User>) :
    RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    fun updateCountries(newUsers: List<User>) {
        users.clear()
        users.addAll(newUsers)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = UserViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
    )

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val imageView = view.findViewById<ImageView>(R.id.userAvatar)
        private val userName = view.findViewById<TextView>(R.id.userFullName)
        private val userEmail = view.findViewById<TextView>(R.id.userEmail)
        private val relativeLayout = view.findViewById<RelativeLayout>(R.id.expanded_view)
        private val constraint = view.findViewById<ConstraintLayout>(R.id.constraint)
        private val salary = view.findViewById<TextView>(R.id.tv_salary)

        @SuppressLint("SetTextI18n")
        fun bind(user: User) {
            userName.text = user.employeeName
            userEmail.text = "ID - ${user.id.toString()}" + "    |    Age - ${user.employeeAge}"

            if (user.profileImage.toString().isEmpty()) {
                imageView.load(R.drawable.ic_baseline_person_24) {
                    crossfade(true)
                }
            } else {
                imageView.load(user.profileImage) {
                    crossfade(true)
                }
            }

            relativeLayout.visibility = if (user.isExpanded) View.VISIBLE else View.GONE

            constraint.setOnClickListener {
                if (!user.isExpanded) {
                    salary.text = "Salary - " + user.employeeSalary.toString() + " INR"
                    user.isExpanded = true
                    relativeLayout.beVisible()
                } else {
                    user.isExpanded = false
                    relativeLayout.beGone()
                }

            }
        }
    }
}
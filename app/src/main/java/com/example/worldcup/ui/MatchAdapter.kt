package com.example.worldcup.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.worldcup.R
import com.example.worldcup.data.domain.Match
import com.example.worldcup.databinding.ItemMatchBinding
import com.example.worldcup.databinding.ItemMatchHeaderBinding
import com.example.worldcup.util.Diffrentutil

class MatchAdapter(private var list: List<Match>, private val listener: MatchinteractionListener) :
    RecyclerView.Adapter<MatchAdapter.BaseviewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseviewHolder {
        when (viewType) {
            Heaader -> {
                val viewHeader = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_match_header, parent, false)
                return HeaderViewHolder(viewHeader)
            }
            Recycler -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)
                return MatchviewHolder(view)
            }


        }
        return super.createViewHolder(parent,viewType)
    }

    override fun onBindViewHolder(holder: BaseviewHolder, position: Int) {
        val currentMatch = list[position]
       when(holder)
       {
          is MatchviewHolder ->
           {
               holder.binding.apply {
                   rightTeam.text = currentMatch.RightTeamName
                   leftTeam.text = currentMatch.LeftTeamName
                   rightScore.text = currentMatch.RightTeamGoals.toString()
                   scoreLeft.text = currentMatch.LeftTeamGoals.toString()
                   studiamName.text = currentMatch.stadium
                   Year.text = currentMatch.year.toString()
                   root.setOnClickListener { listener.onclickitem(currentMatch) }
                   DeleteIcon.setOnClickListener { listener.deleteimatch(position) }
                   rightTeam.setOnClickListener { listener.clickOnTeamName(currentMatch.RightTeamName) }
                   if (currentMatch.RightTeamGoals > currentMatch.LeftTeamGoals) {
                       rightScore.setTextColor(
                           ContextCompat.getColor(
                               holder.binding.root.context,
                               R.color.Green
                           )
                       )
                       scoreLeft.setTextColor(
                           ContextCompat.getColor(
                               holder.binding.root.context,
                               R.color.black
                           )
                       )
                   } else if (currentMatch.RightTeamGoals < currentMatch.LeftTeamGoals) {
                       scoreLeft.setTextColor(
                           ContextCompat.getColor(
                               holder.binding.root.context,
                               R.color.Green
                           )
                       )

                       rightScore.setTextColor(
                           ContextCompat.getColor(
                               holder.binding.root.context,
                               R.color.black
                           )
                       )
                   } else {
                       scoreLeft.setTextColor(
                           ContextCompat.getColor(
                               holder.binding.root.context,
                               R.color.teal_200
                           )
                       )
                       rightScore.setTextColor(
                           ContextCompat.getColor(
                               holder.binding.root.context,
                               R.color.teal_200
                           )
                       )
                   }
               }

           }
       }

    }

    fun setupData(newlist: List<Match>) {
        val diffrenceResult = DiffUtil.calculateDiff(Diffrentutil(newlist, list))
        list = newlist
        diffrenceResult.dispatchUpdatesTo(this)
    }

    override fun getItemCount() = list.size
    override fun getItemViewType(position: Int): Int {
        return if (position %2== 0) {
            Heaader
        } else
            Recycler
    }

    abstract class BaseviewHolder(viewitem: View) : RecyclerView.ViewHolder(viewitem)

    class MatchviewHolder(viewitem: View) : BaseviewHolder(viewitem) {
        val binding = ItemMatchBinding.bind(viewitem)

    }

    class HeaderViewHolder(viewitem: View) : BaseviewHolder(viewitem) {
        val binding = ItemMatchHeaderBinding.bind(viewitem)
    }

    companion object {
        const val Heaader = 11
        const val Recycler = 12
    }
}
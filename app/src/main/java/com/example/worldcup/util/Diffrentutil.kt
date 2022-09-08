package com.example.worldcup.util

import androidx.recyclerview.widget.DiffUtil
import com.example.worldcup.data.domain.Match

class Diffrentutil(val oldMatchList: List<Match>, val newMatchList: List<Match>) :
    DiffUtil.Callback() {
    override fun getOldListSize() = oldMatchList.size


    override fun getNewListSize() = newMatchList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return (
                oldMatchList[oldItemPosition].RightTeamName == newMatchList[newItemPosition].RightTeamName
                && newMatchList[oldItemPosition].LeftTeamName == newMatchList[newItemPosition].LeftTeamName
                )
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }
}
package com.example.worldcup.ui

import com.example.worldcup.data.domain.Match

interface MatchinteractionListener{

    fun onclickitem(match:Match)
     fun clickOnTeamName(name:String)
     fun deleteimatch(index:Int)
}
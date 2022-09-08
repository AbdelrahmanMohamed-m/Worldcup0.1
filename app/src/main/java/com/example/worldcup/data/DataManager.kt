package com.example.worldcup.data

import com.example.worldcup.data.domain.Match

object DataManager {
    private val matchlist = mutableListOf<Match>()
    val matches: List<Match>
    get() = matchlist.toList()
    private var matchindex=0
    fun addMatch(match:Match)
  {
      matchlist.add(match)
  }
  fun Deletematch(index:Int)
  {
      matchlist.removeAt(index)
  }
}

package com.example.worldcup.util

import com.example.worldcup.data.domain.Match

class parcer {
    fun parce(line:String):Match{
       val token = line.split(",")
      return Match(
          year = token[Constant.ColumnIndex.YEAR].toInt(),
          stadium =token[Constant.ColumnIndex.STADIUM],
          city =token[Constant.ColumnIndex.CITY],
          RightTeamName= token[Constant.ColumnIndex.HOME_TEAM_NAME],
          LeftTeamName= token[Constant.ColumnIndex.AWAY_TEAM_NAME] ,
          RightTeamGoals =token[Constant.ColumnIndex.HOME_TEAM_GOALS].toInt(),
          LeftTeamGoals =token[Constant.ColumnIndex.AWAY_TEAM_GOALS].toInt(),

       )
    }
}
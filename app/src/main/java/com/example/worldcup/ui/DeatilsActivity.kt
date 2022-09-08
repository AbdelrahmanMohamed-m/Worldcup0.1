package com.example.worldcup.ui

import android.view.LayoutInflater
import com.example.worldcup.data.domain.Match
import com.example.worldcup.databinding.ActivityDeatilsBinding
import com.example.worldcup.util.Constant

class DeatilsActivity :BaseActivity<ActivityDeatilsBinding>(){
    override val LOG_TAG: String = "Details"

    override val bindinginflater: (LayoutInflater) -> ActivityDeatilsBinding = ActivityDeatilsBinding::inflate

    override fun setup() {
      val match:Match? = intent.getSerializableExtra(Constant.Key.MATCH) as Match?
        match?.let {
bindmatch(it)
        }
    }
 private fun bindmatch(match: Match)
 {
     binding?.apply {
         upteam.text = match.RightTeamName
         downteam.text = match.LeftTeamName
         downscore.text = match.LeftTeamGoals.toString()
         upscore.text = match.RightTeamGoals.toString()
         YearDetails.text = match.year.toString()
     }
 }
    override fun callback() {
    }

}
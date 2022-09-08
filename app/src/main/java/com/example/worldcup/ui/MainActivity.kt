package com.example.worldcup.ui

import android.content.Intent
import android.view.LayoutInflater
import android.widget.Toast
import com.example.worldcup.data.DataManager
import com.example.worldcup.data.domain.Match
import com.example.worldcup.databinding.ActivityMainBinding
import com.example.worldcup.util.Constant
import com.example.worldcup.util.parcer
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : BaseActivity<ActivityMainBinding>(), MatchinteractionListener {
    override val LOG_TAG: String = "Main_Activity"
    override val bindinginflater: (LayoutInflater) -> ActivityMainBinding =
        ActivityMainBinding::inflate
        private lateinit var adapter: MatchAdapter

    override fun setup() {
        parseFile()
        adapter = MatchAdapter(DataManager.matches, this)
        binding?.RecyclerMatch?.adapter = adapter
    }

    override fun callback() {
        binding!!.fingerbtn.setOnClickListener {
            addfinalmatch()

        }
    }
    private fun addfinalmatch() {
        val finalMatch = Match(
            RightTeamName = " France ",
            LeftTeamName = " Croatia ",
            year = 2018,
            LeftTeamGoals = 2,
            RightTeamGoals = 4,
            city = " Moscow ",
            stadium = " Luzhniki Stadium "
        )
        DataManager.addMatch(finalMatch)
        adapter.setupData(DataManager.matches)
    }

    private fun parseFile() {
        val inputstream = assets.open("worldcup.csv")
        val buffer = BufferedReader(InputStreamReader(inputstream))
        val parccer = parcer()
        buffer.forEachLine {
            val currentmatch = parccer.parce(it)
            DataManager.addMatch(currentmatch)
        }
    }

    override fun onclickitem(match: Match) {
        val intent = Intent(this, DeatilsActivity::class.java)
        intent.putExtra(Constant.Key.MATCH, match)
        startActivity(intent)
    }

    override fun clickOnTeamName(name: String) {
        Toast.makeText(applicationContext, "hello", Toast.LENGTH_SHORT).show()
    }

    override fun deleteimatch(index: Int) {
      DataManager.Deletematch(index)
        adapter.setupData(DataManager.matches)
    }
}


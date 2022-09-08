package com.example.worldcup.ui

import android.view.LayoutInflater
import com.example.worldcup.databinding.ActivitySearchBinding

class SearchActivity(
    override val LOG_TAG: String = "Search_Activity",
    override val bindinginflater: (LayoutInflater) -> ActivitySearchBinding = ActivitySearchBinding::inflate,
) : BaseActivity<ActivitySearchBinding>() {

    override fun setup() {

    }

    override fun callback() {
    }

}

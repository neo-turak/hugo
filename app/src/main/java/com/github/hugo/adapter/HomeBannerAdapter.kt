package com.github.hugo.adapter

import coil.load
import coil.transform.RoundedCornersTransformation
import com.github.neoturak.common.dp2px
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder

/**
 *@author   Hugo
 *@Description
 *@time    2023/7/7 上午12:11
 *@project  hugo
 *Think Twice, Code Once!
 */
class HomeBannerAdapter : BannerImageAdapter<String>(
    mutableListOf(
        "https://cdn.pixabay.com/photo/2023/05/15/09/18/iceberg-7994536_1280.jpg",
        "https://cdn.pixabay.com/photo/2023/06/24/15/04/dragonfly-8085413_1280.jpg",
        "https://cdn.pixabay.com/photo/2023/06/23/18/29/bird-8083971_1280.jpg",
        "https://cdn.pixabay.com/photo/2023/05/31/14/20/mountains-8031511_1280.jpg"
    )
) {
    override fun onBindView(holder: BannerImageHolder?, data: String?, position: Int, size: Int) {
        holder!!.imageView.load(data) {
            this.crossfade(true)
            transformations(RoundedCornersTransformation(holder.itemView.context.dp2px(10f)))
        }
    }
}
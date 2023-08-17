package cn.edu.bjtu.gs.main.homepage.api

import cn.edu.bjtu.gs.BaseModel
import cn.edu.bjtu.gs.main.homepage.HomePageModel

/**
 * Author: fanyafeng
 * Date: 2023/8/17 16:19
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class HomePageResponse : BaseModel {
    var total: Int? = null
    var rows: List<HomePageModel>? = null
}
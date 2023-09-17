package cn.edu.bjtu.gs.main.publishviewholders.api

import cn.edu.bjtu.gs.http.HttpRequestParamsImpl
import cn.edu.bjtu.gs.url.Urls
import com.ripple.http.base.annotation.HttpRequest

/**
 * Author: fanyafeng
 * Date: 2023/9/17 08:41
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng

@HttpRequest(Urls.URL_PUBLISH_EDIT)
class PublishEditPostParams : HttpRequestParamsImpl() {
//    "id": 6,
//    "title": "标题0801666", //标题
//    "type": 12, //11:社交类
//    12:运动类
//    13:学术类
//    21:企业招聘
//    22:实习基地
//    23:企业培训
//    24:学历提升
//    25:其他需求
//    "startTime": "2023-08-15 15:11:29", //预计开始时间
//    "endTime": "2023-08-25 15:11:29", //预计结束时间
//    "address": "北京交通大学思源东楼304", //地址
//    "volume": 1, //容量 1720.23
//    "enrollStartTime": "2023-07-20 15:11:29", //报名开始时间
//    "enrollEndTime": "2023-08-10 15:11:29", //报名结束时间
//    "cancelEndTime": "2023-08-110 15:11:29", //取消报名截止时间
//    "tag": "1,2", //标签
//    "content": "全国大学生计算机建模比赛0801666" //内容

    var id: String = ""
    var title: String = ""
    var type: String = ""
    var startTime: String = ""
    var endTime: String = ""
    var address: String = ""
    var volume: String = ""
    var enrollStartTime: String = ""
    var enrollEndTime: String = ""
    var cancelEndTime: String = ""
    var tag: String = ""
    var content: String = ""
}
package cn.edu.bjtu.gs.main.login.manager

import cn.edu.bjtu.gs.main.login.model.UserInfoModel

/**
 * Author: fanyafeng
 * Date: 2023/8/22 15:18
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng


class UserInfoManager private constructor() {
    companion object {
        //            val instance:UserInfoManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
//                UserInfoManager()
//            }
        const val USER_INFO_KEY="user_info_key"

        @Volatile
        private var INSTANCE: UserInfoManager? = null

        @JvmStatic
        fun getInstance() = INSTANCE ?: synchronized(this) {
            val instance = UserInfoManager()
            INSTANCE = instance
            return instance
        }
    }

     var userInfo: UserInfoModel? = null


}
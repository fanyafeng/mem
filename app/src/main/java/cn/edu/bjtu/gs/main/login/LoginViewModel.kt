package cn.edu.bjtu.gs.main.login

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cn.edu.bjtu.gs.cache.CacheDatabase
import cn.edu.bjtu.gs.cache.CacheModel
import cn.edu.bjtu.gs.http.HttpParamsBuilderImpl.Companion.TOKEN
import kotlinx.coroutines.launch


/**
 * Author: fanyafeng
 * Data: 2023/8/1 14:50
 * Email: fanyafeng@live.cn
 * Description:
 *                                   _ooOoo_
 *                                  o8888888o
 *                                  88" . "88
 *                                  (| -_- |)
 *                                   O\ = /O
 *                               ____/`---'\____
 *                             .   ' \\| |// `.
 *                              / \\||| : |||// \
 *                            / _||||| -:- |||||- \
 *                              | | \\\ - /// | |
 *                            | \_| ''\---/'' | |
 *                             \ .-\__ `-` ___/-. /
 *                          ___`. .' /--.--\ `. . __
 *                       ."" '< `.___\_<|>_/___.' >'"".
 *                      | | : `- \`.;`\ _ /`;.`/ - ` : | |
 *                        \ \ `-. \_ __\ /__ _/ .-` / /
 *                ======`-.____`-.___\_____/___.-`____.-'======
 *                                   `=---='
 *                .............................................
 *                         佛祖保佑             永无BUG
 *                 佛曰:
 *                         写字楼里写字间，写字间里程序员；
 *                         程序人员写程序，又拿程序换酒钱。
 *                         酒醒只在网上坐，酒醉还来网下眠；
 *                         酒醉酒醒日复日，网上网下年复年。
 *                         但愿老死电脑间，不愿鞠躬老板前；
 *                         奔驰宝马贵者趣，公交自行程序员。
 *                         别人笑我忒疯癫，我笑自己命太贱；
 *                         不见满街漂亮妹，哪个归得程序员？
 *///Github See: https://github.com/fanyafeng


class LoginViewModel : ViewModel() {

    suspend fun saveToken(context: Context, tokenFrom: String) {
        viewModelScope.launch {
            val dao = CacheDatabase.getDatabase(context).cacheDao()
            val token = dao.query(TOKEN)?.value
            if (token.isNullOrEmpty()) {
                dao.insert(CacheModel(TOKEN, tokenFrom))
            } else {
                dao.update(CacheModel(TOKEN, tokenFrom))
            }
        }
    }
}
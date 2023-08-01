package cn.edu.bjtu.gs.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


/**
 * Author: fanyafeng
 * Data: 2023/8/1 14:11
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


@Database(entities = [CacheModel::class], version = 1, exportSchema = false)
abstract class CacheDatabase : RoomDatabase() {

    abstract fun cacheDao(): CacheDao

    companion object {
        @Volatile
        private var INSTANCE: CacheDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): CacheDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, CacheDatabase::class.java, "cache_database.db"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                instance
            }
        }
    }

}
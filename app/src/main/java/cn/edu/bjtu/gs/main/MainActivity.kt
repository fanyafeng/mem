package cn.edu.bjtu.gs.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import cn.edu.bjtu.gs.BaseActivity
import cn.edu.bjtu.gs.R
import cn.edu.bjtu.gs.databinding.ActivityMainBinding
import cn.edu.bjtu.gs.main.addresspage.AddressPageFragment
import cn.edu.bjtu.gs.main.homepage.HomePageFragment
import cn.edu.bjtu.gs.main.login.api.LoginPostParam
import cn.edu.bjtu.gs.main.messagepage.MessagePageFragment
import cn.edu.bjtu.gs.main.minepage.MinePageFragment
import cn.edu.bjtu.gs.main.publishpage.PublishPageFragment
import cn.edu.bjtu.gs.main.register.api.RegisterPostParam
import cn.edu.bjtu.gs.main.register.api.RegisterResponse
import com.ripple.http.extend.httpPost

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    private var mainTabModelList = mutableListOf<MainTabModel>()
    private var mainFragmentList = mutableListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        initView()
        initData()
    }

    private fun initView() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        mainFragmentList.apply {
            add(HomePageFragment().apply {
                fragmentTransaction.add(R.id.container, this, "1")
            })
            add(AddressPageFragment().apply {
                fragmentTransaction.add(R.id.container, this, "2")
            })
            add(PublishPageFragment().apply {
                fragmentTransaction.add(R.id.container, this, "3")
            })
            add(MessagePageFragment().apply {
                fragmentTransaction.add(R.id.container, this, "4")
            })
            add(MinePageFragment().apply {
                fragmentTransaction.add(R.id.container, this, "5")
            })
        }
        fragmentTransaction.commit()

        mainTabModelList.apply {
            clear()
            add(
                MainTabModel(
                    0,
                    binding.homePageIcon,
                    binding.homePageTitle,
                    binding.homePageGroup
                ).apply {
                    mainTabModelList = this@MainActivity.mainTabModelList
                    mainFragmentList = this@MainActivity.mainFragmentList
                    fragmentManager = this@MainActivity.supportFragmentManager
                }
            )
            add(
                MainTabModel(
                    1,
                    binding.addressPageIcon,
                    binding.addressPageTitle,
                    binding.addressPageGroup
                ).apply {
                    mainTabModelList = this@MainActivity.mainTabModelList
                    mainFragmentList = this@MainActivity.mainFragmentList
                    fragmentManager = this@MainActivity.supportFragmentManager
                }
            )
            add(
                MainTabModel(
                    2,
                    binding.publishPageIcon,
                    binding.publishPageTitle,
                    binding.publishPageGroup
                ).apply {
                    mainTabModelList = this@MainActivity.mainTabModelList
                    mainFragmentList = this@MainActivity.mainFragmentList
                    fragmentManager = this@MainActivity.supportFragmentManager
                }
            )
            add(
                MainTabModel(
                    3,
                    binding.messagePageIcon,
                    binding.messagePageTitle,
                    binding.messagePageGroup
                ).apply {
                    mainTabModelList = this@MainActivity.mainTabModelList
                    mainFragmentList = this@MainActivity.mainFragmentList
                    fragmentManager = this@MainActivity.supportFragmentManager
                }
            )
            add(
                MainTabModel(
                    4,
                    binding.minePageIcon,
                    binding.minePageTitle,
                    binding.minePageGroup
                ).apply {
                    mainTabModelList = this@MainActivity.mainTabModelList
                    mainFragmentList = this@MainActivity.mainFragmentList
                    fragmentManager = this@MainActivity.supportFragmentManager
                }
            )
        }
        mainTabModelList[0].setChecked()

        binding.homePageGroup.performClick()
    }

    private fun initData() {

    }

    private fun selectTab(selectPosition: Int) {
        mainTabModelList.forEachIndexed { index, mainTabModel ->
            if (index == selectPosition) {
                mainTabModel.setChecked()
            } else {
                mainTabModel.setUnChecked()
            }
        }
    }
}
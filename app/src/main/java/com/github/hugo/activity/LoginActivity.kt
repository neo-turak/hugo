package com.github.hugo.activity

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.github.hugo.MainActivity
import com.github.hugo.R
import com.github.hugo.base.CustomToast
import com.github.hugo.databinding.ActivityLoginBinding
import com.github.hugo.vm.LoginViewModel
import com.github.neoturak.common.singleClick
import com.github.neoturak.common.startActivity
import com.github.neoturak.ui.immersiveStatusBar
import dagger.hilt.android.AndroidEntryPoint

/**
 *@author   Hugo
 *@Description
 *@time    2023/7/11 下午1:43
 *@project  hugo
 *Think Twice, Code Once!
 */
@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    private val vm: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        immersiveStatusBar()
        setContentView(binding.root)
        //事件
        binding.tvLogin.singleClick {
            if (binding.etPassword.text.length == 6 && binding.etPhoneNumber.text.toString().length == 11) {
              checkMobilePwd(
                  binding.etPhoneNumber.text.toString().trim(),
                  binding.etPassword.text.toString()
              )
          } else {
              CustomToast(this@LoginActivity, "请输入手机号和密码").show()
          }
        }
        vm.msg.observe(this) {
            CustomToast(this@LoginActivity, it).show()
        }
        vm.shopAdminModel.observe(this) {
            startActivity<MainActivity>()
        }

        //
        binding.ivEye.singleClick {
            vm.changeEye()
        }
        vm.showPwd.observe(this) {
            if (it) {
                binding.etPassword.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
                binding.ivEye.setImageDrawable(
                    ContextCompat.getDrawable(
                        this@LoginActivity,
                        R.drawable.ic_eye_open
                    )
                )
            } else {
                binding.etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                binding.ivEye.setImageDrawable(
                    ContextCompat.getDrawable(
                        this@LoginActivity,
                        R.drawable.ic_eye_close
                    )
                )
            }
            binding.etPassword.setSelection(binding.etPassword.text.length)
        }
    }

    private fun checkMobilePwd(mobile: String, pwd: String) {
        vm.shopAdminLogin(mobile, pwd)
    }

}
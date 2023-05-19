package com.github.hugo.ui.dialog

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.github.hugo.databinding.DialogNameInputBinding
import com.github.hugo.utils.CustomToast
import com.github.neoturak.common.singleClick

class NameInputDialog
private constructor() : DialogFragment() {
    private lateinit var binding: DialogNameInputBinding
    var callback: ((String) -> Unit)? = null

    companion object {
        fun instance(): NameInputDialog {
            return NameInputDialog()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogNameInputBinding.inflate(layoutInflater)

        isCancelable = false
        dialog?.setCanceledOnTouchOutside(false)
        binding.ivCancel.singleClick {
            dialog?.dismiss()
        }
        binding.btnCofirm.singleClick {
            if (binding.etName.text.toString().trim() == "") {
                CustomToast(requireContext(), "Empty user name!", Toast.LENGTH_SHORT)
                    .show()
                return@singleClick
            }
            callback?.invoke(binding.etName.text.toString().trim())
            dialog?.dismiss()
        }
        return AlertDialog.Builder(requireContext())
            .setView(binding.root)
            .setCancelable(false)
            .create()
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.setDimAmount(0f)
    }

}
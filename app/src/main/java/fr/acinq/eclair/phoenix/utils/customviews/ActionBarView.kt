/*
 * Copyright 2019 ACINQ SAS
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fr.acinq.eclair.phoenix.utils.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import fr.acinq.eclair.phoenix.R
import fr.acinq.eclair.phoenix.databinding.CustomActionBarViewBinding


class ActionBarView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = R.attr.actionBarViewStyle) :
  ConstraintLayout(context, attrs, R.attr.actionBarViewStyle) {

  private var mBinding: CustomActionBarViewBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.custom_action_bar_view, this, true)

  init {
    attrs?.let {
      val arr = context.obtainStyledAttributes(attrs, R.styleable.ActionBarView, defStyleAttr, R.style.default_textAppearance)
      mBinding.title.text = arr.getString(R.styleable.ActionBarView_text)
      arr.recycle()
    }
  }

  fun setOnBackAction(l : View.OnClickListener) {
    mBinding.backButton.setOnClickListener(l)
  }
}

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

package fr.acinq.eclair.phoenix.utils

import android.content.Context
import fr.acinq.eclair.channel.*
import fr.acinq.eclair.phoenix.R

object Transcriber {
  fun readableState(context: Context, state: State): String {
    return when {
      state is `CLOSING$` -> context.getString(R.string.state_closing)
      state is `CLOSED$` -> context.getString(R.string.state_closed)
      state is `NORMAL$` -> context.getString(R.string.state_normal)
      state is `SYNCING$` -> context.getString(R.string.state_sync)
      state is `SHUTDOWN$` -> context.getString(R.string.state_shutdown)
      state is `OFFLINE$` -> context.getString(R.string.state_offline)
      state.toString().startsWith("WAIT_") -> context.getString(R.string.state_wait_confirmed)
      else -> state.toString()
    }
  }

  fun colorForState(context: Context, state: State): Int {
    return when {
      state is `CLOSING$` || state is `CLOSED$` || state is `SHUTDOWN$` -> context.getColor(R.color.red)
      state is `NORMAL$` -> context.getColor(R.color.green)
      state is `SYNCING$` -> context.getColor(R.color.salmon)
      state is `OFFLINE$` -> context.getColor(R.color.slate)
      state.toString().startsWith("WAIT_") -> context.getColor(R.color.salmon)
      state.toString().startsWith("ERR_") -> context.getColor(R.color.red)
      else -> context.getColor(R.color.salmon)
    }
  }
}

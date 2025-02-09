/*
 * Copyright (C) 2022 Thibault B.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.thibaultbee.streampack.internal.muxers.flv.packet

import android.media.MediaFormat
import io.github.thibaultbee.streampack.data.AudioConfig
import java.nio.ByteBuffer

class AudioSpecificConfig(
    private val decoderSpecificInformation: ByteBuffer,
    private val audioConfig: AudioConfig
) {
    fun write(buffer: ByteBuffer) {
        if (audioConfig.mimeType == MediaFormat.MIMETYPE_AUDIO_AAC) {
            buffer.put(decoderSpecificInformation)
        } else {
            throw NotImplementedError("No support for ${audioConfig.mimeType}")
        }
    }
}
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
package io.github.thibaultbee.streampack.internal.muxers.ts.descriptors

import io.github.thibaultbee.streampack.internal.utils.extractArray
import io.github.thibaultbee.streampack.utils.ResourcesUtils
import org.junit.Assert.assertArrayEquals
import org.junit.Test
import java.nio.ByteBuffer

class AdaptationFieldTest {

    @Test
    fun `adaptation field with pcr`() {
        val expectedAdaptationField = ByteBuffer.wrap(
            ResourcesUtils.readResources("test-samples/muxer/adaptation-field.ts")
        )

        val adaptationField = AdaptationField(
            discontinuityIndicator = false,
            randomAccessIndicator = true,
            elementaryStreamPriorityIndicator = false,
            programClockReference = 13895163261,
            originalProgramClockReference = null,
            spliceCountdown = null,
            transportPrivateData = null,
            adaptationFieldExtension = null
        )

        assertArrayEquals(
            expectedAdaptationField.array(),
            adaptationField.toByteBuffer().extractArray()
        )
    }
}
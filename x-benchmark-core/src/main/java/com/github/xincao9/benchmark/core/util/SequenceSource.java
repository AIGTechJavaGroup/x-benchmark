/*
 * Copyright 2018 xingyunzhi.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.xincao9.benchmark.core.util;

import com.github.xincao9.benchmark.core.interfaces.Source;
import com.github.xincao9.benchmark.core.service.TaskPoolService;

/**
 *
 * @author xincao9@gmail.com
 */
public class SequenceSource implements Source {

    private static final TaskPoolService taskPool = TaskPoolService.getInstance();
    private final int max;

    public SequenceSource(int max) {
        this.max = max;
    }

    @Override
    public int read() {
        for (int i = 1; i <= max; i++) {
            try {
                taskPool.add(i);
            } catch (InterruptedException ex) {
                return -1;
            }
        }
        return max;
    }
}

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
package com.github.xincao9.redis;

import com.github.xincao9.benchmark.core.XBenchmarkCore;
import com.github.xincao9.benchmark.core.util.SequenceSource;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.JedisPool;

/**
 *
 * @author xincao9@gmail.com
 */
public class XBenchmarkRedis {

    private static JedisPool jedisPool;

    public static void main(String... args) {
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
        genericObjectPoolConfig.setMaxTotal(128);
        jedisPool = new JedisPool(genericObjectPoolConfig, "172.31.128.236", 6379);
        XBenchmarkCore.bootstrap(new SequenceSource(1000000), args);
        jedisPool.close();
    }

    public static JedisPool getJedisPool() {
        return jedisPool;
    }

}

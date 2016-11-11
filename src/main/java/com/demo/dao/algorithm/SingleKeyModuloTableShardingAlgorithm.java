/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
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
 * </p>
 */

package com.demo.dao.algorithm;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;

public final class SingleKeyModuloTableShardingAlgorithm implements SingleKeyTableShardingAlgorithm<String> {
	
	@Override
	public String doEqualSharding(final Collection<String> availableTargetNames, final ShardingValue<String> shardingValue) {
		for (String each : availableTargetNames) {
			if (each.endsWith(Integer.parseInt(shardingValue.getValue().substring(shardingValue.getValue().length()-1, shardingValue.getValue().length())) % 2 + "")) {
				return each;
			}
		}
		throw new UnsupportedOperationException();
	}
	
	@Override
	public Collection<String> doInSharding(final Collection<String> availableTargetNames, final ShardingValue<String> shardingValue) {
		Collection<String> result = new LinkedHashSet<>(availableTargetNames.size());
		Collection<String> values = shardingValue.getValues();
		for (String value : values) {
			for (String tableNames : availableTargetNames) {
				if (tableNames.endsWith(Integer.parseInt(value.substring(value.length()-1, value.length())) % 2 + "")) {
					result.add(tableNames);
				}
			}
		}
		return result;
	}
	
	@Override
	public Collection<String> doBetweenSharding(final Collection<String> availableTargetNames, final ShardingValue<String> shardingValue) {
		Collection<String> result = new LinkedHashSet<>(availableTargetNames.size());
		Collection<String> values = shardingValue.getValues();
		
		List<String> valueList = (List<String>) values;
		String beginStr = valueList.get(0);
		Integer beginInt = Integer.parseInt(beginStr.substring(beginStr.length()-1, beginStr.length()));
		String endStr = valueList.get(1);
		Integer endInt = Integer.parseInt(endStr.substring(endStr.length()-1, endStr.length()));
		
		for (Integer i = beginInt; i <= endInt; i++) {
			for (String each : availableTargetNames) {
				if (each.endsWith(i % 2 + "")) {
					result.add(each);
				}
			}
		}
		return result;
	}
	
}

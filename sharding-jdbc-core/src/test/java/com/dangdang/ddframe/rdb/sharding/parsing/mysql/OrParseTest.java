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

package com.dangdang.ddframe.rdb.sharding.parsing.mysql;

import com.dangdang.ddframe.rdb.sharding.api.fixture.ShardingRuleMockBuilder;
import com.dangdang.ddframe.rdb.sharding.constant.DatabaseType;
import com.dangdang.ddframe.rdb.sharding.parsing.AbstractBaseParseTest;
import com.dangdang.ddframe.rdb.sharding.parsing.SQLParsingEngine;
import com.dangdang.ddframe.rdb.sharding.parsing.parser.context.Condition;
import com.dangdang.ddframe.rdb.sharding.parsing.parser.context.table.Table;
import com.dangdang.ddframe.rdb.sharding.parsing.parser.statement.SQLStatement;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public final class OrParseTest extends AbstractBaseParseTest {
    
    public OrParseTest(
            final String testCaseName, final String sql, final String expectedSQL,
            final Collection<Table> expectedTables, final List<Condition> expectedConditions, final SQLStatement expectedSQLStatement) {
        super(testCaseName, sql, expectedSQL, expectedTables, expectedConditions, expectedSQLStatement);
    }
    
    @Parameters(name = "{0}")
    public static Collection<Object[]> dataParameters() {
        return AbstractBaseParseTest.dataParameters("com/dangdang/ddframe/rdb/sharding/parsing/mysql/or/");
    }
    
    // TODO 归并字段，整合进mySQL测试
    // TODO 暂时不支持or
    @Test
    @Ignore
    public void assertParse() {
        new SQLParsingEngine(DatabaseType.MySQL, getSql(), new ShardingRuleMockBuilder()
                .addShardingColumns("id").addShardingColumns("user_id").addShardingColumns("name").addShardingColumns("age")
                .addShardingColumns("days").addShardingColumns("fee").addShardingColumns("travel_date").addShardingColumns("long").build()).parse();
    }
}

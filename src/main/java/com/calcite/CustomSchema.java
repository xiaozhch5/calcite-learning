package com.calcite;

import com.google.common.collect.ImmutableMap;
import org.apache.calcite.schema.Table;
import org.apache.calcite.schema.impl.AbstractSchema;
import org.apache.calcite.util.Source;
import org.apache.calcite.util.Sources;


import java.net.URL;
import java.util.Map;

/**
 * Created by zhchxiao on 2019-10-17.
 */
public class CustomSchema extends AbstractSchema {
    private Map<String, Table> tableMap;

    @Override
    protected Map<String, Table> getTableMap(){
        URL url = CustomSchema.class.getResource("/data.csv");
        Source source = Sources.of(url);
        if(tableMap == null){
            final ImmutableMap.Builder<String, Table> builder = ImmutableMap.builder();
            builder.put("TEST01", new CustomTable(source));
            tableMap = builder.build();
        }
        return tableMap;
    }
}

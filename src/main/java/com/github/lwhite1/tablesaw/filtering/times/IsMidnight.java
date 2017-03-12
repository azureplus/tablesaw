package com.github.lwhite1.tablesaw.filtering.times;

import com.github.lwhite1.tablesaw.api.ColumnType;
import com.github.lwhite1.tablesaw.api.DateTimeColumn;
import com.github.lwhite1.tablesaw.api.Table;
import com.github.lwhite1.tablesaw.api.TimeColumn;
import com.github.lwhite1.tablesaw.columns.Column;
import com.github.lwhite1.tablesaw.columns.ColumnReference;
import com.github.lwhite1.tablesaw.filtering.ColumnFilter;
import com.github.lwhite1.tablesaw.util.Selection;

/**
 *
 */
public class IsMidnight extends ColumnFilter {

    public IsMidnight(ColumnReference reference) {
        super(reference);
    }

    @Override
    public Selection apply(Table relation) {

        String name = columnReference().getColumnName();
        Column column = relation.column(name);
        ColumnType type = column.type();
        switch (type) {
            case LOCAL_TIME:
                TimeColumn timeColumn = relation.timeColumn(name);
                return timeColumn.isMidnight();
            case LOCAL_DATE_TIME:
                DateTimeColumn dateTimeColumn = relation.dateTimeColumn(name);
                return dateTimeColumn.isMidnight();
            default:
                throw new UnsupportedOperationException("Columns of type " + type.name() + " do not support the operation "
                        + "isMidnight() ");
        }
    }
}

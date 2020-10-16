/*
 * Copyright (C) 2016 Lizhe Yan.
 * 
 * Author: Lizhe Yan <yanlizhe@sina.com>
 * 
 * This file is part of sql-formater.
 * 
 * sql-formater is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public 
 * License as published by the Free Software Foundation, either 
 * version 3 of the License, or (at your option) any later 
 * version.
 * 
 * sql-formater is distributed in the hope that it will be 
 * useful, but WITHOUT ANY WARRANTY; without even the implied 
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR 
 * PURPOSE. See the GNU Lesser General Public License for more 
 * details.
 * 
 * You should have received a copy of the GNU Lesser General 
 * Public License along with sql-formater. 
 * If not, see <https://www.gnu.org/licenses/>.
 * 
 */

package net.xx.sqlFormater.statement.dialec;

import java.util.Date;

import org.springframework.util.StringUtils;

import net.xx.sqlFormater.SqlBeanFactory;
import net.xx.sqlFormater.enumerate.ConditionType;
import net.xx.sqlFormater.filter.GeneralFilterExecute;
import net.xx.sqlFormater.filter.StandardFilterExecute;
import net.xx.sqlFormater.filter.StandardFilterExecuteWrapper;
import net.xx.sqlFormater.statement.StandardStatementUpdate;

public abstract class AbsStandardUpdate extends AbsGeneralUpdate 
		implements StandardStatementUpdate {
	
	protected AbsStandardUpdate(StandardFilterExecute filter) {
		super(null);
		if (null != filter) {
			setStandardFilterExecute(filter);
		}
	}

	protected AbsStandardUpdate(String filter, String formater) {
		super(null, formater);
		if(SqlBeanFactory.hasName(filter)) {
			setStandardFilterExecute(SqlBeanFactory.getBean(filter, StandardFilterExecute.class));
		}
	}

	@Override
	public final GeneralFilterExecute getGeneralFilterExecute() {
		StandardFilterExecute filter = getStandardFilterExecute();
		if (filter instanceof StandardFilterExecuteWrapper) {
			filter = ((StandardFilterExecuteWrapper) filter).getSource();
		}
		return (GeneralFilterExecute) filter;
	}
	
	@Override
	public final void setGeneralFilterExecute(GeneralFilterExecute generalFilterExecute) {
		setStandardFilterExecute((StandardFilterExecute) generalFilterExecute);
	}

	

	@Override
	public void setTable(String table) {
		final StringBuilder sql = new StringBuilder();
		sql.append(getOpenQuote());
		sql.append(table);
		sql.append(getCloseQuote());
		setRawFrom(sql.toString());
	}

	@Override
	public void setNullValue(String column) {
		final StringBuilder sql = new StringBuilder();
		sql.append(getOpenQuote());
		sql.append(column);
		sql.append(getCloseQuote());
		sql.append(" = null");
		pushRawSet(sql.toString());
	}

	@Override
	public void setValue(String column, Object value) {
		final StringBuilder sql = new StringBuilder();
		sql.append(getOpenQuote());
		sql.append(column);
		sql.append(getCloseQuote());
		sql.append(" = ?");
		pushRawSet(sql.toString());
		pushRawValue(value);
	}

	@Override
	public void setByteValue(String column, Byte value) {
		if (null == value) {
			setNullValue(column);
		} else {
			setValue(column, value);
		}
	}

	@Override
	public void setShortValue(String column, Short value) {
		if (null == value) {
			setNullValue(column);
		} else {
			setValue(column, value);
		}
	}

	@Override
	public void setIntegerValue(String column, Integer value) {
		if (null == value) {
			setNullValue(column);
		} else {
			setValue(column, value);
		}
	}

	@Override
	public void setLongValue(String column, Long value) {
		if (null == value) {
			setNullValue(column);
		} else {
			setValue(column, value);
		}
	}

	@Override
	public void setFloatValue(String column, Float value) {
		if (null == value) {
			setNullValue(column);
		} else {
			setValue(column, value);
		}
	}

	@Override
	public void setDoubleValue(String column, Double value) {
		if (null == value) {
			setNullValue(column);
		} else {
			setValue(column, value);
		}
	}

	@Override
	public void setStringValue(String column, String value) {
		if (StringUtils.isEmpty(value)) {
			setNullValue(column);
		} else {
			setValue(column, value);
		}
	}

	@Override
	public void pushNullCondition(String column) {
		getStandardFilterExecute().pushNullCondition(column);
	}

	@Override
	public void pushNotNullCondition(String column) {
		getStandardFilterExecute().pushNotNullCondition(column);
	}

	@Override
	public void pushCondition(String column, String statment) {
		getStandardFilterExecute().pushCondition(column, statment);
	}

	@Override
	public void pushEqualByte(String column, Byte value) {
		getStandardFilterExecute().pushEqualByte(column, value);
	}

	@Override
	public void pushEqualShort(String column, Short value) {
		getStandardFilterExecute().pushEqualShort(column, value);
	}

	@Override
	public void pushEqualInteger(String column, Integer value) {
		getStandardFilterExecute().pushEqualInteger(column, value);
	}

	@Override
	public void pushEqualLong(String column, Long value) {
		getStandardFilterExecute().pushEqualLong(column, value);
	}

	@Override
	public void pushEqualFloat(String column, Float value) {
		getStandardFilterExecute().pushEqualFloat(column, value);
	}

	@Override
	public void pushEqualDouble(String column, Double value) {
		getStandardFilterExecute().pushEqualDouble(column, value);
	}

	@Override
	public void pushEqualString(String column, String value) {
		getStandardFilterExecute().pushEqualString(column, value);
	}

	@Override
	public void pushArgument(String column, ConditionType condition, Object value) {
		getStandardFilterExecute().pushArgument(column, condition, value);
	}

	@Override
	public void pushEqualDate(String column, Date value) {
		getStandardFilterExecute().pushEqualDate(column, value);
	}

	@Override
	public void pushEqualDateTime(String column, Date value) {
		getStandardFilterExecute().pushEqualDateTime(column, value);
	}

	@Override
	public void pushLargeThenDate(String column, Date value) {
		getStandardFilterExecute().pushLargeThenDate(column, value);
	}

	@Override
	public void pushLargeThenDateTime(String column, Date value) {
		getStandardFilterExecute().pushLargeThenDateTime(column, value);
	}

	@Override
	public void pushSmallThenDate(String column, Date value) {
		getStandardFilterExecute().pushSmallThenDate(column, value);
	}

	@Override
	public void pushSmallThenDateTime(String column, Date value) {
		getStandardFilterExecute().pushSmallThenDateTime(column, value);
	}

	@Override
	public void pushBetweenDate(String column, Date start, Date end) {
		getStandardFilterExecute().pushBetweenDate(column, start, end);
	}

	@Override
	public void pushBetweenDateTime(String column, Date start, Date end) {
		getStandardFilterExecute().pushBetweenDateTime(column, start, end);
	}

}

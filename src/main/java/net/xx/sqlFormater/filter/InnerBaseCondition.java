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

package net.xx.sqlFormater.filter;

import java.util.List;

public interface InnerBaseCondition {
	
	/**
	 * 获取当前的搜索条件列表
	 * @param generated 如果没有，是否需要新建
	 * @return 内容列表
	 */
	public List<String> getBaseCondition(boolean generated);
	
	/**
	 * 获取当前的参数列表
	 * @param generated 如果没有，是否需要新建
	 * @return 内容列表
	 */
	public List<Object> getBaseArgs(boolean generated);

}

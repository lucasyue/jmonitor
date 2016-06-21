package com.sfit.model;

import java.sql.Connection;

import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

public abstract class BaseType {
	// 定义的类型名称,必须为大写
	public abstract String getDefinedTypeName();

	// 将JOPO中的数据装换成数组
	protected abstract Object[] toArray();

	// 读取数组,转换成JOPO中的数据
	protected abstract void fromArray(Object[] array);

	// 从Struct中解析数据
	public void fromStruct(STRUCT struct) throws Exception {
		try {
			fromArray(struct.getAttributes());
		} catch (Exception e) {
			throw new Exception("从Struct中解析数据失败",e);
		}
	}

	// 将数据转换成Struct
	public oracle.sql.STRUCT toStruct(Connection connection) throws Exception {
		try {
			StructDescriptor descriptor = StructDescriptor.createDescriptor(
					getDefinedTypeName(), connection);
			STRUCT struct = new STRUCT(descriptor, connection, toArray());
			return struct;
		} catch (Exception e) {
			if(connection==null){
				throw new Exception("没有数据库连接",e);
			}else{
				throw new Exception("将数据转换成Struct失败",e);
			}
		}
	}
	
	//跨用户掉对象（转换）
	public oracle.sql.STRUCT toStruct(Connection connection,String settleadmin) throws Exception {
		try {
			StructDescriptor descriptor = StructDescriptor.createDescriptor(
					settleadmin, connection);
			STRUCT struct = new STRUCT(descriptor, connection, toArray());
			return struct;
		} catch (Exception e) {
			if(connection==null){
				throw new Exception("没有数据库连接",e);
			}else{
				throw new Exception("跨用户掉对象（转换）失败",e);
			}
		}
	}
}
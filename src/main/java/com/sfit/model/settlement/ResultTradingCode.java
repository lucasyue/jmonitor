package com.sfit.model.settlement;

import com.bstek.dorado.annotation.PropertyDef;
import com.sfit.model.BaseType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResultTradingCode extends BaseType
{
	@PropertyDef(label="经纪公司代码",required=true )
	private String brokerID;
	@PropertyDef(label="投资者代码",required=true )
	private String investorID;
	@PropertyDef(label="投资单元代码",required=true )
	private String investUnitID;
	@PropertyDef(label="交易所代码",required=true )
	private String exchangeID;
	@PropertyDef(label="交易编码",required=true )
	private String clientID;
	@PropertyDef(label="是否活跃",required=true )
	private Integer isActive;
	@PropertyDef(label="开户日期")
	private String openDate;
	@PropertyDef(label="注销日期")
	private String cancelDate;
	@PropertyDef(label="来源类型")
	private String codeSourceType;
	@PropertyDef(label="编码类型")
	private String clientIDType;
	@PropertyDef(label="开户证件类型",required=true )
	private String openCardType;
	@PropertyDef(label="开户证件号码",required=true )
	private String openCardNo;
	@PropertyDef(label="联系地址")
	private String address;
	@PropertyDef(label="休眠状态")
	private String freezeStatus;
	@PropertyDef(label="投资者属性")
	private String propertyString;
	@PropertyDef(label="是否限制开仓权限")
	private Integer isOpenLimit;
	@PropertyDef(label="录入员代码")
	private String operatorID;
	@PropertyDef(label="录入日期")
	private String operateDate;
	@PropertyDef(label="录入时间")
	private String operateTime;
  
	public ResultTradingCode()
	{
	}
  
	//定义的类型名称
	public String getDefinedTypeName()
	{
		return "Ty_ResultTradingCode".toUpperCase();
	}
  
	//将JOPO中的数据装换成数组,必须严格按照结构的定义次序
	protected Object[] toArray()
	{
		Object array[] = new Object[19];
		array[0] = getBrokerID();
		array[1] = getInvestorID();
		array[2] = getInvestUnitID();
		array[3] = getExchangeID();
		array[4] = getClientID();
		array[5] = getIsActive();
		array[6] = getOpenDate();
		array[7] = getCancelDate();
		array[8] = getCodeSourceType();
		array[9] = getClientIDType();
		array[10] = getOpenCardType();
		array[11] = getOpenCardNo();
		array[12] = getAddress();
		array[13] = getFreezeStatus();
		array[14] = getPropertyString();
		array[15] = getIsOpenLimit();
		array[16] = getOperatorID();
		array[17] = getOperateDate();
		array[18] = getOperateTime();

		return array;
	}
  
	//读取数组,转换成JOPO中的数据
	protected void fromArray(Object[] array)
	{
		if (array[0] != null)
		  setBrokerID(String.valueOf(array[0].toString().trim()));
		else
		  setBrokerID(null);
		if (array[1] != null)
		  setInvestorID(String.valueOf(array[1].toString().trim()));
		else
		  setInvestorID(null);
		if (array[2] != null)
		  setInvestUnitID(String.valueOf(array[2].toString().trim()));
		else
		  setInvestUnitID(null);
		if (array[3] != null)
		  setExchangeID(String.valueOf(array[3].toString().trim()));
		else
		  setExchangeID(null);
		if (array[4] != null)
		  setClientID(String.valueOf(array[4].toString().trim()));
		else
		  setClientID(null);
		if (array[5] != null)
		  setIsActive(Integer.valueOf(array[5].toString().trim()));
		else
		  setIsActive(null);
		if (array[6] != null)
		  setOpenDate(String.valueOf(array[6].toString().trim()));
		else
		  setOpenDate(null);
		if (array[7] != null)
		  setCancelDate(String.valueOf(array[7].toString().trim()));
		else
		  setCancelDate(null);
		if (array[8] != null)
		  setCodeSourceType(String.valueOf(array[8].toString().trim()));
		else
		  setCodeSourceType(null);
		if (array[9] != null)
		  setClientIDType(String.valueOf(array[9].toString().trim()));
		else
		  setClientIDType(null);
		if (array[10] != null)
		  setOpenCardType(String.valueOf(array[10].toString().trim()));
		else
		  setOpenCardType(null);
		if (array[11] != null)
		  setOpenCardNo(String.valueOf(array[11].toString().trim()));
		else
		  setOpenCardNo(null);
		if (array[12] != null)
		  setAddress(String.valueOf(array[12].toString().trim()));
		else
		  setAddress(null);
		if (array[13] != null)
		  setFreezeStatus(String.valueOf(array[13].toString().trim()));
		else
		  setFreezeStatus(null);
		if (array[14] != null)
		  setPropertyString(String.valueOf(array[14].toString().trim()));
		else
		  setPropertyString(null);
		if (array[15] != null)
		  setIsOpenLimit(Integer.valueOf(array[15].toString().trim()));
		else
		  setIsOpenLimit(null);
		if (array[16] != null)
		  setOperatorID(String.valueOf(array[16].toString().trim()));
		else
		  setOperatorID(null);
		if (array[17] != null)
		  setOperateDate(String.valueOf(array[17].toString().trim()));
		else
		  setOperateDate(null);
		if (array[18] != null)
		  setOperateTime(String.valueOf(array[18].toString().trim()));
		else
		  setOperateTime(null);
	}
  
	//经纪公司代码
	public void setBrokerID(String brokerID)
	{
		if(brokerID != null){
			String reg = "[\n-\r]";
			Pattern p = Pattern.compile(reg);
			Matcher m = p.matcher(brokerID.toString().trim()); 
			this.brokerID = m.replaceAll("");
		}else{
			this.brokerID = brokerID;
		}
	}

	public String getBrokerID()
	{
		return brokerID;
	}
	
	//投资者代码
	public void setInvestorID(String investorID)
	{
		if(investorID != null){
			String reg = "[\n-\r]";
			Pattern p = Pattern.compile(reg);
			Matcher m = p.matcher(investorID.toString().trim()); 
			this.investorID = m.replaceAll("");
		}else{
			this.investorID = investorID;
		}
	}

	public String getInvestorID()
	{
		return investorID;
	}
	
	//投资单元代码
	public void setInvestUnitID(String investUnitID)
	{
		if(investUnitID != null){
			String reg = "[\n-\r]";
			Pattern p = Pattern.compile(reg);
			Matcher m = p.matcher(investUnitID.toString().trim()); 
			this.investUnitID = m.replaceAll("");
		}else{
			this.investUnitID = investUnitID;
		}
	}

	public String getInvestUnitID()
	{
		return investUnitID;
	}
	
	//交易所代码
	public void setExchangeID(String exchangeID)
	{
		if(exchangeID != null){
			String reg = "[\n-\r]";
			Pattern p = Pattern.compile(reg);
			Matcher m = p.matcher(exchangeID.toString().trim()); 
			this.exchangeID = m.replaceAll("");
		}else{
			this.exchangeID = exchangeID;
		}
	}

	public String getExchangeID()
	{
		return exchangeID;
	}
	
	//交易编码
	public void setClientID(String clientID)
	{
		if(clientID != null){
			String reg = "[\n-\r]";
			Pattern p = Pattern.compile(reg);
			Matcher m = p.matcher(clientID.toString().trim()); 
			this.clientID = m.replaceAll("");
		}else{
			this.clientID = clientID;
		}
	}

	public String getClientID()
	{
		return clientID;
	}
	
	//是否活跃
	public void setIsActive(Integer isActive)
	{
		this.isActive = isActive;
	}

	public Integer getIsActive()
	{
		return isActive;
	}
	
	//开户日期
	public void setOpenDate(String openDate)
	{
		if(openDate != null){
			String reg = "[\n-\r]";
			Pattern p = Pattern.compile(reg);
			Matcher m = p.matcher(openDate.toString().trim()); 
			this.openDate = m.replaceAll("");
		}else{
			this.openDate = openDate;
		}
	}

	public String getOpenDate()
	{
		return openDate;
	}
	
	//注销日期
	public void setCancelDate(String cancelDate)
	{
		if(cancelDate != null){
			String reg = "[\n-\r]";
			Pattern p = Pattern.compile(reg);
			Matcher m = p.matcher(cancelDate.toString().trim()); 
			this.cancelDate = m.replaceAll("");
		}else{
			this.cancelDate = cancelDate;
		}
	}

	public String getCancelDate()
	{
		return cancelDate;
	}
	
	//来源类型
	public void setCodeSourceType(String codeSourceType)
	{
		if(codeSourceType != null){
			String reg = "[\n-\r]";
			Pattern p = Pattern.compile(reg);
			Matcher m = p.matcher(codeSourceType.toString().trim()); 
			this.codeSourceType = m.replaceAll("");
		}else{
			this.codeSourceType = codeSourceType;
		}
	}

	public String getCodeSourceType()
	{
		return codeSourceType;
	}
	
	//编码类型
	public void setClientIDType(String clientIDType)
	{
		if(clientIDType != null){
			String reg = "[\n-\r]";
			Pattern p = Pattern.compile(reg);
			Matcher m = p.matcher(clientIDType.toString().trim()); 
			this.clientIDType = m.replaceAll("");
		}else{
			this.clientIDType = clientIDType;
		}
	}

	public String getClientIDType()
	{
		return clientIDType;
	}
	
	//开户证件类型
	public void setOpenCardType(String openCardType)
	{
		if(openCardType != null){
			String reg = "[\n-\r]";
			Pattern p = Pattern.compile(reg);
			Matcher m = p.matcher(openCardType.toString().trim()); 
			this.openCardType = m.replaceAll("");
		}else{
			this.openCardType = openCardType;
		}
	}

	public String getOpenCardType()
	{
		return openCardType;
	}
	
	//开户证件号码
	public void setOpenCardNo(String openCardNo)
	{
		if(openCardNo != null){
			String reg = "[\n-\r]";
			Pattern p = Pattern.compile(reg);
			Matcher m = p.matcher(openCardNo.toString().trim()); 
			this.openCardNo = m.replaceAll("");
		}else{
			this.openCardNo = openCardNo;
		}
	}

	public String getOpenCardNo()
	{
		return openCardNo;
	}
	
	//联系地址
	public void setAddress(String address)
	{
		if(address != null){
			String reg = "[\n-\r]";
			Pattern p = Pattern.compile(reg);
			Matcher m = p.matcher(address.toString().trim()); 
			this.address = m.replaceAll("");
		}else{
			this.address = address;
		}
	}

	public String getAddress()
	{
		return address;
	}
	
	//休眠状态
	public void setFreezeStatus(String freezeStatus)
	{
		if(freezeStatus != null){
			String reg = "[\n-\r]";
			Pattern p = Pattern.compile(reg);
			Matcher m = p.matcher(freezeStatus.toString().trim()); 
			this.freezeStatus = m.replaceAll("");
		}else{
			this.freezeStatus = freezeStatus;
		}
	}

	public String getFreezeStatus()
	{
		return freezeStatus;
	}
	
	//投资者属性
	public void setPropertyString(String propertyString)
	{
		if(propertyString != null){
			String reg = "[\n-\r]";
			Pattern p = Pattern.compile(reg);
			Matcher m = p.matcher(propertyString.toString().trim()); 
			this.propertyString = m.replaceAll("");
		}else{
			this.propertyString = propertyString;
		}
	}

	public String getPropertyString()
	{
		return propertyString;
	}
	
	//是否限制开仓权限
	public void setIsOpenLimit(Integer isOpenLimit)
	{
		this.isOpenLimit = isOpenLimit;
	}

	public Integer getIsOpenLimit()
	{
		return isOpenLimit;
	}
	
	//录入员代码
	public void setOperatorID(String operatorID)
	{
		if(operatorID != null){
			String reg = "[\n-\r]";
			Pattern p = Pattern.compile(reg);
			Matcher m = p.matcher(operatorID.toString().trim()); 
			this.operatorID = m.replaceAll("");
		}else{
			this.operatorID = operatorID;
		}
	}

	public String getOperatorID()
	{
		return operatorID;
	}
	
	//录入日期
	public void setOperateDate(String operateDate)
	{
		if(operateDate != null){
			String reg = "[\n-\r]";
			Pattern p = Pattern.compile(reg);
			Matcher m = p.matcher(operateDate.toString().trim()); 
			this.operateDate = m.replaceAll("");
		}else{
			this.operateDate = operateDate;
		}
	}

	public String getOperateDate()
	{
		return operateDate;
	}
	
	//录入时间
	public void setOperateTime(String operateTime)
	{
		if(operateTime != null){
			String reg = "[\n-\r]";
			Pattern p = Pattern.compile(reg);
			Matcher m = p.matcher(operateTime.toString().trim()); 
			this.operateTime = m.replaceAll("");
		}else{
			this.operateTime = operateTime;
		}
	}

	public String getOperateTime()
	{
		return operateTime;
	}
	
}

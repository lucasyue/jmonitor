package cn.yandz.monitor;

import java.lang.instrument.Instrumentation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

import com.sfit.model.settlement.ResultTradingCode;

import net.sf.json.JSONObject;  
  
/** 
 * 对象占用字节大小工具类 
 * 
 * @date 2014-03-18 11:29 
 */  
class Obj{
	//private int i;//16+4+4=24
//	private  Integer ii	;//16+4+8+(28%8)=32
//	public int getI() {
//		return i;
//	}
//	public void setI(int i) {
//		this.i = i;
//	}
//
//	public Integer getIi() {
//		return ii;
//	}
//	public void setIi(Integer ii) {
//		this.ii = ii;
//	}
	private String name;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}	
}
public class SizeOfObjectUtils {
    static Instrumentation inst;
    public static void premain(String args, Instrumentation instP) {  
        inst = instP;
        Obj a=new Obj();
        long size=sizeOf(a);
        a.setName("dfsadfdd");
        System.out.println(new Date().getTime()+"对象A占内存大小为："+size);
        System.out.println(new Date().getTime()+"对象Integer占内存大小为："+sizeOf(new Integer(1)));
//		long size=sizeOf(new ResultTradingCode());
		long fullsize = 0;
		try {
			String data="{'brokerID':'2016',"+
					"'investorID':'000001','investUnitID':'000001','exchangeID':'CFFEX',"+
					"'clientID':'00003','isActive':1,'openDate':'20160201','cancelDate':null,"+
					"'codeSourceType':'0','clientIDType':'2','openCardType':null,'openCardNo':null,"+
					"'address':null,'freezeStatus':'1','propertyString':'\u6D66\u4E1C','isOpenLimit':null,"+
					"'operatorID':null,'operateDate':null,'operateTime':null}";
			JSONObject obj=JSONObject.fromObject(data);
			ResultTradingCode rs=(ResultTradingCode) JSONObject.toBean(obj, ResultTradingCode.class);
			fullsize = fullSizeOf(rs);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		System.out.println("对象com.sfit.model.settlement.ResultTradingCode.ResultTradingCode占用字节数为\n：");
		System.out.println(fullsize+"bytes");
    }  
  
    /** 
     * 直接计算当前对象占用空间大小，包括当前类及超类的基本类型实例字段大小、<br></br> 
     * 引用类型实例字段引用大小、实例基本类型数组总占用空间、实例引用类型数组引用本身占用空间大小;<br></br> 
     * 但是不包括超类继承下来的和当前类声明的实例引用字段的对象本身的大小、实例引用数组引用的对象本身的大小 <br></br> 
     * 
     * @param obj 
     * @return 
     */  
    public static long sizeOf(Object obj) {  
        long size= inst.getObjectSize(obj);  
        System.out.println(obj.getClass().getSimpleName());
        System.out.println(obj.getClass().getName()+":"+obj+" size:"+size);
        return size;
    }  
  
    /** 
     * 递归计算当前对象占用空间总大小，包括当前类和超类的实例字段大小以及实例字段引用对象大小 
     * 
     * @param objP
     * @return 
     * @throws IllegalAccessException 
     */  
    public static long fullSizeOf(Object objP) throws IllegalAccessException {  
        Set<Object> visited = new HashSet<Object>();  
        Deque<Object> toBeQueue = new ArrayDeque<Object>();  
        toBeQueue.add(objP);  
        long size = 0L;  
        while (toBeQueue.size() > 0) {  
            Object obj = toBeQueue.poll();  
            //sizeOf的时候已经计基本类型和引用的长度，包括数组  
            size += skipObject(visited, obj) ? 0L : sizeOf(obj);
            visited.add(objP);
            Class<?> tmpObjClass = obj.getClass();  
            if (tmpObjClass.isArray()) {  
                //[I , [F 基本类型名字长度是2  
                if (tmpObjClass.getName().length() > 2) {  
                    for (int i = 0, len = Array.getLength(obj); i < len; i++) {  
                        Object tmp = Array.get(obj, i);  
                        if (tmp != null) {  
                            //非基本类型需要深度遍历其对象  
                            toBeQueue.add(Array.get(obj, i));  
                        }  
                    }  
                }  
            } else {//对象字段和父类  
                while (tmpObjClass != null) {  
                    Field[] fields = tmpObjClass.getDeclaredFields();  
                    for (Field field : fields) {  
                        if (Modifier.isStatic(field.getModifiers())   //静态不计  
                                || field.getType().isPrimitive()) {    //基本类型不重复计  
                            continue;  
                        }  
  
                        field.setAccessible(true);  
                        Object fieldValue = field.get(obj);  
                        if (fieldValue == null) {  
                            continue;  
                        }  
                        toBeQueue.add(fieldValue);  
                    }  
                    tmpObjClass = tmpObjClass.getSuperclass();  
                }  
            }  
        }  
        return size;  
    }  
  
    /** 
     * String.intern的对象不计；计算过的不计，也避免死循环 
     * 
     * @param visited 
     * @param obj 
     * @return 
     */  
    static boolean skipObject(Set<Object> visited, Object obj) {  
        if (obj instanceof String && obj == ((String) obj).intern()) {  
            return true;  
        }  
        return visited.contains(obj);  
    }  
}
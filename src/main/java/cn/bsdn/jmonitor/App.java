package cn.bsdn.jmonitor;

import static java.lang.System.out;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import com.sfit.model.settlement.ResultTradingCode;

import net.sf.json.JSONObject;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws Exception {
        out.println(VM.current().details());
        A a=new A();
        a.f=true;
        out.println(ClassLayout.parseInstance(a).toPrintable());
        String data="{'brokerID':'2016',"+
				"'investorID':'000001','investUnitID':'000001','exchangeID':'CFFEX',"+
				"'clientID':'00003','isActive':1,'openDate':'20160201','cancelDate':'2016-06-17',"+
				"'codeSourceType':'0','clientIDType':'2','openCardType':'111','openCardNo':'11111',"+
				"'address':'xxxxxxxx','freezeStatus':'1','propertyString':'\u6D66\u4E1C','isOpenLimit':'1',"+
				"'operatorID':'12456','operateDate':'2016-06-17','operateTime':'16:59:11'}";
		JSONObject obj=JSONObject.fromObject(data);
		ResultTradingCode rs=(ResultTradingCode) JSONObject.toBean(obj, ResultTradingCode.class);
        out.println(ClassLayout.parseInstance(rs).toPrintable());
    }

    public static class A {
        boolean f;
    }
}

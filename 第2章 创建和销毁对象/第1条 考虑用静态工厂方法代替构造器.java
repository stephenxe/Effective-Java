//静态工厂方法与构造器不同的第一大优势在于，它们有名称
//静态工厂方法与构造器不同的第二大优势在于，不必在每次调用它们的时候都创建一个新对象 eg  Singleton
//静态工厂方法与构造器不同的第一大优势在于，它们可以返回原返回类型的任何子类型的对象 eg 基于接口的框架
//服务提供者框架三个组件： 服务接口(Service Interface) 提供者注册API 服务访问API
//Service provider framework sketch
//Service Interface
public interface Service {
  method1();//Service-specific methods go here
}
//Service provider interface
public interface Provider {
  Service newService();
}
//Noninstantiable class for service registeration and access
public class Services {
  private Services(){}//Prevents instantiation

  //Maps service names to services
  private static final Map<String, Provider> providers=
    new ConcurrentHashMap<String, Provider>();
  public static final String DEFAULT_PROVIDER_NAME = "<def>";
  //Provider registeration API
  public static void registerDefaultProvider(Provider p){
    registerProvider(DEFAULT_PROVIDER_NAME,p);
  }
  public static void registerProvider(String name,Provider p){
    provider.put(name,p);
  }
  //Service access API
  public static Service newInstance(){
    return newInstance(DEFAULT_PROVIDER_NAME);
  }
  public static Service newInstance(String name){
    Provider p=provider.get(name);
    if (p==null)
      throw new IllegalArgumentException(
      "No Provider registered with name: "+name);
    return p.newService();
  }
}
//静态工厂方法与构造器不同的第一大优势在于，在创建参数化类型实例的时候，它们是代码变得更加简洁
Map<String,List<String>> m=new HashMap<String,List<String>>();

public static <K,V> HashMap<K,V> newInstance(){
  return new HashMap<K,V>();
}
Map<String,List<String>> m=HashMap.newInstance();
//静态工厂方法的主要缺点在于，类如果不含公有的或者受保护的构造器，就不能被子类化
//静态工厂方法的主要缺点在于，它们与其它的静态方法实际上没有任何区别
//惯用名称：valueof  of  getInstance  newInstance  getType  newType

//总结，首先考虑警惕工厂方法，而不是提供公有的构造器。

//实现Singleton有两种方法，都要把构造器保持为私有的，并导出公有的静态成员，
//1.公有静态成员 final域
//Singleton with public final field
public class Elvis{
  public static final Elvis INSTANCE = new Elvis();
  private Elvis(){...}

  public void leaveTheBuilding(){...}
}

//2.公有成员诗歌静态工厂方法
//Singleton with static factory
public class Elvis{
  private static final Elvis INSTANCE = new Elvis();
  private Elvis(){...}
  public static Elvis getInstance(){return INSTANCE;}
  public void leaveTheBuilding(){...}
}

//为了保证序列化时的Singleton，必须声明所有实例域为瞬时的（transient）的并提供readResolve

//readResolve method to perserve Singleton property
private Object readResolve(){
  //Return the one true Elvis and let the garbage collector
  //take care of the Elvis impersonator
  return INSTANCE;
}
//3.包含单个元素的枚举类型
//Enum signleton - the preferred approach
public enum Elvis{
  INSTANCE;
  public void leaveTheBuilding(){...}
}
//  这种方法与公有域方法相近，提供序列化机制，绝对防治多次实例化，是实现单例最佳方法

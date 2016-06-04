//工具类不希望被实例化，然而会有缺省的构造器，解决方法就是包涵显式的私有构造器
//Noninstantiable utility class
public class UtilityClass{
  //Supress default constructor for Noninstantiablility
  private UtilityClass(){
    throw new AssertionError();
  }
  ...//Remainder omitted
}

//  缺点：不能子类化

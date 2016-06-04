//多个构造器参数实现，1.采用重叠构造器  当有多个参数时，客户端代码会很难写
//2.JavaBeans模式setter方法设置参数  阻止了把类做成不可变的可能性
//3.Builder模式 必要参数调用构造器或者静态方法得到一个builder对象，在builder对象上调用setter方法 通过调用无参builder方法生成不可变对象
//Builder Pattern
public class NutritionFacts{
  private final int servingSize;
  private final int servings;
  private final int calories;
  private final int fat;
  private final int sodium;
  private final int carbohydrate;

  public static class Builder{
    //Required Parameters
    private final int servingSize;
    private final int servings;

    //Optional parameters - initialised to default values
    private int calories=0;
    private int fat=0;
    private int carbohydrate=0;
    private int sodium=0;

    public Builder(int servingSize,int services){
      this.servingSize=servingSize;
      this.services=services;
    }

    public Builder calories(int val){
      calories=val;return this;
    }
    public Builder fat(int val){
      fat=val;return this;
    }
    public Builder carbohydrate(int val){
      carbohydrate=val;return this;
    }
    public Builder sodium(int val){
      sodium=val;return this;
    }

    public NutritionFacts build(){
      return new NutritionFacts(this);
    }
  }

  private NutritionFacts(Builder Builder){
    servingSize=builder.servingSize;
    servings=builder.servings;
    calories=builder.calories;
    fat=builder.fat;
    carbohydrate=builder.carbohydrate;
    sodium=builder.sodium;
  }
}

//客户端代码
NutritionFacts cocaCola = new NutritionFacts.Builder(240,8).
calories(100).sodium(35).carbohydrate(27).build();

//发行版1.5及以上只要一个泛型就能满足所有builder
//A builder for objects of type T
public interface Builder<T>{
  public T build();
}
//利用一个客户端提供的Builder实例来构建树
Tree buildTree(Builder<? extends Node> nodeBuilder){...}
//缺点：1.为了创建对象必须先创建它的构建器 比重叠构造器更加冗长

//如果类的构造器或静态工厂中具有多个参数，builder模式是个不错的选择，构建器壁JavaBeans更加安全。

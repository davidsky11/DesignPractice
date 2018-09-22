# 设计模式（23种）

## 一、设计模式的分类

总体分为三大类：

- **创建型**模式，5种： 
  工厂方法模式、抽象工厂模式、单例模式、建造者模式、原型模式；

- **结构型**模式，7种： 
  适配器模式、装饰器模式、代理模式、外观模式、桥接模式、组合模式、享元模式；

- **行为型**模式，11种：  
  策略模式、模板方法模式、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式；

- 其他模式，2种： 
  并发型模式、线程池模式。

![设计模式内在联系](https://github.com/davidsky11/DesignMode/blob/master/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F%E5%86%85%E5%9C%A8%E5%85%B3%E7%B3%BB.jpg)

## 二、设计模式的六大原则

**总原则：开闭原则（Open Close Principle）**

 **对扩展开放，对修改关闭（可复用设计，抽象化）**
 
    在程序需要进行扩展的时候，不能去修改原有的代码，而是要扩展原有代码，实现一个热插拔的效果。
    
    一句话概括：为了使程序的扩展性好，易于维护和升级。
    
    xml和properties等格式的配置文件是纯文本文件，无须编译，因此在软件开发中，一般不把对配置文件的修改认为是对系统源代码的修改（符合开闭原则）。

 **1. 单一职责原则（Single Responsibility Principle）**
 
    一个类只负责一个功能领域中的相应职责 
    不要存在多于一个导致类变更的原因 
    每个类应该实现单一的职责，如若不然，就应该把类拆分 
    **高内聚、低耦合**
 
 **2、里氏替换原则（Liskov Substitution Principle）**
 
    所有引用基类（父类）的地方必须能透明地使用其子类的对象 
    
    里氏替换原则中，子类对父类的方法尽量不要重写和重载。因为父类代表了定义好的结构，通过这个规范的接口与外界交互，子类不应该随便破快它。  
    
    在程序中尽量使用基类类型来对对象进行定义，而在运行时再确定其子类类型，用子类对象来替换父类对象。 
 
> 注意点：
 - 子类的所有方法必须在父类中声明，或子类必须实现父类中声明的所有方法。
 - 尽量把父类设计为抽象类或者接口，让子类继承父类或实现父接口，并实现在父类中声明的方法，运行时，子类实例替换父类实例，我们可以很方便地扩展系统的功能，同时无须修改原有子类的代码，增加新的功能可以通过增加一个新的子类来实现。 
 - Java语言中，在编译阶段，Java编译器会检查一个程序是否符合里氏代换原则，这是一个与实现无关的、纯语法意义上的检查，但Java编译器的检查是有局限的。  
 
 **3、依赖倒转原则（Dependence Inversion Principle）**
 
    抽象不应该依赖于细节，细节应当依赖于抽象。即，要针对接口编程，而不是针对实现编程。 
    
    开闭原则的基础，具体内容：面向接口编程，依赖于抽象而不依赖于具体。写代码时用到具体类时，不与具体类交互，而与具体类的上层接口交互。
    
    依赖倒转原则要求我们在程序代码中传递参数时或在关联关系中，尽量引用层次高的抽象层类，即使用接口和抽象类进行变量类型声明、参数类型声明、方法返回类型声明，以及数据类型的转换等，而不要用具体类来做这些事情。为了确保该原则的应用，一个具体类应当只实现接口或抽象类中声明过的方法，而不要给出多余的方法，否则将无法调用到在子类中增加的新方法。  
 
    在引入抽象层后，系统将具有很好的灵活性，在程序中尽量使用抽象层进行编程，而将具体类写在配置文件中，这样一来，如果系统行为发生变化，只需要对抽象层进行扩展，并修改配置文件，而无须修改原有系统的源代码，在不修改的情况下来扩展系统的功能，满足开闭原则的要求。  
 
    在实现依赖倒转原则时，我们需要针对抽象层编程，而将具体类的对象通过依赖注入(DependencyInjection, DI)的方式注入到其他对象中，依赖注入是指当一个对象要与其他对象发生依赖关系时，通过抽象来注入所依赖的对象。常用的注入方式有三种，分别是：构造注入，设值注入（Setter注入）和接口注入。构造注入是指通过构造函数来传入具体类的对象，设值注入是指通过Setter方法来传入具体类的对象，而接口注入是指通过在接口中声明的业务方法来传入具体类的对象。这些方法在定义时使用的是抽象类型，在运行时再传入具体类型的对象，由子类对象来覆盖父类对象。  
 
 > **开闭原则是目标，里氏替换原则是基础，依赖倒转原则是手段**
 
 **4、接口隔离原则（Interface Segregation Principle）**
 
    使用多个专门的接口，而不使用单一的总接口，即客户端不应该依赖那些它不需要的接口
 
    每个接口中不存在子类用不到却必须实现的方法，如果不然，就要将接口拆分。使用多个隔离的接口，比使用单个接口（多个接口方法集合到一个接口）要好。
 
    在使用接口隔离原则时，需要注意控制接口的粒度，接口不能太小，如果太小会导致系统中接口泛滥，不利于维护；接口也不能太大，太大的即可将违背接口隔离原则，灵活性较差，使用起来很不方便。  
 
 **5、迪米特法则（最少直到原则，Demeter Principle）**
 
    一个软件实体应当尽可能少地与其他实体发生相互作用（保持松散的耦合关系）
 
     一个类对自己依赖的类知道的越少越好。无论被依赖的类多么复杂，都应该将逻辑封装在方法的内部，通过public方法提供给外部。这样当被依赖的类变化时，才能最小的影响该类。

    迪米特法则（另一种形式：不要和“陌生人”说话，只与你的直接朋友通信）中，对于一个对象，其朋友包括以下几类：
    1. 当前对象本身（this）； 
    2. 以参数形式传入到当前对象方法中的对象；
    3. 当前对象的成员对象； 
    4. 如果当前对象的成员对象是一个集合，那么集合中的元素也都是朋友；
    5、当前对象所创建的对象。
 
***通过引入一个合理的第三者来降低现有对象之间的耦合度：***  

    应该尽量减少对象之间的交互，如果两个对象之间不必彼此直接通信，那么这两个对象就不应当发生任何直接的相互作用，如果其中的一个对象需要调用另一个对象的某一个方法的话，可以通过第三者转发这个调用。
 
**注意：**
 1. 在类的划分上，应当尽量创建松耦合的类，类之间的耦合度越低，就越有利于复用，一个处在松耦合中的类一旦被修改，不会对关联的类造成太大波及
 2. 在类的结构设计上，每一个类都应当尽量降低其成员变量和成员函数的访问权限 
 3. 在类的设计上，只要有可能，一个类型应当设计成不变类
 4. 在对其他类的引用上，一个对象对其他对象的引用应当降到最低 
 
 **6、合成/聚合复用原则（Composite Reuse Principle，CARP）**
 
 + 聚合（Aggregation）：一种弱的“拥有”关系，体现的是A对象可以包含B对象但B对象不是A对象的一部分  
 + 合成（Composition）：一种强的“拥有”关系，体现了严格的部分和整体关系，部分和整体的生命周期一样


> **'尽量首先使用合成/聚合的方式，而不是使用继承'**
 1. 继承复用破坏包装，它把父类的实现细节直接暴露给了子类，这违背了信息隐藏的原则；
 2. 如果父类发生了改变，那么子类也要发生相应的该表，这就直接导致了类与类之间的高耦合，不利于类的扩展、复用、维护等，也带来了系统僵硬和脆弱的设计。
 
---

> **Coad法则**：
只有当以下Coad条件全部被满足时，才应当使用继承关系：

> - 子类是超类的一个特殊种类，而不是超类的一个角色。区分“Has-A”和“Is-A”。只有“Is-A”关系才符合继承关系，“Has-A”关系应当用聚合来描述。
> - 永远不会出现需要将子类换成另外一个类的子类的情况。如果不能肯定将来是否会变成另外一个子类的话，就不要使用继承。

> - 子类具有扩展超类的责任，而不是具有置换掉（override）或注销掉（Nullify）超类的责任。如果一个子类需要大量的置换掉超类的行为，那么这个类就不应该是这个超类的子类。  
> - 只有在分类学角度上有意义时，才可以使用继承。不要从工具类继承。 
 
 ***注：***  
 “Is－A”代表一个类是另外一个类的一种；  
 “Has-A”代表一个类是另外一个类的一个角色，而不是另外一个类的特殊种类。  
 
 
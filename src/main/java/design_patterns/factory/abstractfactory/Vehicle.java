package design_patterns.factory.abstractfactory;

/**
 * @Auther: qiucy
 * @Date: 2019-06-17 21:50
 * @Description:用的是abstract而不是interface，这是个语言问题。
 *  Vehicle交通工具比较抽象，不够具体，但还是存在的名词。
 *  Movable就个不存在的副词（形容词）了
 *  工厂方法是易于扩展一族产品
 */
public abstract class Vehicle {
    abstract void go();
}

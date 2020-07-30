package com.example.java8.userful.generics;

/**
 * 自定义模板
 * @param <T>
 */
class BasicHolder<T> {

    T element;

    void set(T arg) {
        element = arg;
    }

    T get() {
        return element;
    }

    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}

/**
 * 继承模板
 */
class SubType extends BasicHolder<SubType> {}

class CRGWithBasicHolder {

    public static void main(String[] args) {
        SubType st1 = new SubType();
        SubType st2 = new SubType();
        st1.set(st2);
        st1.f();

        BasicHolder<SubType> basicHolder = new BasicHolder<>();
        basicHolder.set(st2);
        basicHolder.f();
    }
}

/**
 * 下面情况下不好使 set冲突
 */
class Base {}

class Derived extends Base {}

interface OrdinaryGetter {
    Base get();
}

interface DerivedGetter extends OrdinaryGetter {

    Derived get();
}

class CovariantReturnTypes {

    void test(DerivedGetter getter) {
        Derived d = getter.get();
    }
}

class GenericSetter<T> {

    void set(T arg) {
        System.out.println("GenericSetter.set(Base)");
    }
}

class DerivedGs extends GenericSetter<Base> {

    void set(Derived derived) {
        System.out.println("DerivedGs.set(Derived)");
    }
}

class PlainGenericInheritance {

    public static void main(String[] args) {
        Base base = new Base();
        Derived derived = new Derived();
        DerivedGs derivedGs = new DerivedGs();
        derivedGs.set(derived);
        derivedGs.set(base); // ok
    }
}

/**
 * 自循环解决方案
 * @param <T>
 */
interface BaseSetterAndGetter<T extends BaseSetterAndGetter<T>> {

    T get();

    void set(T arg);
}

/*BaseSetterAndGetter带入到T还是本身*/
interface ChildSetterAndGetter extends BaseSetterAndGetter<ChildSetterAndGetter> {
}

interface A {}

/* Error*/
/*
这里的B是错误的 因为A 跟 BaseSetterAndGetter 没有继承的关系
*/
/* interface B extends BaseSetterAndGetter<A> {}*/

// ok
interface C extends BaseSetterAndGetter<ChildSetterAndGetter>{}


class GenericSetterAndGetter {

    void test(ChildSetterAndGetter setterAndGetter, ChildSetterAndGetter child, BaseSetterAndGetter parent) {
        ChildSetterAndGetter childSetterAndGetter = setterAndGetter.get();
        setterAndGetter.set(child);
        // setterAndGetter.set(parent); Error
    }
}









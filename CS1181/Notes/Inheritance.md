Inheritance 
    
    Derived Classes
        A derived class (also known as a subclass or child class) is a class that is derived from another class, called a base class (also known as a parent class).

    Modifiers
        Modifiers are public, private, and protected
        Public: Accessible by self, derived classes, and everyone else
        Private: Accessible by self
        Protected: Accessible by self, derived class, and other classes in the same package
        No specifier, Accessible by self and other classes in the same package

    Class Definitions
        The keyword "public" in a class definition like public class DerivedClass specifies a class's visibility in other classes in the program
            public: A class can be used by every class in the program regardless of the package in which either is defined
            no specifier: A class can be used only in other classes within the same package, known as package-private

    Overriding vs. Overloading
        In OVERLOADING, methods with the same name must have different parameter types or number of parameters. In OVERRIDING, a derived class member must have the same parameter types, number of parameters, and return value as the base class member method with the same name. OVERLOADING is performed if derived and base member methods have different parameters types; the member method of the derived class does not hide the member method of the base class

    Object Class
        The built in OBJECT CLASS serves as the base class for all other classes and does not have a base class. All classes, including user-defined classes, are derived from Object and implement Object's methods. Two common methods defined within the Object Class are toString() and equals().

        toString()
            The toString() method returns a String representation of the Object. By default, toString() returns a String containing the object's class name followed by the object's hash code in hexadecimal form. Ex. java.lang.Object@372f7a8d.
        equals()
        The equals(otherObject) method compares an Object to otherObject and returns true if both variables reference a String containing the same object. Otherwise, equals() returns false. By default, equals() tests the equality of the two Object references, not the equality of the Objects' contents.

    Polymorphism
        Polymorphism refers to determining which program behavior to execute depending on data types. Method overloading is a form of COMPILE-TIME POLYMORPHISM wherein the compiler determines which of several identically-named methods to call based on the method's arguements. Another form is RUNTIME POLYMORPHISM wherein the compiler can not make the determination but instead the determination is made while the program is running.
        One scenario requiring runtime polymorphism involves derived classes. Programmers commonly create a collection of objects of booth base and derived class types. Ex. the statement:
        ArrayList<GenericItem> inventoryList = new ArrayList<GenericItem>(); declares an ArrayList that can contain references to objects of type GenericItem of ProduceItem. ProduceItem derives from GenericItem.

    Object-oriented programming (OOP)
        Object-oritented programming is a powerful programming paradigm, consisting of several features. Three key features include:
            Classes: A class encapsulates data and behavior to create objects
            Inheritance: Inheritance allows one class (a subclass) to be based on another class (a base class or superclass).
            Abstract Classes: An abstract class is a class that guides the design of subclasses but can not itself be instantiated as an object.
Polymorphism
    Poly meaning "many"
    Morphism meaning "names"

    Class (instance) Variable
        A class variable that exists within an entire class.

    Local Variable
        A variable that exists only within a method.

    Access Modifiers
        Public, Private in front of a variable, such as "Public Int", "Private String".

    UML
        3 boxes the describe a class, top box is the name of the class, the middle box is the fields of the class, and the bottom box is setters and getters.
        Ex. Top Box: ComputerScientist, Middle Box: gender, name, isAlive, bottom box setGender, getGender, setName, getName

    Super
        A keyword used to reference existing classes. Calling a super keyword, it will reference everything in the inheritance that follows the current class.

    Child class
        "Vehicle car = new Vehicle()", if every car is not the same, how would you implement differences in each class that inherits the car? You'd make a child class, a child class inherits from the original class, in this case the car class, and you can make differences in each child class, so they won't have to be the same (as in have new versions of the original methods).

    Abstract Classes
        Abstract is a keyword. It enforces that the class can not be instantiated (meaning it can not have an object made from it). A parent class can be an abstract class, but the child class does not have to be. So, if you have a Vehicle parent class, and a truck and car child class, if the vehicle class is abstract, you can then make a new car out of vehicle, such as "Vehicle car = new car()" or a truck "Vehicle truck = new truck()". So now, the child classes can operate by themselves, and use their own version of the classes from the parent class.

    Concrete Class
        A class that extends an abstract class.

    @Override
        Overrides a method.

Interface
    Java does not support multi-inheritance. So, you can not inherit from 2 different parent classes. Use interfaces! They are similar to abstract classes, in a sense they describe the object behavior, but not the implementation. Methods can not specify body. You can implement multiple interfaces with a comma. Java has a lot of interfaces built into it, for example the compareTo() interface.

    compareTo()
        An interface that is used to specify how Collections.sort() works under the hood.

Abstract Classes Vs. Interfaces
    Abstract classes don't have multi-inheritance and doesn't have many built in, while interfaces can have multiple per class and has many built in
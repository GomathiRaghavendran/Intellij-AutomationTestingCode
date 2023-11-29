package codeFromGomathi.abstractConcept.Interface;
//Interface - only abstract methods are allowed
// even if we dont declare abstract in front of the method, java compiler will keep abstract in that method automatically in interface
// By implementing Interface, we can write logic in the child class
// We can achieve abstraction 100% by using Interface
// also cant create object for interface
public interface Vehicle {
    void bus();
    void train();
    void  car();
    void tram();

    void bicycle();
    void flight();
}

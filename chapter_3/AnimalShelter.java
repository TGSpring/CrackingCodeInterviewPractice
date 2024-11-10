/**
 * Tyler Spring
 * 11/10/2024
 * Chapter 3 Question 3.6
 * Animal Shelter - A FIFO shelter for dogs and cats.
 */

 import java.util.LinkedList;

 // Base class Animal representing both dogs and cats with a name and arrival order.
 class Animal {
     private String name;
     private int order; // Order represents the arrival time.
 
     public Animal(String name) {
         this.name = name;
     }
 
     public void setOrder(int order) {
         this.order = order;
     }
 
     public int getOrder() {
         return order;
     }
 
     public String getName() {
         return name;
     }
 
     // Checks if this animal is older than another by comparing order values.
     public boolean isOlderThan(Animal other) {
         return this.order < other.order;
     }
 }
 
 // Dog class extending Animal, representing a specific type of animal.
 class Dog extends Animal {
     public Dog(String name) {
         super(name);
     }
 }
 
 // Cat class extending Animal, representing a specific type of animal.
 class Cat extends Animal {
     public Cat(String name) {
         super(name);
     }
 }
 
 // AnimalShelter class implementing a FIFO system for managing dogs and cats.
 public class AnimalShelter {
     private LinkedList<Dog> dogs; // Queue for dogs.
     private LinkedList<Cat> cats; // Queue for cats.
     private int order; // Acts as a timestamp to track arrival order.
 
     public AnimalShelter() {
         dogs = new LinkedList<>();
         cats = new LinkedList<>();
         order = 0;
     }
 
     // Enqueues an animal and assigns an arrival order.
     public void enqueue(Animal animal) {
         animal.setOrder(order);
         order++;
 
         if (animal instanceof Dog) {
             dogs.addLast((Dog) animal);
         } else if (animal instanceof Cat) {
             cats.addLast((Cat) animal);
         }
     }
 
     // Dequeues the oldest animal, either a dog or a cat, based on arrival order.
     public Animal dequeueAny() {
         if (dogs.isEmpty()) {
             return dequeueCat();
         } else if (cats.isEmpty()) {
             return dequeueDog();
         }
 
         // Compare the order of the oldest dog and cat.
         Dog oldestDog = dogs.peek();
         Cat oldestCat = cats.peek();
         if (oldestDog.isOlderThan(oldestCat)) {
             return dequeueDog();
         } else {
             return dequeueCat();
         }
     }
 
     // Dequeues the oldest dog.
     public Dog dequeueDog() {
         return dogs.poll();
     }
 
     // Dequeues the oldest cat.
     public Cat dequeueCat() {
         return cats.poll();
     }
 
     // Main method to test the AnimalShelter functionality.
     public static void main(String[] args) {
         AnimalShelter shelter = new AnimalShelter();
 
         // Adding animals to the shelter
         shelter.enqueue(new Dog("Rex"));
         shelter.enqueue(new Cat("Whiskers"));
         shelter.enqueue(new Dog("Buddy"));
         shelter.enqueue(new Cat("Mittens"));
 
         // Testing the dequeue operations
         System.out.println("Dequeued Any: " + shelter.dequeueAny().getName()); // Should dequeue Rex
         System.out.println("Dequeued Dog: " + shelter.dequeueDog().getName()); // Should dequeue Buddy
         System.out.println("Dequeued Cat: " + shelter.dequeueCat().getName()); // Should dequeue Whiskers
     }
 }
 
 /**
  * Explanation:
  Enqueue(Animal animal): 
  Each animal gets a timestamp upon arrival, represented by order.
  we increment order after each enqueue to ensure that each animal has a unique arrival time.
  The animal is added to either the dogs or cats queue based on its type.

  DequeueAny():
  If one queue is empty, we dequeue from the other.
  If both have animals, we compare the order of the animals at the front and dequeue the oldest one.

  DequeueDog() and DequeueCat():
  These methods simply remove the front dog or cat from their respective queues.


  Complexity:

  enqueue O(1): as adding to a queue is a constant-time operation.
  dequeueAny, dog, cat O(1), as removing from the front of a queue is also constant time.
  */
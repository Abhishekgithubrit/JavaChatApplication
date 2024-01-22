class Emp extends Thread{
  public  void run(){
        System.out.println("Tread is running...");
        for(int i=0; i<2; i++){
        System.out.println(Thread.currentThread().getName() + "in control ");
        }
        for(int i=0; i<10; i++){
          try{
            Thread.sleep(500);
          }
          catch(Exception e){
            System.out.println(e);
          }
          System.out.println(i);
        }
      }
}
class Emp2 extends Thread{
  public void run(){
    synchronized(this){
      System.out.println("Starting of Thread of Emp2 :" + Thread.currentThread().getName());
      try{  
        this.wait();
      }catch(Exception e){
        System.out.println(e);
      }

      System.out.println("notified.........");
    }
  }
}
class mul {
  public static void main(String[] args) {
    Emp t2 = new Emp();
    Emp2 t4 = new Emp2();
    
    Emp t3 = new Emp();
    t4.start();
    System.out.println("before running of the Tread ::" + t2.isAlive());
    t2.start();
    System.out.println("before running of the Tread ::" + t2.isAlive());
    t2.setPriority(2);
    t2.setName("AbhishekThread!!!!");
    System.out.println("The Tread id is ::" + t2.getId());
    System.out.println("t2 Thread priority is ::" +  t2.getPriority());
    try{
      t2.join();
    }catch(Exception e){
      System.out.println(e);
    }
    for(int i=0; i<2; i++){
      System.out.println("Comes under yeild method....");
      t3.yield();
    }
    
    t3.start();
    t3.setPriority(1);
    System.out.println(t3.getId());
    System.out.println("t3 Thread priority is :" + t3.getPriority());
    try{
      t3.join();
    }catch(Exception e){
      System.out.println(e);
    }
   
    
  }
}

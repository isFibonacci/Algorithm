
class RunnyStack<Base> {
  private class Run {
    private Base base;
    private int length;
    private Run next;

    private Run(Base base, int length, Run next) {
      this.base = base;
      this.length = length;
      this.next = next;
    }
  }

  private Run top;
  private int count;
  private Run rear;

  public RunnyStack() {
    top = new Run(null, 0, null);
    rear = new Run(null, 0, null);
    count = 0;
  }

  public int depth() {
    return count;
  }

  public boolean isEmpty() {
    return top.base == null;
  }

  public Base peek() {
    if (isEmpty())
      throw new IllegalStateException();
    return rear.base;
    
  }

  public void pop() {
    if (isEmpty())
      throw new IllegalStateException();
    count -= 1;
    top.length -= 1;
    top = top.next;
  }

  public void push(Base base) {
    if (isEmpty()) {
      Run newTop = new Run(base, top.length, top);
      rear = top;
      rear.next = null;
      top = newTop;
      top.length += 1;
      count += 1;
    }
    else if (isEuqal(top.base, base)) {
        count += 1;
        top = new Run(base, top.length, top);
        rear = top;
        rear.next = null;
    }
    else {
        rear = top;
        rear.next = null;
        top = new Run(base, top.length, top);
        count += 1;
        top.length += 1;
    }
}

  public int runs() {
    return top.length;
  }

  public boolean isEuqal(Base top, Base newRun) {
    if (top == null || newRun == null)
      return top == newRun;
    return top.equals(newRun);
  }

}

class Camembert
{
  public static void main(String [] args)
  {
    RunnyStack<String> s = new RunnyStack<String>();

    System.out.println(s.isEmpty());         //  true      
    System.out.println(s.depth());           //  0          
    System.out.println(s.runs());            //  0          

    try
    {
      s.pop();
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No pop");          //  No pop     
    }

    try
    {
      System.out.println(s.peek());
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No peek");         //  No peek    
    }
 
    s.push("A");
    System.out.println(s.peek());            //  A          
    System.out.println(s.depth());           //  1          
    System.out.println(s.runs());            //  1          

    System.out.println(s.isEmpty());         //  false      

    s.push("B");
    System.out.println(s.peek());            //  B          
    System.out.println(s.depth());           //  2          
    System.out.println(s.runs());            //  2          

    s.push("B");
    System.out.println(s.peek());            //  B          
    System.out.println(s.depth());           //  3          
    System.out.println(s.runs());            //  2          

    s.push("B");
    System.out.println(s.peek());            //  B          
    System.out.println(s.depth());           //  4          
    System.out.println(s.runs());            //  2          

    s.push("C");
    System.out.println(s.peek());            //  C          
    System.out.println(s.depth());           //  5          
    System.out.println(s.runs());            //  3          

    s.push("C");
    System.out.println(s.peek());            //  C          
    System.out.println(s.depth());           //  6          
    System.out.println(s.runs());            //  3          

    s.pop();
    System.out.println(s.peek());            //  C          
    System.out.println(s.depth());           //  5          
    System.out.println(s.runs());            //  3          

    s.pop();
    System.out.println(s.peek());            //  B          
    System.out.println(s.depth());           //  4          
    System.out.println(s.runs());            //  2          

    s.pop();
    System.out.println(s.peek());            //  B          
    System.out.println(s.depth());           //  3          
    System.out.println(s.runs());            //  2          

    s.pop();
    s.pop();
    System.out.println(s.peek());            //  A          
    System.out.println(s.depth());           //  1          
    System.out.println(s.runs());            //  1          

    s.pop();
    System.out.println(s.isEmpty());         //  true       
    System.out.println(s.depth());           //  0          
    System.out.println(s.runs());            //  0          

    try
    {
      System.out.println(s.peek());
    }
    catch (IllegalStateException ignore)
    {
      System.out.println("No peek");         //  No peek    
    }
  }
}


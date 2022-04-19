class Fibonacci {
  static int fib(int n){
    if (n <= 1)
      return 1;
    else
      return fib(n-1) + fib(n-2);
  }

public static void main(String[] args){
  int antall = Integer.parseInt(args[0]);
  for (int i =1; i <= antall; i++)
    System.out.println("Fibonacci: " + fib(i));
}
}  


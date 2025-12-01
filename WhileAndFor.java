public class WhileAndFor
{
  public static void main(String[] args)
  {
    int i = -10;
    while (i <= 10)
    {
      System.out.println(i);
      i += 1;
    }

    for (int j = -10; j <= 10; j++)
    {
      System.out.println(j);
    }
    
    for (int k = 0; k <= 50; k+=5)
    {
      System.out.println(k);
    }

    int l = 0;
    while (l <= 50)
    {
      System.out.println(l);
      l += 5;
    }
  }
}
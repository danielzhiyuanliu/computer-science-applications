public class HiddenMessage
{
    public static String hideMessage(String message) 
    {
        String hidden = ""; 
        int n = message.length();
        
        for (int i = 0; i < n; i++) 
        {
            String c = message.substring(i, i + 1);

            if (c.equals(" ")) 
            {
                hidden = hidden + "   "; 
            } 
            else 
            {
                hidden = hidden + "_";
                
                if (i < n - 1) 
                {
                    hidden = hidden + " ";
                }
            }
        }
        
        return hidden;
    }
    
    public static void main(String[] args) 
    {
        String message = "My message is hidden";
        String hiddenMessage = hideMessage(message);
        System.out.println(hiddenMessage);
    }
}
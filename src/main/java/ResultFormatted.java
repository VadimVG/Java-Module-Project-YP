import java.util.HashMap;

public class ResultFormatted {
    public static HashMap<String, String> hashMap= new HashMap<>();

    static {
        hashMap.put("1", "рубль");
        hashMap.put("234", "рубля");
        hashMap.put("56789", "рублей");
    }

    public static void outFormatted(double num){
        String val= String.valueOf(num).split("\\.")[0];
        for (String s: hashMap.keySet()){
            if (s.contains(String.valueOf(val.charAt(val.length()-1)))){
                System.out.println(String.format("Каждый человек должен заплатить %.2f %s", num, hashMap.get(s)));
                break;
            }
        }
    }
}

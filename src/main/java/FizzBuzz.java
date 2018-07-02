import java.util.*;

class FizzBuzz {
private static final Map<Integer,String> VALUES = initFinalMap();

    static Map<Integer,String> initFinalMap(){
        Map<Integer,String> map = new LinkedHashMap<>();
        map.put(3,"Fizz");
        map.put(5,"Buzz");
        map.put(7,"Vozz");

        return Collections.unmodifiableMap(map);
    }

    static String multiple(int number){
        StringBuilder res = new StringBuilder();

        for(Map.Entry<Integer,String> mapEntry : VALUES.entrySet()){
            if(number%mapEntry.getKey() == 0) {
                System.out.println("Map entry: " + mapEntry.getValue());
                res.append(mapEntry.getValue());
            }
        }

        return res.toString();
    }

    static String contains(int number){
        String strNum = Integer.toString(number);
        StringBuilder res = new StringBuilder();

        for(char c : strNum.toCharArray()) {
            int key = Character.getNumericValue(c);
            if(VALUES.containsKey(key)){
                res.append(VALUES.get(key));
            }
        }

        return res.toString();
    }

    static String fizzBuzz (int number){
        String res = multiple(number).concat(contains(number));

        return res.equals("") ?  Integer.toString(number) : res;
    }
}


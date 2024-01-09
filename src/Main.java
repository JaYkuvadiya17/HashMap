//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        MyHashMap<String, Integer> myHashMap = new MyHashMap<>(32);

        myHashMap.put("polygenelubricants", 10);
        myHashMap.put("jay", 20);
        myHashMap.put("jay", 30);
        Integer jay = myHashMap.remove("jay");
        myHashMap.put(null, null);

        System.out.println(myHashMap.get("jay"));
        System.out.println(myHashMap.isEmpty());
        System.out.println(jay);
        System.out.println(myHashMap.containsKey("jay"));

        Integer test = myHashMap.remove("hello");
        System.out.println(test);
        System.out.println(myHashMap.size());

//        myHashMap.clear();

        System.out.println(myHashMap.size());
        System.out.println(myHashMap.containsKey("polygenelubricants"));
        System.out.println(myHashMap.containsValue(40));
    }

}
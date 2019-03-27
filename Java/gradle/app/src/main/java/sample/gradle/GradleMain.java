package sample.gradle;

// util
import java.io.IOException;

// list, map
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.HashMap;

// jacson
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Map;

// file
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;


class Called {

  void forIf(){
    System.out.println("forIf--------------------------start");

    for (int i = 0 ; i < 3 ; i++){
        if (i % 2 == 0){
        System.out.println(i + "は偶数です");
        }
        if (i % 2 != 0){
        System.out.println(i + "は奇数です");
        }
    }

    System.out.println("forIf--------------------------end");
  }

  void file_read(){
    System.out.println("file_read--------------------------start");

    String cd = System.getProperty("user.dir");
    System.out.println(cd);
    String file_path = cd + "/file";
    String filename = "input.csv";
    String charset = "UTF-8";
 
    try {
        List<String> line = Files.readAllLines(
            Paths.get(file_path, filename),
                Charset.forName(charset));
        for (String s : line) {
            System.out.println(s);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    System.out.println("file_read--------------------------end");
  }

  void file_write(){
    System.out.println("file_write--------------------------start");

    try {
        File file = new File("output.txt");
        FileWriter fw = new FileWriter(file);
        fw.write("test output");
        fw.close();
    } catch (IOException ex) {
        ex.printStackTrace();
    }

    System.out.println("file_write--------------------------end");
  }

  void listIteratorArrays(){
    System.out.println("listIteratorArrays--------------------------start");

    List<String> list = Arrays.asList("A", "B", "C");

    System.out.println("list.size()-------start");
    for(int i = 0; i < list.size(); ++i){
        String s = list.get(i);
        System.out.println(s);
    }
    System.out.println("list.size()-------end");

    System.out.println("イテレータ-------start");
    for(Iterator<String>itr = list.iterator(); itr.hasNext();){
        String s = itr.next();
        System.out.println(s);
    }
    System.out.println("イテレータ-------end");

    System.out.println("拡張for文-------start");
    for(String s : list){
        System.out.println(s);
    }
    System.out.println("拡張for文-------end");

    System.out.println("ラムダ-------start");
    list.forEach(s -> {
        System.out.println(s);
    });
    System.out.println("ラムダ-------end");

    System.out.println("ラムダだが、メソッド参照-------start");
    list.forEach(System.out::println);
    System.out.println("ラムダだが、メソッド参照-------end");

    System.out.println("listIteratorArrays--------------------------end");
  }

  void arraylist_add_get_update_delete(){
    System.out.println("arraylist_add_get_update_delete--------------------------start");

    System.out.println("add-------start");
    List<Integer> list1 = new ArrayList<>();
    list1.add(1);
    list1.add(2);
    System.out.println(list1);

    List<Integer> list2 = new ArrayList<>();
    list2.add(3);
    list1.addAll(list2);
    System.out.println(list1);
    System.out.println("add-------end");

    System.out.println("get-------start");
    List<String> list3 = new ArrayList<>(Arrays.asList("a", "b", "c"));
    System.out.println("list = " + list3);
    System.out.println("要素数 = " + list3.size());
    System.out.println("get-------end");

    System.out.println("update-------start");
    List<Integer> list4 = new ArrayList<>();
    for(int i = 0; i < 5; i++) {
        list4.add(i);
    }
    list4.set(0, 3);
    System.out.println(list4);
    System.out.println("update-------end");

    System.out.println("delete-------start");
    list4.remove(0);
    System.out.println(list4);
    System.out.println("delete-------end");

    System.out.println("arraylist_add_get_update_delete--------------------------end");
  }

  void arraylist_duplicate(){
    System.out.println("arraylist_duplicate--------------------------start");

    List<String> listA = new ArrayList<String>(Arrays.asList("s", "a", "m", "u", "r", "a", "i"));
    List<String> listB = new ArrayList<String>(new HashSet<>(listA));
    List<String> listC = new ArrayList<String>(new LinkedHashSet<>(listA));
    System.out.println("ListA = " + listA);
    System.out.println("ListB = " + listB);
    System.out.println("ListA = " + listC);

    System.out.println("arraylist_duplicate--------------------------end");
  }

  void hashmap_put(){
    System.out.println("hashmap_put--------------------------start");   

    // Mapの宣言
    Map<String, String> map1 = new HashMap<String, String>();
    // MAPにデータを格納
    map1.put("key1", "apple");
    map1.put("key2", "orange");
    map1.put("key3", "melon");
    System.out.println(map1.get("key1"));
    System.out.println(map1.get("key2"));
    System.out.println(map1.get("key3"));

    System.out.println("hashmap_put--------------------------end");
  }

  void jackson_objectmapper_obj_str(){
    System.out.println("jackson_ObjectMapper_obj_str--------------------------start");

    System.out.println("Javaオブジェクト→JSON文字列-------start");
    Hoge hoge1 = new Hoge();
    hoge1.id = 10;
    hoge1.name = "hoge1";
    ObjectMapper mapper1 = new ObjectMapper();
    try {
        String json = mapper1.writeValueAsString(hoge1);
        System.out.println(json);
    } catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println("Javaオブジェクト→JSON文字列-------end");
    
		System.out.println("JSON文字列→Javaオブジェクト-------start");
    String json_str = "{\"id\":20, \"name\":\"hoge2\"}";
    ObjectMapper mapper2 = new ObjectMapper();
    try {
        Hoge hoge2 = mapper2.readValue(json_str, Hoge.class);
        System.out.println(hoge2);
    } catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("JSON文字列→Javaオブジェクト-------end");

    System.out.println("jackson_ObjectMapper_obj_str--------------------------end");
  }

  void jackson_objectmapper_get(){
    System.out.println("jackson_ObjectMapper_get--------------------------start");   

    try {
      // 基本。
      ObjectMapper mapper = new ObjectMapper();
      String jsondata = "{\"a\":1,\"b\":2}";
      Map<String,Integer> result = mapper.readValue(jsondata, Map.class);
      System.out.println("result1.toString() : " + result.toString());

      // リスト
      jsondata = "[1,2]";
      List<Integer> result2 = mapper.readValue(jsondata, List.class);
      System.out.println("result2.toString() : " + result2.toString());

      // ネストしたリスト
      jsondata = "[[\"1111\",\"aaaa\"],[\"2222\",\"bbbb\"]]";
      List<List<String>> result3 = mapper.readValue(jsondata, List.class);
      System.out.println("result3.toString() : " + result3.toString());

      // オブジェクトの中にリストが含まれているパターン
      jsondata = "{\"a\":1,\"b\":2,\"c\":[\"xxxx\",\"yyyy\"]}";
      Map<String,Object> result4 = mapper.readValue(jsondata, Map.class);
      System.out.println("result4.toString() : " + result4.toString());
      System.out.println("result4.a    : " + result4.get("a").getClass() +":"+result4.get("a"));
      System.out.println("result4.b    : " + result4.get("b").getClass() +":"+result4.get("b"));
      System.out.println("result4.c[0] : " + result4.get("c").getClass() +":"+result4.get("c"));
      System.out.println("result4.c[1] : " + ((List)result4.get("c")).get(0).getClass() +":"+((List)result4.get("c")).get(0));
      System.out.println("result4.c : " + ((List)result4.get("c")).get(1).getClass() +":"+((List)result4.get("c")).get(1));
    } catch (IOException e) {
			e.printStackTrace();
		}

    System.out.println("jackson_ObjectMapper_get--------------------------end");
  }
  
  void jackson_objectmapper_loop(){
    System.out.println("jackson_ObjectMapper_loop--------------------------start");   

    try {
      ObjectMapper mapper = new ObjectMapper();
      String jsondata = "{\"a\":1,\"b\":2,\"c\":[\"xxxx\",\"yyyy\"],\"d\":{\"d1\":\"eeeee\",\"d2\":\"fffff\"}}";
      Map<String,Object> result5 = mapper.readValue(jsondata, Map.class);
      for (String key : result5.keySet()){
      	if (result5.get(key) instanceof Map) {
      		System.out.println("result5.get(\""+key+"\") instanceof Map");
          System.out.println(result5.get(key));
      	}else if (result5.get(key) instanceof List){
      		System.out.println("result5.get(\""+key+"\") instanceof List");;
          System.out.println(result5.get(key));
      	}	
      }
    } catch (IOException e) {
			e.printStackTrace();
		}

    System.out.println("jackson_ObjectMapper_loop--------------------------end");
  }

  void jackson_jsonnode(){
    System.out.println("jackson_JsonNode--------------------------start");   
    
    try {
      System.out.println("get------------");  
      ObjectMapper mapper = new ObjectMapper();
      JsonNode root = mapper.readTree(new File("file/input.json"));
      System.out.println(root);
      String member_name = root.get("member").get(0).get("name").asText();
      System.out.println(member_name);
      int age = root.get("member").get(3).get("age").asInt();
      System.out.println(age);
      JsonNode root_2 = root.get("member").get(0);
      System.out.println(root_2);

      System.out.println("put------------");  
      ((ObjectNode)root_2).put("name", "NO");
      ((ObjectNode)root_2).put("k", "v");
      System.out.println(root_2);

      System.out.println("for get------------");  
      for (JsonNode n : root.get("album")) {
          String album_name = n.get("name").asText();
          int year = n.get("year").asInt();
          String month = n.get("month").asText();
          int day = n.get("year").asInt();
          System.out.println(album_name + ": " + day + " " + month + " " + year);
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

    System.out.println("jackson_JsonNode--------------------------end");   
  }

  void type_sample(){
    System.out.println("type_sample--------------------------start");

    byte x1 = 127;
    short x2 = 32767;
    final int x3 = 2147483647;
    long x4 = 2147483647;
    float x5 = 1.5f;
    double x6 = 1.5d;
    char x7 = 'A';
    boolean x8 = true;
    String x9 = "abc";

    // x3 = 8;   final確認用

    System.out.println(x1);
    System.out.println(x2);
    System.out.println(x3);
    System.out.println(x4);
    System.out.println(x5);
    System.out.println(x6);
    System.out.println(x7);
    System.out.println(x8);
    System.out.println(x9);

    System.out.println("type_sample--------------------------end");
  }
}


class Hoge {
    public int id;
    public String name;

    @Override
    public String toString() {
        return "Hoge [id=" + id + ", name=" + name + "]";
    }
}


class GradleMain {
    public static void main(String args[]) {
        System.out.println("GradleMain============================start");
        Called c_001 = new Called();

        System.out.println("Basic================================");
        c_001.forIf();

        System.out.println("file================================");
        c_001.file_read();
        c_001.file_write();

        System.out.println("list, map================================");
        c_001.listIteratorArrays();
        c_001.arraylist_add_get_update_delete();
        c_001.arraylist_duplicate();
        c_001.hashmap_put();

        System.out.println("jackson================================");
        c_001.jackson_objectmapper_obj_str();
        c_001.jackson_objectmapper_loop();
        c_001.jackson_objectmapper_get();
        c_001.jackson_jsonnode();

        System.out.println("type================================");
        c_001.type_sample();

        System.out.println("GradleMain============================end");
    }
}

package sample.gradle;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

import java.util.Map;

import java.util.HashSet;
import java.util.LinkedHashSet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;


class Called {

   void calledPrint(){
        System.out.println("calledPrint--------------------------start");

        System.out.println("calledPrintB実行");

        System.out.println("calledPrint--------------------------end");
   }

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

   void arraylist(){
        System.out.println("arraylist--------------------------start");

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

        System.out.println("arraylist--------------------------end");
   }

   void list_duplicate(){
        System.out.println("list_duplicate--------------------------start");

        List<String> listA = new ArrayList<String>(Arrays.asList("s", "a", "m", "u", "r", "a", "i"));
        List<String> listB = new ArrayList<String>(new HashSet<>(listA));
        List<String> listC = new ArrayList<String>(new LinkedHashSet<>(listA));
        System.out.println("ListA = " + listA);
        System.out.println("ListB = " + listB);
        System.out.println("ListA = " + listC);

        System.out.println("list_duplicate--------------------------end");
   }

    void jackson_obj_str(){
        System.out.println("jackson_obj_str--------------------------start");

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

        System.out.println("jackson_obj_str--------------------------end");
    }

    void jackson_get(){
        System.out.println("jackson_get--------------------------end");        
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

        System.out.println("jackson_get--------------------------end");
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

        System.out.println("Basic================================");
        Called c_001 = new Called();
        c_001.calledPrint();
        c_001.forIf();

        System.out.println("ファイル操作================================");
        c_001.file_read();
        c_001.file_write();

        System.out.println("list, map================================");
        c_001.listIteratorArrays();
        c_001.arraylist();
        c_001.jackson_obj_str();
        c_001.jackson_get();
        c_001.list_duplicate();

        System.out.println("type================================");
        c_001.type_sample();

        System.out.println("GradleMain============================end");
    }
}

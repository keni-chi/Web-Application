# Java

## 概要
覚書である。順次記載予定。

### コンパイル、実行

#### 基本
1. build.gradleを作成  

  ```
  apply plugin: 'java'
  ```

2. フォルダ構成作成   
  ```
  │─build.gradle
  └─src
      └─main
          └─java
              └─sample
                  └─gradle
                          GradleMain.java
  ```   
  
3. GradleMain.javaを作成  
  ```
  package sample.gradle;

  public class GradleMain {
      public static void main(String[] args) {
          System.out.println("Hello Gradle!!");
      }
  }
  ```
  
4. コンパイル  
  ```
  gradle
  gradle compileJava
  ```

5. 実行
  ```
  java -cp build/classes/java/main sample.gradle.GradleMain
  ```

#### gradle run による実行
1. build.gradleに以下を追加
  ```
  apply plugin: 'application'
  mainClassName = 'sample.gradle.GradleMain'
  ```

2. 実行
  ```
  gradle
  gradle run
  ```

#### libsの利用  
1. libsフォルダを作成  
2. 必要な.jarファイルを置く  
3. build.gradleを編集して以下を追加
  ```
  dependencies {
      compile fileTree(dir: 'libs', include: '*.jar')
      compile files('libs/jackson-annotations-2.6.0.jar')
      compile files('libs/jackson-core-2.6.7.jar')
      compile files('libs/jackson-databind-2.6.7.1.jar')
      compile files('libs/jackson-dataformat-cbor-2.6.7.jar')
  }
  ```  


## 参考
[Gradle使い方メモ1](https://qiita.com/opengl-8080/items/4c1aa85b4737bd362d9e)  
[Gradle使い方メモ2(libs)](https://qiita.com/summer/items/ba5393e703f3d5a74e8a)  

[list,Iterator,arrayについて](https://qiita.com/masa-kunikata/items/72703085dbf59cc83052)  
[arrayListについて](https://www.sejuku.net/blog/20355#add_addAll)  
[jacksonについて](https://qiita.com/opengl-8080/items/b613b9b3bc5d796c840c)    
[jackson(pattern)について](http://www.hiihah.info/index.php?Java%EF%BC%9AJackson%E3%82%92%E3%81%A4%E3%81%8B%E3%81%A3%E3%81%A6JSON%E3%82%92%E8%AA%AD%E3%81%BF%E8%BE%BC%E3%82%80)  
[jackson JsonNodeについて](https://blog.kymmt.com/entry/jackson)  

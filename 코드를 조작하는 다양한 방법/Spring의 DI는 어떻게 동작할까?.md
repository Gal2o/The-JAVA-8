## BookService.java
``` java
@Service
public class BookService {
  
  @Autowired
  BookRepository bookRepository;
 
}
```
  - #### BookRepository 인스턴스는 어떻게 null이 아닌걸까?
  - #### Spring은 어떻게 BookService 인스턴스에 BookRepository 인스턴스를 넣어준 것일까?
-----
## Book.java
``` java
  public class Book {

    private String a = "a";

    private static String b = "BOOK";

    private static final String c = "BOOK";

    private String d = "d";

    protected String e = "e";

    public Book() {
    }

    public Book(String a, String d, String e) {
        this.a = a;
        this.d = d;
        this.e = e;
    }

    private void f() {
        System.out.println("F");
    }

    public void g() {
        System.out.println("G");
    }

    public int h() {
        return 100;
    }
}
```
-----
## Myinteface.java
``` java
  public interface Myinterface { }
```
## MyBook.java
``` java
  public class MyBook extends Book implements Myinterface { }
```
------
- ### 리플렉션의 시작은 `Class<T>`
- ### `Class<T>` 에 접근하는 방법
  - #### 모든 클래스를 로딩한 후, Class<T>의 인스턴스가 생긴다. "타입.class"로 접근할 수 있다.
  ``` java
    Class<Book> bookClass = Book.class
  ```
  - #### 모든 인스턴스는 getClass() 메소드를 가지고 있다. "인스턴스.getClass()"로 접근할 수 있다.
  ``` java
    // 새로운 인스턴스 만들기
    Book book = new Book();
  
    // getClass를 이용하여 클래스의 정보를 가지고 올 수 있다.
    Class<? extends Book> aClass = book.getClass();
  ```
  -------
  - #### 클래스를 문자열로 읽어오는 방법
    - #### Class.forName("FQCN")
    - #### -classpath에 해당 클래스가 없다면 ClassNotFoundException이 발생한다
    - #### Book의 경로까지 적어서 클래스 네임까지 적어주자
    ``` java
      System.out.println(Class.forName("com.example.thejavacode.Book"));
    ```
    - #### 결과
    ```
      class com.example.thejavacode.Book
    ```
  ------
  - #### getField를 사용해서 Book에 있는 메소드들을 가져올 수 있다. (Public 만 가능‼) <br><br> 하지만, `getDeclaredFields` 는 접근지시자를 따지지 않고 모두 가져온다
  ``` java
    Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);
  ```
  - #### 결과
  ```
    private java.lang.String com.example.thejavacode.Book.a
    private static java.lang.String com.example.thejavacode.Book.b
    private static final java.lang.String com.example.thejavacode.Book.c
    private java.lang.String com.example.thejavacode.Book.d
    protected java.lang.String com.example.thejavacode.Book.e
  ```
  ------
  - #### Book에 있는 값들을 가져오고 싶다
  ``` java
    Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            try {
                // 접근이 불가능한 필드에 모두 접근하려면 (private, protected)
                // setAccessible을 true를 설정해준다.
                // **리플렉션은 접근지시자들을 모두 무시할 수 있다**
                f.setAccessible(true);
                System.out.printf("%s %s\n", f, f.get(book));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
    });
  ```
  - #### 결과
  ```
    private java.lang.String com.example.thejavacode.Book.a a
    private static java.lang.String com.example.thejavacode.Book.b BOOK
    private static final java.lang.String com.example.thejavacode.Book.c BOOK
    private java.lang.String com.example.thejavacode.Book.d d
    protected java.lang.String com.example.thejavacode.Book.e e
  ```
------
  - ### 나머지 기능들
  ``` java
    // Modifier를 사용해서 접근지시자를 확인 할 수 있다.
    Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
        int modifiers = f.getModifiers();
        System.out.println(f);
        System.out.println(Modifier.isPrivate(modifiers));
        System.out.println(Modifier.isStatic(modifiers));
    });
  ```
  ``` java
    // 메소드 모두 가져오기
    Arrays.stream(bookClass.getMethods()).forEach(System.out::println);
  ```
  ``` java
    // 생성자 가져오기
    Arrays.stream(bookClass.getDeclaredConstructors()).forEach(System.out::println);
  ```
  ``` java
    // 상위 클래스 (부모, 슈퍼클래스) 가져오기
    System.out.println(MyBook.class.getSuperclass());
  ```
  ``` java
    // 인터페이스 가져오기
    Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);
  ```
  

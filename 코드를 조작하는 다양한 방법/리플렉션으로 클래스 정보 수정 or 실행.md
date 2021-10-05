# 리플렉션으로 클래스 정보 수정 or 실행하기

## Class 인스턴스 만들기
  - ### 일단 클래스 객체를 하나 만든다
  ``` java
    Class<?> bookClass = Class.forName("com.example.thejavacode.Book2");
  ```
  - ### 인스턴스 만들기
  ``` java
    // 기존 클래스의 인스턴스를 만드는 방법
    // 지금은 권장하지 않는다.
    bookClass.newInstance();
  ```
  ``` java
    // 기본생성자를 만들고 Book2를 캐스팅해서 인스턴스를 만든다.
    // 기본생성자는 파라미터 타입이 없으므로 null을 넘겨준다
    Constructor<?> constructor = bookClass.getConstructor(null);
    Book2 book2 = (Book2) constructor.newInstance();
  ```
  ``` java
    // String b가 필요한 생성자
    public Book2(String b) {
        B = b;
    }
    
    // 매개변수를 가지고 있는 생성자를 가지고 오고 싶다면, 맞는 파라미터 타입을 주면 된다
    Constructor<?> constructor = bookClass.getConstructor(String.class);
    Book2 book2 = (Book2) constructor.newInstance("Book2");
  ```
-------
## 클래스의 정보 조회 및 수정
  - ### 클래스의 필드 값을 가져오기
  ``` java
    // static 객체 가져오기
    public static String A = "A";
    
    Field a = Book2.class.getDeclaredField("A");
    
    // 넘겨줄 매개변수가 없다면, null을 넘겨줘서 get으로 조회할 수 있다.
    System.out.println(a.get(null));
    
    // set(넘겨 줄 매개변수, 값)으로 A 객체의 값을 변경 할 수 있다.
    a.set(null, "Change A");
    System.out.println(a.get(null));
  ```
  - ### 결과
  ```
    A
    Change A
  ```
  - ### static이 아닌 지역변수 필드 값 가져오기
  ``` java
    // 인스턴스 생성 후, 값을 초기화 하는 String B
    private String B = "B";
    
    // B는 인스턴스가 있어야만 값을 가지게 되는 객체이므로
    Field b = Book2.class.getDeclaredField("B");
    
    // private이므로 접근지시자 제한을 풀어주자
    b.setAccessible(true);
    
    // 위에 만들어 둔 인스턴스(book2)를 이용하여 B를 가져오자
    // A처럼 하면 NullPointerExeception 발생
    System.out.println(b.get(book2));
    
    b.set(book2, "Change B");
    System.out.println(b.get(book2));
  ```
  - ### 결과
  ```
    Book2
    Change B
  ```
--------
## 클래스의 메소드 정보 조회 및 수정
  - ### 클래스의 메소드 가져오기
  ``` java
    // C()를 호출하면 C를 출력하는 메소드
    private void C() {
        System.out.println("C");
    }
    
    // 메소드는 Method 변수 사용
    Method c = Book2.class.getDeclaredMethod("C");
    
    // C도 private이므로 접근 지시자 제한 해제
    c.setAccessible(true);
    
    // invoke로 메소드를 호출하고, 
    // 클래스의 인스턴스를 넘겨줘야 한다
    c.invoke(book2);
  ```
  - ### 결과
  ```
    C
  ```
  - ### 매개 변수를 필요로 하는 메소드 조회하기
  ``` java
    public int sum(int left, int right) {
        return left + right;
    }
    
    // 매개 변수가 int left, right 이므로 레퍼런스 타입으로 넘겨줘야 한다, 프리미티브 타입은 에러발생!
    Method sum = Book2.class.getDeclaredMethod("sum", int.class, int.class);
    int result = (int) sum.invoke(book2, 1, 2);
    System.out.println(result);
  ```
  - ### 결과
  ```
    3
  ```
  

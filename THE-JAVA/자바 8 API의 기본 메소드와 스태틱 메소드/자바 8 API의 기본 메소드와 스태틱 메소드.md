# 자바 8 API의 기본 메소드와 스태틱 메소드

## Iterable의 기본 메소드
  - forEach()
  - spliterator()

## Collection의 기본 메소드
  - stream() / parallelStream()
  - removeIf(Predicate)
  - spliterator()

## Comparator의 기본 메소드 및 스태틱 메소드
  - reversed()
  - thenComparing()
  - static reverseOrder() / naturalOrder()
  - static nullsFirst() / nullsLast()
  - static comparing()

### 자바 8 이전 API 설계, 라이브러리 구조
  > abstract 객체를 이용해서 API, 라이브러리 등을 구현함 (편의성 제공 목적)  
  > <img width="507" alt="image" src="https://user-images.githubusercontent.com/35948339/116230247-5c44ab00-a792-11eb-862e-10c96133e9f5.png">  
  > a, b, c 는 상속을 이용해서 abstract 구현

### 자바 8 이후 부터는 인터페이스가 제공한다  
  > <img width="297" alt="image" src="https://user-images.githubusercontent.com/35948339/116230645-dbd27a00-a792-11eb-8149-4072d4f01cc5.png"><br>
  > 기본 default 메소드를 구현  
  > 인터페이스를 implements 하여 비침투성, 상속을 강제하지 않고 자유롭게 사용할 수 있다  

  - WebMvcConfigurer 인터페이스와, 이 인터페이스를 구현한 WebMvcConfigurerAdapter(자바 8 이하, Deprecated) 내부에 있는 비어져 있는 메소드들 
  - ex) void a() 이러한 상속이 자바 8에서는 필요 없다.

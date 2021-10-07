## 다이나믹 프록시
  - #### 리플렉션의 일부
  - #### 스프링 데이터 JPA는 다이나믹 프록시가 쓰인다
----------
## 스프링 데이터 JPA는 어떻게 동작할까?
  - #### BookRepository.java
  ``` java
    public interface BookRepository extends JpaRepository<Book, Integer> {
    }
  ```
  - #### 1️⃣ 인터페이스 하나로 어떻게 JPA를 동작시킬 수 있는 것 일까? <br><br> 2️⃣ 스프링 데이터 JPA에서 인터페이스 타입의 인스턴스는 누가 만드는 것 일까?
  - #### ➡ Spring AOP를 기반으로 동작하며 RepositoryFactorySupport에서 프록시를 생성한다
--------
## 프록시 패턴
  - ![image](https://user-images.githubusercontent.com/35948339/136430879-2b8efe0d-0b83-40f3-b3cc-65a9c69ad8d3.png)

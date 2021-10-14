## Lombok
  - #### @Getter, @Setter, @Builder, @EqualsAndHashCode 등 <br><br> `애노테이션`과 `애노테이션 프로세서`를 제공하여 반복적인 코드를 작성할 때, 편하게 생성해줌
  - ### Lombok 동작 원리
    - #### 컴파일 시점에 `애노테이션 프로세서`를 사용하여 `소스코드의 AST(abstract syntax tree)`를 조작한다
    - <img src="https://user-images.githubusercontent.com/35948339/136820115-1d881b23-eeec-446e-90e5-427e01ca9e1c.png" width=550>
  - #### 논란거리
    - #### AST : 소스코드의 구조를 트리로 보여줌 <br><br> ‼ 원래, 참조만 가능하고 수정할 순 없다. <br><br> 그런데 참조만 가능한 API를 수정가능 하게 해서 Lombok이 구현 되도록 만든다
    - #### 📍 그럼에도 불구하고 대안이 없고 편리함 때문에 계속 쓰이는 중..
-------

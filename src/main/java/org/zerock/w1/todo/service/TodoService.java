package org.zerock.w1.todo.service;

import org.zerock.w1.todo.dto.TodoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//enum타입으로 클래스 작성 시 이점 : 정해진 수만큼만 객체를 생성할 수 있다.
public enum TodoService {
    INSTANCE; //객체의 개수를 결정하는 부분으로 한 개만 지정 -> 하나의 객체만을 생성해서 사용 : 싱글톤 패턴

    //새로운 TodoDTO 객체를 받아서 확인
    public void register(TodoDTO todoDTO){
        System.out.println("DEBUG.........................." + todoDTO);
    }

    //10개의 TodoDTO 객체를 만들어 반환하도록 구성
    public List<TodoDTO> getList(){
        List<TodoDTO> todoDTOS = IntStream.range(0,10).mapToObj(i -> {
            TodoDTO dto = new TodoDTO();
            dto.setTno((long)i);
            dto.setTitle("Todo..." +i);
            dto.setDueDate(LocalDate.now());

            return dto;
        }).collect(Collectors.toList());

        return todoDTOS;
    }

    //샘플용 TodoDTO 객체를 생성해서 반환해주도록 구현
    public TodoDTO get(Long tno){
        TodoDTO dto = new TodoDTO();
        dto.setTno(tno);
        dto.setTitle("Sample Todo");
        dto.setDueDate(LocalDate.now());
        dto.setFinished(true);

        return dto;
    }

}

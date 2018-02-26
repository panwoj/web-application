package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TaskMapperTest {

    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    public void shouldMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto((long) 1, "test", "test");
        //When
        Task task = taskMapper.mapToTask(taskDto);
        //Then
        Assert.assertEquals(taskDto.getId(), task.getId());
        Assert.assertEquals(taskDto.getContent(), task.getContent());
        Assert.assertEquals(taskDto.getTitle(), task.getTitle());
    }

    @Test
    public void shouldMapToTaskDto() {
        //Given
        Task task = new Task((long) 1, "test", "test");
        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //Then
        Assert.assertEquals(taskDto.getId(), task.getId());
        Assert.assertEquals(taskDto.getContent(), task.getContent());
        Assert.assertEquals(taskDto.getTitle(), task.getTitle());
    }

    @Test
    public void shouldMapToTaskDtoList() {
        //Given
        List<Task> taskList = new ArrayList<>();
        Task task1 = new Task((long)1, "test1", "test1");
        Task task2 = new Task((long)2, "test2", "test2");
        Task task3 = new Task((long)3, "test3", "test3");
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);
        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);
        //Then
        Assert.assertEquals(taskList.size(), taskDtoList.size());
    }
}

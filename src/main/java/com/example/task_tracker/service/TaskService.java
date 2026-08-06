package com.example.task_tracker.service;

import com.example.task_tracker.model.Task;
import com.example.task_tracker.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;
import com.example.task_tracker.model.Status;

public class TaskService {
    private final TaskRepository repos;
    private final List<Task> task;

    private int maxIdGenerate(){
        int maxId = 0;
        for (Task tak : task){
            if (maxId < tak.getId()){
                maxId = tak.getId();
            }
        }
        return maxId + 1;
    }

    public TaskService(){
        repos = new TaskRepository();
        task = repos.loadTasks();
    }
    
    public void addTask(String des){
        if (des.length() == 0){
            return;
        }
        int idMax = maxIdGenerate();
        Task tak = new Task();

        tak.setId(idMax);
        tak.setDescription(des);
        tak.setStatus(Status.TODO);
        tak.setCreatedAt(LocalDateTime.now());
        tak.setUpdatedAt(LocalDateTime.now());

        task.add(tak);
        repos.saveTasks(task);
        System.out.println("Task added successfully (ID: " + idMax + ")");
    }

    public void updateTask(int s_id, String newDes){
        boolean flag = false;
        for (Task tak : task){
            if (s_id == tak.getId()){
                tak.setDescription(newDes);
                tak.setUpdatedAt(LocalDateTime.now());
                flag = true;
                System.out.println("Da update task thanh cong");
                break;
            }
        }
        repos.saveTasks(task);
        if (flag == false){
            System.out.println("Khong tim thay id:" + s_id);
        }
    }

    public void deleteTask(String d_id){
        boolean remove = false;
        if (d_id.equals("all")){
            task.clear();
            remove = true;
        } else{
            remove = task.removeIf(tak -> tak.getId() == Integer.parseInt(d_id));
        }
        if (remove == false){
            System.out.println("Khong tim thay task");
        } else{
            System.out.println("Da xoa task thanh cong");
            repos.saveTasks(task);
        }
    }

    public void updateStatus(int s_id, Status newSta){
        boolean flag = false;
        for (Task tak : task){
            if (tak.getId() == s_id){
                tak.setStatus(newSta);
                tak.setUpdatedAt(LocalDateTime.now());
                System.out.println("Da update status task thanh cong");
                flag = true;
                break;
            }
        }
        repos.saveTasks(task);
        if (flag == false){
            System.out.println("Ko tim thay id");
        }
    }

    public void listTask(Status filter){
        if (task.isEmpty()){
            System.out.println("List chua co task nao");
            return;
        }
        for (Task tak : task){
            if (filter == null || tak.getStatus() == filter){
                System.out.println("[" + tak.getId() + "]:" + tak.getDescription() + "------" +
                    "Creat: " + tak.getCreatedAt() + "------" + "Updated: " + tak.getUpdatedAt());
            }
        }
    }
}

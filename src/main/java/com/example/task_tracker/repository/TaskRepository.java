package com.example.task_tracker.repository;

import com.example.task_tracker.model.Task;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import com.example.task_tracker.model.Status;

public class TaskRepository {
    
    private final Path path = Paths.get("tasks.json");

    private String getVal(String s, String begin, String end){
        int start = s.indexOf(begin) + begin.length();
        int en = s.indexOf(end, start);
        if (en == -1){
            en = s.indexOf("}", start);
        }
        return s.substring(start, en).trim();
    }

    public List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        if (!Files.exists(path)){
            return tasks;
        }
        try {
            String json = Files.readString(path).trim();
            if (json.length() <= 2){
                return tasks;
            }
            String cont = json.substring(1, json.length()-1).trim();
            String[] blocks = cont.split("},");
            for (String block : blocks){
                Task tak = new Task();

                tak.setId(Integer.parseInt(getVal(block, "\"id\":", ",")));
                tak.setDescription(getVal(block, "\"description\":\"", "\""));
                tak.setStatus(Status.valueOf(getVal(block, "\"status\":\"", "\"")));
                tak.setCreatedAt(LocalDateTime.parse(getVal(block, "\"createdAt\":\"", "\"")));
                tak.setUpdatedAt(LocalDateTime.parse(getVal(block, "\"updatedAt\":\"", "\"")));
                
                tasks.add(tak);
            }
            
        } catch (Exception ex){
            System.out.println("Loi doc file:" + ex.getMessage());
        }
        return tasks;
    }

    public void saveTasks(List<Task> tasks) {
        StringBuilder jsonBuild = new StringBuilder("[\n");
        for (int i=0; i < tasks.size(); i++){
            Task task = tasks.get(i);
            jsonBuild.append("  {\n");
            jsonBuild.append("    \"id\":").append(task.getId()).append(",\n");
            String safeDes = task.getDescription().replace("\"", "\\\"");
            jsonBuild.append("    \"description\":\"").append(safeDes).append("\",\n");
            jsonBuild.append("    \"status\":\"").append(task.getStatus()).append("\",\n");
            jsonBuild.append("    \"createdAt\":\"").append(task.getCreatedAt().toString()).append("\",\n");
            jsonBuild.append("    \"updatedAt\":\"").append(task.getUpdatedAt().toString()).append("\"\n");
            jsonBuild.append("  }");
            if (i < tasks.size()-1){
                jsonBuild.append(",");
            }
            jsonBuild.append("\n");
        }
        jsonBuild.append("]");

        try{
            Files.writeString(path, jsonBuild.toString());
        }catch (Exception ex){
            System.out.println("Loi ghi file: " + ex.getMessage());
        }
    }
}
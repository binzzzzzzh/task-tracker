package com.example.task_tracker.repository;

import com.example.task_tracker.model.Task;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

public class TaskRepository {
    
    private final Path path = Paths.get("tasks.json");

    public List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        if (!Files.exists(path)){
            return tasks;
        }
        try {
            String json = Files.readString(path).trim();
            
        }
        // TODO: 1. Kiểm tra file có tồn tại không
        // TODO: 2. Đọc toàn bộ nội dung file thành 1 chuỗi String (dùng Files.readString)
        // TODO: 3. Viết thuật toán cắt chuỗi JSON đó ra để trích xuất dữ liệu
        // TODO: 4. Tạo các Object Task và thêm vào biến tasks
        
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
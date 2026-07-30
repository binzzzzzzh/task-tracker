package com.example.task_tracker.repository;

import com.example.task_tracker.model.Task;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

public class TaskRepository {
    
    private final String FILE_PATH = "tasks.json";

    public List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        
        // TODO: 1. Kiểm tra file có tồn tại không
        // TODO: 2. Đọc toàn bộ nội dung file thành 1 chuỗi String (dùng Files.readString)
        // TODO: 3. Viết thuật toán cắt chuỗi JSON đó ra để trích xuất dữ liệu
        // TODO: 4. Tạo các Object Task và thêm vào biến tasks
        
        return tasks;
    }

    public void saveTasks(List<Task> tasks) {
        // TODO: 1. Tạo một StringBuilder để chứa chuỗi JSON
        // TODO: 2. Dùng vòng lặp duyệt qua biến tasks
        // TODO: 3. Lắp ráp từng thuộc tính (id, description...) thành chuỗi định dạng JSON
        // TODO: 4. Ghi đè chuỗi đó xuống file (dùng Files.writeString)
    }
}
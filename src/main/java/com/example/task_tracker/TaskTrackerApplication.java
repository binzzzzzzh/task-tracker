package com.example.task_tracker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.task_tracker.model.Status;
import com.example.task_tracker.service.TaskService;

@SpringBootApplication
public class TaskTrackerApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TaskTrackerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		if (args.length == 0){
			System.out.println("Khong co lenh");
			return;
		}
		TaskService taskserv = new TaskService();
		String com = args[0];

		try {
			switch (com){
				case "add":
					if (args[1] == ""){
						System.out.println("Loi: khong co noi dung task");
						break;
					}
					taskserv.addTask(args[1]);
					break;
				case "update":
					if (args.length < 3 || args.length > 3){
						System.out.println("Loi: thieu hoac thua noi dung");
						break;
					}
					taskserv.updateTask(Integer.parseInt(args[1]), args[2]);
					break;
				case "delete":
					if (args.length < 2){
						System.out.println("Loi: thieu id de xoa");
						break;
					}
					taskserv.deleteTask(args[1]);
					break;
				case "mark-in-progress":
					if (args.length < 2){
						System.out.println("Loi: ko co id de mark");
						break;
					}
					taskserv.updateStatus(Integer.parseInt(args[1]), Status.IN_PROGRESS);
					break;
				case "mark-done":
					if (args.length < 2){
						System.out.println("Loi: ko co id de mark");
						break;
					}
					taskserv.updateStatus(Integer.parseInt(args[1]), Status.DONE);
					break;
				case "list":
					if (args.length == 1){
						taskserv.listTask(null);
						break;
					}
					String comm = args[1];
					if (comm.equals("done")){
						taskserv.listTask(Status.DONE);
					} else if (comm.equals("todo")){
						taskserv.listTask(Status.TODO);
					} else if (comm.equals("in-progress")){
						taskserv.listTask(Status.IN_PROGRESS);
					} else {
						System.out.println("Lenh ko hop le");
					}
					break;
				default:
					System.out.println("Lenh ko hop le");
			}
		} catch (NumberFormatException e){
			System.out.println("Loi: phai la so nguyen");
		} catch (Exception e){
			System.out.println("Xay ra loi");
		}
	}

}

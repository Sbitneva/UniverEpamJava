package sbitneva.homeworks.entities;

public class Task {
    private int taskIndex;
    private int taskData[];

    public Task(int taskIndex, int matrix[]) {
        this.taskIndex = taskIndex;
        this.taskData = matrix;
    }

    public int getTaskIndex() {
        return taskIndex;
    }

    public int[] getTaskData() {
        return taskData;
    }

    @Override
    public String toString() {
        return "Task{" + "taskIndex=" + taskIndex + '}';
    }
}

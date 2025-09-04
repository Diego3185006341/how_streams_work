package org.example;

class MyTask extends Thread {
    private String name;

    public MyTask(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + " - Count: " + i);
            try {
                Thread.sleep(500); // simulate work
            } catch (InterruptedException e) {
                System.out.println(name + " interrupted");
            }
        }
    }
}

public class Foo {
    public static void main(String[] args) {
        Thread t = new Thread(new ShirsRunnable());
        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<10; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("hello world");
                }
            }
        });
        t2.start();
    }
}

class ShirsRunnable implements Runnable{

    @Override
    public void run() {
        for (int i=0; i<10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Integer.valueOf(i));
        }
    }
}

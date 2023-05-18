public class PriorityQueue {
    int SIZE = 5;
    int[] items = new int[SIZE];
    int front, rear;

    PriorityQueue() {
        front = -1;
        rear = -1;
    }

    public static void quickSort(int[] source, int leftBorder, int rightBorder) {
        int leftMarket = leftBorder;
        int rightMarket = rightBorder;
        int privot = source[(leftMarket + rightMarket) / 2];
        do {
            while (source[leftMarket] < privot) {
                leftMarket++;
            }
            while (source[rightMarket] > privot) {
                rightMarket--;
            }
            if (leftMarket <= rightMarket) {
                if (leftMarket < rightMarket) {
                    int tmp = source[leftMarket];
                    source[leftMarket] = source[rightMarket];
                    source[rightMarket] = tmp;
                }
                leftMarket++;
                rightMarket--;
            }
        } while (leftMarket <= rightMarket);
        if (leftMarket < rightMarket) {
            quickSort(source, leftMarket, rightBorder);
        }
        if (leftBorder < rightMarket) {
            quickSort(source, leftBorder, rightMarket);
        }
    }

    boolean isFull() {
        if (front == 0 && rear == SIZE - 1) {
            return true;
        }
        return false;
    }

    boolean isEmpty() {
        if (front == -1)
            return true;
        else
            return false;
    }

    void enQueue(int element) {
        if (isFull()) {
            System.out.println("Очередь заполнена");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear++;
            items[rear] = element;
            quickSort(items, front, rear);
            System.out.println("Добавлен элемент" + element);
        }
    }

    int deQueue() {
        int element;
        if (isEmpty()) {
            System.out.println("Очередь пуста");
            return (-1);
        } else {
            element = items[front];
            if (front >= rear) {
                front = -1;
                rear = -1;
            } else {
                front++;
            }
            System.out.println("Удалён элемент -> " + element);
            return (element);
        }
    }

    void display() {
        int i;
        if (isEmpty()) {
            System.out.println("Пустая очеедь");
        } else {
            System.out.println("\n Индекс Front -> " + front);
            System.out.println("Элементы -> ");
            for (i = front; i <= rear; i++)
                System.out.println(items[i] + " ");
            System.out.println("\n Индекс REAR -> " + rear);
        }
    }

    public static void main(String[] args) {
        PriorityQueue q = new PriorityQueue();
        q.deQueue();
        q.enQueue(4);
        q.enQueue(1);
        q.enQueue(3);
        q.enQueue(2);
        q.enQueue(6);
        q.display();
        q.deQueue();
        q.display();
    }
}

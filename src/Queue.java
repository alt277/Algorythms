import java.util.EmptyStackException;

    public class Queue<Item> {
        private Item[] list;
        private int size = 0;
        private final int DEFAULT_CAPACITY = 10;

        private int begin = 0;
        private int end = 0;

        public Queue(int capacity) {
            if (capacity <= 0) {
                throw new IllegalArgumentException("bad size");
            }
            list = (Item[]) new Object[capacity];
        }

        public Queue() {
            list = (Item[]) new Object[DEFAULT_CAPACITY];
        }


        public void insert(Item item) {
            if (isFull()) {
                throw new StackOverflowError();
            }
            size++;
            list[end] = item;
            end = nextIndex(end);
        }

        public Item remove() {
            Item value = peekFront();
            size--;
            list[begin] = null;
            begin = nextIndex(begin);
            return value;
        }

        private int nextIndex(int index) {
            return (index + 1) % list.length;
        }

        private Item peekFront() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return list[begin];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == list.length;
        }

        public int size() {
            return size;
        }


        public static void main(String[] args) {

            Queue<Integer> queue = new Queue<>(10);

            for (int i = 0; i <queue.DEFAULT_CAPACITY ; i++) {
                queue.insert(i);
                System.out.println("size="+queue.size);
            }
            for (int i = 0; i < queue.DEFAULT_CAPACITY; i++) {
                System.out.println(queue.remove());
            }
            System.out.println("size="+queue.size());

        }

    }


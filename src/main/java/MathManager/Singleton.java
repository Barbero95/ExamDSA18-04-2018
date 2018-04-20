package MathManager;

public class Singleton {

        private static Singleton instance;
        private Singleton() {
            // Exists only to defeat instantiation.
        }
        public static Singleton getInstance() {
            if(instance == null) {
                instance = new Singleton();
            }
            return instance;
        }

        private MathManagerImpl impl = new MathManagerImpl();

        public MathManagerImpl getImpl() {
            return impl;
        }
}

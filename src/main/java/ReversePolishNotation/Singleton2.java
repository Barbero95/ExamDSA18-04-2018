package ReversePolishNotation;

import MathManager.MathManagerImpl;

public class Singleton2 {

        private static Singleton2 instance;
        private Singleton2() {
            // Exists only to defeat instantiation.
        }
        public static Singleton2 getInstance() {
            if(instance == null) {
                instance = new Singleton2();
            }
            return instance;
        }

        private Procesar impl = new Procesar();

        public Procesar getImpl() {
            return impl;
        }
}

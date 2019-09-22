(ns tutorial.interop
  (:import (java.util Random)
           (java.awt Frame Color EventQueue)
           (java.lang Thread$UncaughtExceptionHandler)))

(= (String. "asdf") "asdf")

(let [string (String. "asdf")]
  (.charAt string 0))

(System/getProperty "java.version")
(let [string (String. "asdf")]
  (. string charAt 1))

(.. (StringBuilder.)
    (append "Running java ")
    (append (System/getProperty "java.version"))
    (toString))


(let [rand (Random.)]
  (.nextInt rand))
(let [frame (doto (Frame.)
              (.setLayout nil)
              (.setSize 400 300)
              (.setBackground Color/CYAN)
              (.setVisible true))]

  (.start (Thread. (fn []
                     (Thread/sleep 1000)
                     (EventQueue/invokeLater (fn []
                                               (.dispose frame)))))))

(let [result (try
               (/ 10 1)
               (catch Exception e
                 :unknown-error)
               (finally
                 :cleanup))]
  result)

(Thread/setDefaultUncaughtExceptionHandler
  (reify Thread$UncaughtExceptionHandler
    (uncaughtException [this thread throwable]
      (println (.getMessage throwable)))))


<h1 align="center">Threads</h1>
<p>En Java, un "thread" (hilo) es la unidad más pequeña de ejecución dentro de un programa. Un programa Java puede tener varios hilos que se ejecutan simultáneamente, permitiendo la ejecución concurrente de tareas. Los hilos permiten que las aplicaciones realicen multitarea, ejecutando diferentes partes del código de forma independiente.</p>
<p>En términos más simples, un programa Java puede tener varios hilos de ejecución, y cada hilo realiza una secuencia de instrucciones. Los hilos comparten recursos, como la memoria y los datos, pero tienen su propia pila de ejecución.</p>
<p>Algunos conceptos clave relacionados con los hilos en Java son:</p>
<p><b>Multitarea:</b></p>

- Multitarea en hardware: Refiere a la capacidad de la CPU para ejecutar múltiples hilos de forma simultánea mediante técnicas como la multiprogramación o la multiprocesamiento.
- Multitarea en software: Se refiere a la capacidad de un programa para realizar varias tareas simultáneamente, y los hilos son la forma en que se logra en Java.

<p><b>Proceso vs. Hilo:</b></p>

- Un programa en Java se ejecuta en su propio proceso.
- Cada proceso puede tener uno o más hilos de ejecución.
- Los hilos dentro de un mismo proceso comparten recursos y memoria, mientras que los procesos son independientes.

<p><b>Clase Thread:</b></p>

- En Java, la clase fundamental para trabajar con hilos es Thread.
- Puedes crear un hilo extendiendo la clase Thread y sobrescribiendo su método run().
- Al instanciar un objeto de tu clase que extiende Thread y llamar a su método start(), se inicia un nuevo hilo de ejecución.

<h2  align="center">Métodos de la clase Thread</h2>

<p><b>start():</b></p>

-  Inicia la ejecución del hilo. Cuando se llama a este método, se invoca internamente el método run() que contiene el código a ejecutar en el hilo.

<p><b>run():</b></p>

-  Este método contiene el código que se ejecutará en el hilo. Debe ser sobrescrito por la clase que extiende Thread o implementa Runnable.

<p><b>sleep(long millis):</b></p>

- Hace que el hilo actual se suspenda durante el tiempo especificado en milisegundos. Puede lanzar una excepción InterruptedException.

<p><b>join():</b></p>

- Hace que el hilo que llama espere hasta que el hilo en el que se llama haya terminado su ejecución.

<p><b>isAlive():</b></p>

- Retorna true si el hilo está vivo (ha sido iniciado pero no ha terminado aún), y false en caso contrario.

<p><b>getId():</b></p>

- Retorna el identificador único del hilo.

<p><b>setName(String name):</b></p>

- Establece el nombre del hilo.

<p><b>getName():</b></p>

- Retorna el nombre del hilo.

<p><b>currentThread():</b></p>

- Retorna la referencia al objeto Thread que representa el hilo en el que se está ejecutando el método.

<p><b>yield():<p><b>

- Indica al sistema que el hilo actual está dispuesto a ceder su tiempo de ejecución. Es una sugerencia al planificador de hilos, no una garantía.

<p><b>interrupt():</b></p>

- Interrumpe el hilo. Puede lanzar una excepción InterruptedException en el hilo si este estaba en un estado de espera o durmiendo.

<p><b>isInterrupted():</b></p>

- Retorna true si el hilo ha sido interrumpido, y false si no.

<p><b>setPriority(int priority):</b></p>

- Establece la prioridad del hilo. Los valores válidos van desde Thread.MIN_PRIORITY hasta Thread.MAX_PRIORITY.

<p><b>getPriority():</b></p>

- Retorna la prioridad del hilo.

<h2 align="center">Runneable</h2>
<p>La interfaz <b>'Runnable'</b> en Java es una interfaz funcional que proporciona una forma de definir tareas que pueden ser ejecutadas por un hilo. Esta interfaz se utiliza comúnmente al trabajar con hilos en lugar de extender la clase <b>'Thread'</b>. La ventaja de usar <b>'Runnable'</b> es que puedes separar la lógica de la tarea de la lógica de ejecución del hilo, lo que facilita la reutilización del código.</p>
<p>La interfaz <b>'Runnable'</b> tiene un solo método llamado <b>'run()'</b>, que debe ser implementado por cualquier clase que la implemente. Este método contiene el código que se ejecutará en el hilo cuando se inicie.</p>

<h2 aling="center">'Join' vs 'Sleep'</h2>
<h3>Join</h3>
<p>Propósito: El método <b>join()</b> se utiliza para esperar a que un hilo termine su ejecución antes de que el hilo actual continúe su ejecución.<p>
<p>Uso:</p> Se puede llamar al método <b>join()</b> en un objeto <b>Thread</b> desde otro hilo para esperar hasta que ese hilo termine.
<p> El método <b>join()</b> también tiene una versión que permite especificar un tiempo máximo de espera, después del cual el hilo actual continúa su ejecución incluso si el hilo al que se está uniendo aún no ha terminado.</p>

<h3>Sleep(long millis)</h3>
<p>Propósito: El método <b>sleep()</b> se utiliza para hacer que un hilo espere durante un período de tiempo específico antes de reanudar su ejecución.</p>
<p>Uso: Se puede utilizar <b>sleep()</b> para introducir retardos en la ejecución del hilo actual.</p>
<p><b>sleep()</b> no libera los recursos que el hilo pueda estar utilizando, y también puede lanzar una excepción InterruptedException si el hilo es interrumpido mientras está dormido.</p>

<p>En resumen, <b>join()</b> se utiliza para esperar a que otro hilo termine, mientras que <b>sleep()</b> se utiliza para hacer que un hilo espere durante un período de tiempo específico antes de continuar su ejecución. Ambos son útiles en situaciones diferentes, dependiendo de los requisitos específicos de la aplicación.</p>

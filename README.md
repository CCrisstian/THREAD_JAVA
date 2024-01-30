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

<h2 align="center">'Join' vs 'Sleep'</h2>
<h3>Join</h3>
<p>Propósito: El método <b>join()</b> se utiliza para esperar a que un hilo termine su ejecución antes de que el hilo actual continúe su ejecución.<p>
<p>Uso: Se puede llamar al método <b>join()</b> en un objeto <b>Thread</b> desde otro hilo para esperar hasta que ese hilo termine.</p>
<p> El método <b>join()</b> también tiene una versión que permite especificar un tiempo máximo de espera, después del cual el hilo actual continúa su ejecución incluso si el hilo al que se está uniendo aún no ha terminado.</p>

<h3>Sleep(long millis)</h3>
<p>Propósito: El método <b>sleep()</b> se utiliza para hacer que un hilo espere durante un período de tiempo específico antes de reanudar su ejecución.</p>
<p>Uso: Se puede utilizar <b>sleep()</b> para introducir retardos en la ejecución del hilo actual.</p>
<p><b>sleep()</b> no libera los recursos que el hilo pueda estar utilizando, y también puede lanzar una excepción InterruptedException si el hilo es interrumpido mientras está dormido.</p>

<p>En resumen, <b>join()</b> se utiliza para esperar a que otro hilo termine, mientras que <b>sleep()</b> se utiliza para hacer que un hilo espere durante un período de tiempo específico antes de continuar su ejecución. Ambos son útiles en situaciones diferentes, dependiendo de los requisitos específicos de la aplicación.</p>

<h2 align="center">Synchronized</h2>
<p>El modificador <b>'synchronized</b> en Java se utiliza para crear secciones críticas en código, lo que significa que solo un hilo puede ejecutar ese bloque de código a la vez. Esto ayuda a evitar problemas de concurrencia y a garantizar que ciertas secciones del código no sean ejecutadas simultáneamente por múltiples hilos, lo que podría llevar a condiciones de carrera y resultados inesperados</p>
<p>Se puede usar <b>'synchronized</b> de dos maneras: en métodos o en bloques de código.</p>
<h3>1. Método Sincronizado:</h3>
<p>Cuando un método está marcado como <b>'synchronized</b>, se obtiene un bloqueo en el objeto en el que se está llamando el método. Esto significa que otros hilos que intenten ejecutar cualquier método sincronizado en el mismo objeto tendrán que esperar a que el bloqueo se libere.</p>
<h3>2. Bloque de Código Sincronizado:</h3>
<p>En este caso, el bloque de código sincronizado está limitado al objeto específico (miObjeto) que se proporciona como argumento al bloque <b>'synchronized'</b>. Otros hilos que intenten ejecutar un bloque sincronizado en el mismo objeto tendrán que esperar.</p>
<h3>Uso adecuado de <b>'synchronized'</b>:</h3>

- <b>Evitar excesivo bloqueo:</b> El uso excesivo de synchronized puede conducir a la degradación del rendimiento. Es importante sincronizar solo las secciones críticas necesarias para evitar bloquear innecesariamente otros hilos.

- <b>Usar objetos compartidos como bloqueo:</b> Si varios hilos trabajan con el mismo recurso compartido, es común usar ese objeto compartido como el objeto de bloqueo.

- <b>Usar métodos atómicos:</b> Cuando sea posible, utiliza métodos atómicos proporcionados por las clases del paquete java.util.concurrent en lugar de synchronized para realizar operaciones seguras sin necesidad de bloquear todo el método o bloque de código.

<p>El uso adecuado de <b>synchronized'</b> es esencial para garantizar la consistencia y evitar problemas de concurrencia en aplicaciones multihilo.</p>

<h2 align="center">Wait(), Notify() y NotifyAll()</h2>

<p>El método <b>'wait()'</b> es un método de la clase Object en Java, no de la clase Thread. Sin embargo, es comúnmente utilizado en el contexto de la programación concurrente y la gestión de hilos. <b>'wait()'</b> se utiliza junto con el método <b>'notify()</b> y <b>'notifyAll()'</b> para lograr la sincronización y la comunicación entre hilos.</p>
<h3>Uso Básico:</h3>
<p>El método <b>'wait()'</b> se utiliza dentro de un bloque sincronizado para liberar el bloqueo del objeto y hacer que el hilo espere hasta que otro hilo llame a <b>'notify()</b> o <b>'notifyAll()'</b> en el mismo objeto. Cuando un hilo llama a <b>'wait()'</b>, se suspende su ejecución y libera el bloqueo asociado al objeto. El hilo permanece en estado de espera hasta que otro hilo llama a <b>'notify()'</b> o <b>'notifyAll()'</b> en el mismo objeto, lo que despierta al hilo en espera.</p>
<h3>Uso con 'notify()' y 'notifyAll()':</h3>

- notify(): Despierta a uno de los hilos que están en espera (elegido de manera no determinista).
- notifyAll(): Despierta a todos los hilos que están en espera. A menudo es preferible usar notifyAll() para evitar situaciones en las que algunos hilos podrían quedarse en espera indefinidamente.

<h3>Consideraciones Importantes:</h3>

- Dentro de un bloque sincronizado: wait() debe ser llamado dentro de un bloque sincronizado para evitar condiciones de carrera.
- En un bucle mientras: Es común utilizar wait() dentro de un bucle while que verifica una condición para evitar "despertares espurios" (despertares sin una notificación real).
- Excepción InterruptedException: wait() puede lanzar InterruptedException, por lo que es necesario manejar esta excepción.

<p>La combinación de <b>'wait()'</b>, <b>'notify()'</b>, y <b>'notifyAll()'</b> es fundamental para la implementación de patrones de comunicación entre hilos en Java. Estos métodos proporcionan una forma segura de sincronizar y coordinar la ejecución de hilos en situaciones donde se comparten recursos.</p>
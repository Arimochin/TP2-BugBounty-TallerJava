## Entregable

Completar la siguiente tabla con un análisis de cada test fallido. Para cada uno indicar la causa raíz del error y la corrección aplicada.

| Test (`Clase.método`) | Descripción del error                                                                                                                                                                                                                                       | Descripción de la solución                                                                |
|---|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------|
| `LogServiceTest.addLogs` | El test dice que se esperaba "100000" pero el resultado era "200000". El test compara el tamaño de la lista de eventos que se quieren registrar con la lista de Logs donde se añaden. En addLog se estaba añadiendo el log dos veces a la lista.            | Eliminar una de las lineas que decia "list.add(log);"                                     |
| `LogServiceTest.hasAllLogsConcurrent` |                                                                                                                                                                                                                                                             |                                                                                           |
| `LogServiceTest.getLogsByUser` | El test indica que un objeto User deberia identificarse por su nombre. El error seria que no se considero que el HashMap utiliza para comparar los metodos equals() y hashCode(), y que para comparar un objeto por defecto usa las referencias de memoria. | Sobreescribir equals() y hashCode() en User para que compare correctamente por el nombre. |
| `TodoServiceTest.testCreateTodo` | En el metodo createNewTodo no se estaba seteando el contenido en el nuevo ToDo.                                                                                                                                                                             | Agregamos la linea "nuevo.setContent(content);" antes de hacer "addTODO(nuevo);".         |
| `TodoServiceTest.testTimerDelete` | En el metodo deleteOldMessages se preguntaba si los segundos del ToDo son menores que los segundo dados.                                                                                                                                                    | Invertir el simbolo para que quede "segundosDelTodo > sec".                               |
| `CurrentUserTest.testGetsDefaultUser` | El error era que en el metodo getCurrent() la condicion del if estaba invertida. Era si current != null entonces creo usuario, lo que hace que si es null, se retorna null.                                                                                 | Invertir condicion para que quede "current == null".                                      |
| `CurrentUserTest.testCurrentConcurrent` |                                                                                                                                                                                                                                                             |                                                                                           |
| `UserServiceTest.testSortedByName` | El error era que en el metodo getUsers() de UserService se estaba ordenando la lista por Id.                                                                                                                                                                | Cambiar la linea donde se ordena, reemplazar User::getId por User::getName.               |
| `UserServiceTest.testAddNullUser` |                                                                                                                                                                                                                                                             |                                                                                           |
| `UserServiceTest.testLoginUser` |                                                                                                                                                                                                                                                             |                                                                                           |
| `UserServiceTest.testAddUsersAndClear` |                                                                                                                                                                                                                                                             |                                                                                           |

### LogServiceTest
```bash
mvn test -Dtest=LogServiceTest#addLogs
mvn test -Dtest=LogServiceTest#hasAllLogsConcurrent
mvn test -Dtest=LogServiceTest#getLogsByUser
```
### TodoServiceTest
```bash
mvn test -Dtest=TodoServiceTest#testCreateTodo
mvn test -Dtest=TodoServiceTest#testTimerDelete
```
### CurrentUserTest
```bash
mvn test -Dtest=CurrentUserTest#testGetsDefaultUser
mvn test -Dtest=CurrentUserTest#testCurrentConcurrent
```
### UserServiceTest
```bash
mvn test -Dtest=UserServiceTest#testSortedByName
mvn test -Dtest=UserServiceTest#testAddNullUser
mvn test -Dtest=UserServiceTest#testLoginUser
mvn test -Dtest=UserServiceTest#testAddUsersAndClear
```
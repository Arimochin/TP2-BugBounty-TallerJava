## Entregable

Completar la siguiente tabla con un análisis de cada test fallido. Para cada uno indicar la causa raíz del error y la corrección aplicada.

| Test (`Clase.método`) | Descripción del error                                                                                                                                                                                                                                       | Descripción de la solución                                                                |
|---|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------|
| `LogServiceTest.addLogs` | El test dice que se esperaba "100000" pero el resultado era "200000". El test compara el tamaño de la lista de eventos que se quieren registrar con la lista de Logs donde se añaden. En addLog se estaba añadiendo el log dos veces a la lista.            | Eliminar una de las lineas que decia "list.add(log);"                                     |
| `LogServiceTest.hasAllLogsConcurrent` |                                                                                                                                                                                                                                                             |                                                                                           |
| `LogServiceTest.getLogsByUser` | El test indica que un objeto User deberia identificarse por su nombre. El error seria que no se considero que el HashMap utiliza para comparar los metodos equals() y hashCode(), y que para comparar un objeto por defecto usa las referencias de memoria. | Sobreescribir equals() y hashCode() en User para que compare correctamente por el nombre. |
| `TodoServiceTest.testCreateTodo` | En el metodo createNewTodo no se estaba seteando el contenido en el nuevo ToDo.                                                                                                                                                                             | Agregamos la linea "nuevo.setContent(content);" antes de hacer "addTODO(nuevo);".         |
| `TodoServiceTest.testTimerDelete` |                                                                                                                                                                                                                                                             |                                                                                           |
| `CurrentUserTest.testGetsDefaultUser` |                                                                                                                                                                                                                                                             |                                                                                           |
| `CurrentUserTest.testCurrentConcurrent` |                                                                                                                                                                                                                                                             |                                                                                           |
| `UserServiceTest.testSortedByName` |                                                                                                                                                                                                                                                             |                                                                                           |
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
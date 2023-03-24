## SpringAopExecutionSpeed
Display the execution speed of only those methods that are marked with @ShowTime. Output results to the console only for those methods marked with @ShowResult. Create @ShowTime and @ShowResult yourself.
## 8. Spring 6. AOP
## Завдання 2

У проєкті із завдань замінити реалізацію використання анотацій (замість XML).

## Завдання 4 

З прикладу 007_AOP_Annotation вивести швидкість виконання лише тих методів, які позначені @ShowTime. 
Вивести результати в консоль тільки для тих методів, які позначені @ShowResult. @ShowTime та @ShowResult створити самостійно. 

## Заметки

### SpEL

**SpEL(Spring Expression Language)** - это язык выражений, который используется в Spring Framework для описания различных функций, таких как pointcut для AOP (Аспектно-ориентированное программирование). Вот некоторые из основных правил синтаксиса SpEL для написания pointcut Java:

SpEL pointcut выражения начинаются с ключевого слова execution. После execution следует путь к методу, который вы хотите выбрать. Например, execution(* com.example.service.UserService.*(..)).

 - "*" используется для обозначения любого типа возвращаемого значения.
 - com.example.service.UserService - это имя класса, который содержит методы, которые вы хотите выбрать.
 - "*" после UserService обозначает любое имя метода.
 - (..) обозначает любое количество аргументов метода.
 
Вы можете использовать операторы логического И (&&) и логического ИЛИ (||) для комбинации нескольких выражений pointcut.

Вы можете использовать оператор ! для инвертирования выражения pointcut.

Можно использовать args() для выбора методов, которые принимают аргументы определенного типа.

Вы можете использовать @annotation() для выбора методов, которые аннотированы определенной аннотацией.
